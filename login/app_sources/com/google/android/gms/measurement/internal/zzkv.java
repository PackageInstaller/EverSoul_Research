package com.google.android.gms.measurement.internal;

import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkv implements Runnable {
    private final /* synthetic */ AtomicReference zza;
    private final /* synthetic */ zzo zzb;
    private final /* synthetic */ zzkq zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzkv(zzkq zzkqVar, AtomicReference atomicReference, zzo zzoVar) {
        this.zza = atomicReference;
        this.zzb = zzoVar;
        this.zzc = zzkqVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzfi zzfiVar;
        synchronized (this.zza) {
            try {
                try {
                } finally {
                    this.zza.notify();
                }
            } catch (RemoteException e) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id", e);
            }
            if (!this.zzc.zzk().zzn().zzh()) {
                this.zzc.zzj().zzv().zza("Analytics storage consent denied; will not get app instance id");
                this.zzc.zzm().zza((String) null);
                this.zzc.zzk().zze.zza(null);
                this.zza.set(null);
                return;
            }
            zzfiVar = this.zzc.zzb;
            if (zzfiVar == null) {
                this.zzc.zzj().zzg().zza("Failed to get app instance id");
                return;
            }
            Preconditions.checkNotNull(this.zzb);
            this.zza.set(zzfiVar.zzb(this.zzb));
            String str = (String) this.zza.get();
            if (str != null) {
                this.zzc.zzm().zza(str);
                this.zzc.zzk().zze.zza(str);
            }
            this.zzc.zzam();
            this.zza.notify();
        }
    }
}
