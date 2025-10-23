package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzje implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzio zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzje(zzio zzioVar, long j) {
        this.zza = j;
        this.zzb = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zzk().zzf.zza(this.zza);
        this.zzb.zzj().zzc().zza("Session timeout duration set", Long.valueOf(this.zza));
    }
}
