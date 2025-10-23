package androidx.arch.core.executor;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public class ArchTaskExecutor extends TaskExecutor {
    private static volatile ArchTaskExecutor sInstance;
    private TaskExecutor mDefaultTaskExecutor;
    private TaskExecutor mDelegate;
    private static final Executor sMainThreadExecutor = new Executor() { // from class: androidx.arch.core.executor.ArchTaskExecutor.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().postToMainThread(runnable);
        }
    };
    private static final Executor sIOThreadExecutor = new Executor() { // from class: androidx.arch.core.executor.ArchTaskExecutor.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            ArchTaskExecutor.getInstance().executeOnDiskIO(runnable);
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ArchTaskExecutor() {
        DefaultTaskExecutor defaultTaskExecutor = new DefaultTaskExecutor();
        this.mDefaultTaskExecutor = defaultTaskExecutor;
        this.mDelegate = defaultTaskExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ArchTaskExecutor getInstance() {
        if (sInstance != null) {
            return sInstance;
        }
        synchronized (ArchTaskExecutor.class) {
            if (sInstance == null) {
                sInstance = new ArchTaskExecutor();
            }
        }
        return sInstance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setDelegate(TaskExecutor taskExecutor) {
        if (taskExecutor == null) {
            taskExecutor = this.mDefaultTaskExecutor;
        }
        this.mDelegate = taskExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.arch.core.executor.TaskExecutor
    public void executeOnDiskIO(Runnable runnable) {
        this.mDelegate.executeOnDiskIO(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.arch.core.executor.TaskExecutor
    public void postToMainThread(Runnable runnable) {
        this.mDelegate.postToMainThread(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Executor getMainThreadExecutor() {
        return sMainThreadExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Executor getIOThreadExecutor() {
        return sIOThreadExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.arch.core.executor.TaskExecutor
    public boolean isMainThread() {
        return this.mDelegate.isMainThread();
    }
}
