package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjv implements Runnable {
    private final /* synthetic */ zzif zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ long zzc;
    private final /* synthetic */ boolean zzd;
    private final /* synthetic */ zzif zze;
    private final /* synthetic */ zzio zzf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjv(zzio zzioVar, zzif zzifVar, long j, long j2, boolean z, zzif zzifVar2) {
        this.zza = zzifVar;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = z;
        this.zze = zzifVar2;
        this.zzf = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzf.zza(this.zza);
        this.zzf.zza(this.zzb, false);
        zzio.zza(this.zzf, this.zza, this.zzc, true, this.zzd);
        if (zzpt.zza() && this.zzf.zze().zza(zzbg.zzbq)) {
            zzio.zza(this.zzf, this.zza, this.zze);
        }
    }
}
