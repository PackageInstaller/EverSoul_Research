package com.google.android.gms.measurement.internal;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzhx implements Callable<byte[]> {
    private final /* synthetic */ zzbe zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ zzhh zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final /* synthetic */ byte[] call() throws Exception {
        zzmp zzmpVar;
        zzmp zzmpVar2;
        zzmpVar = this.zzc.zza;
        zzmpVar.zzr();
        zzmpVar2 = this.zzc.zza;
        return zzmpVar2.zzm().zza(this.zza, this.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhx(zzhh zzhhVar, zzbe zzbeVar, String str) {
        this.zza = zzbeVar;
        this.zzb = str;
        this.zzc = zzhhVar;
    }
}
