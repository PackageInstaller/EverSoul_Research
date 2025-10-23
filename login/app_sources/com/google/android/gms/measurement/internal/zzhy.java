package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhy implements Callable<List<zznd>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzhh zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zznd> call() throws Exception {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmpVar = this.zzb.zza;
        zzmpVar.zzr();
        zzmpVar2 = this.zzb.zza;
        return zzmpVar2.zzf().zzi(this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhy(zzhh zzhhVar, String str) {
        this.zza = str;
        this.zzb = zzhhVar;
    }
}
