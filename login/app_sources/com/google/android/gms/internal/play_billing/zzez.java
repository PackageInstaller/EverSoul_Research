package com.google.android.gms.internal.play_billing;

import com.google.android.gms.internal.play_billing.zzdy;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzez extends zzdy.zzi implements Runnable {
    private final Runnable zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzdy
    protected final String zzg() {
        return "task=[" + this.zzc.toString() + "]";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzez(Runnable runnable) {
        runnable.getClass();
        this.zzc = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            this.zzc.run();
        } catch (Throwable th) {
            zzo(th);
            throw th;
        }
    }
}
