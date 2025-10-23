package com.google.firebase.installations;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class AwaitListener implements OnCompleteListener<Void> {
    private final CountDownLatch latch = new CountDownLatch(1);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AwaitListener() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void onSuccess() {
        this.latch.countDown();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.latch.await(j, timeUnit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.tasks.OnCompleteListener
    public void onComplete(Task<Void> task) {
        this.latch.countDown();
    }
}
