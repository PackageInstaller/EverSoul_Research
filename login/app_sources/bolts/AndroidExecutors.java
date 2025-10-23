package bolts;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
final class AndroidExecutors {
    static final int CORE_POOL_SIZE;
    private static final int CPU_COUNT;
    private static final AndroidExecutors INSTANCE = new AndroidExecutors();
    static final long KEEP_ALIVE_TIME = 1;
    static final int MAX_POOL_SIZE;
    private final Executor uiThread = new UIThreadExecutor();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        CPU_COUNT = availableProcessors;
        CORE_POOL_SIZE = availableProcessors + 1;
        MAX_POOL_SIZE = (availableProcessors * 2) + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AndroidExecutors() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ExecutorService newCachedThreadPool() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        allowCoreThreadTimeout(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ExecutorService newCachedThreadPool(ThreadFactory threadFactory) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue(), threadFactory);
        allowCoreThreadTimeout(threadPoolExecutor, true);
        return threadPoolExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void allowCoreThreadTimeout(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        threadPoolExecutor.allowCoreThreadTimeOut(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Executor uiThread() {
        return INSTANCE.uiThread;
    }

    private static class UIThreadExecutor implements Executor {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private UIThreadExecutor() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }
}
