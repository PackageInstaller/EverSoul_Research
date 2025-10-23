package com.google.common.util.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingListeningExecutorService extends ForwardingExecutorService implements ListeningExecutorService {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.util.concurrent.ForwardingExecutorService, com.google.common.collect.ForwardingObject
    public abstract ListeningExecutorService delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    public /* bridge */ /* synthetic */ Future submit(Runnable runnable, @ParametricNullness Object obj) {
        return submit(runnable, (Runnable) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingListeningExecutorService() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    public <T> ListenableFuture<T> submit(Callable<T> callable) {
        return delegate().submit((Callable) callable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    public ListenableFuture<?> submit(Runnable runnable) {
        return delegate().submit(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.ForwardingExecutorService, java.util.concurrent.ExecutorService
    public <T> ListenableFuture<T> submit(Runnable runnable, @ParametricNullness T t) {
        return delegate().submit(runnable, (Runnable) t);
    }
}
