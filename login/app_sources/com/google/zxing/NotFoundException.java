package com.google.zxing;

/* loaded from: classes3.dex */
public final class NotFoundException extends ReaderException {
    private static final NotFoundException INSTANCE;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        NotFoundException notFoundException = new NotFoundException();
        INSTANCE = notFoundException;
        notFoundException.setStackTrace(NO_TRACE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NotFoundException() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static NotFoundException getNotFoundInstance() {
        return INSTANCE;
    }
}
