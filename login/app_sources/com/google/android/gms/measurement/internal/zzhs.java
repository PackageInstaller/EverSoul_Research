package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhs implements Callable<zzaj> {
    private final /* synthetic */ zzo zza;
    private final /* synthetic */ zzhh zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ zzaj call() throws Exception {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmpVar = this.zzb.zza;
        zzmpVar.zzr();
        zzmpVar2 = this.zzb.zza;
        return new zzaj(zzmpVar2.zza(this.zza.zza));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhs(zzhh zzhhVar, zzo zzoVar) {
        this.zza = zzoVar;
        this.zzb = zzhhVar;
    }
}
