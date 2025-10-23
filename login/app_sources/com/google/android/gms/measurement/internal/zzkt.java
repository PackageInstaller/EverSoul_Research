package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkt implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ boolean zzb;
    private final /* synthetic */ zznb zzc;
    private final /* synthetic */ zzkq zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzkt(zzkq zzkqVar, zzo zzoVar, boolean z, zznb zznbVar) {
        this.zza = zzoVar;
        this.zzb = z;
        this.zzc = zznbVar;
        this.zzd = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        zzfiVar = this.zzd.zzb;
        if (zzfiVar == null) {
            this.zzd.zzj().zzg().zza("Discarding data. Failed to set user property");
            return;
        }
        Preconditions.checkNotNull(this.zza);
        this.zzd.zza(zzfiVar, this.zzb ? null : this.zzc, this.zza);
        this.zzd.zzam();
    }
}
