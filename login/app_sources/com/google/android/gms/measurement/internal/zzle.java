package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzle implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzkq zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzle(zzkq zzkqVar, zzo zzoVar) {
        this.zza = zzoVar;
        this.zzb = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        zzfiVar = this.zzb.zzb;
        if (zzfiVar == null) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfiVar.zzf(this.zza);
            this.zzb.zzam();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send measurementEnabled to the service", e);
        }
    }
}
