package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
abstract class zaav implements Runnable {
    final /* synthetic */ zaaw zab;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Lock lock;
        Lock lock2;
        zabi zabiVar;
        lock = this.zab.zab;
        lock.lock();
        try {
            try {
                if (!Thread.interrupted()) {
                    zaa();
                }
            } catch (RuntimeException e) {
                zabiVar = this.zab.zaa;
                zabiVar.zam(e);
            }
        } finally {
            lock2 = this.zab.zab;
            lock2.unlock();
        }
    }

    protected abstract void zaa();
}
