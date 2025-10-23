package com.google.firebase.perf.config;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.firebase.FirebaseApp;
import com.google.firebase.perf.logging.AndroidLogger;
import com.google.firebase.perf.util.Optional;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public class DeviceCacheManager {
    private static final String PREFS_NAME = "FirebasePerfSharedPrefs";
    private static DeviceCacheManager instance;
    private static final AndroidLogger logger = AndroidLogger.getInstance();
    private final ExecutorService serialExecutor;
    private volatile SharedPreferences sharedPref;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DeviceCacheManager(ExecutorService executorService) {
        this.serialExecutor = executorService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized DeviceCacheManager getInstance() {
        DeviceCacheManager deviceCacheManager;
        synchronized (DeviceCacheManager.class) {
            if (instance == null) {
                instance = new DeviceCacheManager(Executors.newSingleThreadExecutor());
            }
            deviceCacheManager = instance;
        }
        return deviceCacheManager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void clearInstance() {
        instance = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void setContext(final Context context) {
        if (this.sharedPref == null && context != null) {
            this.serialExecutor.execute(new Runnable() { // from class: com.google.firebase.perf.config.DeviceCacheManager$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.Runnable
                public final void run() {
                    DeviceCacheManager.this.m424xa0ef4a14(context);
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$setContext$0$com-google-firebase-perf-config-DeviceCacheManager */
    /* synthetic */ void m424xa0ef4a14(Context context) {
        if (this.sharedPref != null || context == null) {
            return;
        }
        this.sharedPref = context.getSharedPreferences("FirebasePerfSharedPrefs", 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean containsKey(String str) {
        return (this.sharedPref == null || str == null || !this.sharedPref.contains(str)) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Boolean> getBoolean(String str) {
        if (str == null) {
            logger.debug("Key is null when getting boolean value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.m443of(Boolean.valueOf(this.sharedPref.getBoolean(str, false)));
        } catch (ClassCastException e) {
            logger.debug("Key %s from sharedPreferences has type other than long: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear(String str) {
        if (str == null) {
            logger.debug("Key is null. Cannot clear nullable key");
        } else {
            this.sharedPref.edit().remove(str).apply();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setValue(String str, boolean z) {
        if (str == null) {
            logger.debug("Key is null when setting boolean value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putBoolean(str, z).apply();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<String> getString(String str) {
        if (str == null) {
            logger.debug("Key is null when getting String value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.m443of(this.sharedPref.getString(str, ""));
        } catch (ClassCastException e) {
            logger.debug("Key %s from sharedPreferences has type other than String: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setValue(String str, String str2) {
        if (str == null) {
            logger.debug("Key is null when setting String value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        if (str2 == null) {
            this.sharedPref.edit().remove(str).apply();
            return true;
        }
        this.sharedPref.edit().putString(str, str2).apply();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Double> getDouble(String str) {
        if (str == null) {
            logger.debug("Key is null when getting double value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            try {
                return Optional.m443of(Double.valueOf(Double.longBitsToDouble(this.sharedPref.getLong(str, 0L))));
            } catch (ClassCastException e) {
                logger.debug("Key %s from sharedPreferences has type other than double: %s", str, e.getMessage());
                return Optional.absent();
            }
        } catch (ClassCastException unused) {
            return Optional.m443of(Double.valueOf(Float.valueOf(this.sharedPref.getFloat(str, 0.0f)).doubleValue()));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setValue(String str, double d) {
        if (str == null) {
            logger.debug("Key is null when setting double value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(str, Double.doubleToRawLongBits(d)).apply();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Optional<Long> getLong(String str) {
        if (str == null) {
            logger.debug("Key is null when getting long value on device cache.");
            return Optional.absent();
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return Optional.absent();
            }
        }
        if (!this.sharedPref.contains(str)) {
            return Optional.absent();
        }
        try {
            return Optional.m443of(Long.valueOf(this.sharedPref.getLong(str, 0L)));
        } catch (ClassCastException e) {
            logger.debug("Key %s from sharedPreferences has type other than long: %s", str, e.getMessage());
            return Optional.absent();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean setValue(String str, long j) {
        if (str == null) {
            logger.debug("Key is null when setting long value on device cache.");
            return false;
        }
        if (this.sharedPref == null) {
            setContext(getFirebaseApplicationContext());
            if (this.sharedPref == null) {
                return false;
            }
        }
        this.sharedPref.edit().putLong(str, j).apply();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Context getFirebaseApplicationContext() {
        try {
            FirebaseApp.getInstance();
            return FirebaseApp.getInstance().getApplicationContext();
        } catch (IllegalStateException unused) {
            return null;
        }
    }
}
