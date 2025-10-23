package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjw implements Runnable {
    private final /* synthetic */ zzav zza;
    private final /* synthetic */ zzio zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjw(zzio zzioVar, zzav zzavVar) {
        this.zza = zzavVar;
        this.zzb = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        if (this.zzb.zzk().zza(this.zza)) {
            this.zzb.zzo().zza(false);
        } else {
            this.zzb.zzj().zzn().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(this.zza.zza()));
        }
    }
}
