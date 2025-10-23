package com.google.android.gms.measurement.internal;

import com.google.android.gms.internal.measurement.zzpt;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjy implements Runnable {
    private final /* synthetic */ zzif zza;
    private final /* synthetic */ long zzb;
    private final /* synthetic */ boolean zzc;
    private final /* synthetic */ zzif zzd;
    private final /* synthetic */ zzio zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjy(zzio zzioVar, zzif zzifVar, long j, boolean z, zzif zzifVar2) {
        this.zza = zzifVar;
        this.zzb = j;
        this.zzc = z;
        this.zzd = zzifVar2;
        this.zze = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zze.zza(this.zza);
        zzio.zza(this.zze, this.zza, this.zzb, false, this.zzc);
        if (zzpt.zza() && this.zze.zze().zza(zzbg.zzbq)) {
            zzio.zza(this.zze, this.zza, this.zzd);
        }
    }
}
