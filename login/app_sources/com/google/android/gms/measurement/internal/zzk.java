package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-sdk@@21.5.1 */
/* loaded from: classes2.dex */
final class zzk implements Runnable {
    private final /* synthetic */ com.google.android.gms.internal.measurement.zzcv zza;
    private final /* synthetic */ String zzb;
    private final /* synthetic */ String zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ AppMeasurementDynamiteService zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzk(AppMeasurementDynamiteService appMeasurementDynamiteService, com.google.android.gms.internal.measurement.zzcv zzcvVar, String str, String str2, boolean z) {
        this.zza = zzcvVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = z;
        this.zze = appMeasurementDynamiteService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza.zzr().zza(this.zza, this.zzb, this.zzc, this.zzd);
    }
}
