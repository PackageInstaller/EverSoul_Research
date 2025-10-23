package org.apache.commons.lang3.concurrent;

/* loaded from: classes2.dex */
public class CircuitBreakingException extends RuntimeException {
    private static final long serialVersionUID = 1408176654686913340L;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CircuitBreakingException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CircuitBreakingException(String str, Throwable th) {
        super(str, th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CircuitBreakingException(String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CircuitBreakingException(Throwable th) {
        super(th);
    }
}
