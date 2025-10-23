package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.apache.commons.lang3.StringUtils;

/* compiled from: FacebookGraphResponseException.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\u0005H\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\n"}, m839d2 = {"Lcom/facebook/FacebookGraphResponseException;", "Lcom/facebook/FacebookException;", "graphResponse", "Lcom/facebook/GraphResponse;", "errorMessage", "", "(Lcom/facebook/GraphResponse;Ljava/lang/String;)V", "getGraphResponse", "()Lcom/facebook/GraphResponse;", "toString", "facebook-core_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class FacebookGraphResponseException extends FacebookException {
    private final GraphResponse graphResponse;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final GraphResponse getGraphResponse() {
        return this.graphResponse;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FacebookGraphResponseException(GraphResponse graphResponse, String str) {
        super(str);
        this.graphResponse = graphResponse;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.FacebookException, java.lang.Throwable
    public String toString() {
        GraphResponse graphResponse = this.graphResponse;
        FacebookRequestError error = graphResponse == null ? null : graphResponse.getError();
        StringBuilder sb = new StringBuilder("{FacebookGraphResponseException: ");
        String message = getMessage();
        if (message != null) {
            sb.append(message);
            sb.append(StringUtils.SPACE);
        }
        if (error != null) {
            sb.append("httpResponseCode: ").append(error.getRequestStatusCode()).append(", facebookErrorCode: ").append(error.getErrorCode()).append(", facebookErrorType: ").append(error.getErrorType()).append(", message: ").append(error.getErrorMessage()).append("}");
        }
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "errorStringBuilder.toString()");
        return sb2;
    }
}
