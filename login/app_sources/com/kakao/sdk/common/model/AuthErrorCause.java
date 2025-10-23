package com.kakao.sdk.common.model;

import com.facebook.internal.AnalyticsEvents;
import com.gamania.beanfunsdk.api.AppDefine;
import kotlin.Metadata;

/* compiled from: KakaoSdkError.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u000b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m839d2 = {"Lcom/kakao/sdk/common/model/AuthErrorCause;", "", "(Ljava/lang/String;I)V", "InvalidRequest", "InvalidClient", "InvalidScope", "InvalidGrant", "Misconfigured", "Unauthorized", "AccessDenied", AppDefine.STR_OPENID_RESULT_SERVER_ERROR, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public enum AuthErrorCause {
    InvalidRequest,
    InvalidClient,
    InvalidScope,
    InvalidGrant,
    Misconfigured,
    Unauthorized,
    AccessDenied,
    ServerError,
    Unknown
}
