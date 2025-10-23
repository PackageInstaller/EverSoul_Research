package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhj implements Runnable {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzhh zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhj(zzhh zzhhVar, zzo zzoVar) {
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
        zzmpVar2.zza(zzoVar);
    }
}
