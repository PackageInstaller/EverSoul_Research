package com.google.firebase.analytics;

import com.google.android.gms.internal.measurement.zzcl;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.1 */
/* loaded from: classes2.dex */
final class zzb extends ThreadPoolExecutor {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzb(FirebaseAnalytics firebaseAnalytics, int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30L, timeUnit, blockingQueue);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        super.execute(zzcl.zza().zza(runnable));
    }
}
