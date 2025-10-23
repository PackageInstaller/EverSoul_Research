package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjc implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzio zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjc(zzio zzioVar, boolean z) {
        this.zza = z;
        this.zzb = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        boolean zzac = this.zzb.zzu.zzac();
        boolean zzab = this.zzb.zzu.zzab();
        this.zzb.zzu.zza(this.zza);
        if (zzab == this.zza) {
            this.zzb.zzu.zzj().zzp().zza("Default data collection state already set to", Boolean.valueOf(this.zza));
        }
        if (this.zzb.zzu.zzac() == zzac || this.zzb.zzu.zzac() != this.zzb.zzu.zzab()) {
            this.zzb.zzu.zzj().zzv().zza("Default data collection is different than actual status", Boolean.valueOf(this.zza), Boolean.valueOf(zzac));
        }
        this.zzb.zzar();
    }
}
