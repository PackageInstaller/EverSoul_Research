package com.google.firebase.installations;

import com.google.firebase.FirebaseException;

/* loaded from: classes2.dex */
public class FirebaseInstallationsException extends FirebaseException {
    private final Status status;

    public enum Status {
        BAD_CONFIG,
        UNAVAILABLE,
        TOO_MANY_REQUESTS
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseInstallationsException(Status status) {
        this.status = status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseInstallationsException(String str, Status status) {
        super(str);
        this.status = status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebaseInstallationsException(String str, Status status, Throwable th) {
        super(str, th);
        this.status = status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Status getStatus() {
        return this.status;
    }
}
