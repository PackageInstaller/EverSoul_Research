package com.kakao.sdk.common.model;

import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.NativeProtocol;
import com.gamania.beanfunsdk.api.AppDefine;
import kotlin.Metadata;

/* compiled from: KakaoSdkError.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b&\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(¨\u0006)"}, m839d2 = {"Lcom/kakao/sdk/common/model/ApiErrorCause;", "", "errorCode", "", "(Ljava/lang/String;II)V", "getErrorCode", "()I", "InternalError", "IllegalParams", "UnsupportedApi", "BlockedAction", NativeProtocol.ERROR_PERMISSION_DENIED, "DeprecatedApi", "ApiLimitExceeded", "NotRegisteredUser", "AlreadyRegisteredUser", "AccountDoesNotExist", "PropertyKeyDoesNotExist", "AppDoesNotExist", "InvalidToken", "InsufficientScope", "RequiredAgeVerification", "UnderAgeLimit", "SigningIsNotCompleted", "InvalidTransaction", "TransactionHasExpired", "NotTalkUser", "NotFriend", "UserDeviceUnsupported", "TalkMessageDisabled", "TalkSendMessageMonthlyLimitExceed", "TalkSendMessageDailyLimitExceed", "NotStoryUser", "StoryImageUploadSizeExceeded", AppDefine.STR_OPENID_RESULT_TIMEOUT, "StoryInvalidScrapUrl", "StoryInvalidPostId", "StoryMaxUploadCountExceed", "DeveloperDoesNotExist", "UnderMaintenance", AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public enum ApiErrorCause {
    InternalError(-1),
    IllegalParams(-2),
    UnsupportedApi(-3),
    BlockedAction(-4),
    PermissionDenied(-5),
    DeprecatedApi(-9),
    ApiLimitExceeded(-10),
    NotRegisteredUser(-101),
    AlreadyRegisteredUser(-102),
    AccountDoesNotExist(-103),
    PropertyKeyDoesNotExist(-201),
    AppDoesNotExist(-301),
    InvalidToken(-401),
    InsufficientScope(-402),
    RequiredAgeVerification(-405),
    UnderAgeLimit(-406),
    SigningIsNotCompleted(-421),
    InvalidTransaction(-422),
    TransactionHasExpired(-423),
    NotTalkUser(-501),
    NotFriend(-502),
    UserDeviceUnsupported(-504),
    TalkMessageDisabled(-530),
    TalkSendMessageMonthlyLimitExceed(-531),
    TalkSendMessageDailyLimitExceed(-532),
    NotStoryUser(-601),
    StoryImageUploadSizeExceeded(-602),
    TimeOut(-603),
    StoryInvalidScrapUrl(-604),
    StoryInvalidPostId(-605),
    StoryMaxUploadCountExceed(-606),
    DeveloperDoesNotExist(-903),
    UnderMaintenance(-9798),
    Unknown(Integer.MAX_VALUE);

    private final int errorCode;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ApiErrorCause(int i) {
        this.errorCode = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getErrorCode() {
        return this.errorCode;
    }
}
