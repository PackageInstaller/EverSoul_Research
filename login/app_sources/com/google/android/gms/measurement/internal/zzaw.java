package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzaw implements Runnable {
    private final /* synthetic */ zzid zza;
    private final /* synthetic */ zzat zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzaw(zzat zzatVar, zzid zzidVar) {
        this.zza = zzidVar;
        this.zzb = zzatVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzd();
        if (zzab.zza()) {
            this.zza.zzl().zzb(this);
            return;
        }
        boolean zzc = this.zzb.zzc();
        this.zzb.zzd = 0L;
        if (zzc) {
            this.zzb.zzb();
        }
    }
}
