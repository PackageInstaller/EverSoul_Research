package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhn implements Runnable {
    private final /* synthetic */ zzae zza;
    private final /* synthetic */ zzhh zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhn(zzhh zzhhVar, zzae zzaeVar) {
        this.zza = zzaeVar;
        this.zzb = zzhhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmp zzmpVar3;
        zzmpVar = this.zzb.zza;
        zzmpVar.zzr();
        if (this.zza.zzc.zza() == null) {
            zzmpVar3 = this.zzb.zza;
            zzmpVar3.zza(this.zza);
        } else {
            zzmpVar2 = this.zzb.zza;
            zzmpVar2.zzb(this.zza);
        }
    }
}
