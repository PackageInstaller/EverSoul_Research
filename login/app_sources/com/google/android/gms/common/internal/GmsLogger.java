package com.google.android.gms.common.internal;

import android.util.Log;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class GmsLogger {
    private final String zza;
    private final String zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GmsLogger(String str) {
        this(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zza(String str) {
        String str2 = this.zzb;
        return str2 == null ? str : str2.concat(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final String zzb(String str, Object... objArr) {
        String str2 = this.zzb;
        String format = String.format(str, objArr);
        return str2 == null ? format : str2.concat(format);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean canLog(int i) {
        return Log.isLoggable(this.zza, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean canLogPii() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public void m143d(String str, String str2) {
        if (canLog(3)) {
            Log.d(str, zza(str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public void m145e(String str, String str2) {
        if (canLog(6)) {
            Log.e(str, zza(str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void efmt(String str, String str2, Object... objArr) {
        if (canLog(6)) {
            Log.e(str, zzb(str2, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public void m147i(String str, String str2) {
        if (canLog(4)) {
            Log.i(str, zza(str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void pii(String str, String str2) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void pii(String str, String str2, Throwable th) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: v */
    public void m149v(String str, String str2) {
        if (canLog(2)) {
            Log.v(str, zza(str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public void m151w(String str, String str2) {
        if (canLog(5)) {
            Log.w(str, zza(str2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void wfmt(String str, String str2, Object... objArr) {
        if (canLog(5)) {
            Log.w(this.zza, zzb(str2, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void wtf(String str, String str2, Throwable th) {
        if (canLog(7)) {
            Log.e(str, zza(str2), th);
            Log.wtf(str, zza(str2), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GmsLogger(String str, String str2) {
        Preconditions.checkNotNull(str, "log tag cannot be null");
        Preconditions.checkArgument(str.length() <= 23, "tag \"%s\" is longer than the %d character maximum", str, 23);
        this.zza = str;
        this.zzb = (str2 == null || str2.length() <= 0) ? null : str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public void m144d(String str, String str2, Throwable th) {
        if (canLog(3)) {
            Log.d(str, zza(str2), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public void m146e(String str, String str2, Throwable th) {
        if (canLog(6)) {
            Log.e(str, zza(str2), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public void m148i(String str, String str2, Throwable th) {
        if (canLog(4)) {
            Log.i(str, zza(str2), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: v */
    public void m150v(String str, String str2, Throwable th) {
        if (canLog(2)) {
            Log.v(str, zza(str2), th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public void m152w(String str, String str2, Throwable th) {
        if (canLog(5)) {
            Log.w(str, zza(str2), th);
        }
    }
}
