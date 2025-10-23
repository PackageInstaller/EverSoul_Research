package com.kakaogame.kakao;

import android.app.Activity;
import android.content.Context;
import android.util.Pair;
import com.kakao.sdk.partner.user.UserApiClientKt;
import com.kakao.sdk.partner.user.model.AgeAuthErrorCause;
import com.kakao.sdk.partner.user.model.AgeAuthInfo;
import com.kakao.sdk.partner.user.model.AgeCriteria;
import com.kakao.sdk.user.UserApiClient;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthDataManager;
import com.kakaogame.core.CoreManager;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.util.AppUtil;
import com.liapp.y;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: KakaoAgeAuthManager.kt */
@Metadata(m838d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0016\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u0017H\u0082@¢\u0006\u0002\u0010\u0019J\u001e\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001f\u001a\u00020 J\u0012\u0010!\u001a\u00020\u00122\b\u0010\"\u001a\u0004\u0018\u00010#H\u0002J\u0018\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00180\u00172\u0006\u0010\u001f\u001a\u00020 H\u0002J\u0018\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\"\u0010&\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0018\u00010\u00172\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0002J\u0018\u0010'\u001a\u0004\u0018\u00010(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010)J\u0018\u0010*\u001a\u0004\u0018\u00010(2\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010)J \u0010+\u001a\u0004\u0018\u00010(2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0012H\u0082@¢\u0006\u0002\u0010,J\u001e\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010.0\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0082@¢\u0006\u0002\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\nR\"\u0010\u000e\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0013¨\u0006/"}, m839d2 = {"Lcom/kakaogame/kakao/KakaoAgeAuthManager;", "", "()V", "ONE_DAY_TIME", "", "TAG", "", "ageAuthLimit", "", "getAgeAuthLimit", "()I", "ageAuthValidDays", "getAgeAuthValidDays", "<set-?>", "cI", "getCI", "()Ljava/lang/String;", "isAgeAuthCheckOnLoginProcess", "", "()Z", "isAgeAuthFailProcessKill", "isReachBoardGame", "ageAuthInfo", "Lcom/kakaogame/KGResult;", "Lcom/kakao/sdk/partner/user/model/AgeAuthInfo;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "checkAgeAuth", "activity", "Landroid/app/Activity;", "isLogin", "getCIonAutoLogin", "context", "Landroid/content/Context;", "isVerifiedDate", "authenticatedAt", "Ljava/util/Date;", "requestAgeAuthInfo", "requestShowAgeAuthDialog", "showAgeAuthDialog", "showAgeAuthFailedDialog", "", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "showAgeAuthGuideDialog", "showAgeLimitDialog", "(Landroid/app/Activity;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "verifyAgeSync", "Ljava/lang/Void;", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoAgeAuthManager {
    public static final KakaoAgeAuthManager INSTANCE = new KakaoAgeAuthManager();
    private static final String TAG = y.ݬֲ֮ܲت(1512536607);
    private static final long ONE_DAY_TIME = DateUtils.MILLIS_PER_DAY;
    private static String cI = "";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private KakaoAgeAuthManager() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCI() {
        return cI;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isReachBoardGame() {
        boolean isReachBoardGame = InfodeskHelper.INSTANCE.isReachBoardGame();
        Logger.INSTANCE.m704i(TAG, y.ۮڭڭܬި(862600131).concat(isReachBoardGame ? y.دײܮڳܯ(2051939573) : y.ٲٴݴ״ٰ(1781635312)));
        return isReachBoardGame;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isAgeAuthCheckOnLoginProcess() {
        return CoreManager.INSTANCE.getInstance().getConfiguration().isAgeAuthOnLogin();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getAgeAuthLimit() {
        int ageAuthLimit = InfodeskHelper.INSTANCE.getAgeAuthLimit();
        Logger.INSTANCE.m704i(TAG, y.֬ڱܱײٮ(-1158803535) + ageAuthLimit);
        return ageAuthLimit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isAgeAuthFailProcessKill() {
        return CoreManager.INSTANCE.getInstance().getConfiguration().getAgeAuthFailProcessKill();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getCIonAutoLogin(Context context) {
        Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
        KGResult<AgeAuthInfo> requestAgeAuthInfo = requestAgeAuthInfo(context);
        if (!requestAgeAuthInfo.isSuccess()) {
            return "";
        }
        AgeAuthInfo content = requestAgeAuthInfo.getContent();
        Intrinsics.checkNotNull(content);
        return content.getCi();
    }

    /* JADX WARN: Code restructure failed: missing block: B:84:0x0208, code lost:
    
        if (kotlin.jvm.internal.Intrinsics.areEqual(r0, r2.name()) == false) goto L81;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final com.kakaogame.KGResult<java.lang.String> checkAgeAuth(android.app.Activity r9, boolean r10) {
        /*
            Method dump skipped, instructions count: 662
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.kakao.KakaoAgeAuthManager.checkAgeAuth(android.app.Activity, boolean):com.kakaogame.KGResult");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object ageAuthInfo(Continuation<? super KGResult<AgeAuthInfo>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        KakaoAgeAuthManager kakaoAgeAuthManager = INSTANCE;
        UserApiClientKt.ageAuthInfo(UserApiClient.INSTANCE.getInstance(), Boxing.boxInt(kakaoAgeAuthManager.getAgeAuthLimit()), kakaoAgeAuthManager.isReachBoardGame() ? CollectionsKt.listOf(y.٬ݯح׭٩(576558622)) : null, AgeCriteria.YEAR, new Function2<AgeAuthInfo, Throwable, Unit>() { // from class: com.kakaogame.kakao.KakaoAgeAuthManager$ageAuthInfo$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(AgeAuthInfo ageAuthInfo, Throwable th) {
                invoke2(ageAuthInfo, th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AgeAuthInfo ageAuthInfo, Throwable th) {
                Unit unit;
                String str;
                String str2;
                if (th != null) {
                    Continuation<KGResult<AgeAuthInfo>> continuation2 = safeContinuation2;
                    Logger logger = Logger.INSTANCE;
                    str2 = KakaoAgeAuthManager.TAG;
                    logger.m699d(str2, y.ݬֲ֮ܲت(1512537727) + th);
                    Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                    KGResult.Companion companion = KGResult.INSTANCE;
                    Object obj = classifyKakaoError.first;
                    Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                    KGResult result = companion.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second);
                    Result.Companion companion2 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(result));
                    unit = Unit.INSTANCE;
                } else {
                    unit = null;
                }
                if (unit == null) {
                    KakaoAgeAuthManager kakaoAgeAuthManager2 = KakaoAgeAuthManager.INSTANCE;
                    Continuation<KGResult<AgeAuthInfo>> continuation3 = safeContinuation2;
                    Logger logger2 = Logger.INSTANCE;
                    str = KakaoAgeAuthManager.TAG;
                    logger2.m699d(str, y.ݮڮֲڭܩ(-628464940) + ageAuthInfo);
                    KGResult successResult = KGResult.INSTANCE.getSuccessResult(ageAuthInfo);
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation3.resumeWith(Result.m1440constructorimpl(successResult));
                }
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<AgeAuthInfo> requestAgeAuthInfo(Context context) {
        Object runBlocking$default;
        Logger.INSTANCE.m699d(TAG, y.ݬֲ֮ܲت(1512474335));
        try {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KakaoAgeAuthManager$requestAgeAuthInfo$checkAgeAuthResult$1(null), 1, null);
            KGResult kGResult = (KGResult) runBlocking$default;
            if (kGResult.isSuccess()) {
                Object content = kGResult.getContent();
                Intrinsics.checkNotNull(content);
                AgeAuthInfo ageAuthInfo = (AgeAuthInfo) content;
                if (isReachBoardGame()) {
                    String ci = ageAuthInfo.getCi();
                    cI = ci;
                    AuthDataManager.updateCI(context, ci);
                }
                return KGResult.INSTANCE.getSuccessResult(ageAuthInfo);
            }
            return KGResult.INSTANCE.getResult(kGResult);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> showAgeAuthDialog(Activity activity, boolean isLogin) {
        BuildersKt__BuildersKt.runBlocking$default(null, new KakaoAgeAuthManager$showAgeAuthDialog$1(activity, null), 1, null);
        KGResult<String> requestShowAgeAuthDialog = requestShowAgeAuthDialog(activity);
        Logger.INSTANCE.m699d(TAG, y.֬ڱܱײٮ(-1158679655) + requestShowAgeAuthDialog);
        int code = requestShowAgeAuthDialog.getCode();
        if (code == 200) {
            return null;
        }
        if (code == AgeAuthErrorCause.LOWER_AGE_LIMIT.getStatus()) {
            if (isAgeAuthFailProcessKill()) {
                BuildersKt__BuildersKt.runBlocking$default(null, new KakaoAgeAuthManager$showAgeAuthDialog$2(activity, isLogin, null), 1, null);
                if (isLogin) {
                    AppUtil.terminateApp(activity);
                }
            }
            if (isLogin) {
                return KGResult.INSTANCE.getSuccessResult();
            }
            return KGResult.INSTANCE.getResult(KGResult.KGResultCode.UNDER_AGE_PLAYER);
        }
        if (code != 7204) {
            BuildersKt__BuildersKt.runBlocking$default(null, new KakaoAgeAuthManager$showAgeAuthDialog$3(activity, null), 1, null);
            if (isLogin && isAgeAuthFailProcessKill()) {
                AppUtil.terminateApp(activity);
            }
            return KGResult.INSTANCE.getResult(9001);
        }
        return KGResult.INSTANCE.getResult(KGResult.KGResultCode.AGREEMENT_REQUIRED);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object verifyAgeSync(Activity activity, Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KakaoAgeAuthManager$verifyAgeSync$2$1(activity, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final KGResult<String> requestShowAgeAuthDialog(Activity activity) {
        Object runBlocking$default;
        Logger.INSTANCE.m699d(TAG, y.ٴسسݬߨ(1393536394));
        try {
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KakaoAgeAuthManager$requestShowAgeAuthDialog$requestResult$1(activity, null), 1, null);
            KGResult kGResult = (KGResult) runBlocking$default;
            return kGResult.isSuccess() ? checkAgeAuth(activity, false) : KGResult.INSTANCE.getResult(kGResult);
        } catch (Exception e) {
            Logger.INSTANCE.m702e(TAG, e.toString(), e);
            return KGResult.INSTANCE.getResult(4001, e.toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showAgeAuthGuideDialog(Activity activity, Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Logger.INSTANCE.m704i(TAG, y.٬ݯح׭٩(576482382));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KakaoAgeAuthManager$showAgeAuthGuideDialog$2$1(activity, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showAgeAuthFailedDialog(Activity activity, Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Logger.INSTANCE.m704i(TAG, y.ݬֲ֮ܲت(1512473647));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KakaoAgeAuthManager$showAgeAuthFailedDialog$2$1(activity, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object showAgeLimitDialog(Activity activity, boolean z, Continuation<? super Unit> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        Logger.INSTANCE.m704i(TAG, y.֬ڱܱײٮ(-1158679551));
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KakaoAgeAuthManager$showAgeLimitDialog$2$1(z, activity, safeContinuation, null), 3, null);
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean isVerifiedDate(Date authenticatedAt) {
        if (authenticatedAt == null) {
            return false;
        }
        long time = authenticatedAt.getTime() + (ONE_DAY_TIME * getAgeAuthValidDays());
        Logger logger = Logger.INSTANCE;
        String str = TAG;
        logger.m699d(str, y.ݮڮֲڭܩ(-628385676) + time);
        Logger.INSTANCE.m699d(str, y.ݬֲ֮ܲت(1512474375) + System.currentTimeMillis());
        return System.currentTimeMillis() < time;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final int getAgeAuthValidDays() {
        return InfodeskHelper.INSTANCE.getAgeAuthValidDays();
    }
}
