package org.apache.commons.lang3.concurrent;

/* loaded from: classes2.dex */
public class ConcurrentRuntimeException extends RuntimeException {
    private static final long serialVersionUID = -6582182735562919670L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ConcurrentRuntimeException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConcurrentRuntimeException(Throwable th) {
        super(ConcurrentUtils.checkedException(th));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ConcurrentRuntimeException(String str, Throwable th) {
        super(str, ConcurrentUtils.checkedException(th));
    }
}
