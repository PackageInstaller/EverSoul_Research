package com.android.billingclient.api;

import com.liapp.y;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzas implements ThreadFactory {
    private final ThreadFactory zza = Executors.defaultThreadFactory();
    private final AtomicInteger zzb = new AtomicInteger(1);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzas(BillingClientImpl billingClientImpl) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ThreadFactory
    public final Thread newThread(Runnable runnable) {
        AtomicInteger atomicInteger = this.zzb;
        Thread newThread = this.zza.newThread(runnable);
        newThread.setName(y.ٴسسݬߨ(1392873338) + atomicInteger.getAndIncrement());
        return newThread;
    }
}
