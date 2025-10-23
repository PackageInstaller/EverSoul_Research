package com.google.common.util.concurrent;

import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
enum DirectExecutor implements Executor {
    INSTANCE;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Enum
    public String toString() {
        return "MoreExecutors.directExecutor()";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        runnable.run();
    }
}
