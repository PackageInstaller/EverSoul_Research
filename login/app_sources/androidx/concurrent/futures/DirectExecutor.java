package androidx.concurrent.futures;

import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public enum DirectExecutor implements Executor {
    INSTANCE;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Enum
    public String toString() {
        return "DirectExecutor";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
