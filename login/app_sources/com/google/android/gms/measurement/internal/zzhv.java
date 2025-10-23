package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhv implements Runnable {
    private final /* synthetic */ zzbe zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzhh zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhv(zzhh zzhhVar, zzbe zzbeVar, zzo zzoVar) {
        this.zza = zzbeVar;
        this.zzb = zzoVar;
        this.zzc = zzhhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zzc(this.zzc.zzb(this.zza, this.zzb), this.zzb);
    }
}
