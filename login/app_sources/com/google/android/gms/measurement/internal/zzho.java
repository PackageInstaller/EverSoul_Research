package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzho implements Callable<List<zzae>> {
    private final /* synthetic */ String zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ zzhh zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzae> call() throws Exception {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmpVar = this.zzd.zza;
        zzmpVar.zzr();
        zzmpVar2 = this.zzd.zza;
        return zzmpVar2.zzf().zza(this.zza, this.zzb, this.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzho(zzhh zzhhVar, String str, String str2, String str3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = zzhhVar;
    }
}
