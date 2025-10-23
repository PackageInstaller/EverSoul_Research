package com.google.android.gms.common.config;

import android.os.Binder;
import android.os.StrictMode;
import android.util.Log;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public abstract class GservicesValue<T> {
    private static final Object zzc = new Object();
    protected final String zza;
    protected final Object zzb;
    private Object zzd = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected GservicesValue(String str, Object obj) {
        this.zza = str;
        this.zzb = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ResultIgnorabilityUnspecified
    public static boolean isInitialized() {
        synchronized (zzc) {
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GservicesValue<Float> value(String str, Float f) {
        return new zzd(str, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GservicesValue<Integer> value(String str, Integer num) {
        return new zzc(str, num);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GservicesValue<Long> value(String str, Long l) {
        return new zzb(str, l);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GservicesValue<String> value(String str, String str2) {
        return new zze(str, str2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GservicesValue<Boolean> value(String str, boolean z) {
        return new zza(str, Boolean.valueOf(z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ResultIgnorabilityUnspecified
    public final T get() {
        T t;
        T t2 = (T) this.zzd;
        if (t2 != null) {
            return t2;
        }
        StrictMode.ThreadPolicy allowThreadDiskReads = StrictMode.allowThreadDiskReads();
        Object obj = zzc;
        synchronized (obj) {
        }
        synchronized (obj) {
            try {
            } finally {
                StrictMode.setThreadPolicy(allowThreadDiskReads);
            }
        }
        try {
            t = (T) zza(this.zza);
        } catch (SecurityException unused) {
            long clearCallingIdentity = Binder.clearCallingIdentity();
            try {
                t = (T) zza(this.zza);
            } finally {
                Binder.restoreCallingIdentity(clearCallingIdentity);
            }
        }
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final T getBinderSafe() {
        return get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void override(T t) {
        Log.w("GservicesValue", "GservicesValue.override(): test should probably call initForTests() first");
        this.zzd = t;
        Object obj = zzc;
        synchronized (obj) {
            synchronized (obj) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resetOverride() {
        this.zzd = null;
    }

    protected abstract Object zza(String str);
}
