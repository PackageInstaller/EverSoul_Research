package com.google.firebase.concurrent;

import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
final class PausableScheduledExecutorServiceImpl extends DelegatingScheduledExecutorService implements PausableScheduledExecutorService {
    private final PausableExecutorService delegate;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PausableScheduledExecutorServiceImpl(PausableExecutorService pausableExecutorService, ScheduledExecutorService scheduledExecutorService) {
        super(pausableExecutorService, scheduledExecutorService);
        this.delegate = pausableExecutorService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.concurrent.PausableExecutor
    public void pause() {
        this.delegate.pause();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.concurrent.PausableExecutor
    public void resume() {
        this.delegate.resume();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.concurrent.PausableExecutor
    public boolean isPaused() {
        return this.delegate.isPaused();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.concurrent.DelegatingScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.concurrent.DelegatingScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }
}
