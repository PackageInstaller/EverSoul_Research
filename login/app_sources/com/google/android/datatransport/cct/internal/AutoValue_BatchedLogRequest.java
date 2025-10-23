package com.google.android.datatransport.cct.internal;

import com.google.firebase.encoders.annotations.Encodable;
import java.util.List;

/* loaded from: classes.dex */
final class AutoValue_BatchedLogRequest extends BatchedLogRequest {
    private final List<LogRequest> logRequests;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AutoValue_BatchedLogRequest(List<LogRequest> list) {
        if (list == null) {
            throw new NullPointerException("Null logRequests");
        }
        this.logRequests = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.cct.internal.BatchedLogRequest
    @Encodable.Field(name = "logRequest")
    public List<LogRequest> getLogRequests() {
        return this.logRequests;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "BatchedLogRequest{logRequests=" + this.logRequests + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof BatchedLogRequest) {
            return this.logRequests.equals(((BatchedLogRequest) obj).getLogRequests());
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.logRequests.hashCode() ^ 1000003;
    }
}
