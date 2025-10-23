package com.google.android.gms.measurement.internal;

import com.google.common.util.concurrent.FutureCallback;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zziz implements FutureCallback<Object> {
    private final /* synthetic */ zzmh zza;
    private final /* synthetic */ zzio zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zziz(zzio zzioVar, zzmh zzmhVar) {
        this.zza = zzmhVar;
        this.zzb = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onFailure(Throwable th) {
        this.zzb.zzt();
        this.zzb.zzh = false;
        this.zzb.zzao();
        this.zzb.zzj().zzg().zza("registerTriggerAsync failed with throwable", th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.FutureCallback
    public final void onSuccess(Object obj) {
        this.zzb.zzt();
        this.zzb.zzh = false;
        this.zzb.zzao();
        this.zzb.zzj().zzc().zza("registerTriggerAsync ran. uri", this.zza.zza);
    }
}
