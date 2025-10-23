package com.google.firebase.perf.transport;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.BuildConfig;
import com.google.firebase.perf.FirebasePerformance;
import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.logging.ConsoleUrlGenerator;
import com.google.firebase.perf.metrics.validator.PerfMetricValidator;
import com.google.firebase.perf.p010v1.AndroidApplicationInfo;
import com.google.firebase.perf.p010v1.ApplicationInfo;
import com.google.firebase.perf.p010v1.ApplicationProcessState;
import com.google.firebase.perf.p010v1.GaugeMetric;
import com.google.firebase.perf.p010v1.NetworkRequestMetric;
import com.google.firebase.perf.p010v1.PerfMetric;
import com.google.firebase.perf.p010v1.PerfMetricOrBuilder;
import com.google.firebase.perf.p010v1.TraceMetric;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.perf.util.Constants;
import com.google.firebase.perf.util.Rate;
import java.lang.ref.WeakReference;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: classes2.dex */
public class TransportManager implements AppStateMonitor.AppStateCallback {
    private static final int CORE_POOL_SIZE = 0;
    private static final String KEY_AVAILABLE_GAUGES_FOR_CACHING = "KEY_AVAILABLE_GAUGES_FOR_CACHING";
    private static final String KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING = "KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING";
    private static final String KEY_AVAILABLE_TRACES_FOR_CACHING = "KEY_AVAILABLE_TRACES_FOR_CACHING";
    private static final int MAX_GAUGE_METRICS_CACHE_SIZE = 50;
    private static final int MAX_NETWORK_REQUEST_METRICS_CACHE_SIZE = 50;
    private static final int MAX_POOL_SIZE = 1;
    private static final int MAX_TRACE_METRICS_CACHE_SIZE = 50;
    private Context appContext;
    private AppStateMonitor appStateMonitor;
    private ApplicationInfo.Builder applicationInfoBuilder;
    private final Map<String, Integer> cacheMap;
    private ConfigResolver configResolver;
    private FirebaseApp firebaseApp;
    private FirebaseInstallationsApi firebaseInstallationsApi;
    private FirebasePerformance firebasePerformance;
    private FlgTransport flgTransport;
    private Provider<TransportFactory> flgTransportFactoryProvider;
    private String packageName;
    private String projectId;
    private RateLimiter rateLimiter;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final TransportManager instance = new TransportManager();
    private final ConcurrentLinkedQueue<PendingPerfEvent> pendingEventsQueue = new ConcurrentLinkedQueue<>();
    private final AtomicBoolean isTransportInitialized = new AtomicBoolean(false);
    private boolean isForegroundState = false;
    private ExecutorService executorService = new ThreadPoolExecutor(0, 1, 10, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TransportManager() {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        this.cacheMap = concurrentHashMap;
        concurrentHashMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, 50);
        concurrentHashMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, 50);
        concurrentHashMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, 50);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static TransportManager getInstance() {
        return instance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void initializeForTest(FirebaseApp firebaseApp, FirebasePerformance firebasePerformance, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider, ConfigResolver configResolver, RateLimiter rateLimiter, AppStateMonitor appStateMonitor, FlgTransport flgTransport, ExecutorService executorService) {
        this.firebaseApp = firebaseApp;
        this.projectId = firebaseApp.getOptions().getProjectId();
        this.appContext = firebaseApp.getApplicationContext();
        this.firebasePerformance = firebasePerformance;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.flgTransportFactoryProvider = provider;
        this.configResolver = configResolver;
        this.rateLimiter = rateLimiter;
        this.appStateMonitor = appStateMonitor;
        this.flgTransport = flgTransport;
        this.executorService = executorService;
        this.cacheMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, 50);
        this.cacheMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, 50);
        this.cacheMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, 50);
        finishInitialization();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void initialize(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<TransportFactory> provider) {
        this.firebaseApp = firebaseApp;
        this.projectId = firebaseApp.getOptions().getProjectId();
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.flgTransportFactoryProvider = provider;
        this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.syncInit();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void syncInit() {
        Context applicationContext = this.firebaseApp.getApplicationContext();
        this.appContext = applicationContext;
        this.packageName = applicationContext.getPackageName();
        this.configResolver = ConfigResolver.getInstance();
        this.rateLimiter = new RateLimiter(this.appContext, new Rate(100L, 1L, TimeUnit.MINUTES), 500L);
        this.appStateMonitor = AppStateMonitor.getInstance();
        this.flgTransport = new FlgTransport(this.flgTransportFactoryProvider, this.configResolver.getAndCacheLogSourceName());
        finishInitialization();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void finishInitialization() {
        this.appStateMonitor.registerForAppState(new WeakReference<>(instance));
        ApplicationInfo.Builder newBuilder = ApplicationInfo.newBuilder();
        this.applicationInfoBuilder = newBuilder;
        newBuilder.setGoogleAppId(this.firebaseApp.getOptions().getApplicationId()).setAndroidAppInfo(AndroidApplicationInfo.newBuilder().setPackageName(this.packageName).setSdkVersion(BuildConfig.FIREPERF_VERSION_NAME).setVersionName(getVersionName(this.appContext)));
        this.isTransportInitialized.set(true);
        while (!this.pendingEventsQueue.isEmpty()) {
            final PendingPerfEvent poll = this.pendingEventsQueue.poll();
            if (poll != null) {
                this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda4
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Runnable
                    public final void run() {
                        TransportManager.this.m440xd2410da6(poll);
                    }
                });
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$finishInitialization$0$com-google-firebase-perf-transport-TransportManager */
    /* synthetic */ void m440xd2410da6(PendingPerfEvent pendingPerfEvent) {
        syncLog(pendingPerfEvent.perfMetricBuilder, pendingPerfEvent.appState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.application.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        this.isForegroundState = applicationProcessState == ApplicationProcessState.FOREGROUND;
        if (isInitialized()) {
            this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    TransportManager.this.m441x3928ae6c();
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$onUpdateAppState$1$com-google-firebase-perf-transport-TransportManager */
    /* synthetic */ void m441x3928ae6c() {
        this.rateLimiter.changeRate(this.isForegroundState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isInitialized() {
        return this.isTransportInitialized.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(TraceMetric traceMetric) {
        log(traceMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(final TraceMetric traceMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.m1183lambda$log$2$comgooglefirebaseperftransportTransportManager(traceMetric, applicationProcessState);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$log$2$com-google-firebase-perf-transport-TransportManager, reason: not valid java name */
    /* synthetic */ void m1183lambda$log$2$comgooglefirebaseperftransportTransportManager(TraceMetric traceMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setTraceMetric(traceMetric), applicationProcessState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(NetworkRequestMetric networkRequestMetric) {
        log(networkRequestMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(final NetworkRequestMetric networkRequestMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.m1184lambda$log$3$comgooglefirebaseperftransportTransportManager(networkRequestMetric, applicationProcessState);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$log$3$com-google-firebase-perf-transport-TransportManager, reason: not valid java name */
    /* synthetic */ void m1184lambda$log$3$comgooglefirebaseperftransportTransportManager(NetworkRequestMetric networkRequestMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setNetworkRequestMetric(networkRequestMetric), applicationProcessState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(GaugeMetric gaugeMetric) {
        log(gaugeMetric, ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(final GaugeMetric gaugeMetric, final ApplicationProcessState applicationProcessState) {
        this.executorService.execute(new Runnable() { // from class: com.google.firebase.perf.transport.TransportManager$$ExternalSyntheticLambda5
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                TransportManager.this.m1185lambda$log$4$comgooglefirebaseperftransportTransportManager(gaugeMetric, applicationProcessState);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$log$4$com-google-firebase-perf-transport-TransportManager, reason: not valid java name */
    /* synthetic */ void m1185lambda$log$4$comgooglefirebaseperftransportTransportManager(GaugeMetric gaugeMetric, ApplicationProcessState applicationProcessState) {
        syncLog(PerfMetric.newBuilder().setGaugeMetric(gaugeMetric), applicationProcessState);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void syncLog(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        if (!isInitialized()) {
            if (isAllowedToCache(builder)) {
                logger.debug("Transport is not initialized yet, %s will be queued for to be dispatched later", getLogcatMsg(builder));
                this.pendingEventsQueue.add(new PendingPerfEvent(builder, applicationProcessState));
                return;
            }
            return;
        }
        PerfMetric applicationInfoAndBuild = setApplicationInfoAndBuild(builder, applicationProcessState);
        if (isAllowedToDispatch(applicationInfoAndBuild)) {
            dispatchLog(applicationInfoAndBuild);
            SessionManager.getInstance().stopGaugeCollectionIfSessionRunningTooLong();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isAllowedToCache(PerfMetricOrBuilder perfMetricOrBuilder) {
        int intValue = this.cacheMap.get(KEY_AVAILABLE_TRACES_FOR_CACHING).intValue();
        int intValue2 = this.cacheMap.get(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING).intValue();
        int intValue3 = this.cacheMap.get(KEY_AVAILABLE_GAUGES_FOR_CACHING).intValue();
        if (perfMetricOrBuilder.hasTraceMetric() && intValue > 0) {
            this.cacheMap.put(KEY_AVAILABLE_TRACES_FOR_CACHING, Integer.valueOf(intValue - 1));
            return true;
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric() && intValue2 > 0) {
            this.cacheMap.put(KEY_AVAILABLE_NETWORK_REQUESTS_FOR_CACHING, Integer.valueOf(intValue2 - 1));
            return true;
        }
        if (perfMetricOrBuilder.hasGaugeMetric() && intValue3 > 0) {
            this.cacheMap.put(KEY_AVAILABLE_GAUGES_FOR_CACHING, Integer.valueOf(intValue3 - 1));
            return true;
        }
        logger.debug("%s is not allowed to cache. Cache exhausted the limit (availableTracesForCaching: %d, availableNetworkRequestsForCaching: %d, availableGaugesForCaching: %d).", getLogcatMsg(perfMetricOrBuilder), Integer.valueOf(intValue), Integer.valueOf(intValue2), Integer.valueOf(intValue3));
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isAllowedToDispatch(PerfMetric perfMetric) {
        if (!this.configResolver.isPerformanceMonitoringEnabled()) {
            logger.info("Performance collection is not enabled, dropping %s", getLogcatMsg(perfMetric));
            return false;
        }
        if (!perfMetric.getApplicationInfo().hasAppInstanceId()) {
            logger.warn("App Instance ID is null or empty, dropping %s", getLogcatMsg(perfMetric));
            return false;
        }
        if (!PerfMetricValidator.isValid(perfMetric, this.appContext)) {
            logger.warn("Unable to process the PerfMetric (%s) due to missing or invalid values. See earlier log statements for additional information on the specific missing/invalid values.", getLogcatMsg(perfMetric));
            return false;
        }
        if (!this.rateLimiter.isEventSampled(perfMetric)) {
            incrementDropCount(perfMetric);
            logger.info("Event dropped due to device sampling - %s", getLogcatMsg(perfMetric));
            return false;
        }
        if (!this.rateLimiter.isEventRateLimited(perfMetric)) {
            return true;
        }
        incrementDropCount(perfMetric);
        logger.info("Rate limited (per device) - %s", getLogcatMsg(perfMetric));
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void dispatchLog(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            logger.info("Logging %s. In a minute, visit the Firebase console to view your data: %s", getLogcatMsg(perfMetric), getConsoleUrl(perfMetric.getTraceMetric()));
        } else {
            logger.info("Logging %s", getLogcatMsg(perfMetric));
        }
        this.flgTransport.log(perfMetric);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getVersionName(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            return packageInfo.versionName == null ? "" : packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException unused) {
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PerfMetric setApplicationInfoAndBuild(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        updateFirebaseInstallationIdIfPossibleAndNeeded();
        ApplicationInfo.Builder applicationProcessState2 = this.applicationInfoBuilder.setApplicationProcessState(applicationProcessState);
        if (builder.hasTraceMetric() || builder.hasNetworkRequestMetric()) {
            applicationProcessState2 = ((ApplicationInfo.Builder) applicationProcessState2.mo1206clone()).putAllCustomAttributes(getGlobalCustomAttributes());
        }
        return builder.setApplicationInfo(applicationProcessState2).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Map<String, String> getGlobalCustomAttributes() {
        updateFirebasePerformanceIfPossibleAndNeeded();
        FirebasePerformance firebasePerformance = this.firebasePerformance;
        if (firebasePerformance != null) {
            return firebasePerformance.getAttributes();
        }
        return Collections.emptyMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void updateFirebasePerformanceIfPossibleAndNeeded() {
        if (this.firebasePerformance == null && isInitialized()) {
            this.firebasePerformance = FirebasePerformance.getInstance();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0068  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private void updateFirebaseInstallationIdIfPossibleAndNeeded() {
        /*
            r6 = this;
            com.google.firebase.perf.config.ConfigResolver r0 = r6.configResolver
            boolean r0 = r0.isPerformanceMonitoringEnabled()
            if (r0 == 0) goto L6f
            com.google.firebase.perf.v1.ApplicationInfo$Builder r0 = r6.applicationInfoBuilder
            boolean r0 = r0.hasAppInstanceId()
            if (r0 == 0) goto L15
            boolean r0 = r6.isForegroundState
            if (r0 != 0) goto L15
            return
        L15:
            r0 = 0
            r1 = 1
            com.google.firebase.installations.FirebaseInstallationsApi r2 = r6.firebaseInstallationsApi     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L3a java.util.concurrent.ExecutionException -> L4b
            com.google.android.gms.tasks.Task r2 = r2.getId()     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L3a java.util.concurrent.ExecutionException -> L4b
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L3a java.util.concurrent.ExecutionException -> L4b
            r4 = 60000(0xea60, double:2.9644E-319)
            java.lang.Object r2 = com.google.android.gms.tasks.Tasks.await(r2, r4, r3)     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L3a java.util.concurrent.ExecutionException -> L4b
            java.lang.String r2 = (java.lang.String) r2     // Catch: java.util.concurrent.TimeoutException -> L29 java.lang.InterruptedException -> L3a java.util.concurrent.ExecutionException -> L4b
            goto L5c
        L29:
            r2 = move-exception
            com.google.firebase.perf.logging.AndroidLogger r3 = com.google.firebase.perf.transport.TransportManager.logger
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r2.getMessage()
            r1[r0] = r2
            java.lang.String r0 = "Task to retrieve Installation Id is timed out: %s"
            r3.error(r0, r1)
            goto L5b
        L3a:
            r2 = move-exception
            com.google.firebase.perf.logging.AndroidLogger r3 = com.google.firebase.perf.transport.TransportManager.logger
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r2.getMessage()
            r1[r0] = r2
            java.lang.String r0 = "Task to retrieve Installation Id is interrupted: %s"
            r3.error(r0, r1)
            goto L5b
        L4b:
            r2 = move-exception
            com.google.firebase.perf.logging.AndroidLogger r3 = com.google.firebase.perf.transport.TransportManager.logger
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.String r2 = r2.getMessage()
            r1[r0] = r2
            java.lang.String r0 = "Unable to retrieve Installation Id: %s"
            r3.error(r0, r1)
        L5b:
            r2 = 0
        L5c:
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L68
            com.google.firebase.perf.v1.ApplicationInfo$Builder r0 = r6.applicationInfoBuilder
            r0.setAppInstanceId(r2)
            goto L6f
        L68:
            com.google.firebase.perf.logging.AndroidLogger r0 = com.google.firebase.perf.transport.TransportManager.logger
            java.lang.String r1 = "Firebase Installation Id is empty, contact Firebase Support for debugging."
            r0.warn(r1)
        L6f:
            return
            fill-array 0x0070: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.perf.transport.TransportManager.updateFirebaseInstallationIdIfPossibleAndNeeded():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void incrementDropCount(PerfMetric perfMetric) {
        if (perfMetric.hasTraceMetric()) {
            this.appStateMonitor.incrementCount(Constants.CounterNames.TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        } else if (perfMetric.hasNetworkRequestMetric()) {
            this.appStateMonitor.incrementCount(Constants.CounterNames.NETWORK_TRACE_EVENT_RATE_LIMITED.toString(), 1L);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getLogcatMsg(PerfMetricOrBuilder perfMetricOrBuilder) {
        if (perfMetricOrBuilder.hasTraceMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getTraceMetric());
        }
        if (perfMetricOrBuilder.hasNetworkRequestMetric()) {
            return getLogcatMsg(perfMetricOrBuilder.getNetworkRequestMetric());
        }
        return perfMetricOrBuilder.hasGaugeMetric() ? getLogcatMsg(perfMetricOrBuilder.getGaugeMetric()) : "log";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getLogcatMsg(TraceMetric traceMetric) {
        return String.format(Locale.ENGLISH, "trace metric: %s (duration: %sms)", traceMetric.getName(), new DecimalFormat("#.####").format(traceMetric.getDurationUs() / 1000.0d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getLogcatMsg(NetworkRequestMetric networkRequestMetric) {
        return String.format(Locale.ENGLISH, "network request trace: %s (responseCode: %s, responseTime: %sms)", networkRequestMetric.getUrl(), networkRequestMetric.hasHttpResponseCode() ? String.valueOf(networkRequestMetric.getHttpResponseCode()) : "UNKNOWN", new DecimalFormat("#.####").format((networkRequestMetric.hasTimeToResponseCompletedUs() ? networkRequestMetric.getTimeToResponseCompletedUs() : 0L) / 1000.0d));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getLogcatMsg(GaugeMetric gaugeMetric) {
        return String.format(Locale.ENGLISH, "gauges (hasMetadata: %b, cpuGaugeCount: %d, memoryGaugeCount: %d)", Boolean.valueOf(gaugeMetric.hasGaugeMetadata()), Integer.valueOf(gaugeMetric.getCpuMetricReadingsCount()), Integer.valueOf(gaugeMetric.getAndroidMemoryReadingsCount()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private String getConsoleUrl(TraceMetric traceMetric) {
        String name = traceMetric.getName();
        if (name.startsWith(Constants.SCREEN_TRACE_PREFIX)) {
            return ConsoleUrlGenerator.generateScreenTraceUrl(this.projectId, this.packageName, name);
        }
        return ConsoleUrlGenerator.generateCustomTraceUrl(this.projectId, this.packageName, name);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void setInitialized(boolean z) {
        this.isTransportInitialized.set(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void clearAppInstanceId() {
        this.applicationInfoBuilder.clearAppInstanceId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ConcurrentLinkedQueue<PendingPerfEvent> getPendingEventsQueue() {
        return new ConcurrentLinkedQueue<>(this.pendingEventsQueue);
    }
}
