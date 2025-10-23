package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzko implements Runnable {
    private final /* synthetic */ zzki zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ zzkh zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzko(zzkh zzkhVar, zzki zzkiVar, long j) {
        this.zza = zzkiVar;
        this.zzb = j;
        this.zzc = zzkhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzc.zza(this.zza, false, this.zzb);
        this.zzc.zza = null;
        this.zzc.zzo().zza((zzki) null);
    }
}
