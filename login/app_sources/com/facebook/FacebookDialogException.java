package com.facebook;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FacebookDialogException.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0001\rB!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, m839d2 = {"Lcom/facebook/FacebookDialogException;", "Lcom/facebook/FacebookException;", "message", "", "errorCode", "", "failingUrl", "(Ljava/lang/String;ILjava/lang/String;)V", "getErrorCode", "()I", "getFailingUrl", "()Ljava/lang/String;", "toString", "Companion", "facebook-common_release"}, m840k = 1, m841mv = {1, 5, 1}, m843xi = 48)
/* loaded from: classes.dex */
public final class FacebookDialogException extends FacebookException {
    public static final long serialVersionUID = 1;
    private final int errorCode;
    private final String failingUrl;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getErrorCode() {
        return this.errorCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getFailingUrl() {
        return this.failingUrl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FacebookDialogException(String str, int i, String str2) {
        super(str);
        this.errorCode = i;
        this.failingUrl = str2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.facebook.FacebookException, java.lang.Throwable
    public String toString() {
        String str = "{FacebookDialogException: errorCode: " + this.errorCode + ", message: " + getMessage() + ", url: " + this.failingUrl + "}";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder()\n        .append(\"{FacebookDialogException: \")\n        .append(\"errorCode: \")\n        .append(errorCode)\n        .append(\", message: \")\n        .append(message)\n        .append(\", url: \")\n        .append(failingUrl)\n        .append(\"}\")\n        .toString()");
        return str;
    }
}
