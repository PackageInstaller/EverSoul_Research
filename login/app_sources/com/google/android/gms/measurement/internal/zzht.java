package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzns;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzht implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzhh zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzht(zzhh zzhhVar, zzo zzoVar) {
        this.zza = zzoVar;
        this.zzb = zzhhVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmpVar = this.zzb.zza;
        zzmpVar.zzr();
        zzmpVar2 = this.zzb.zza;
        zzo zzoVar = this.zza;
        zzmpVar2.zzl().zzt();
        zzmpVar2.zzs();
        Preconditions.checkNotEmpty(zzoVar.zza);
        zzif zza = zzif.zza(zzoVar.zzt, (zzns.zza() && zzmpVar2.zze().zza(zzbg.zzcm)) ? zzoVar.zzy : 100);
        zzif zzb = zzmpVar2.zzb(zzoVar.zza);
        zzmpVar2.zzj().zzp().zza("Setting consent, package, consent", zzoVar.zza, zza);
        zzmpVar2.zza(zzoVar.zza, zza);
        if (zza.zzc(zzb)) {
            zzmpVar2.zzd(zzoVar);
        }
        if (zzns.zza() && zzmpVar2.zze().zza(zzbg.zzcm)) {
            zzav zza2 = zzav.zza(zzoVar.zzz);
            if (zzav.zza.equals(zza2)) {
                return;
            }
            zzmpVar2.zzj().zzp().zza("Setting DMA consent. package, consent", zzoVar.zza, zza2);
            zzmpVar2.zza(zzoVar.zza, zza2);
        }
    }
}
