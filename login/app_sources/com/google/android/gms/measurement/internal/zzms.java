package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzms implements Runnable {
    private final /* synthetic */ zzna zza;
    private final /* synthetic */ zzmp zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzms(zzmp zzmpVar, zzna zznaVar) {
        this.zza = zznaVar;
        this.zzb = zzmpVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzmp.zza(this.zzb, this.zza);
        this.zzb.zzv();
    }
}
