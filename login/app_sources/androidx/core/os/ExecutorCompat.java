package androidx.core.os;

import android.os.Handler;
import androidx.core.util.Preconditions;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class ExecutorCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Executor create(Handler handler) {
        return new HandlerExecutor(handler);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ExecutorCompat() {
    }

    private static class HandlerExecutor implements Executor {
        private final Handler mHandler;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        HandlerExecutor(Handler handler) {
            this.mHandler = (Handler) Preconditions.checkNotNull(handler);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            if (!this.mHandler.post((Runnable) Preconditions.checkNotNull(runnable))) {
                throw new RejectedExecutionException(this.mHandler + " is shutting down");
            }
        }
    }
}
