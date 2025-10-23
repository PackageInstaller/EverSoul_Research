package com.google.android.gms.tasks;

import java.util.concurrent.Callable;

/* compiled from: com.google.android.gms:play-services-tasks@@18.1.0 */
/* loaded from: classes2.dex */
final class zzz implements Runnable {
    final /* synthetic */ zzw zza;
    final /* synthetic */ Callable zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzz(zzw zzwVar, Callable callable) {
        this.zza = zzwVar;
        this.zzb = callable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zza.zzb(this.zzb.call());
        } catch (Exception e) {
            this.zza.zza(e);
        } catch (Throwable th) {
            this.zza.zza(new RuntimeException(th));
        }
    }
}
