package com.google.android.gms.measurement.internal;

import com.google.android.gms.measurement.internal.AppMeasurementDynamiteService;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.1 */
/* loaded from: classes2.dex */
final class zzj implements Runnable {
    private final /* synthetic */ AppMeasurementDynamiteService.zzb zza;
    private final /* synthetic */ AppMeasurementDynamiteService zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzj(AppMeasurementDynamiteService appMeasurementDynamiteService, AppMeasurementDynamiteService.zzb zzbVar) {
        this.zza = zzbVar;
        this.zzb = appMeasurementDynamiteService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza.zzp().zza(this.zza);
    }
}
