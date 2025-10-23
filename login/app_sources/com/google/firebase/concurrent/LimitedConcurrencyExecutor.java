package com.google.firebase.concurrent;

import com.google.firebase.components.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.Semaphore;

/* loaded from: classes2.dex */
class LimitedConcurrencyExecutor implements Executor {
    private final Executor delegate;
    private final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();
    private final Semaphore semaphore;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LimitedConcurrencyExecutor(Executor executor, int i) {
        Preconditions.checkArgument(i > 0, "concurrency must be positive.");
        this.delegate = executor;
        this.semaphore = new Semaphore(i, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.queue.offer(runnable);
        maybeEnqueueNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void maybeEnqueueNext() {
        while (this.semaphore.tryAcquire()) {
            Runnable poll = this.queue.poll();
            if (poll != null) {
                this.delegate.execute(decorate(poll));
            } else {
                this.semaphore.release();
                return;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Runnable decorate(final Runnable runnable) {
        return new Runnable() { // from class: com.google.firebase.concurrent.LimitedConcurrencyExecutor$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public final void run() {
                LimitedConcurrencyExecutor.this.m385x96c64136(runnable);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$decorate$0$com-google-firebase-concurrent-LimitedConcurrencyExecutor */
    /* synthetic */ void m385x96c64136(Runnable runnable) {
        try {
            runnable.run();
        } finally {
            this.semaphore.release();
            maybeEnqueueNext();
        }
    }
}
