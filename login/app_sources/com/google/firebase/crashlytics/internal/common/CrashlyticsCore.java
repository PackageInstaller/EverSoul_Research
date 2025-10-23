package com.google.firebase.crashlytics.internal.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.FirebaseApp;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy;
import com.google.firebase.crashlytics.internal.analytics.AnalyticsEventLogger;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler;
import com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbSource;
import com.google.firebase.crashlytics.internal.metadata.LogFileManager;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.crashlytics.internal.persistence.FileStore;
import com.google.firebase.crashlytics.internal.settings.SettingsProvider;
import com.google.firebase.crashlytics.internal.stacktrace.MiddleOutFallbackStrategy;
import com.google.firebase.crashlytics.internal.stacktrace.RemoveRepeatsStrategy;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes2.dex */
public class CrashlyticsCore {
    static final String CRASHLYTICS_REQUIRE_BUILD_ID = "com.crashlytics.RequireBuildId";
    static final boolean CRASHLYTICS_REQUIRE_BUILD_ID_DEFAULT = true;
    static final String CRASH_MARKER_FILE_NAME = "crash_marker";
    static final int DEFAULT_MAIN_HANDLER_TIMEOUT_SEC = 3;
    private static final String INITIALIZATION_MARKER_FILE_NAME = "initialization_marker";
    static final int MAX_STACK_SIZE = 1024;
    private static final String MISSING_BUILD_ID_MSG = "The Crashlytics build ID is missing. This occurs when the Crashlytics Gradle plugin is missing from your app's build configuration. Please review the Firebase Crashlytics onboarding instructions at https://firebase.google.com/docs/crashlytics/get-started?platform=android#add-plugin";
    static final int NUM_STACK_REPETITIONS_ALLOWED = 10;
    private static final String ON_DEMAND_DROPPED_KEY = "com.crashlytics.on-demand.dropped-exceptions";
    private static final String ON_DEMAND_RECORDED_KEY = "com.crashlytics.on-demand.recorded-exceptions";
    private final AnalyticsEventLogger analyticsEventLogger;
    private final FirebaseApp app;
    private final CrashlyticsBackgroundWorker backgroundWorker;
    public final BreadcrumbSource breadcrumbSource;
    private final Context context;
    private CrashlyticsController controller;
    private final ExecutorService crashHandlerExecutor;
    private CrashlyticsFileMarker crashMarker;
    private final DataCollectionArbiter dataCollectionArbiter;
    private boolean didCrashOnPreviousExecution;
    private final FileStore fileStore;
    private final IdManager idManager;
    private CrashlyticsFileMarker initializationMarker;
    private final CrashlyticsNativeComponent nativeComponent;
    private final RemoteConfigDeferredProxy remoteConfigDeferredProxy;
    private final CrashlyticsAppQualitySessionsSubscriber sessionsSubscriber;
    private final long startTime = System.currentTimeMillis();
    private final OnDemandCounter onDemandCounter = new OnDemandCounter();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getVersion() {
        return "18.6.2";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CrashlyticsCore(FirebaseApp firebaseApp, IdManager idManager, CrashlyticsNativeComponent crashlyticsNativeComponent, DataCollectionArbiter dataCollectionArbiter, BreadcrumbSource breadcrumbSource, AnalyticsEventLogger analyticsEventLogger, FileStore fileStore, ExecutorService executorService, CrashlyticsAppQualitySessionsSubscriber crashlyticsAppQualitySessionsSubscriber, RemoteConfigDeferredProxy remoteConfigDeferredProxy) {
        this.app = firebaseApp;
        this.dataCollectionArbiter = dataCollectionArbiter;
        this.context = firebaseApp.getApplicationContext();
        this.idManager = idManager;
        this.nativeComponent = crashlyticsNativeComponent;
        this.breadcrumbSource = breadcrumbSource;
        this.analyticsEventLogger = analyticsEventLogger;
        this.crashHandlerExecutor = executorService;
        this.fileStore = fileStore;
        this.backgroundWorker = new CrashlyticsBackgroundWorker(executorService);
        this.sessionsSubscriber = crashlyticsAppQualitySessionsSubscriber;
        this.remoteConfigDeferredProxy = remoteConfigDeferredProxy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean onPreExecute(AppData appData, SettingsProvider settingsProvider) {
        if (!isBuildIdValid(appData.buildId, CommonUtils.getBooleanResourceValue(this.context, CRASHLYTICS_REQUIRE_BUILD_ID, true))) {
            throw new IllegalStateException(MISSING_BUILD_ID_MSG);
        }
        String clsuuid = new CLSUUID(this.idManager).toString();
        try {
            this.crashMarker = new CrashlyticsFileMarker(CRASH_MARKER_FILE_NAME, this.fileStore);
            this.initializationMarker = new CrashlyticsFileMarker(INITIALIZATION_MARKER_FILE_NAME, this.fileStore);
            UserMetadata userMetadata = new UserMetadata(clsuuid, this.fileStore, this.backgroundWorker);
            LogFileManager logFileManager = new LogFileManager(this.fileStore);
            MiddleOutFallbackStrategy middleOutFallbackStrategy = new MiddleOutFallbackStrategy(1024, new RemoveRepeatsStrategy(10));
            this.remoteConfigDeferredProxy.setupListener(userMetadata);
            this.controller = new CrashlyticsController(this.context, this.backgroundWorker, this.idManager, this.dataCollectionArbiter, this.fileStore, this.crashMarker, appData, userMetadata, logFileManager, SessionReportingCoordinator.create(this.context, this.idManager, this.fileStore, appData, logFileManager, userMetadata, middleOutFallbackStrategy, settingsProvider, this.onDemandCounter, this.sessionsSubscriber), this.nativeComponent, this.analyticsEventLogger, this.sessionsSubscriber);
            boolean didPreviousInitializationFail = didPreviousInitializationFail();
            checkForPreviousCrash();
            this.controller.enableExceptionHandling(clsuuid, Thread.getDefaultUncaughtExceptionHandler(), settingsProvider);
            if (didPreviousInitializationFail && CommonUtils.canTryConnection(this.context)) {
                Logger.getLogger().m390d("Crashlytics did not finish previous background initialization. Initializing synchronously.");
                finishInitSynchronously(settingsProvider);
                return false;
            }
            Logger.getLogger().m390d("Successfully configured exception handler.");
            return true;
        } catch (Exception e) {
            Logger.getLogger().m393e("Crashlytics was not started due to an exception during initialization", e);
            this.controller = null;
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<Void> doBackgroundInitializationAsync(final SettingsProvider settingsProvider) {
        return Utils.callTask(this.crashHandlerExecutor, new Callable<Task<Void>>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.1
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public Task<Void> call() throws Exception {
                return CrashlyticsCore.this.doBackgroundInitialization(settingsProvider);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<Void> doBackgroundInitialization(SettingsProvider settingsProvider) {
        markInitializationStarted();
        try {
            this.breadcrumbSource.registerBreadcrumbHandler(new BreadcrumbHandler() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.firebase.crashlytics.internal.breadcrumbs.BreadcrumbHandler
                public final void handleBreadcrumb(String str) {
                    CrashlyticsCore.this.log(str);
                }
            });
            this.controller.saveVersionControlInfo();
            if (!settingsProvider.getSettingsSync().featureFlagData.collectReports) {
                Logger.getLogger().m390d("Collection of crash reports disabled in Crashlytics settings.");
                return Tasks.forException(new RuntimeException("Collection of crash reports disabled in Crashlytics settings."));
            }
            if (!this.controller.finalizeSessions(settingsProvider)) {
                Logger.getLogger().m398w("Previous sessions could not be finalized.");
            }
            return this.controller.submitAllReports(settingsProvider.getSettingsAsync());
        } catch (Exception e) {
            Logger.getLogger().m393e("Crashlytics encountered a problem during asynchronous initialization.", e);
            return Tasks.forException(e);
        } finally {
            markInitializationComplete();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCrashlyticsCollectionEnabled(Boolean bool) {
        this.dataCollectionArbiter.setCrashlyticsDataCollectionEnabled(bool);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<Boolean> checkForUnsentReports() {
        return this.controller.checkForUnsentReports();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<Void> sendUnsentReports() {
        return this.controller.sendUnsentReports();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Task<Void> deleteUnsentReports() {
        return this.controller.deleteUnsentReports();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logException(Throwable th) {
        this.controller.writeNonFatalException(Thread.currentThread(), th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(String str) {
        this.controller.writeToLog(System.currentTimeMillis() - this.startTime, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setUserId(String str) {
        this.controller.setUserId(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCustomKey(String str, String str2) {
        this.controller.setCustomKey(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setCustomKeys(Map<String, String> map) {
        this.controller.setCustomKeys(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setInternalKey(String str, String str2) {
        this.controller.setInternalKey(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logFatalException(Throwable th) {
        Logger.getLogger().m390d("Recorded on-demand fatal events: " + this.onDemandCounter.getRecordedOnDemandExceptions());
        Logger.getLogger().m390d("Dropped on-demand fatal events: " + this.onDemandCounter.getDroppedOnDemandExceptions());
        this.controller.setInternalKey(ON_DEMAND_RECORDED_KEY, Integer.toString(this.onDemandCounter.getRecordedOnDemandExceptions()));
        this.controller.setInternalKey(ON_DEMAND_DROPPED_KEY, Integer.toString(this.onDemandCounter.getDroppedOnDemandExceptions()));
        this.controller.logFatalException(Thread.currentThread(), th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CrashlyticsController getController() {
        return this.controller;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void finishInitSynchronously(final SettingsProvider settingsProvider) {
        Future<?> submit = this.crashHandlerExecutor.submit(new Runnable() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                CrashlyticsCore.this.doBackgroundInitialization(settingsProvider);
            }
        });
        Logger.getLogger().m390d("Crashlytics detected incomplete initialization on previous app launch. Will initialize synchronously.");
        try {
            submit.get(3L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            Logger.getLogger().m393e("Crashlytics was interrupted during initialization.", e);
        } catch (ExecutionException e2) {
            Logger.getLogger().m393e("Crashlytics encountered a problem during initialization.", e2);
        } catch (TimeoutException e3) {
            Logger.getLogger().m393e("Crashlytics timed out during initialization.", e3);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void markInitializationStarted() {
        this.backgroundWorker.checkRunningOnThread();
        this.initializationMarker.create();
        Logger.getLogger().m396v("Initialization marker file was created.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void markInitializationComplete() {
        this.backgroundWorker.submit(new Callable<Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.3
            /* JADX WARN: Can't rename method to resolve collision */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.concurrent.Callable
            public Boolean call() throws Exception {
                try {
                    boolean remove = CrashlyticsCore.this.initializationMarker.remove();
                    if (!remove) {
                        Logger.getLogger().m398w("Initialization marker file was not properly removed.");
                    }
                    return Boolean.valueOf(remove);
                } catch (Exception e) {
                    Logger.getLogger().m393e("Problem encountered deleting Crashlytics initialization marker.", e);
                    return false;
                }
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean didPreviousInitializationFail() {
        return this.initializationMarker.isPresent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void checkForPreviousCrash() {
        try {
            this.didCrashOnPreviousExecution = Boolean.TRUE.equals((Boolean) Utils.awaitEvenIfOnMainThread(this.backgroundWorker.submit(new Callable<Boolean>() { // from class: com.google.firebase.crashlytics.internal.common.CrashlyticsCore.4
                /* JADX WARN: Can't rename method to resolve collision */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.concurrent.Callable
                public Boolean call() throws Exception {
                    return Boolean.valueOf(CrashlyticsCore.this.controller.didCrashOnPreviousExecution());
                }
            })));
        } catch (Exception unused) {
            this.didCrashOnPreviousExecution = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean didCrashOnPreviousExecution() {
        return this.didCrashOnPreviousExecution;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isBuildIdValid(String str, boolean z) {
        if (!z) {
            Logger.getLogger().m396v("Configured not to require a build ID.");
            return true;
        }
        if (!TextUtils.isEmpty(str)) {
            return true;
        }
        Log.e(Logger.TAG, ".");
        Log.e(Logger.TAG, ".     |  | ");
        Log.e(Logger.TAG, ".     |  |");
        Log.e(Logger.TAG, ".     |  |");
        Log.e(Logger.TAG, ".   \\ |  | /");
        Log.e(Logger.TAG, ".    \\    /");
        Log.e(Logger.TAG, ".     \\  /");
        Log.e(Logger.TAG, ".      \\/");
        Log.e(Logger.TAG, ".");
        Log.e(Logger.TAG, MISSING_BUILD_ID_MSG);
        Log.e(Logger.TAG, ".");
        Log.e(Logger.TAG, ".      /\\");
        Log.e(Logger.TAG, ".     /  \\");
        Log.e(Logger.TAG, ".    /    \\");
        Log.e(Logger.TAG, ".   / |  | \\");
        Log.e(Logger.TAG, ".     |  |");
        Log.e(Logger.TAG, ".     |  |");
        Log.e(Logger.TAG, ".     |  |");
        Log.e(Logger.TAG, ".");
        return false;
    }
}
