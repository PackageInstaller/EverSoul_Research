package com.google.android.gms.measurement.internal;

import android.os.Handler;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
abstract class zzat {
    private static volatile Handler zza;
    private final zzid zzb;
    private final Runnable zzc;
    private volatile long zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Handler zzd() {
        Handler handler;
        if (zza != null) {
            return zza;
        }
        synchronized (zzat.class) {
            if (zza == null) {
                zza = new com.google.android.gms.internal.measurement.zzcp(this.zzb.zza().getMainLooper());
            }
            handler = zza;
        }
        return handler;
    }

    public abstract void zzb();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzat(zzid zzidVar) {
        Preconditions.checkNotNull(zzidVar);
        this.zzb = zzidVar;
        this.zzc = new zzaw(this, zzidVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza() {
        this.zzd = 0L;
        zzd().removeCallbacks(this.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(long j) {
        zza();
        if (j >= 0) {
            this.zzd = this.zzb.zzb().currentTimeMillis();
            if (zzd().postDelayed(this.zzc, j)) {
                return;
            }
            this.zzb.zzj().zzg().zza("Failed to schedule delayed post. time", Long.valueOf(j));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzc() {
        return this.zzd != 0;
    }
}
