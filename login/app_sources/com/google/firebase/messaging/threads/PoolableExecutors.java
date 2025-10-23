package com.google.firebase.messaging.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class PoolableExecutors {
    private static final ExecutorFactory DEFAULT_INSTANCE;
    private static volatile ExecutorFactory instance;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        DefaultExecutorFactory defaultExecutorFactory = new DefaultExecutorFactory();
        DEFAULT_INSTANCE = defaultExecutorFactory;
        instance = defaultExecutorFactory;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PoolableExecutors() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ExecutorFactory factory() {
        return instance;
    }

    private static class DefaultExecutorFactory implements ExecutorFactory {
        private static final long CORE_THREAD_TIMEOUT_SECS = 60;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DefaultExecutorFactory() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ExecutorService newThreadPool(ThreadPriority threadPriority) {
            return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ExecutorService newThreadPool(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return Executors.unconfigurableExecutorService(Executors.newCachedThreadPool(threadFactory));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ExecutorService newThreadPool(int i, ThreadPriority threadPriority) {
            return newThreadPool(i, Executors.defaultThreadFactory(), threadPriority);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ExecutorService newThreadPool(int i, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, i, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            return Executors.unconfigurableExecutorService(threadPoolExecutor);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ExecutorService newSingleThreadExecutor(ThreadPriority threadPriority) {
            return newThreadPool(1, threadPriority);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ExecutorService newSingleThreadExecutor(ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return newThreadPool(1, threadFactory, threadPriority);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ScheduledExecutorService newScheduledThreadPool(int i, ThreadPriority threadPriority) {
            return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public ScheduledExecutorService newScheduledThreadPool(int i, ThreadFactory threadFactory, ThreadPriority threadPriority) {
            return Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(i, threadFactory));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public void executeOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable) {
            new Thread(runnable, str2).start();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.messaging.threads.ExecutorFactory
        public Future<?> submitOneOff(String str, String str2, ThreadPriority threadPriority, Runnable runnable) {
            FutureTask futureTask = new FutureTask(runnable, null);
            new Thread(futureTask, str2).start();
            return futureTask;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void installExecutorFactory(ExecutorFactory executorFactory) {
        if (instance != DEFAULT_INSTANCE) {
            throw new IllegalStateException("Trying to install an ExecutorFactory twice!");
        }
        instance = executorFactory;
    }
}
