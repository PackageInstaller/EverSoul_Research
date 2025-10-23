package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzks implements Runnable {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzo zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzcv zze;
    private final /* synthetic */ zzkq zzf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzks(zzkq zzkqVar, String str, String str2, zzo zzoVar, boolean z, com.google.android.gms.internal.measurement.zzcv zzcvVar) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = zzoVar;
        this.zzd = z;
        this.zze = zzcvVar;
        this.zzf = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        Bundle bundle = new Bundle();
        try {
            zzfiVar = this.zzf.zzb;
            if (zzfiVar == null) {
                this.zzf.zzj().zzg().zza("Failed to get user properties; not connected to service", this.zza, this.zzb);
                return;
            }
            Preconditions.checkNotNull(this.zzc);
            Bundle zza = zzng.zza(zzfiVar.zza(this.zza, this.zzb, this.zzd, this.zzc));
            this.zzf.zzam();
            this.zzf.zzq().zza(this.zze, zza);
        } catch (RemoteException e) {
            this.zzf.zzj().zzg().zza("Failed to get user properties; remote exception", this.zza, e);
        } finally {
            this.zzf.zzq().zza(this.zze, bundle);
        }
    }
}
