package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhk implements Runnable {
    private final /* synthetic */ zzae zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzhh zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhk(zzhh zzhhVar, zzae zzaeVar, zzo zzoVar) {
        this.zza = zzaeVar;
        this.zzb = zzoVar;
        this.zzc = zzhhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmp zzmpVar3;
        zzmpVar = this.zzc.zza;
        zzmpVar.zzr();
        if (this.zza.zzc.zza() == null) {
            zzmpVar3 = this.zzc.zza;
            zzmpVar3.zza(this.zza, this.zzb);
        } else {
            zzmpVar2 = this.zzc.zza;
            zzmpVar2.zzb(this.zza, this.zzb);
        }
    }
}
