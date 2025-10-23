package com.kakaogame.kakao;

import android.util.Pair;
import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.AuthError;
import com.kakao.sdk.common.model.AuthErrorCause;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.text.SimpleDateFormat;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KakaoUtil.kt */
@Metadata(m838d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u001a\u0010\n\u001a\u0006\u0012\u0002\b\u00030\u000b2\f\u0010\f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u000bH\u0007J\u000e\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0007J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007J\u0012\u0010\u0012\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0013"}, m839d2 = {"Lcom/kakaogame/kakao/KakaoUtil;", "", "()V", "TAG", "", "classifyKakaoError", "Landroid/util/Pair;", "", "error", "", "convertResultCode", "Lcom/kakaogame/KGResult;", "result", "getResultCode", "errorCode", "parseInvitataionDate", "", "dateStr", "parseInvitataionDateForJoiner", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoUtil {
    public static final KakaoUtil INSTANCE = new KakaoUtil();
    private static final String TAG = "KakaoUtil";

    /* compiled from: KakaoUtil.kt */
    @Metadata(m840k = 3, m841mv = {1, 9, 0}, m843xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[ClientErrorCause.values().length];
            try {
                iArr[ClientErrorCause.Cancelled.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClientErrorCause.NotSupported.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClientErrorCause.TokenNotFound.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ClientErrorCause.BadParameter.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[AuthErrorCause.values().length];
            try {
                iArr2[AuthErrorCause.AccessDenied.ordinal()] = 1;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[AuthErrorCause.InvalidRequest.ordinal()] = 2;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[AuthErrorCause.InvalidClient.ordinal()] = 3;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[AuthErrorCause.InvalidScope.ordinal()] = 4;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[AuthErrorCause.InvalidGrant.ordinal()] = 5;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[AuthErrorCause.Misconfigured.ordinal()] = 6;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[AuthErrorCause.ServerError.ordinal()] = 7;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[AuthErrorCause.Unauthorized.ordinal()] = 8;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[AuthErrorCause.Unknown.ordinal()] = 9;
            } catch (NoSuchFieldError unused13) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoUtil() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final long parseInvitataionDate(String dateStr) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782219640) + dateStr;
        String str2 = y.ۮڭڭܬި(862712859);
        logger.m704i(str2, str);
        if (dateStr == null) {
            return 0L;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ").parse(dateStr).getTime();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final long parseInvitataionDateForJoiner(String dateStr) {
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782219640) + dateStr;
        String str2 = y.ۮڭڭܬި(862712859);
        logger.m704i(str2, str);
        if (dateStr == null) {
            return 0L;
        }
        try {
            return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'").parse(dateStr).getTime();
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            return 0L;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<?> convertResultCode(KGResult<?> result) {
        String str;
        if (result == null) {
            return KGResult.INSTANCE.getResult(4002);
        }
        KakaoUtil kakaoUtil = INSTANCE;
        int resultCode = kakaoUtil.getResultCode(result.getCode());
        String str2 = y.ݬֲ֮ܲت(1512761407);
        String str3 = y.دײܮڳܯ(2051571757);
        if ((resultCode == 400 || resultCode == 403) && result.getContent() != null) {
            try {
                JSONObject jSONObject = (JSONObject) result.getContent();
                Intrinsics.checkNotNull(jSONObject);
                Object obj = jSONObject.get((Object) str3);
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Long");
                resultCode = kakaoUtil.getResultCode((int) ((Long) obj).longValue());
                JSONObject jSONObject2 = (JSONObject) result.getContent();
                Intrinsics.checkNotNull(jSONObject2);
                result.put((KGResult<?>) str2, (String) jSONObject2.get((Object) "msg"));
            } catch (Exception unused) {
            }
        }
        if (resultCode == result.getCode()) {
            return result;
        }
        String description = result.getDescription();
        String str4 = description;
        if (str4 == null || str4.length() == 0) {
            str = y.֬ڱܱײٮ(-1158685151) + result.getCode();
        } else {
            str = description + y.٬ݯح׭٩(576472974) + result.getCode() + ')';
        }
        KGResult<?> kGResult = result;
        kGResult.put((KGResult<?>) str3, (String) Integer.valueOf(resultCode));
        kGResult.put((KGResult<?>) str2, str);
        return KGResult.INSTANCE.getResult(resultCode, str, result.getContent());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getResultCode(int errorCode) {
        if (errorCode == ApiErrorCause.Unknown.getErrorCode()) {
            return 9999;
        }
        if (errorCode > 0) {
            return errorCode;
        }
        if (errorCode == ApiErrorCause.InternalError.getErrorCode()) {
            return 500;
        }
        if ((errorCode == ApiErrorCause.IllegalParams.getErrorCode() || errorCode == ApiErrorCause.StoryInvalidScrapUrl.getErrorCode()) || errorCode == ApiErrorCause.StoryInvalidPostId.getErrorCode()) {
            return 4000;
        }
        if (errorCode == ApiErrorCause.UnsupportedApi.getErrorCode() || errorCode == ApiErrorCause.UserDeviceUnsupported.getErrorCode()) {
            return 5001;
        }
        if (errorCode == ApiErrorCause.BlockedAction.getErrorCode()) {
            return 461;
        }
        if (errorCode == ApiErrorCause.PermissionDenied.getErrorCode()) {
            return 403;
        }
        if (errorCode == ApiErrorCause.NotRegisteredUser.getErrorCode()) {
            return 3002;
        }
        if (((((((((errorCode == ApiErrorCause.DeprecatedApi.getErrorCode() || errorCode == ApiErrorCause.ApiLimitExceeded.getErrorCode()) || errorCode == ApiErrorCause.AlreadyRegisteredUser.getErrorCode()) || errorCode == ApiErrorCause.PropertyKeyDoesNotExist.getErrorCode()) || errorCode == ApiErrorCause.AppDoesNotExist.getErrorCode()) || errorCode == ApiErrorCause.InsufficientScope.getErrorCode()) || errorCode == ApiErrorCause.NotFriend.getErrorCode()) || errorCode == ApiErrorCause.NotStoryUser.getErrorCode()) || errorCode == ApiErrorCause.DeveloperDoesNotExist.getErrorCode()) || errorCode == ApiErrorCause.AccountDoesNotExist.getErrorCode()) {
            return 4002;
        }
        if (errorCode == ApiErrorCause.InvalidToken.getErrorCode()) {
            return 4010;
        }
        if (errorCode == ApiErrorCause.NotTalkUser.getErrorCode()) {
            return KGResult.KGResultCode.NOT_KAKAOTALK_USER;
        }
        if (errorCode == ApiErrorCause.TalkMessageDisabled.getErrorCode()) {
            return KGResult.KGResultCode.MESSAGE_SETTING_DISABLE;
        }
        if (errorCode == ApiErrorCause.TalkSendMessageMonthlyLimitExceed.getErrorCode()) {
            return KGResult.KGResultCode.EXCEED_MONTHLY_USAGE;
        }
        if (errorCode == ApiErrorCause.TalkSendMessageDailyLimitExceed.getErrorCode()) {
            return KGResult.KGResultCode.EXCEED_DAILY_USAGE;
        }
        if (errorCode == ApiErrorCause.StoryImageUploadSizeExceeded.getErrorCode()) {
            return KGResult.KGResultCode.EXCEED_MAX_UPLOAD_SIZE;
        }
        if (errorCode == ApiErrorCause.StoryMaxUploadCountExceed.getErrorCode()) {
            return KGResult.KGResultCode.EXCEED_MAX_UPLOAD_NUMBER;
        }
        if (errorCode == ApiErrorCause.TimeOut.getErrorCode()) {
            return 2001;
        }
        return errorCode == ApiErrorCause.UnderMaintenance.getErrorCode() ? KGResult.KGResultCode.SERVICE_UNAVAILABLE : errorCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final Pair<Integer, String> classifyKakaoError(Throwable error) {
        Pair<Integer, String> pair;
        Intrinsics.checkNotNullParameter(error, y.٬ݯح׭٩(576154958));
        if (error instanceof ClientError) {
            ClientError clientError = (ClientError) error;
            int i = WhenMappings.$EnumSwitchMapping$0[clientError.getReason().ordinal()];
            if (i == 1) {
                return new Pair<>(9001, clientError.getMsg());
            }
            if (i == 2) {
                return new Pair<>(5001, clientError.getMsg());
            }
            if (i == 3) {
                return new Pair<>(4010, clientError.getMsg());
            }
            if (i == 4) {
                return new Pair<>(4000, clientError.getMsg());
            }
            return new Pair<>(9999, clientError.getMsg());
        }
        if (error instanceof AuthError) {
            AuthError authError = (AuthError) error;
            if (authError.getStatusCode() == 302 && Intrinsics.areEqual(authError.getResponse().getError(), y.֬ڱܱײٮ(-1158684759))) {
                return new Pair<>(Integer.valueOf(KGResult.KGResultCode.KAKAOTALK_NOT_AUTHENTICATION), authError.getResponse().getErrorDescription());
            }
            switch (WhenMappings.$EnumSwitchMapping$1[authError.getReason().ordinal()]) {
                case 1:
                    return new Pair<>(9001, authError.getMsg());
                case 2:
                case 3:
                case 4:
                case 5:
                    return new Pair<>(4000, authError.getMsg());
                case 6:
                    return new Pair<>(4002, authError.getMsg());
                case 7:
                    return new Pair<>(403, authError.getMsg());
                case 8:
                    return new Pair<>(500, authError.getMsg());
                case 9:
                    return new Pair<>(9999, authError.getMsg());
                default:
                    return new Pair<>(9999, authError.getMsg());
            }
        }
        if (error instanceof ApiError) {
            ApiError apiError = (ApiError) error;
            return new Pair<>(Integer.valueOf(apiError.getResponse().getCode()), apiError.getMsg());
        }
        try {
            if (error.getMessage() == null) {
                pair = new Pair<>(4001, "");
            } else {
                pair = new Pair<>(4001, error.getMessage());
            }
        } catch (Exception unused) {
            pair = new Pair<>(4001, "");
        }
        return pair;
    }
}
