package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzlw implements Runnable {
    private final /* synthetic */ zzmp zza;
    private final /* synthetic */ Runnable zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlw(zzlr zzlrVar, zzmp zzmpVar, Runnable runnable) {
        this.zza = zzmpVar;
        this.zzb = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.zza.zzr();
        this.zza.zza(this.zzb);
        this.zza.zzw();
    }
}
