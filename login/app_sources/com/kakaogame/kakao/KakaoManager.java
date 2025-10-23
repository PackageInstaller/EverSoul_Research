package com.kakaogame.kakao;

import android.app.Activity;
import android.util.Pair;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.kakao.sdk.auth.TokenManager;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.talk.model.TalkProfile;
import com.kakao.sdk.user.UserApiClient;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGLocalPlayer;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthImpl;
import com.kakaogame.auth.agreement.AgreementManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.core.KGResultUtil;
import com.kakaogame.idp.IdpAccount;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.log.tracer.TraceLoginActionCode;
import com.kakaogame.log.tracer.Tracer;
import com.kakaogame.player.LocalPlayerService;
import com.kakaogame.server.InhouseGWService;
import com.kakaogame.util.Stopwatch;
import com.kakaogame.util.json.JSONObject;
import com.liapp.y;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KakaoManager.kt */
@Metadata(m838d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J(\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u000e\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0017J\n\u0010 \u001a\u0004\u0018\u00010\u0015H\u0007J\u0010\u0010!\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0017H\u0007J\u0016\u0010\"\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u0017H\u0082@¢\u0006\u0002\u0010#J(\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00150\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0007J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0015H\u0007J\u0010\u0010)\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0015H\u0002J(\u0010*\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u00042\u0006\u0010\u001d\u001a\u00020\u001eH\u0002J\u0016\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0082@¢\u0006\u0002\u0010#J\u0016\u0010,\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0086@¢\u0006\u0002\u0010#R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007R\u0011\u0010\b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0007R\u001a\u0010\t\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\u0007\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00068FX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\f\u0010\u0007R*\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f8\u0006@BX\u0087\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0011\u0010\u0002\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m839d2 = {"Lcom/kakaogame/kakao/KakaoManager;", "", "()V", "TAG", "", "isKakaoLoginUser", "", "()Z", "isNotTalkUser", "isSignup", "setSignup", "(Z)V", "isTalkUser", "isTalkUser$annotations", "<set-?>", "Lcom/kakao/sdk/talk/model/TalkProfile;", "talkProfile", "getTalkProfile$annotations", "getTalkProfile", "()Lcom/kakao/sdk/talk/model/TalkProfile;", "userProfile", "Lcom/kakaogame/kakao/UserProfile;", "checkAgreement", "Lcom/kakaogame/KGResult;", "Ljava/lang/Void;", "activity", "Landroid/app/Activity;", "account", "Lcom/kakaogame/idp/IdpAccount;", "traceJobId", "", "checkTalkUser", "getUserProfile", "loadProfile", "requestMe", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestMeAndSignup", "loginType", "setKakaoCacheMode", "", "profile", "setUserProfile", "signup", "signupSync", "unlink", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoManager {
    public static final KakaoManager INSTANCE = new KakaoManager();
    private static final String TAG = "KakaoManager";
    private static boolean isSignup;
    private static TalkProfile talkProfile;
    private static UserProfile userProfile;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void getTalkProfile$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static /* synthetic */ void isTalkUser$annotations() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final TalkProfile getTalkProfile() {
        return talkProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isSignup() {
        return isSignup;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setSignup(boolean z) {
        isSignup = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setUserProfile(UserProfile profile) {
        userProfile = profile;
        KakaoCache.INSTANCE.saveUserProfile(CoreManager.INSTANCE.getInstance().getContext(), profile);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final UserProfile getUserProfile() {
        if (userProfile == null && CoreManager.INSTANCE.getInstance().isKakaoCacheMode()) {
            userProfile = KakaoCache.INSTANCE.loadUserProfile(CoreManager.INSTANCE.getInstance().getContext());
        }
        return userProfile;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final void setKakaoCacheMode(UserProfile profile) {
        Intrinsics.checkNotNullParameter(profile, y.֬ڱܱײٮ(-1158685391));
        talkProfile = new TalkProfile(profile.getNickname(), profile.getProfileImagePath(), profile.getThumbnailImagePath(), y.ۮڭڭܬި(862710115));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isTalkUser() {
        return talkProfile != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNotTalkUser() {
        return talkProfile == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isKakaoLoginUser() {
        return userProfile != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final KGResult<Boolean> checkTalkUser() {
        Object runBlocking$default;
        KGIdpProfile idpProfile;
        if (CoreManager.INSTANCE.getInstance().isNotAuthorized()) {
            return KGResult.INSTANCE.getResult(3002);
        }
        KGIdpProfile.KGIdpCode kGIdpCode = KGIdpProfile.KGIdpCode.Kakao;
        KGLocalPlayer currentPlayer = KGLocalPlayer.INSTANCE.getCurrentPlayer();
        if (kGIdpCode == ((currentPlayer == null || (idpProfile = currentPlayer.getIdpProfile()) == null) ? null : idpProfile.getIdpCode())) {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KakaoManager$checkTalkUser$talkProfileResult$1(null), 1, null);
            KGResult kGResult = (KGResult) runBlocking$default;
            Logger.INSTANCE.m704i(y.٬ݯح׭٩(576474518), y.ݬֲ֮ܲت(1512484607) + kGResult);
            if (kGResult.isSuccess()) {
                talkProfile = (TalkProfile) kGResult.getContent();
            } else {
                KakaoUtil.convertResultCode(kGResult);
                if (kGResult.getCode() == 7202) {
                    talkProfile = null;
                } else {
                    return KGResult.INSTANCE.getResult(kGResult);
                }
            }
            boolean z = talkProfile != null;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put(y.دײܮڳܯ(2051441581), Boolean.valueOf(z));
            KGResult<Void> updatePlayer = LocalPlayerService.updatePlayer(linkedHashMap);
            if (updatePlayer.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(updatePlayer);
            }
            return KGResult.INSTANCE.getSuccessResult(Boolean.valueOf(z));
        }
        return KGResult.INSTANCE.getResult(5001, y.دײܮڳܯ(2051792293));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<UserProfile> requestMeAndSignup(Activity activity, String loginType, int traceJobId) {
        KGResult<UserProfile> result;
        String name;
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(loginType, y.دײܮڳܯ(2051394893));
        Logger logger = Logger.INSTANCE;
        String str = y.دײܮڳܯ(2051441685);
        String str2 = y.٬ݯح׭٩(576474518);
        logger.m699d(str2, str);
        Stopwatch start = Stopwatch.INSTANCE.start(y.֬ڱܱײٮ(-1158686151));
        try {
            try {
                Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_IDP_PROFILE);
                KakaoManager kakaoManager = INSTANCE;
                result = loadProfile();
                Tracer tracer = Tracer.INSTANCE;
                TraceLoginActionCode traceLoginActionCode = TraceLoginActionCode.SDK_IDP_PROFILE;
                int code = result.getCode();
                String description = result.getDescription();
                if (description == null) {
                    description = result.toString();
                }
                tracer.finishAction(traceJobId, traceLoginActionCode, code, description);
                if (result.isSuccess()) {
                    UserProfile content = result.getContent();
                    Intrinsics.checkNotNull(content);
                    if (!content.hasSignedUp()) {
                        KGResult<Void> signup = kakaoManager.signup(activity, loginType, traceJobId);
                        KGResult<UserProfile> result2 = signup.isNotSuccess() ? KGResult.INSTANCE.getResult(signup) : loadProfile();
                        start.stop();
                        KGResultUtil.writeClientApiCall(start.getName(), result2, start.getDurationMs());
                        return result2;
                    }
                }
                start.stop();
                name = start.getName();
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str2, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                start.stop();
                name = start.getName();
            }
            KGResultUtil.writeClientApiCall(name, result, start.getDurationMs());
            return result;
        } catch (Throwable th) {
            start.stop();
            KGResultUtil.writeClientApiCall(start.getName(), null, start.getDurationMs());
            throw th;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<UserProfile> loadProfile() {
        Object runBlocking$default;
        Object runBlocking$default2;
        Logger logger = Logger.INSTANCE;
        String str = y.٬ݯح׭٩(576471142);
        String str2 = y.٬ݯح׭٩(576474518);
        logger.m699d(str2, str);
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KakaoManager$loadProfile$requestMeResult$1(null), 1, null);
        KGResult<UserProfile> kGResult = (KGResult) runBlocking$default;
        if (kGResult.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(kGResult);
        }
        UserProfile content = kGResult.getContent();
        Logger logger2 = Logger.INSTANCE;
        StringBuilder append = new StringBuilder(y.֬ڱܱײٮ(-1158686335)).append(content).append(y.ݮڮֲڭܩ(-628379292));
        Intrinsics.checkNotNull(content);
        logger2.m699d(str2, append.append(content.hasSignedUp()).toString());
        if (!content.hasSignedUp()) {
            return kGResult;
        }
        runBlocking$default2 = BuildersKt__BuildersKt.runBlocking$default(null, new KakaoManager$loadProfile$talkProfileResult$1(null), 1, null);
        KGResult kGResult2 = (KGResult) runBlocking$default2;
        Logger.INSTANCE.m704i(str2, y.ݬֲ֮ܲت(1512484607) + kGResult2);
        if (kGResult2.isSuccess()) {
            talkProfile = (TalkProfile) kGResult2.getContent();
        } else {
            KakaoUtil.convertResultCode(kGResult2);
            if (kGResult2.getCode() == 7202) {
                talkProfile = null;
            } else {
                return KGResult.INSTANCE.getResult(kGResult2);
            }
        }
        return kGResult;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object requestMe(Continuation<? super KGResult<UserProfile>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        SafeContinuation safeContinuation2 = safeContinuation;
        Logger logger = Logger.INSTANCE;
        String str = y.ݬֲ֮ܲت(1512484247);
        String str2 = y.٬ݯح׭٩(576474518);
        logger.m699d(str2, str);
        try {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KakaoManager$requestMe$2$1(safeContinuation2, null), 3, null);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4001, e.toString())));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object unlink(Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        Logger logger = Logger.INSTANCE;
        String str = y.ݮڮֲڭܩ(-628378108);
        String str2 = y.٬ݯح׭٩(576474518);
        logger.m699d(str2, str);
        try {
            UserApiClient.INSTANCE.getInstance().unlink(new Function1<Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoManager$unlink$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(1);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    String str3 = y.٬ݯح׭٩(576474518);
                    if (th != null) {
                        Logger.INSTANCE.m699d(str3, y.֬ڱܱײٮ(-1158687151));
                        Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                        KGResult.Companion companion = KGResult.INSTANCE;
                        Object obj = classifyKakaoError.first;
                        Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                        KGResult result = companion.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second);
                        Continuation<KGResult<Void>> continuation2 = safeContinuation2;
                        Result.Companion companion2 = Result.INSTANCE;
                        continuation2.resumeWith(Result.m1440constructorimpl(result));
                        return;
                    }
                    Logger.INSTANCE.m699d(str3, y.֬ڱܱײٮ(-1158686999));
                    KGResult successResult = KGResult.INSTANCE.getSuccessResult();
                    Continuation<KGResult<Void>> continuation3 = safeContinuation2;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1440constructorimpl(successResult));
                }
            });
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str2, e.toString(), e);
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4001, e.toString())));
        }
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object signupSync(Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KakaoManager$signupSync$2$1(safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<Void> signup(Activity activity, String loginType, int traceJobId) {
        Object runBlocking$default;
        String str = y.ٴسسݬߨ(1393524970);
        String str2 = y.ۮڭڭܬި(862709803);
        Logger logger = Logger.INSTANCE;
        String str3 = y.ۮڭڭܬި(862709931);
        String str4 = y.٬ݯح׭٩(576474518);
        logger.m699d(str4, str3);
        try {
            isSignup = true;
            OAuthToken token = TokenManager.INSTANCE.getInstance().getToken();
            Intrinsics.checkNotNull(token);
            String accessToken = token.getAccessToken();
            KGResult<JSONObject> kakaoUserInfo = InhouseGWService.getKakaoUserInfo(accessToken, traceJobId);
            if (kakaoUserInfo.isNotSuccess()) {
                return KGResult.INSTANCE.getResult(kakaoUserInfo);
            }
            JSONObject content = kakaoUserInfo.getContent();
            Intrinsics.checkNotNull(content);
            KGResult<Void> checkAgreement = checkAgreement(activity, IdpAccount.INSTANCE.createIdpAccount(KGIdpProfile.KGIdpCode.Kakao.getCode(), String.valueOf((Number) content.get((Object) "kakaoAppUserId")), accessToken, "", loginType), traceJobId);
            if (!checkAgreement.isSuccess()) {
                return checkAgreement;
            }
            Tracer.INSTANCE.startAction(traceJobId, TraceLoginActionCode.SDK_KAKAO_SIGN_UP);
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KakaoManager$signup$signupResult$1(null), 1, null);
            KGResult<Void> kGResult = (KGResult) runBlocking$default;
            Logger.INSTANCE.m699d(str4, str2 + kGResult);
            Tracer.INSTANCE.finishAction(traceJobId, TraceLoginActionCode.SDK_KAKAO_SIGN_UP, kGResult.isSuccess() ? 200 : Tracer.INSTANCE.makeCustomErrorCode(traceJobId, TypedValues.TransitionType.TYPE_FROM), kGResult.isSuccess() ? "Success" : str + kGResult.getCode());
            return kGResult;
        } catch (Exception e) {
            Logger.INSTANCE.m702e(str4, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<Void> checkAgreement(Activity activity, IdpAccount account, int traceJobId) {
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Intrinsics.checkNotNullParameter(account, y.ۮڭڭܬި(862470355));
        Logger logger = Logger.INSTANCE;
        String str = y.ٲٴݴ״ٰ(1782134072) + account;
        String str2 = y.٬ݯح׭٩(576474518);
        logger.m699d(str2, str);
        if (InfodeskHelper.INSTANCE.getOffTermsAgreementPopup()) {
            return KGResult.INSTANCE.getSuccessResult();
        }
        AgreementManager.AgreementCheckType agreementCheckType = AuthImpl.isConnectProcess() ? AgreementManager.AgreementCheckType.CONNECT : AgreementManager.AgreementCheckType.LOGIN;
        KGResult<JSONObject> agreement = AgreementManager.getAgreement(account, agreementCheckType, traceJobId);
        if (agreement.isNotSuccess()) {
            return KGResult.INSTANCE.getResult(agreement);
        }
        JSONObject content = agreement.getContent();
        Intrinsics.checkNotNull(content);
        KGResult<Void> checkAgreementPopupView = AgreementManager.checkAgreementPopupView(activity, agreementCheckType, content, traceJobId);
        Logger.INSTANCE.m699d(str2, y.ݬֲ֮ܲت(1512415535) + checkAgreementPopupView);
        return checkAgreementPopupView;
    }
}
