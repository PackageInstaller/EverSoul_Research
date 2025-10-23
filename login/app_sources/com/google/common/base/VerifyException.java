package com.google.common.base;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public class VerifyException extends RuntimeException {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VerifyException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VerifyException(@CheckForNull String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VerifyException(@CheckForNull Throwable th) {
        super(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public VerifyException(@CheckForNull String str, @CheckForNull Throwable th) {
        super(str, th);
    }
}
