package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Platform {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isInstanceOfThrowableClass(@CheckForNull Throwable th, Class<? extends Throwable> cls) {
        return cls.isInstance(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Platform() {
    }
}
