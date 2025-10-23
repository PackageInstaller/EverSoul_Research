package com.google.zxing;

/* loaded from: classes3.dex */
public abstract class ReaderException extends Exception {
    protected static final StackTraceElement[] NO_TRACE;
    protected static final boolean isStackTrace;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        isStackTrace = System.getProperty("surefire.test.class.path") != null;
        NO_TRACE = new StackTraceElement[0];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ReaderException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ReaderException(Throwable th) {
        super(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        return null;
    }
}
