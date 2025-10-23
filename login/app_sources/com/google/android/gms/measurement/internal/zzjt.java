package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjt implements Runnable {
    private final /* synthetic */ Boolean zza;
    private final /* synthetic */ zzio zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjt(zzio zzioVar, Boolean bool) {
        this.zza = bool;
        this.zzb = zzioVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zzb.zza(this.zza, true);
    }
}
