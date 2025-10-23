package com.google.common.util.concurrent;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Runnables {
    private static final Runnable EMPTY_RUNNABLE = new Runnable() { // from class: com.google.common.util.concurrent.Runnables.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
        }
    };

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Runnable doNothing() {
        return EMPTY_RUNNABLE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Runnables() {
    }
}
