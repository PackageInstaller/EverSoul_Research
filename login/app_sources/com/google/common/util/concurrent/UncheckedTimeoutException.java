package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public class UncheckedTimeoutException extends RuntimeException {
    private static final long serialVersionUID = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UncheckedTimeoutException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UncheckedTimeoutException(@CheckForNull String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UncheckedTimeoutException(@CheckForNull Throwable th) {
        super(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UncheckedTimeoutException(@CheckForNull String str, @CheckForNull Throwable th) {
        super(str, th);
    }
}
