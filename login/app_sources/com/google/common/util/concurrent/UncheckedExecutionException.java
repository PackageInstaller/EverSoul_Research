package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public class UncheckedExecutionException extends RuntimeException {
    private static final long serialVersionUID = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected UncheckedExecutionException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected UncheckedExecutionException(@CheckForNull String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UncheckedExecutionException(@CheckForNull String str, @CheckForNull Throwable th) {
        super(str, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UncheckedExecutionException(@CheckForNull Throwable th) {
        super(th);
    }
}
