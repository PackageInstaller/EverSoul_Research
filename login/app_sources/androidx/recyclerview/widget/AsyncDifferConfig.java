package androidx.recyclerview.widget;

import androidx.recyclerview.widget.DiffUtil;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* loaded from: classes.dex */
public final class AsyncDifferConfig<T> {
    private final Executor mBackgroundThreadExecutor;
    private final DiffUtil.ItemCallback<T> mDiffCallback;
    private final Executor mMainThreadExecutor;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AsyncDifferConfig(Executor executor, Executor executor2, DiffUtil.ItemCallback<T> itemCallback) {
        this.mMainThreadExecutor = executor;
        this.mBackgroundThreadExecutor = executor2;
        this.mDiffCallback = itemCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Executor getMainThreadExecutor() {
        return this.mMainThreadExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Executor getBackgroundThreadExecutor() {
        return this.mBackgroundThreadExecutor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DiffUtil.ItemCallback<T> getDiffCallback() {
        return this.mDiffCallback;
    }

    public static final class Builder<T> {
        private static Executor sDiffExecutor;
        private static final Object sExecutorLock = new Object();
        private Executor mBackgroundThreadExecutor;
        private final DiffUtil.ItemCallback<T> mDiffCallback;
        private Executor mMainThreadExecutor;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder(DiffUtil.ItemCallback<T> itemCallback) {
            this.mDiffCallback = itemCallback;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder<T> setMainThreadExecutor(Executor executor) {
            this.mMainThreadExecutor = executor;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder<T> setBackgroundThreadExecutor(Executor executor) {
            this.mBackgroundThreadExecutor = executor;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public AsyncDifferConfig<T> build() {
            if (this.mBackgroundThreadExecutor == null) {
                synchronized (sExecutorLock) {
                    if (sDiffExecutor == null) {
                        sDiffExecutor = Executors.newFixedThreadPool(2);
                    }
                }
                this.mBackgroundThreadExecutor = sDiffExecutor;
            }
            return new AsyncDifferConfig<>(this.mMainThreadExecutor, this.mBackgroundThreadExecutor, this.mDiffCallback);
        }
    }
}
