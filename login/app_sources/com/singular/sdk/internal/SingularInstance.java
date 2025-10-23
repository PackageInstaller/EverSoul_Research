package com.singular.sdk.internal;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import com.facebook.appevents.AppEventsConstants;
import com.google.gson.GsonBuilder;
import com.google.gson.ToNumberPolicy;
import com.singular.sdk.ShortLinkHandler;
import com.singular.sdk.SingularConfig;
import com.singular.sdk.SingularDeviceAttributionHandler;
import com.singular.sdk.internal.ApiCustomUserId;
import com.singular.sdk.internal.ApiGDPRConsent;
import com.singular.sdk.internal.ApiGDPRUnder13;
import com.singular.sdk.internal.ApiStartSession;
import com.singular.sdk.internal.ApiSubmitEvent;
import com.singular.sdk.internal.BatchManager;
import com.singular.sdk.internal.ConfigManager;
import com.singular.sdk.internal.InstallReferrer.SLDigitalTurbineReferrer;
import com.singular.sdk.internal.InstallReferrer.SLGoogleReferrer;
import com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler;
import com.singular.sdk.internal.InstallReferrer.SLSamsungReferrer;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes3.dex */
public class SingularInstance {
    private static final int RETRY_DELAY_INTERVAL_MS = 200;
    private static SingularInstance instance;
    private static final SingularLog logger = SingularLog.getLogger("Instance");
    private static int retryCounter = 0;
    private final ApiManager apiManager;
    private SingularConfig config;
    private final Context context;
    private DeviceInfo deviceInfo;
    String dtInstallReferrer;
    private HashMap<String, String> globalProperties;
    Map<String, Object> googleInstallReferrer;
    private boolean initialized = false;
    private double installReferrerTimeInterval;
    private boolean isFirstInstall;
    Map<String, Object> metaInstallReferrer;
    Map<String, Object> samsungInstallReferrer;
    private SessionManager sessionManager;
    private final SingularWorkerThread worker;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SingularInstance getInstance(Context context, SingularConfig singularConfig) throws IOException {
        if (instance == null) {
            synchronized (SingularInstance.class) {
                if (instance == null) {
                    SingularLog.ENABLE_LOGGING = singularConfig.enableLogging;
                    SingularLog.LOG_LEVEL = singularConfig.logLevel;
                    instance = new SingularInstance(context, singularConfig);
                }
            }
        }
        SingularInstance singularInstance = instance;
        singularInstance.config = singularConfig;
        return singularInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SingularInstance getInstance() {
        return instance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SingularInstance(Context context, SingularConfig singularConfig) throws IOException {
        this.isFirstInstall = false;
        SingularLog singularLog = logger;
        singularLog.debug("SDK version: %s", Constants.SDK_VERSION);
        singularLog.debug("SDK build info: %s", Constants.SDK_BUILD_INFO);
        singularLog.debug("new SingularInstance() with config: %s", singularConfig);
        Context applicationContext = context.getApplicationContext();
        if (!(applicationContext instanceof Application)) {
            throw new IllegalStateException("Context failed to cast to ApplicationContext");
        }
        this.context = applicationContext;
        this.config = singularConfig;
        SingularWorkerThread singularWorkerThread = new SingularWorkerThread("worker");
        this.worker = singularWorkerThread;
        this.apiManager = new ApiManager(new SingularWorkerThread(com.kakao.sdk.partner.user.Constants.API_TYPE), context, new SQLitePersistentQueue(context));
        this.isFirstInstall = Utils.isFirstInstall(getContext());
        singularWorkerThread.start();
        initGlobalProperties();
        runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                SingularInstance.this.init(this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void init(final SingularInstance singularInstance) {
        if (isInitialized()) {
            logger.error("Singular is already initialized, please don't call init() again.");
            return;
        }
        try {
            if (!Utils.isEmptyOrNull(this.config.fcmDeviceToken)) {
                saveDeviceToken(Constants.FCM_DEVICE_TOKEN_KEY, this.config.fcmDeviceToken);
            }
            if (this.config.customUserId != null) {
                saveCustomUserId(this.config.customUserId);
            }
            if (this.config.limitDataSharing != null) {
                limitDataSharing(this.config.limitDataSharing.booleanValue());
            }
            if (this.config.imei != null) {
                setIMEI(this.config.imei);
            }
            singularInstance.deviceInfo = new DeviceInfo(singularInstance.context, this.config.collectOAID, this.config.limitedIdentifiresEnabled);
            if (Utils.isEmptyOrNull(getSharedPreferences().getString(Constants.CUSTOM_SDID_KEY, null)) && !Utils.isEmptyOrNull(this.config.customSdid) && !this.config.customSdid.equalsIgnoreCase("null")) {
                SharedPreferences.Editor edit = this.context.getSharedPreferences(Constants.PREF_SESSION, 0).edit();
                edit.putString(Constants.CUSTOM_SDID_KEY, this.config.customSdid);
                edit.putString(Constants.DID_SET_CUSTOM_SDID_KEY, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                edit.commit();
                if (this.config.sdidAccessorHandler != null) {
                    this.config.sdidAccessorHandler.didSetSdid(this.config.customSdid);
                }
            }
            ConfigManager.init(new ConfigManagerRepoStorage(this.context), new ConfigManagerRepoNetwork(new GeneralHttpService()), new ConfigManager.CompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.singular.sdk.internal.ConfigManager.CompletionHandler
                public void onInitDone() {
                    BatchManager.init(SingularInstance.this.context, new BatchManagerPersistenceSqlite(singularInstance.context), new BatchManager.NetworkSender() { // from class: com.singular.sdk.internal.SingularInstance.2.1
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.singular.sdk.internal.BatchManager.NetworkSender
                        public boolean sendApi(BaseApi baseApi) {
                            try {
                                return baseApi.makeRequest(singularInstance);
                            } catch (IOException e) {
                                SingularInstance.logger.error(Utils.formatException(e));
                                return false;
                            }
                        }
                    }, new BatchManager.RegularFlowSender() { // from class: com.singular.sdk.internal.SingularInstance.2.2
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // com.singular.sdk.internal.BatchManager.RegularFlowSender
                        public void sendApi(BaseApi baseApi) {
                            SingularInstance.this.getApiManager().enqueue(baseApi);
                        }
                    });
                    BatchManager.getInstance().sendEvents();
                }
            });
            singularInstance.sessionManager = new SessionManager(singularInstance);
            this.initialized = true;
            logger.info("Singular is initialized now.");
        } catch (Throwable th) {
            logger.error("error in init()", th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void initGlobalProperties() {
        this.globalProperties = loadGlobalProperties();
        if (this.config.globalProperties.size() == 0) {
            return;
        }
        HashMap<String, String> hashMap = (HashMap) this.globalProperties.clone();
        for (SingularGlobalProperty singularGlobalProperty : this.config.globalProperties.values()) {
            if (singularGlobalProperty.isOverrideExisting() || !hashMap.containsKey(singularGlobalProperty.getKey())) {
                hashMap.put(singularGlobalProperty.getKey(), singularGlobalProperty.getValue());
            }
        }
        if (hashMap.size() > 5) {
            return;
        }
        this.globalProperties = hashMap;
        saveGlobalProperties();
        if (this.globalProperties == null) {
            clearGlobalProperties();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ApiManager getApiManager() {
        return this.apiManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Context getContext() {
        return this.context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isInitialized() {
        return this.initialized;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DeviceInfo getDeviceInfo() {
        return this.deviceInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SingularConfig getSingularConfig() {
        return this.config;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SessionManager getSessionManager() {
        return this.sessionManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getSessionId() {
        SessionManager sessionManager = this.sessionManager;
        if (sessionManager == null) {
            return -1L;
        }
        return sessionManager.getSessionId();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isSessionManagerInitialized() {
        return (!isInitialized() || getInstance() == null || getSessionManager() == null) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean logEvent(String str) {
        return logEvent(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean logEvent(String str, String str2) {
        int length = (str != null ? str.length() : 0) + (str2 != null ? str2.length() : 0);
        if (length > 3746) {
            logger.debug("Event discarded! payload length = %d", Integer.valueOf(length));
            return false;
        }
        logEvent(new ApiSubmitEvent.RawEvent(str, str2));
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void logEvent(final ApiSubmitEvent.RawEvent rawEvent) {
        if (isAllTrackingStopped()) {
            logger.debug("Tracking was stopped! not logging event!");
        } else if (!isSessionManagerInitialized()) {
            retryTask(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    SingularInstance.this.logEvent(rawEvent);
                }
            });
        } else {
            runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    ApiSubmitEvent apiSubmitEvent = new ApiSubmitEvent(rawEvent.timestamp);
                    apiSubmitEvent.addParams(ApiSubmitEvent.Params.build(rawEvent, SingularInstance.instance));
                    if (BatchManager.getInstance() == null) {
                        SingularInstance.instance.apiManager.enqueue(apiSubmitEvent);
                    } else {
                        BatchManager.getInstance().addToBatch(apiSubmitEvent);
                    }
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void logApi(final BaseApi baseApi) {
        if (isAllTrackingStopped()) {
            logger.debug("Tracking was stopped! not logging event!");
        } else if (!isSessionManagerInitialized()) {
            retryTask(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    SingularInstance.this.logApi(baseApi);
                }
            });
        } else {
            runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.6
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    SingularInstance.instance.apiManager.enqueue(baseApi);
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void logSessionStart(final long j) {
        if (isAllTrackingStopped()) {
            logger.debug("Tracking was stopped! not logging event!");
        } else {
            runOnWorkerAtFront(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.7
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    if (SingularInstance.instance != null) {
                        if (SingularInstance.this.isFirstInstall) {
                            SingularInstance.this.fetchMetaInstallReferrer();
                            SingularInstance.this.fetchDTInstallReferrer();
                            SingularInstance.this.fetchInstallReferrerAndSendSession(j);
                            return;
                        }
                        SingularInstance.this.startSession(j);
                    }
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void fetchMetaInstallReferrer() {
        new SLMetaReferrer().fetchReferrer(getContext(), new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.8
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void onInstallReferrerReceived(Map<String, Object> map) {
                SingularInstance.this.metaInstallReferrer = map;
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void fetchDTInstallReferrer() {
        new SLDigitalTurbineReferrer().fetchReferrer(getContext(), new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.9
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void onInstallReferrerReceived(Map<String, Object> map) {
                if (map == null || !map.containsKey(Constants.DT_INSTALL_REFERRER_KEY)) {
                    return;
                }
                SingularInstance.this.dtInstallReferrer = map.get(Constants.DT_INSTALL_REFERRER_KEY).toString();
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void fetchInstallReferrerAndSendSession(long j) {
        final long currentTimeMillis = Utils.getCurrentTimeMillis();
        final CountDownLatch countDownLatch = new CountDownLatch(2);
        new SLGoogleReferrer().fetchReferrer(getContext(), new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.10
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void onInstallReferrerReceived(Map<String, Object> map) {
                SingularInstance.this.googleInstallReferrer = map;
                countDownLatch.countDown();
                SingularInstance.this.installReferrerTimeInterval = Utils.lagSince(currentTimeMillis);
            }
        });
        new SLSamsungReferrer().fetchReferrer(getContext(), new SLInstallReferrerCompletionHandler() { // from class: com.singular.sdk.internal.SingularInstance.11
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.InstallReferrer.SLInstallReferrerCompletionHandler
            public void onInstallReferrerReceived(Map<String, Object> map) {
                SingularInstance.this.samsungInstallReferrer = map;
                countDownLatch.countDown();
            }
        });
        try {
            countDownLatch.await(3L, TimeUnit.SECONDS);
        } catch (InterruptedException unused) {
            logger.debug("InterruptedException!");
        }
        startSession(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void startSession(long j) {
        ApiStartSession apiStartSession = new ApiStartSession(j);
        apiStartSession.addParams(ApiStartSession.Params.build(j, instance));
        instance.apiManager.enqueue(apiStartSession);
        instance.config.openUri = null;
        instance.isFirstInstall = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void logSetDeviceCustomUserId() {
        if (isAllTrackingStopped()) {
            logger.debug("Tracking was stopped! not logging event!");
        } else {
            runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.12
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    ApiCustomUserId apiCustomUserId = new ApiCustomUserId(Utils.getCurrentTimeMillis());
                    apiCustomUserId.addParams(ApiCustomUserId.Params.build(SingularInstance.instance));
                    SingularInstance.instance.apiManager.enqueue(apiCustomUserId);
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void retryTask(Runnable runnable) {
        if (retryCounter < 10) {
            runOnWorkerDelayed(runnable, 200);
            retryCounter++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void runOnWorker(Runnable runnable) {
        this.worker.post(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void runOnWorkerAtFront(Runnable runnable) {
        this.worker.postAtFront(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void runOnWorkerDelayed(Runnable runnable, int i) {
        this.worker.postDelayed(runnable, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onActivityPaused(long j) {
        this.sessionManager.onExitForeground(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onActivityResumed(long j) {
        SessionManager sessionManager = this.sessionManager;
        if (sessionManager != null) {
            sessionManager.onEnterForeground(j);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void startSessionIfOpenedWithDeeplink() {
        if (this.config.singularLink == null) {
            return;
        }
        runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.13
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                SingularInstance.this.sessionManager.startNewSession(Utils.getCurrentTimeMillis());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void saveGCMDeviceToken(String str) {
        saveDeviceToken(Constants.GCM_DEVICE_TOKEN_KEY, str);
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo != null) {
            deviceInfo.setGcmRegId(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void saveFCMDeviceToken(String str) {
        saveDeviceToken(Constants.FCM_DEVICE_TOKEN_KEY, str);
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo != null) {
            deviceInfo.setFcmRegId(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void saveCustomUserId(String str) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(Constants.CUSTOM_USER_ID_KEY, str);
        edit.commit();
        DeviceInfo deviceInfo = this.deviceInfo;
        if (deviceInfo != null) {
            deviceInfo.setCustomUserId(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void saveDeviceToken(String str, String str2) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(str, str2);
        edit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void sendTrackingOptIn() {
        runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.14
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                ApiGDPRConsent apiGDPRConsent = new ApiGDPRConsent(Utils.getCurrentTimeMillis());
                apiGDPRConsent.addParams(ApiGDPRConsent.Params.build(this));
                SingularInstance.this.logApi(apiGDPRConsent);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void sendTrackingUnder13() {
        runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.15
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                ApiGDPRUnder13 apiGDPRUnder13 = new ApiGDPRUnder13(Utils.getCurrentTimeMillis());
                apiGDPRUnder13.addParams(ApiGDPRUnder13.Params.build(this));
                SingularInstance.this.logApi(apiGDPRUnder13);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void stopAllTracking() {
        persistBoolean(Constants.STOP_ALL_TRACKING_KEY, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resumeAllTracking() {
        persistBoolean(Constants.STOP_ALL_TRACKING_KEY, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAllTrackingStopped() {
        return getSharedPreferences().getBoolean(Constants.STOP_ALL_TRACKING_KEY, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void limitDataSharing(boolean z) {
        saveBooleanToPref("limit_data_sharing", z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Boolean getLimitDataSharing() {
        SharedPreferences sharedPreferences = getSharedPreferences();
        if (sharedPreferences.contains("limit_data_sharing")) {
            return Boolean.valueOf(sharedPreferences.getBoolean("limit_data_sharing", false));
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map getGoogleInstallReferrer() {
        return this.googleInstallReferrer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map getSamsungInstallReferrer() {
        return this.samsungInstallReferrer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getDTInstallReferrer() {
        return this.dtInstallReferrer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map getMetaInstallReferrer() {
        return this.metaInstallReferrer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean getIsFirstInstall() {
        return this.isFirstInstall;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double getInstallReferrerTimeInterval() {
        return this.installReferrerTimeInterval;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SharedPreferences getSharedPreferences() {
        return this.context.getSharedPreferences(Constants.PREF_SESSION, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void persistBoolean(final String str, final boolean z) {
        runOnWorker(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.16
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                SingularInstance.this.saveBooleanToPref(str, z);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void saveBooleanToPref(String str, boolean z) {
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putBoolean(str, z);
        edit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setIMEI(String str) {
        Utils.setImei(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashMap<String, String> getGlobalProperties() {
        return this.globalProperties;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public JSONObject getGlobalPropertiesJSON() {
        return new JSONObject(this.globalProperties);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean putGlobalProperty(SingularGlobalProperty singularGlobalProperty) {
        if (this.globalProperties.containsKey(singularGlobalProperty.getKey())) {
            if (singularGlobalProperty.isOverrideExisting()) {
                this.globalProperties.put(singularGlobalProperty.getKey(), singularGlobalProperty.getValue());
            }
            return true;
        }
        if (this.globalProperties.size() >= 5) {
            return false;
        }
        this.globalProperties.put(singularGlobalProperty.getKey(), singularGlobalProperty.getValue());
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setGlobalProperty(SingularGlobalProperty singularGlobalProperty) {
        if (!putGlobalProperty(singularGlobalProperty)) {
            return false;
        }
        saveGlobalProperties();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void removeGlobalProperty(String str) {
        if (Utils.isEmptyOrNull(str) || !this.globalProperties.containsKey(str)) {
            return;
        }
        this.globalProperties.remove(str);
        saveGlobalProperties();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clearGlobalProperties() {
        this.globalProperties = null;
        saveGlobalProperties();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void saveGlobalProperties() {
        if (this.globalProperties == null) {
            this.globalProperties = new HashMap<>();
        }
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        edit.putString(Constants.GLOBAL_PROPERTIES_KEY, getGlobalPropertiesJSON().toString());
        edit.commit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public HashMap<String, String> loadGlobalProperties() {
        JSONObject jSONObject;
        try {
            jSONObject = new JSONObject(getSharedPreferences().getString(Constants.GLOBAL_PROPERTIES_KEY, "{}"));
        } catch (Throwable unused) {
            jSONObject = new JSONObject();
        }
        HashMap<String, String> hashMap = new HashMap<>();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            try {
                String next = keys.next();
                hashMap.put(next, jSONObject.getString(next));
            } catch (Throwable unused2) {
            }
        }
        return hashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void createReferrerShortLink(String str, String str2, String str3, JSONObject jSONObject, ShortLinkHandler shortLinkHandler) {
        if (!ReferrerLinkService.validateRequest(str, str2, str3, jSONObject)) {
            shortLinkHandler.onError("Error sending request: could not validate request params");
            return;
        }
        try {
            ReferrerLinkService.sendReferrerRequest(ReferrerLinkService.unifyParamsToUrl(str, str2, str3, jSONObject), shortLinkHandler);
        } catch (JSONException e) {
            logger.error("Error in JSON parsing ", e);
            shortLinkHandler.onError("Error sending request: could not unify params");
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void handleDeviceAttributionData(JSONObject jSONObject) {
        try {
            final Map map = (Map) new GsonBuilder().setObjectToNumberStrategy(ToNumberPolicy.LONG_OR_DOUBLE).create().fromJson(jSONObject.toString(), Map.class);
            final SingularDeviceAttributionHandler singularDeviceAttributionHandler = this.config.deviceAttributionHandler;
            if (map == null || singularDeviceAttributionHandler == null) {
                return;
            }
            Executors.newSingleThreadExecutor().execute(new Runnable() { // from class: com.singular.sdk.internal.SingularInstance.17
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public void run() {
                    singularDeviceAttributionHandler.onDeviceAttributionInfoReceived(map);
                }
            });
        } catch (Throwable th) {
            logger.debug("could not convert device attribution json object to map" + th.getMessage());
        }
    }
}
