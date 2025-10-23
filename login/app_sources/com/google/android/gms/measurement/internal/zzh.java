package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.1 */
/* loaded from: classes2.dex */
final class zzh implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzcv zza;
    private final /* synthetic */ zzbe zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ AppMeasurementDynamiteService zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzh(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcv zzcvVar, zzbe zzbeVar, String str) {
        this.zza = zzcvVar;
        this.zzb = zzbeVar;
        this.zzc = str;
        this.zzd = appMeasurementDynamiteService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzd.zza.zzr().zza(this.zza, this.zzb, this.zzc);
    }
}
