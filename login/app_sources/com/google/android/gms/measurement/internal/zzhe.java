package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhe implements Runnable {
    private final /* synthetic */ zzim zza;
    private final /* synthetic */ zzhd zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhe(zzhd zzhdVar, zzim zzimVar) {
        this.zza = zzimVar;
        this.zzb = zzhdVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzhd.zza(this.zzb, this.zza);
        this.zzb.zza(this.zza.zzg);
    }
}
