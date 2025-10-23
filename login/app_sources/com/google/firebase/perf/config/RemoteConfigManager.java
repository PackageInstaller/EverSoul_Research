package com.google.firebase.perf.config;

import android.content.Context;
import android.content.pm.PackageManager;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.StartupTime;
import com.google.firebase.inject.Provider;
import com.google.firebase.perf.config.ConfigurationConstants;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;
import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import com.google.firebase.remoteconfig.FirebaseRemoteConfigValue;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class RemoteConfigManager {
    private static final long FETCH_NEVER_HAPPENED_TIMESTAMP_MS = 0;
    private static final String FIREPERF_FRC_NAMESPACE_NAME = "fireperf";
    private static final long MIN_APP_START_CONFIG_FETCH_DELAY_MS = 5000;
    private static final int RANDOM_APP_START_CONFIG_FETCH_DELAY_MS = 25000;
    private final ConcurrentHashMap<String, FirebaseRemoteConfigValue> allRcConfigMap;
    private final long appStartConfigFetchDelayInMs;
    private final long appStartTimeInMs;
    private final DeviceCacheManager cache;
    private final Executor executor;
    private FirebaseRemoteConfig firebaseRemoteConfig;
    private long firebaseRemoteConfigLastFetchTimestampMs;
    private Provider<RemoteConfigComponent> firebaseRemoteConfigProvider;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private static final RemoteConfigManager instance = new RemoteConfigManager();
    private static final long TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS = TimeUnit.HOURS.toMillis(12);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private RemoteConfigManager() {
        this(DeviceCacheManager.getInstance(), new ThreadPoolExecutor(0, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue()), null, new Random().nextInt(RANDOM_APP_START_CONFIG_FETCH_DELAY_MS) + 5000, getInitialStartupMillis());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static long getInitialStartupMillis() {
        StartupTime startupTime = (StartupTime) FirebaseApp.getInstance().get(StartupTime.class);
        if (startupTime != null) {
            return startupTime.getEpochMillis();
        }
        return System.currentTimeMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RemoteConfigManager(DeviceCacheManager deviceCacheManager, Executor executor, FirebaseRemoteConfig firebaseRemoteConfig, long j, long j2) {
        ConcurrentHashMap<String, FirebaseRemoteConfigValue> concurrentHashMap;
        this.firebaseRemoteConfigLastFetchTimestampMs = 0L;
        this.cache = deviceCacheManager;
        this.executor = executor;
        this.firebaseRemoteConfig = firebaseRemoteConfig;
        if (firebaseRemoteConfig == null) {
            concurrentHashMap = new ConcurrentHashMap<>();
        } else {
            concurrentHashMap = new ConcurrentHashMap<>(firebaseRemoteConfig.getAll());
        }
        this.allRcConfigMap = concurrentHashMap;
        this.appStartTimeInMs = j2;
        this.appStartConfigFetchDelayInMs = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static RemoteConfigManager getInstance() {
        return instance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setFirebaseRemoteConfigProvider(Provider<RemoteConfigComponent> provider) {
        this.firebaseRemoteConfigProvider = provider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Double> getDouble(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config double value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.m443of(Double.valueOf(remoteConfigValue.asDouble()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Long> getLong(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config long value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.m443of(Long.valueOf(remoteConfigValue.asLong()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config boolean value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            try {
                return Optional.m443of(Boolean.valueOf(remoteConfigValue.asBoolean()));
            } catch (IllegalArgumentException unused) {
                if (!remoteConfigValue.asString().isEmpty()) {
                    logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                }
            }
        }
        return Optional.absent();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<String> getString(String str) {
        if (str == null) {
            logger.debug("The key to get Remote Config String value is null.");
            return Optional.absent();
        }
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue != null) {
            return Optional.m443of(remoteConfigValue.asString());
        }
        return Optional.absent();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> T getRemoteConfigValueOrDefault(String str, T t) {
        Object obj;
        FirebaseRemoteConfigValue remoteConfigValue = getRemoteConfigValue(str);
        if (remoteConfigValue == null) {
            return t;
        }
        try {
            if (t instanceof Boolean) {
                obj = Boolean.valueOf(remoteConfigValue.asBoolean());
            } else if (t instanceof Double) {
                obj = Double.valueOf(remoteConfigValue.asDouble());
            } else {
                if (!(t instanceof Long) && !(t instanceof Integer)) {
                    if (t instanceof String) {
                        obj = remoteConfigValue.asString();
                    } else {
                        T t2 = (T) remoteConfigValue.asString();
                        try {
                            logger.debug("No matching type found for the defaultValue: '%s', using String.", t);
                            return t2;
                        } catch (IllegalArgumentException unused) {
                            t = t2;
                            if (remoteConfigValue.asString().isEmpty()) {
                                return t;
                            }
                            logger.debug("Could not parse value: '%s' for key: '%s'.", remoteConfigValue.asString(), str);
                            return t;
                        }
                    }
                }
                obj = Long.valueOf(remoteConfigValue.asLong());
            }
            return obj;
        } catch (IllegalArgumentException unused2) {
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FirebaseRemoteConfigValue getRemoteConfigValue(String str) {
        triggerRemoteConfigFetchIfNecessary();
        if (!isFirebaseRemoteConfigAvailable() || !this.allRcConfigMap.containsKey(str)) {
            return null;
        }
        FirebaseRemoteConfigValue firebaseRemoteConfigValue = this.allRcConfigMap.get(str);
        if (firebaseRemoteConfigValue.getSource() != 2) {
            return null;
        }
        logger.debug("Fetched value: '%s' for key: '%s' from Firebase Remote Config.", firebaseRemoteConfigValue.asString(), str);
        return firebaseRemoteConfigValue;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isLastFetchFailed() {
        FirebaseRemoteConfig firebaseRemoteConfig = this.firebaseRemoteConfig;
        return firebaseRemoteConfig == null || firebaseRemoteConfig.getInfo().getLastFetchStatus() == 1 || this.firebaseRemoteConfig.getInfo().getLastFetchStatus() == 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void triggerRemoteConfigFetchIfNecessary() {
        if (isFirebaseRemoteConfigAvailable()) {
            if (this.allRcConfigMap.isEmpty()) {
                this.allRcConfigMap.putAll(this.firebaseRemoteConfig.getAll());
            }
            if (shouldFetchAndActivateRemoteConfigValues()) {
                triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch() {
        this.firebaseRemoteConfigLastFetchTimestampMs = getCurrentSystemTimeMillis();
        this.firebaseRemoteConfig.fetchAndActivate().addOnSuccessListener(this.executor, new OnSuccessListener() { // from class: com.google.firebase.perf.config.RemoteConfigManager$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                RemoteConfigManager.this.m425xa8c2d88f((Boolean) obj);
            }
        }).addOnFailureListener(this.executor, new OnFailureListener() { // from class: com.google.firebase.perf.config.RemoteConfigManager$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                RemoteConfigManager.this.m426x35fd8a10(exc);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$0$com-google-firebase-perf-config-RemoteConfigManager */
    /* synthetic */ void m425xa8c2d88f(Boolean bool) {
        syncConfigValues(this.firebaseRemoteConfig.getAll());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$triggerFirebaseRemoteConfigFetchAndActivateOnSuccessfulFetch$1$com-google-firebase-perf-config-RemoteConfigManager */
    /* synthetic */ void m426x35fd8a10(Exception exc) {
        logger.warn("Call to Remote Config failed: %s. This may cause a degraded experience with Firebase Performance. Please reach out to Firebase Support https://firebase.google.com/support/", exc);
        this.firebaseRemoteConfigLastFetchTimestampMs = 0L;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void syncConfigValues(Map<String, FirebaseRemoteConfigValue> map) {
        this.allRcConfigMap.putAll(map);
        for (String str : this.allRcConfigMap.keySet()) {
            if (!map.containsKey(str)) {
                this.allRcConfigMap.remove(str);
            }
        }
        ConfigurationConstants.ExperimentTTID experimentTTID = ConfigurationConstants.ExperimentTTID.getInstance();
        FirebaseRemoteConfigValue firebaseRemoteConfigValue = this.allRcConfigMap.get(experimentTTID.getRemoteConfigFlag());
        if (firebaseRemoteConfigValue != null) {
            try {
                this.cache.setValue(experimentTTID.getDeviceCacheFlag(), firebaseRemoteConfigValue.asBoolean());
                return;
            } catch (Exception unused) {
                logger.debug("ExperimentTTID remote config flag has invalid value, expected boolean.");
                return;
            }
        }
        logger.debug("ExperimentTTID remote config flag does not exist.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected long getCurrentSystemTimeMillis() {
        return System.currentTimeMillis();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFirebaseRemoteConfigAvailable() {
        Provider<RemoteConfigComponent> provider;
        RemoteConfigComponent remoteConfigComponent;
        if (this.firebaseRemoteConfig == null && (provider = this.firebaseRemoteConfigProvider) != null && (remoteConfigComponent = provider.get()) != null) {
            this.firebaseRemoteConfig = remoteConfigComponent.get(FIREPERF_FRC_NAMESPACE_NAME);
        }
        return this.firebaseRemoteConfig != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean shouldFetchAndActivateRemoteConfigValues() {
        long currentSystemTimeMillis = getCurrentSystemTimeMillis();
        return hasAppStartConfigFetchDelayElapsed(currentSystemTimeMillis) && hasLastFetchBecomeStale(currentSystemTimeMillis);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean hasAppStartConfigFetchDelayElapsed(long j) {
        return j - this.appStartTimeInMs >= this.appStartConfigFetchDelayInMs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean hasLastFetchBecomeStale(long j) {
        return j - this.firebaseRemoteConfigLastFetchTimestampMs > TIME_AFTER_WHICH_A_FETCH_IS_CONSIDERED_STALE_MS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getVersionCode(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            return 0;
        }
    }
}
