package org.apache.commons.lang3.concurrent;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/* loaded from: classes2.dex */
public abstract class BackgroundInitializer<T> implements ConcurrentInitializer<T> {
    private ExecutorService executor;
    private ExecutorService externalExecutor;
    private Future<T> future;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int getTaskCount() {
        return 1;
    }

    protected abstract T initialize() throws Exception;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected BackgroundInitializer() {
        this(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected BackgroundInitializer(ExecutorService executorService) {
        setExternalExecutor(executorService);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized ExecutorService getExternalExecutor() {
        return this.externalExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean isStarted() {
        return this.future != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void setExternalExecutor(ExecutorService executorService) {
        if (isStarted()) {
            throw new IllegalStateException("Cannot set ExecutorService after start()!");
        }
        this.externalExecutor = executorService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean start() {
        ExecutorService executorService;
        if (isStarted()) {
            return false;
        }
        ExecutorService externalExecutor = getExternalExecutor();
        this.executor = externalExecutor;
        if (externalExecutor == null) {
            executorService = createExecutor();
            this.executor = executorService;
        } else {
            executorService = null;
        }
        this.future = this.executor.submit(createTask(executorService));
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public T get() throws ConcurrentException {
        try {
            return getFuture().get();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new ConcurrentException(e);
        } catch (ExecutionException e2) {
            ConcurrentUtils.handleCause(e2);
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized Future<T> getFuture() {
        Future<T> future;
        future = this.future;
        if (future == null) {
            throw new IllegalStateException("start() must be called first!");
        }
        return future;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final synchronized ExecutorService getActiveExecutor() {
        return this.executor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Callable<T> createTask(ExecutorService executorService) {
        return new InitializationTask(executorService);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ExecutorService createExecutor() {
        return Executors.newFixedThreadPool(getTaskCount());
    }

    private class InitializationTask implements Callable<T> {
        private final ExecutorService execFinally;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        InitializationTask(ExecutorService executorService) {
            this.execFinally = executorService;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Callable
        public T call() throws Exception {
            try {
                return (T) BackgroundInitializer.this.initialize();
            } finally {
                ExecutorService executorService = this.execFinally;
                if (executorService != null) {
                    executorService.shutdown();
                }
            }
        }
    }
}
