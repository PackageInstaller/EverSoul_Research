package com.google.android.gms.common.api.internal;

import java.util.concurrent.locks.Lock;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
abstract class zabg {
    private final zabf zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zabg(zabf zabfVar) {
        this.zaa = zabfVar;
    }

    protected abstract void zaa();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zab(zabi zabiVar) {
        Lock lock;
        Lock lock2;
        zabf zabfVar;
        lock = zabiVar.zai;
        lock.lock();
        try {
            zabfVar = zabiVar.zan;
            if (zabfVar == this.zaa) {
                zaa();
            }
        } finally {
            lock2 = zabiVar.zai;
            lock2.unlock();
        }
    }
}
