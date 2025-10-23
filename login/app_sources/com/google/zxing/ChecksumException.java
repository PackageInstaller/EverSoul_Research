package com.google.zxing;

/* loaded from: classes3.dex */
public final class ChecksumException extends ReaderException {
    private static final ChecksumException INSTANCE;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        ChecksumException checksumException = new ChecksumException();
        INSTANCE = checksumException;
        checksumException.setStackTrace(NO_TRACE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ChecksumException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ChecksumException(Throwable th) {
        super(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ChecksumException getChecksumInstance() {
        return isStackTrace ? new ChecksumException() : INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ChecksumException getChecksumInstance(Throwable th) {
        return isStackTrace ? new ChecksumException(th) : INSTANCE;
    }
}
