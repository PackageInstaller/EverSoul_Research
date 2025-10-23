package com.bumptech.glide.load.engine.executor;

import android.os.Process;
import android.os.StrictMode;
import android.util.Log;
import com.liapp.y;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* loaded from: classes.dex */
public final class GlideExecutor implements ExecutorService {
    private static final String ANIMATION_EXECUTOR_NAME = "animation";
    private static final String DEFAULT_DISK_CACHE_EXECUTOR_NAME = "disk-cache";
    private static final int DEFAULT_DISK_CACHE_EXECUTOR_THREADS = 1;
    private static final String DEFAULT_SOURCE_EXECUTOR_NAME = "source";
    private static final long KEEP_ALIVE_TIME_MS = TimeUnit.SECONDS.toMillis(10);
    private static final int MAXIMUM_AUTOMATIC_THREAD_COUNT = 4;
    private static final String SOURCE_UNLIMITED_EXECUTOR_NAME = "source-unlimited";
    private static final String TAG = "GlideExecutor";
    private static volatile int bestThreadCount;
    private final ExecutorService delegate;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newDiskCacheExecutor() {
        return newDiskCacheExecutor(1, y.ݬֲ֮ܲت(1513041775), UncaughtThrowableStrategy.DEFAULT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newDiskCacheExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newDiskCacheExecutor(1, y.ݬֲ֮ܲت(1513041775), uncaughtThrowableStrategy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newDiskCacheExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, true)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newSourceExecutor() {
        return newSourceExecutor(calculateBestThreadCount(), y.ٴسسݬߨ(1392903434), UncaughtThrowableStrategy.DEFAULT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newSourceExecutor(UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return newSourceExecutor(calculateBestThreadCount(), y.ٴسسݬߨ(1392903434), uncaughtThrowableStrategy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newSourceExecutor(int i, String str, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(str, uncaughtThrowableStrategy, false)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newUnlimitedSourceExecutor() {
        return new GlideExecutor(new ThreadPoolExecutor(0, Integer.MAX_VALUE, KEEP_ALIVE_TIME_MS, TimeUnit.MILLISECONDS, new SynchronousQueue(), new DefaultThreadFactory(y.ٴسسݬߨ(1392903626), UncaughtThrowableStrategy.DEFAULT, false)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newAnimationExecutor() {
        return newAnimationExecutor(calculateBestThreadCount() >= 4 ? 2 : 1, UncaughtThrowableStrategy.DEFAULT);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static GlideExecutor newAnimationExecutor(int i, UncaughtThrowableStrategy uncaughtThrowableStrategy) {
        return new GlideExecutor(new ThreadPoolExecutor(i, i, 0L, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new DefaultThreadFactory(y.ٲٴݴ״ٰ(1781734280), uncaughtThrowableStrategy, true)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    GlideExecutor(ExecutorService executorService) {
        this.delegate = executorService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.delegate.execute(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return this.delegate.submit(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.delegate.invokeAll(collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.invokeAll(collection, j, timeUnit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.delegate.invokeAny(collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.delegate.invokeAny(collection, j, timeUnit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.delegate.submit(runnable, t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return this.delegate.submit(callable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.delegate.shutdown();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return this.delegate.shutdownNow();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.delegate.isShutdown();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.delegate.isTerminated();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.delegate.awaitTermination(j, timeUnit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.delegate.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int calculateBestThreadCount() {
        if (bestThreadCount == 0) {
            bestThreadCount = Math.min(4, RuntimeCompat.availableProcessors());
        }
        return bestThreadCount;
    }

    public interface UncaughtThrowableStrategy {
        public static final UncaughtThrowableStrategy DEFAULT;
        public static final UncaughtThrowableStrategy IGNORE = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
            public void handle(Throwable th) {
            }
        };
        public static final UncaughtThrowableStrategy LOG;
        public static final UncaughtThrowableStrategy THROW;

        void handle(Throwable th);

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            UncaughtThrowableStrategy uncaughtThrowableStrategy = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public void handle(Throwable th) {
                    if (th != null) {
                        String str = y.ݮڮֲڭܩ(-628998332);
                        if (Log.isLoggable(str, 6)) {
                            Log.e(str, y.ۮڭڭܬި(862085819), th);
                        }
                    }
                }
            };
            LOG = uncaughtThrowableStrategy;
            THROW = new UncaughtThrowableStrategy() { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy.3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.bumptech.glide.load.engine.executor.GlideExecutor.UncaughtThrowableStrategy
                public void handle(Throwable th) {
                    if (th != null) {
                        throw new RuntimeException(y.ۮڭڭܬި(862085819), th);
                    }
                }
            };
            DEFAULT = uncaughtThrowableStrategy;
        }
    }

    private static final class DefaultThreadFactory implements ThreadFactory {
        private static final int DEFAULT_PRIORITY = 9;
        private final String name;
        final boolean preventNetworkOperations;
        private int threadNum;
        final UncaughtThrowableStrategy uncaughtThrowableStrategy;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        DefaultThreadFactory(String str, UncaughtThrowableStrategy uncaughtThrowableStrategy, boolean z) {
            this.name = str;
            this.uncaughtThrowableStrategy = uncaughtThrowableStrategy;
            this.preventNetworkOperations = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(Runnable runnable) {
            Thread thread;
            String str = y.ٲٴݴ״ٰ(1781732800);
            synchronized (this) {
                thread = new Thread(runnable, str + this.name + "-thread-" + this.threadNum) { // from class: com.bumptech.glide.load.engine.executor.GlideExecutor.DefaultThreadFactory.1
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.lang.Thread, java.lang.Runnable
                    public void run() {
                        Process.setThreadPriority(9);
                        if (DefaultThreadFactory.this.preventNetworkOperations) {
                            StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                        }
                        try {
                            super.run();
                        } catch (Throwable th) {
                            DefaultThreadFactory.this.uncaughtThrowableStrategy.handle(th);
                        }
                    }
                };
                this.threadNum++;
            }
            return thread;
        }
    }
}
