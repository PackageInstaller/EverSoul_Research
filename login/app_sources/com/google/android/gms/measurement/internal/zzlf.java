package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlf implements Runnable {
    private final /* synthetic */ boolean zza = true;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzae zzd;
    private final /* synthetic */ zzae zze;
    private final /* synthetic */ zzkq zzf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlf(zzkq zzkqVar, boolean z, zzo zzoVar, boolean z2, zzae zzaeVar, zzae zzaeVar2) {
        this.zzb = zzoVar;
        this.zzc = z2;
        this.zzd = zzaeVar;
        this.zze = zzaeVar2;
        this.zzf = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        zzfiVar = this.zzf.zzb;
        if (zzfiVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send conditional user property to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfiVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze.zza)) {
                    Preconditions.checkNotNull(this.zzb);
                    zzfiVar.zza(this.zzd, this.zzb);
                } else {
                    zzfiVar.zza(this.zzd);
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("Failed to send conditional user property to the service", e);
            }
        }
        this.zzf.zzam();
    }
}
