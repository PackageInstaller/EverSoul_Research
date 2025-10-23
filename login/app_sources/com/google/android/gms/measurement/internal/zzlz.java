package com.google.android.gms.measurement.internal;

import android.os.Handler;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlz {
    final /* synthetic */ zzly zza;
    private zzmc zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlz(zzly zzlyVar) {
        this.zza = zzlyVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza(long j) {
        Handler handler;
        this.zzb = new zzmc(this, this.zza.zzb().currentTimeMillis(), j);
        handler = this.zza.zzc;
        handler.postDelayed(this.zzb, 2000L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void zza() {
        Handler handler;
        this.zza.zzt();
        if (this.zzb != null) {
            handler = this.zza.zzc;
            handler.removeCallbacks(this.zzb);
        }
        this.zza.zzk().zzn.zza(false);
        this.zza.zza(false);
    }
}
