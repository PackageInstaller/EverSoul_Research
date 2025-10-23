package com.google.android.gms.internal.play_billing;

import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzu implements zzeu {
    final WeakReference zza;
    private final zzq zzb = new zzt(this);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzu(zzr zzrVar) {
        this.zza = new WeakReference(zzrVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        zzr zzrVar = (zzr) this.zza.get();
        boolean cancel = this.zzb.cancel(z);
        if (!cancel || zzrVar == null) {
            return cancel;
        }
        zzrVar.zza();
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public final Object get() throws InterruptedException, ExecutionException {
        return this.zzb.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.zzb.zzc instanceof zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.zzb.isDone();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return this.zzb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zza(Object obj) {
        return this.zzb.zzd(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzeu
    public final void zzb(Runnable runnable, Executor executor) {
        this.zzb.zzb(runnable, executor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean zzc(Throwable th) {
        zzi zziVar = new zzi(th);
        zzf zzfVar = zzq.zzb;
        zzq zzqVar = this.zzb;
        if (!zzfVar.zzd(zzqVar, null, zziVar)) {
            return false;
        }
        zzq.zzc(zzqVar);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Future
    public final Object get(long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return this.zzb.get(j, timeUnit);
    }
}
