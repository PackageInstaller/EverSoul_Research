package com.google.android.datatransport.runtime;

import com.google.android.datatransport.runtime.logging.Logging;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
class SafeLoggingExecutor implements Executor {
    private final Executor delegate;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    SafeLoggingExecutor(Executor executor) {
        this.delegate = executor;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.delegate.execute(new SafeLoggingRunnable(runnable));
    }

    static class SafeLoggingRunnable implements Runnable {
        private final Runnable delegate;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SafeLoggingRunnable(Runnable runnable) {
            this.delegate = runnable;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            try {
                this.delegate.run();
            } catch (Exception e) {
                Logging.m112e("Executor", "Background execution failure.", e);
            }
        }
    }
}
