package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlg implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzbe zzd;
    private final /* synthetic */ String zze;
    private final /* synthetic */ zzkq zzf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlg(zzkq zzkqVar, boolean z, zzo zzoVar, boolean z2, zzbe zzbeVar, String str) {
        this.zza = z;
        this.zzb = zzoVar;
        this.zzc = z2;
        this.zzd = zzbeVar;
        this.zze = str;
        this.zzf = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        zzfiVar = this.zzf.zzb;
        if (zzfiVar == null) {
            this.zzf.zzj().zzg().zza("Discarding data. Failed to send event to service");
            return;
        }
        if (this.zza) {
            Preconditions.checkNotNull(this.zzb);
            this.zzf.zza(zzfiVar, this.zzc ? null : this.zzd, this.zzb);
        } else {
            try {
                if (TextUtils.isEmpty(this.zze)) {
                    Preconditions.checkNotNull(this.zzb);
                    zzfiVar.zza(this.zzd, this.zzb);
                } else {
                    zzfiVar.zza(this.zzd, this.zze, this.zzf.zzj().zzx());
                }
            } catch (RemoteException e) {
                this.zzf.zzj().zzg().zza("Failed to send event to the service", e);
            }
        }
        this.zzf.zzam();
    }
}
