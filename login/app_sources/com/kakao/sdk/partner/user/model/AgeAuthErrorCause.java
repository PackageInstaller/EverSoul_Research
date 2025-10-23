package com.kakao.sdk.partner.user.model;

import kotlin.Metadata;

/* compiled from: AgeAuthError.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, m839d2 = {"Lcom/kakao/sdk/partner/user/model/AgeAuthErrorCause;", "", "status", "", "(Ljava/lang/String;II)V", "getStatus", "()I", "UNAUTHORIZED", "BAD_PARAMETERS", "NOT_AUTHORIZED_AGE", "LOWER_AGE_LIMIT", "ALREADY_AGE_AUTHORIZED", "EXCEED_AGE_CHECK_LIMIT", "AGE_AUTH_RESULT_MISMATCH", "CI_RESULT_MISMATCH", "ERROR", "UNKNOWN", "partner-user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public enum AgeAuthErrorCause {
    UNAUTHORIZED(-401),
    BAD_PARAMETERS(-440),
    NOT_AUTHORIZED_AGE(-450),
    LOWER_AGE_LIMIT(-451),
    ALREADY_AGE_AUTHORIZED(-452),
    EXCEED_AGE_CHECK_LIMIT(-453),
    AGE_AUTH_RESULT_MISMATCH(-480),
    CI_RESULT_MISMATCH(-481),
    ERROR(-500),
    UNKNOWN(-9999);

    private final int status;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AgeAuthErrorCause(int i) {
        this.status = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getStatus() {
        return this.status;
    }
}
