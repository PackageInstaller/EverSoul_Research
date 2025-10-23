package com.nostra13.universalimageloader.core.assist;

/* loaded from: classes3.dex */
public class FailReason {
    private final Throwable cause;
    private final FailType type;

    public enum FailType {
        IO_ERROR,
        DECODING_ERROR,
        NETWORK_DENIED,
        OUT_OF_MEMORY,
        UNKNOWN
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FailReason(FailType failType, Throwable th) {
        this.type = failType;
        this.cause = th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FailType getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Throwable getCause() {
        return this.cause;
    }
}
