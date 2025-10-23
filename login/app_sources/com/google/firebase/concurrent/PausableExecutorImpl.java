package com.google.firebase.concurrent;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;

/* loaded from: classes2.dex */
final class PausableExecutorImpl implements PausableExecutor {
    private final Executor delegate;
    private volatile boolean paused;
    final LinkedBlockingQueue<Runnable> queue = new LinkedBlockingQueue<>();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PausableExecutorImpl(boolean z, Executor executor) {
        this.paused = z;
        this.delegate = executor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.queue.offer(runnable);
        maybeEnqueueNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void maybeEnqueueNext() {
        if (this.paused) {
            return;
        }
        Runnable poll = this.queue.poll();
        while (poll != null) {
            this.delegate.execute(poll);
            poll = !this.paused ? this.queue.poll() : null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.concurrent.PausableExecutor
    public void pause() {
        this.paused = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.concurrent.PausableExecutor
    public void resume() {
        this.paused = false;
        maybeEnqueueNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.concurrent.PausableExecutor
    public boolean isPaused() {
        return this.paused;
    }
}
