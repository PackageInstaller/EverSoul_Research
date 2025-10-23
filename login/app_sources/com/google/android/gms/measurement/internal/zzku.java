package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzku implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ Bundle zzc;
    private final /* synthetic */ zzkq zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzku(zzkq zzkqVar, AtomicReference atomicReference, zzo zzoVar, Bundle bundle) {
        this.zza = atomicReference;
        this.zzb = zzoVar;
        this.zzc = bundle;
        this.zzd = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        synchronized (this.zza) {
            try {
                try {
                    zzfiVar = this.zzd.zzb;
                } finally {
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                this.zzd.zzj().zzg().zza("Failed to get trigger URIs; remote exception", e);
            }
            if (zzfiVar == null) {
                this.zzd.zzj().zzg().zza("Failed to get trigger URIs; not connected to service");
                return;
            }
            Preconditions.checkNotNull(this.zzb);
            this.zza.set(zzfiVar.zza(this.zzb, this.zzc));
            this.zzd.zzam();
            this.zza.notify();
        }
    }
}
