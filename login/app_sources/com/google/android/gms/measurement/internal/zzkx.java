package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkx implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzkq zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzkx(zzkq zzkqVar, zzo zzoVar) {
        this.zza = zzoVar;
        this.zzb = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        zzfiVar = this.zzb.zzb;
        if (zzfiVar == null) {
            this.zzb.zzj().zzg().zza("Discarding data. Failed to send app launch");
            return;
        }
        try {
            Preconditions.checkNotNull(this.zza);
            zzfiVar.zzc(this.zza);
            this.zzb.zzh().zzac();
            this.zzb.zza(zzfiVar, (AbstractSafeParcelable) null, this.zza);
            this.zzb.zzam();
        } catch (RemoteException e) {
            this.zzb.zzj().zzg().zza("Failed to send app launch to the service", e);
        }
    }
}
