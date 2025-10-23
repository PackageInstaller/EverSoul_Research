package com.google.android.datatransport.runtime.backends;

/* loaded from: classes.dex */
public abstract class BackendResponse {

    public enum Status {
        OK,
        TRANSIENT_ERROR,
        FATAL_ERROR,
        INVALID_PAYLOAD
    }

    public abstract long getNextRequestWaitMillis();

    public abstract Status getStatus();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendResponse transientError() {
        return new AutoValue_BackendResponse(Status.TRANSIENT_ERROR, -1L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendResponse fatalError() {
        return new AutoValue_BackendResponse(Status.FATAL_ERROR, -1L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static BackendResponse invalidPayload() {
        return new AutoValue_BackendResponse(Status.INVALID_PAYLOAD, -1L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: ok */
    public static BackendResponse m107ok(long j) {
        return new AutoValue_BackendResponse(Status.OK, j);
    }
}
