package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkz implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzkq zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzkz(zzkq zzkqVar, zzo zzoVar, Bundle bundle) {
        this.zza = zzoVar;
        this.zzb = bundle;
        this.zzc = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        zzfiVar = this.zzc.zzb;
        if (zzfiVar == null) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfiVar.zza(this.zzb, this.zza);
        } catch (RemoteException e) {
            this.zzc.zzj().zzg().zza("Failed to send default event parameters to service", e);
        }
    }
}
