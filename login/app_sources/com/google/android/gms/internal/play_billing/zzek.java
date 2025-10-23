package com.google.android.gms.internal.play_billing;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzek implements Runnable {
    final Future zza;
    final zzej zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzek(Future future, zzej zzejVar) {
        this.zza = future;
        this.zzb = zzejVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Object obj;
        Throwable zza;
        Object obj2 = this.zza;
        if ((obj2 instanceof zzfi) && (zza = zzfj.zza((zzfi) obj2)) != null) {
            this.zzb.zza(zza);
            return;
        }
        try {
            Future future = this.zza;
            boolean z = false;
            if (!future.isDone()) {
                throw new IllegalStateException(zzbf.zza("Future was expected to be done: %s", future));
            }
            while (true) {
                try {
                    obj = future.get();
                    break;
                } catch (InterruptedException unused) {
                    z = true;
                } catch (Throwable th) {
                    if (z) {
                        Thread.currentThread().interrupt();
                    }
                    throw th;
                }
            }
            if (z) {
                Thread.currentThread().interrupt();
            }
            this.zzb.zzb(obj);
        } catch (ExecutionException e) {
            this.zzb.zza(e.getCause());
        } catch (Throwable th2) {
            this.zzb.zza(th2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        zzba zza = zzbc.zza(this);
        zza.zza(this.zzb);
        return zza.toString();
    }
}
