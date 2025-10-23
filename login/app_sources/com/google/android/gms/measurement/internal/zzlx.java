package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlx implements Runnable {
    private final /* synthetic */ long zza;
    private final /* synthetic */ zzly zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlx(zzly zzlyVar, long j) {
        this.zza = j;
        this.zzb = zzlyVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        zzly.zzb(this.zzb, this.zza);
    }
}
