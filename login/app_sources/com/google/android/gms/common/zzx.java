package com.google.android.gms.common;

import android.util.Log;
import com.google.errorprone.annotations.CheckReturnValue;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
@CheckReturnValue
/* loaded from: classes.dex */
class zzx {
    private static final zzx zze = new zzx(true, 3, 1, null, null);
    final boolean zza;

    @Nullable
    final String zzb;

    @Nullable
    final Throwable zzc;
    final int zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzx(boolean z, int i, int i2, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzd = i;
        this.zzb = str;
        this.zzc = th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    static zzx zzb() {
        return zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzx zzc(String str) {
        return new zzx(false, 1, 5, str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzx zzd(String str, Throwable th) {
        return new zzx(false, 1, 5, str, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzx zzf(int i) {
        return new zzx(true, i, 1, null, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzx zzg(int i, int i2, String str, @Nullable Throwable th) {
        return new zzx(false, i, i2, str, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Nullable
    String zza() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zze() {
        if (this.zza || !Log.isLoggable("GoogleCertificatesRslt", 3)) {
            return;
        }
        if (this.zzc != null) {
            Log.d("GoogleCertificatesRslt", zza(), this.zzc);
        } else {
            Log.d("GoogleCertificatesRslt", zza());
        }
    }
}
