package com.google.zxing;

/* loaded from: classes3.dex */
public final class FormatException extends ReaderException {
    private static final FormatException INSTANCE;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        FormatException formatException = new FormatException();
        INSTANCE = formatException;
        formatException.setStackTrace(NO_TRACE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FormatException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private FormatException(Throwable th) {
        super(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FormatException getFormatInstance() {
        return isStackTrace ? new FormatException() : INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FormatException getFormatInstance(Throwable th) {
        return isStackTrace ? new FormatException(th) : INSTANCE;
    }
}
