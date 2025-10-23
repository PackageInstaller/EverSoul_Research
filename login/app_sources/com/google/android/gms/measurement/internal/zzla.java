package com.google.android.gms.measurement.internal;

import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzla implements Runnable {
    private final /* synthetic */ zzki zza;
    private final /* synthetic */ zzkq zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzla(zzkq zzkqVar, zzki zzkiVar) {
        this.zza = zzkiVar;
        this.zzb = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        zzfiVar = this.zzb.zzb;
        if (zzfiVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to service");
            return;
        }
        try {
            zzki zzkiVar = this.zza;
            if (zzkiVar == null) {
                zzfiVar.zza(0L, (String) null, (String) null, this.zzb.zza().getPackageName());
            } else {
                zzfiVar.zza(zzkiVar.zzc, this.zza.zza, this.zza.zzb, this.zzb.zza().getPackageName());
            }
            this.zzb.zzam();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send current screen to the service", e);
        }
    }
}
