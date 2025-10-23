package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgc implements Runnable {
    private final /* synthetic */ boolean zza;
    private final /* synthetic */ zzfz zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgc(zzfz zzfzVar, boolean z) {
        this.zza = z;
        this.zzb = zzfzVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzmp zzmpVar;
        zzmpVar = this.zzb.zzb;
        zzmpVar.zza(this.zza);
    }
}
