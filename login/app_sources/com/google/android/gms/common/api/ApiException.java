package com.google.android.gms.common.api;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public class ApiException extends Exception {

    @Deprecated
    protected final Status mStatus;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ApiException(Status status) {
        super(status.getStatusCode() + ": " + (status.getStatusMessage() != null ? status.getStatusMessage() : ""));
        this.mStatus = status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Status getStatus() {
        return this.mStatus;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStatusCode() {
        return this.mStatus.getStatusCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public String getStatusMessage() {
        return this.mStatus.getStatusMessage();
    }
}
