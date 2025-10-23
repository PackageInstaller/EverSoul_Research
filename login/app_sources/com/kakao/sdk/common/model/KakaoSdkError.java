package com.kakao.sdk.common.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: KakaoSdkError.kt */
@Metadata(m838d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00060\u0001j\u0002`\u0002B\u000f\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tR\u0014\u0010\u0003\u001a\u00020\u0004X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0082\u0001\u0003\n\u000b\f¨\u0006\r"}, m839d2 = {"Lcom/kakao/sdk/common/model/KakaoSdkError;", "Ljava/lang/RuntimeException;", "Lkotlin/RuntimeException;", "msg", "", "(Ljava/lang/String;)V", "getMsg", "()Ljava/lang/String;", "isInvalidTokenError", "", "Lcom/kakao/sdk/common/model/ApiError;", "Lcom/kakao/sdk/common/model/AuthError;", "Lcom/kakao/sdk/common/model/ClientError;", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public abstract class KakaoSdkError extends RuntimeException {
    private final String msg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KakaoSdkError(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoSdkError(String str) {
        super(str);
        this.msg = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getMsg() {
        return this.msg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isInvalidTokenError() {
        if (this instanceof AuthError) {
            if (((AuthError) this).getReason() == AuthErrorCause.InvalidGrant) {
                return true;
            }
        } else if ((this instanceof ApiError) && ((ApiError) this).getReason() == ApiErrorCause.InvalidToken) {
            return true;
        }
        return false;
    }
}
