package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlm implements Runnable {
    private final /* synthetic */ zzfi zza;
    private final /* synthetic */ zzlj zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlm(zzlj zzljVar, zzfi zzfiVar) {
        this.zza = zzfiVar;
        this.zzb = zzljVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        synchronized (this.zzb) {
            this.zzb.zzb = false;
            if (!this.zzb.zza.zzah()) {
                this.zzb.zza.zzj().zzp().zza("Connected to service");
                this.zzb.zza.zza(this.zza);
            }
        }
    }
}
