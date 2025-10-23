package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhu implements Runnable {
    private final /* synthetic */ zzbe zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzhh zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhu(zzhh zzhhVar, zzbe zzbeVar, String str) {
        this.zza = zzbeVar;
        this.zzb = str;
        this.zzc = zzhhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmpVar = this.zzc.zza;
        zzmpVar.zzr();
        zzmpVar2 = this.zzc.zza;
        zzmpVar2.zza(this.zza, this.zzb);
    }
}
