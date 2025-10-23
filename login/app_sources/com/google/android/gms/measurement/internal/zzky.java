package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzky implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzcv zzb;
    private final /* synthetic */ zzkq zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzky(zzkq zzkqVar, zzo zzoVar, com.google.android.gms.internal.measurement.zzcv zzcvVar) {
        this.zza = zzoVar;
        this.zzb = zzcvVar;
        this.zzc = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        try {
            if (!this.zzc.zzk().zzn().zzh()) {
                this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zza((String) null);
                this.zzc.zzk().zze.zza(null);
                return;
            }
            zzfiVar = this.zzc.zzb;
            if (zzfiVar == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(this.zza);
            String zzb = zzfiVar.zzb(this.zza);
            if (zzb != null) {
                this.zzc.zzm().zza(zzb);
                this.zzc.zzk().zze.zza(zzb);
            }
            this.zzc.zzam();
            this.zzc.zzq().zza(this.zzb, zzb);
        } catch (RemoteException e) {
            this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
        } finally {
            this.zzc.zzq().zza(this.zzb, (String) null);
        }
    }
}
