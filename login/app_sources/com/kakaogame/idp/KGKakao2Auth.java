package com.kakaogame.idp;

import android.R;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.kakao.sdk.auth.AuthCodeHandlerActivity;
import com.kakao.sdk.auth.TokenManager;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.SdkIdentifier;
import com.kakao.sdk.common.model.ServerHosts;
import com.kakao.sdk.partner.model.KakaoPhase;
import com.kakao.sdk.partner.model.SdkIdentifierKt;
import com.kakao.sdk.partner.model.ServerHostsKt;
import com.kakao.sdk.talk.model.Friend;
import com.kakao.sdk.talk.model.Friends;
import com.kakao.sdk.user.Constants;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.AccessTokenInfo;
import com.kakaogame.KGAuthActivity;
import com.kakaogame.KGIdpProfile;
import com.kakaogame.KGKakaoAuthType;
import com.kakaogame.KGKakaoProfile;
import com.kakaogame.KGKakaoTalk;
import com.kakaogame.KGResult;
import com.kakaogame.Logger;
import com.kakaogame.auth.AuthActivityManager;
import com.kakaogame.config.Configuration;
import com.kakaogame.core.CoreManager;
import com.kakaogame.game.GameServerProtocol;
import com.kakaogame.idp.KGKakao2Auth;
import com.kakaogame.infodesk.InfodeskHelper;
import com.kakaogame.kakao.C2419R;
import com.kakaogame.kakao.KakaoCache;
import com.kakaogame.kakao.KakaoGameAPI;
import com.kakaogame.kakao.KakaoManager;
import com.kakaogame.kakao.KakaoUtil;
import com.kakaogame.player.LocalPlayerService;
import com.kakaogame.server.ServerConstants;
import com.kakaogame.util.AndroidManifestUtil;
import com.kakaogame.util.json.JSONObject;
import com.kakaogame.version.SDKVersion;
import com.liapp.y;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.SafeContinuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: KGKakao2Auth.kt */
@Metadata(m838d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0011\u0018\u0000 .2\u00020\u00012\u00020\u0002:\u0003./0B\u0005¢\u0006\u0002\u0010\u0003J*\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J<\u0010\u0012\u001a\u00020\u00132\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\t2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016J*\u0010\u001d\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0018\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0016J6\u0010!\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\"\u001a\u0004\u0018\u00010\t2\u001a\u0010\u0019\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J(\u0010#\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u001e\u001a\u0004\u0018\u00010\tH\u0082@¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000bH\u0016J\b\u0010&\u001a\u00020\u001bH\u0002J\u001e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u000b2\u0006\u0010\r\u001a\u00020\u000eH\u0082@¢\u0006\u0002\u0010(J\b\u0010)\u001a\u00020\u001bH\u0002J&\u0010*\u001a\u00020\u001b2\u0006\u0010\r\u001a\u00020\u000e2\u0014\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\t\u0012\u0004\u0012\u00020\u001b0\u001aH\u0002J\u0016\u0010+\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000bH\u0082@¢\u0006\u0002\u0010,J\u0010\u0010-\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010 0\u000bH\u0016R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, m839d2 = {"Lcom/kakaogame/idp/KGKakao2Auth;", "Lcom/kakaogame/idp/IdpAuthHandler;", "Lcom/kakaogame/idp/IdpAuthExHandler;", "()V", "localIdpProfile", "Lcom/kakaogame/KGIdpProfile;", "getLocalIdpProfile", "()Lcom/kakaogame/KGIdpProfile;", "loginType", "", "checkAuth", "Lcom/kakaogame/KGResult;", "Lcom/kakaogame/idp/IdpAccount;", "activity", "Landroid/app/Activity;", "authData", "traceJobId", "", "createSelectLoginTypeDialog", "Landroid/app/Dialog;", "authItems", "", "Lcom/kakaogame/idp/KGKakao2Auth$Item;", "adapter", "Landroid/widget/ListAdapter;", "callback", "Lkotlin/Function1;", "", "getAccessToken", "idpLogin", "extras", "initialize", "Ljava/lang/Void;", "kakaoLoginWithType", "authType", "loginWithTypeSync", "(Landroid/app/Activity;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "onFirstLogin", "refreshAccessToken", "(Landroid/app/Activity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "registerLoginListener", "showKakaoAuthTypeSelectDialog", "signOut", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "unregister", "Companion", "Item", "LoginCallback", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KGKakao2Auth implements IdpAuthHandler, IdpAuthExHandler {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static KakaoPhase KAKAO_PHASE = null;
    public static final String KEY_ALLOW_MSG = "isAllowedMessage";
    public static final String KEY_APP_REGISTERED = "isAppRegistered";
    public static final String KEY_CI = "ci";
    public static final String KEY_IMPRESSION_ID = "impressionId";
    public static final String KEY_MEMBER_KEY = "memberKey";
    public static final String KEY_NICKNAME = "nickname";
    public static final String KEY_PROFILE_IMAGE_URL = "profileImageUrl";
    public static final String KEY_RECOMMENDED = "isRecommended";
    public static final String KEY_RECOMMEND_RANK = "recommendRank";
    public static final String KEY_REMAINING_GROUP_MSG_COUNT = "remainingGroupMessageCount";
    public static final String KEY_REMAINING_INVITE_COUNT = "remainingInviteCount";
    public static final String KEY_SERVICE_USER_ID = "serviceUserId";
    public static final String KEY_TALK_OS = "kakaoTalkOS";
    public static final String KEY_THUMBNAIL_IMAGE_URL = "thumbnailImageUrl";
    public static final String KEY_UNREGISTERED = "isUnregistered";
    public static final String KEY_UUID = "uuid";
    private static final String TAG = "KGKakao2Auth";
    private static String appSecret;
    private static boolean isInitialized;
    private static SdkIdentifier sdkIdentifier;
    private static ServerHosts serverHosts;
    private String loginType = y.֬ڱܱײٮ(-1158768775);

    /* compiled from: KGKakao2Auth.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\bf\u0018\u00002\u0018\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0004\u0012\u00020\u00040\u0001J\u001d\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003H¦\u0002¨\u0006\b"}, m839d2 = {"Lcom/kakaogame/idp/KGKakao2Auth$LoginCallback;", "Lkotlin/Function2;", "Lcom/kakao/sdk/auth/model/OAuthToken;", "", "", "invoke", "oAuthToken", "throwable", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public interface LoginCallback extends Function2<OAuthToken, Throwable, Unit> {
        void invoke(OAuthToken oAuthToken, Throwable throwable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final boolean initializeKakaoSdk(Context context) {
        return INSTANCE.initializeKakaoSdk(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final boolean isCheckAgeAuthOnGame() {
        return INSTANCE.isCheckAgeAuthOnGame();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @JvmStatic
    public static final KGResult<String> updateScope(Activity activity, List<String> list) {
        return INSTANCE.updateScope(activity, list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> initialize(Activity activity) {
        KakaoPhase kakaoPhase;
        String str = y.دײܮڳܯ(2051530173);
        Intrinsics.checkNotNullParameter(activity, y.֬ڱܱײٮ(-1159305015));
        Logger logger = Logger.INSTANCE;
        String str2 = y.ٲٴݴ״ٰ(1782310352);
        String str3 = y.دײܮڳܯ(2051536501);
        logger.m699d(str3, str2);
        try {
            isInitialized = false;
            sdkIdentifier = SdkIdentifierKt.create(SdkIdentifier.INSTANCE, MapsKt.mapOf(TuplesKt.m846to("game_sdk", SDKVersion.version)));
            serverHosts = ServerHostsKt.withPhase(ServerHosts.INSTANCE, KakaoPhase.PRODUCTION);
            String str4 = (String) CoreManager.INSTANCE.getInstance().getConfiguration().get(Configuration.KEY_SERVER_TYPE);
            Logger.INSTANCE.m706v(str3, str + str4);
            if (StringsKt.equals(GameServerProtocol.Sandbox, str4, true)) {
                kakaoPhase = KakaoPhase.SANDBOX;
            } else if (StringsKt.equals("alpha", str4, true)) {
                kakaoPhase = KakaoPhase.DEV;
            } else {
                Intrinsics.checkNotNull(str4);
                String lowerCase = str4.toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                kakaoPhase = StringsKt.contains$default((CharSequence) lowerCase, (CharSequence) "_kakaobeta", false, 2, (Object) null) ? KakaoPhase.CBT : KakaoPhase.PRODUCTION;
            }
            KAKAO_PHASE = kakaoPhase;
            ServerHosts.Companion companion = ServerHosts.INSTANCE;
            KakaoPhase kakaoPhase2 = KAKAO_PHASE;
            Intrinsics.checkNotNull(kakaoPhase2);
            serverHosts = ServerHostsKt.withPhase(companion, kakaoPhase2);
            appSecret = CoreManager.INSTANCE.getInstance().getAppSecret();
            if (!AndroidManifestUtil.checkActivities(activity, CollectionsKt.listOf((Object[]) new String[]{KGAuthActivity.class.getName(), AuthCodeHandlerActivity.class.getName()}))) {
                return KGResult.INSTANCE.getResult(3000);
            }
            SetsKt.plus(LocalPlayerService.Settings.localPlayerFieldKeyList, ServerConstants.REG_TIME);
            registerLoginListener();
            return KGResult.INSTANCE.getSuccessResult();
        } catch (Throwable th) {
            Logger.INSTANCE.m702e(str3, th.toString(), th);
            return KGResult.INSTANCE.getResult(4001, th.toString());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:44:0x0124, code lost:
    
        r14 = r4.getContent();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r14);
        r1 = r14;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.kakaogame.KGResult<com.kakaogame.idp.IdpAccount> idpLogin(android.app.Activity r13, java.lang.String r14, int r15) {
        /*
            Method dump skipped, instructions count: 466
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.idp.KGKakao2Auth.idpLogin(android.app.Activity, java.lang.String, int):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    public String getAccessToken(Activity activity) {
        Object runBlocking$default;
        Logger logger = Logger.INSTANCE;
        String str = y.ۮڭڭܬި(862631707);
        String str2 = y.دײܮڳܯ(2051536501);
        logger.m699d(str2, str);
        if (activity == null) {
            return "";
        }
        runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakao2Auth$getAccessToken$1$refreshResult$1(this, activity, null), 1, null);
        KGResult kGResult = (KGResult) runBlocking$default;
        Logger.INSTANCE.m699d(str2, y.֬ڱܱײٮ(-1158773871) + kGResult);
        return kGResult.isSuccess() ? (String) kGResult.getContent() : "";
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void kakaoLoginWithType(final Activity activity, String authType, final Function1<? super KGResult<String>, Unit> callback) {
        String str;
        final LoginCallback loginCallback = INSTANCE.getLoginCallback(callback);
        final List listOf = CollectionsKt.listOf(Prompt.LOGIN);
        if (authType != null) {
            str = authType.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(str, y.ݮڮֲڭܩ(-628797244));
        } else {
            str = null;
        }
        if (Intrinsics.areEqual(str, KGKakaoAuthType.KakaoAllType.getAuthType())) {
            showKakaoAuthTypeSelectDialog(activity, new Function1<String, Unit>() { // from class: com.kakaogame.idp.KGKakao2Auth$kakaoLoginWithType$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(1);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(String str2) {
                    invoke2(str2);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(String str2) {
                    Unit unit;
                    String str3;
                    if (str2 != null) {
                        KGKakao2Auth kGKakao2Auth = KGKakao2Auth.this;
                        Activity activity2 = activity;
                        KGKakao2Auth.LoginCallback loginCallback2 = loginCallback;
                        List<Prompt> list = listOf;
                        boolean areEqual = Intrinsics.areEqual(str2, KGKakaoAuthType.KakaoTalk.getAuthType());
                        String str4 = y.֬ڱܱײٮ(-1158763095);
                        if (areEqual) {
                            UserApiClient companion = UserApiClient.INSTANCE.getInstance();
                            Intrinsics.checkNotNull(activity2, str4);
                            UserApiClient.loginWithKakaoTalk$default(companion, activity2, 0, null, null, null, loginCallback2, 30, null);
                            str3 = IdpAccount.LOGIN_TYPE_INSTALLED_APP;
                        } else {
                            UserApiClient companion2 = UserApiClient.INSTANCE.getInstance();
                            Intrinsics.checkNotNull(activity2, str4);
                            UserApiClient.loginWithKakaoAccount$default(companion2, activity2, list, null, null, null, null, loginCallback2, 60, null);
                            str3 = KGKakaoTalk.isKakaoTalkInstalled() ? IdpAccount.LOGIN_TYPE_INSTALLED_WEB : IdpAccount.LOGIN_TYPE_NOT_INSTALLED_WEB;
                        }
                        kGKakao2Auth.loginType = str3;
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        callback.invoke(KGResult.INSTANCE.getResult(9001, "", ""));
                    }
                }
            });
            return;
        }
        boolean areEqual = Intrinsics.areEqual(str, KGKakaoAuthType.KakaoWeb.getAuthType());
        String str2 = y.ݬֲ֮ܲت(1512566583);
        String str3 = y.֬ڱܱײٮ(-1158763095);
        if (areEqual) {
            UserApiClient companion = UserApiClient.INSTANCE.getInstance();
            Intrinsics.checkNotNull(activity, str3);
            UserApiClient.loginWithKakaoAccount$default(companion, activity, listOf, null, null, null, null, loginCallback, 60, null);
            if (KGKakaoTalk.isKakaoTalkInstalled()) {
                str2 = y.ٴسسݬߨ(1393476890);
            }
            this.loginType = str2;
            return;
        }
        if (KGKakaoTalk.isKakaoTalkInstalled()) {
            UserApiClient companion2 = UserApiClient.INSTANCE.getInstance();
            Intrinsics.checkNotNull(activity, str3);
            UserApiClient.loginWithKakaoTalk$default(companion2, activity, 0, null, null, null, loginCallback, 30, null);
            str2 = y.֬ڱܱײٮ(-1158768775);
        } else {
            UserApiClient companion3 = UserApiClient.INSTANCE.getInstance();
            Intrinsics.checkNotNull(activity, str3);
            UserApiClient.loginWithKakaoAccount$default(companion3, activity, listOf, null, null, null, null, loginCallback, 60, null);
        }
        this.loginType = str2;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x0139, code lost:
    
        r12.put("uuid", r13);
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.kakaogame.KGResult<com.kakaogame.idp.IdpAccount> checkAuth(android.app.Activity r11, com.kakaogame.idp.IdpAccount r12, int r13) {
        /*
            Method dump skipped, instructions count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.idp.KGKakao2Auth.checkAuth(android.app.Activity, com.kakaogame.idp.IdpAccount, int):com.kakaogame.KGResult");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> logout() {
        KGResult<Void> result;
        Object runBlocking$default;
        String str = y.ٲٴݴ״ٰ(1782161344);
        Logger logger = Logger.INSTANCE;
        String str2 = y.دײܮڳܯ(2051683317);
        String str3 = y.دײܮڳܯ(2051536501);
        logger.m699d(str3, str2);
        try {
            try {
                KakaoCache.INSTANCE.onLogout(CoreManager.INSTANCE.getInstance().getContext());
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakao2Auth$logout$logoutResult$1(this, null), 1, null);
                Logger.INSTANCE.m699d(str3, str + ((KGResult) runBlocking$default));
                result = KGResult.INSTANCE.getSuccessResult();
                KakaoManager.INSTANCE.setSignup(false);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str3, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
                KakaoManager.INSTANCE.setSignup(false);
            }
            KakaoUtil.convertResultCode(result);
            return result;
        } catch (Throwable th) {
            KakaoManager.INSTANCE.setSignup(false);
            KakaoUtil.convertResultCode(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object signOut(Continuation<? super KGResult<Void>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        UserApiClient.INSTANCE.getInstance().logout(new Function1<Throwable, Unit>() { // from class: com.kakaogame.idp.KGKakao2Auth$signOut$2$1
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
                if (th != null) {
                    Logger.INSTANCE.m699d(y.دײܮڳܯ(2051536501), y.دײܮڳܯ(2051525277) + th);
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
                KGResult successResult = KGResult.INSTANCE.getSuccessResult();
                Continuation<KGResult<Void>> continuation3 = safeContinuation2;
                Result.Companion companion3 = Result.INSTANCE;
                continuation3.resumeWith(Result.m1440constructorimpl(successResult));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthHandler
    public KGResult<Void> unregister() {
        KGResult<Void> result;
        Object runBlocking$default;
        String str = y.ݬֲ֮ܲت(1512567775);
        Logger logger = Logger.INSTANCE;
        String str2 = y.ٲٴݴ״ٰ(1781928656);
        String str3 = y.دײܮڳܯ(2051536501);
        logger.m699d(str3, str2);
        try {
            try {
                runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakao2Auth$unregister$unlinkResult$1(null), 1, null);
                result = (KGResult) runBlocking$default;
                Logger.INSTANCE.m699d(str3, str + result);
            } catch (Exception e) {
                Logger.INSTANCE.m702e(str3, e.toString(), e);
                result = KGResult.INSTANCE.getResult(4001, e.toString());
            }
            KakaoUtil.convertResultCode(result);
            return result;
        } catch (Throwable th) {
            KakaoUtil.convertResultCode(null);
            throw th;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x00c4 A[Catch: Exception -> 0x00f1, TRY_ENTER, TryCatch #1 {Exception -> 0x00f1, blocks: (B:3:0x0011, B:6:0x0023, B:15:0x009a, B:18:0x00c4, B:19:0x00e6, B:20:0x00ed, B:25:0x00e1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00e1 A[Catch: Exception -> 0x00f1, TryCatch #1 {Exception -> 0x00f1, blocks: (B:3:0x0011, B:6:0x0023, B:15:0x009a, B:18:0x00c4, B:19:0x00e6, B:20:0x00ed, B:25:0x00e1), top: B:2:0x0011 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0099  */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.kakaogame.idp.IdpAuthExHandler
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public com.kakaogame.KGIdpProfile getLocalIdpProfile() {
        /*
            r10 = this;
            r0 = 1512826055(0x5a2be4c7, float:1.2095941E16)
            java.lang.String r0 = com.liapp.y.ݬֲ֮ܲت(r0)
            java.lang.String r1 = ""
            r2 = 2051779213(0x7a4baa8d, float:2.6437386E35)
            java.lang.String r2 = com.liapp.y.دײܮڳܯ(r2)
            r3 = 0
            com.kakaogame.core.CoreManager$Companion r4 = com.kakaogame.core.CoreManager.INSTANCE     // Catch: java.lang.Exception -> Lf1
            com.kakaogame.core.CoreManager r4 = r4.getInstance()     // Catch: java.lang.Exception -> Lf1
            com.kakaogame.idp.IdpAccount r4 = r4.getAuthData()     // Catch: java.lang.Exception -> Lf1
            com.kakaogame.kakao.UserProfile r5 = com.kakaogame.kakao.KakaoManager.getUserProfile()     // Catch: java.lang.Exception -> Lf1
            if (r4 == 0) goto Lec
            if (r5 == 0) goto Lec
            com.kakao.sdk.talk.model.TalkProfile r6 = com.kakaogame.kakao.KakaoManager.getTalkProfile()     // Catch: java.lang.Exception -> Lf1
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap     // Catch: java.lang.Exception -> Lf1
            r7.<init>()     // Catch: java.lang.Exception -> Lf1
            java.util.Map r7 = (java.util.Map) r7     // Catch: java.lang.Exception -> Lf1
            java.lang.String r8 = "idpCode"
            java.lang.String r9 = "Kakao"
            r7.put(r8, r9)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r8 = "idpUserId"
            java.lang.String r9 = r4.getIdpUserId()     // Catch: java.lang.Exception -> Lf1
            r7.put(r8, r9)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r8 = "idpAccessToken"
            java.lang.String r9 = r4.getIdpAccessToken()     // Catch: java.lang.Exception -> Lf1
            r7.put(r8, r9)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r8 = "ci"
            java.lang.String r4 = r4.getCI()     // Catch: java.lang.Exception -> Lf1
            r7.put(r8, r4)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r4 = "uuid"
            java.lang.String r8 = r5.getUuid()     // Catch: java.lang.Exception -> Lf1
            r7.put(r4, r8)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r4 = "serviceUserId"
            long r8 = r5.getServiceUserId()     // Catch: java.lang.Exception -> Lf1
            java.lang.Long r8 = java.lang.Long.valueOf(r8)     // Catch: java.lang.Exception -> Lf1
            r7.put(r4, r8)     // Catch: java.lang.Exception -> Lf1
            r7.put(r2, r1)     // Catch: java.lang.Exception -> Lf1
            r7.put(r0, r1)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r1 = "isAppRegistered"
            r4 = 1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> Lf1
            r7.put(r1, r8)     // Catch: java.lang.Exception -> Lf1
            r1 = 0
            java.util.Map r8 = r5.getProperties()     // Catch: java.lang.Exception -> L93
            if (r8 == 0) goto L93
            java.util.Map r8 = r5.getProperties()     // Catch: java.lang.Exception -> L93
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch: java.lang.Exception -> L93
            java.lang.String r9 = "msg_blocked"
            java.lang.Object r8 = r8.get(r9)     // Catch: java.lang.Exception -> L93
            java.lang.String r8 = (java.lang.String) r8     // Catch: java.lang.Exception -> L93
            java.lang.String r9 = "true"
            boolean r8 = kotlin.text.StringsKt.equals(r9, r8, r4)     // Catch: java.lang.Exception -> L93
            goto L94
        L93:
            r8 = r1
        L94:
            java.lang.String r9 = "isAllowedMessage"
            if (r8 != 0) goto L99
            goto L9a
        L99:
            r4 = r1
        L9a:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r4)     // Catch: java.lang.Exception -> Lf1
            r7.put(r9, r1)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r1 = "remainingInviteCount"
            int r4 = r5.getRemainingInviteCount()     // Catch: java.lang.Exception -> Lf1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> Lf1
            r7.put(r1, r4)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r1 = "remainingGroupMessageCount"
            int r4 = r5.getRemainingGroupMsgCount()     // Catch: java.lang.Exception -> Lf1
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)     // Catch: java.lang.Exception -> Lf1
            r7.put(r1, r4)     // Catch: java.lang.Exception -> Lf1
            r1 = 2051787797(0x7a4bcc15, float:2.6454388E35)
            java.lang.String r1 = com.liapp.y.دײܮڳܯ(r1)
            if (r6 == 0) goto Le1
            java.lang.String r4 = r6.getNickname()     // Catch: java.lang.Exception -> Lf1
            r7.put(r2, r4)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r2 = r6.getThumbnailUrl()     // Catch: java.lang.Exception -> Lf1
            r7.put(r0, r2)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r0 = "profileImageUrl"
            java.lang.String r2 = r6.getProfileImageUrl()     // Catch: java.lang.Exception -> Lf1
            r7.put(r0, r2)     // Catch: java.lang.Exception -> Lf1
            java.lang.String r0 = "android"
            r7.put(r1, r0)     // Catch: java.lang.Exception -> Lf1
            goto Le6
        Le1:
            java.lang.String r0 = "unknown"
            r7.put(r1, r0)     // Catch: java.lang.Exception -> Lf1
        Le6:
            com.kakaogame.KGKakaoProfile r0 = new com.kakaogame.KGKakaoProfile     // Catch: java.lang.Exception -> Lf1
            r0.<init>(r7)     // Catch: java.lang.Exception -> Lf1
            goto Led
        Lec:
            r0 = r3
        Led:
            com.kakaogame.KGIdpProfile r0 = (com.kakaogame.KGIdpProfile) r0     // Catch: java.lang.Exception -> Lf1
            r3 = r0
            goto L104
        Lf1:
            r0 = move-exception
            com.kakaogame.Logger r1 = com.kakaogame.Logger.INSTANCE
            java.lang.String r2 = r0.toString()
            java.lang.Throwable r0 = (java.lang.Throwable) r0
            r4 = 2051536501(0x7a47f675, float:2.5956645E35)
            java.lang.String r4 = com.liapp.y.دײܮڳܯ(r4)
            r1.m702e(r4, r2, r0)
        L104:
            return r3
            fill-array 0x0106: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.idp.KGKakao2Auth.getLocalIdpProfile():com.kakaogame.KGIdpProfile");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object refreshAccessToken(Activity activity, Continuation<? super KGResult<String>> continuation) {
        SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
        final SafeContinuation safeContinuation2 = safeContinuation;
        if (!INSTANCE.initializeKakaoSdk(activity)) {
            Result.Companion companion = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4010, y.٬ݯح׭٩(576520590))));
        }
        if (CoreManager.testKakaoErrorCode != 200) {
            Result.Companion companion2 = Result.INSTANCE;
            safeContinuation2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(CoreManager.testKakaoErrorCode, y.ݬֲ֮ܲت(1512565287))));
        }
        UserApiClient.INSTANCE.getInstance().accessTokenInfo(new Function2<AccessTokenInfo, Throwable, Unit>() { // from class: com.kakaogame.idp.KGKakao2Auth$refreshAccessToken$2$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(AccessTokenInfo accessTokenInfo, Throwable th) {
                invoke2(accessTokenInfo, th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(AccessTokenInfo accessTokenInfo, Throwable th) {
                if (th != null) {
                    Logger.INSTANCE.m699d(y.دײܮڳܯ(2051536501), y.ݬֲ֮ܲت(1512560927) + th);
                    Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                    KGResult.Companion companion3 = KGResult.INSTANCE;
                    Object obj = classifyKakaoError.first;
                    Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                    KGResult result = companion3.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second);
                    Continuation<KGResult<String>> continuation2 = safeContinuation2;
                    Result.Companion companion4 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(result));
                    return;
                }
                OAuthToken token = TokenManager.INSTANCE.getInstance().getToken();
                KGResult successResult = KGResult.INSTANCE.getSuccessResult(token != null ? token.getAccessToken() : null);
                Continuation<KGResult<String>> continuation3 = safeContinuation2;
                Result.Companion companion5 = Result.INSTANCE;
                continuation3.resumeWith(Result.m1440constructorimpl(successResult));
            }
        });
        Object orThrow = safeContinuation.getOrThrow();
        if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return orThrow;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void registerLoginListener() {
        Logger.INSTANCE.m699d(y.دײܮڳܯ(2051536501), y.֬ڱܱײٮ(-1158766719));
        CoreManager.INSTANCE.getInstance().addCoreStateListener(new CoreManager.CoreStateListener() { // from class: com.kakaogame.idp.KGKakao2Auth$registerLoginListener$stateListener$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogout(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onPause() {
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onUnregister(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onLogin(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                if (CoreManager.INSTANCE.getInstance().isFirstLogin()) {
                    KGKakao2Auth.this.onFirstLogin();
                }
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakaogame.core.CoreManager.CoreStateListener
            public void onConnect(String playerId) {
                Intrinsics.checkNotNullParameter(playerId, y.ݬֲ֮ܲت(1512589743));
                KGKakao2Auth.this.onFirstLogin();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0077 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0078 A[Catch: Exception -> 0x0201, TryCatch #0 {Exception -> 0x0201, blocks: (B:3:0x0031, B:5:0x0044, B:8:0x004c, B:10:0x006b, B:16:0x0078, B:19:0x0093, B:22:0x00ba, B:25:0x0104, B:28:0x013d, B:30:0x0153, B:31:0x015b, B:33:0x0161, B:35:0x01a8, B:37:0x0175, B:39:0x0180, B:41:0x01a0, B:43:0x01a6, B:44:0x01a3), top: B:2:0x0031 }] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onFirstLogin() {
        /*
            Method dump skipped, instructions count: 530
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakaogame.idp.KGKakao2Auth.onFirstLogin():void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void showKakaoAuthTypeSelectDialog(final Activity activity, final Function1<? super String, Unit> callback) {
        if (!KGKakaoTalk.isKakaoTalkInstalled()) {
            callback.invoke(KGKakaoAuthType.KakaoWeb.getAuthType());
            return;
        }
        final List<Item> listOf = CollectionsKt.listOf((Object[]) new Item[]{new Item(CoreManager.INSTANCE.getResourceString(y.ݮڮֲڭܩ(-628426972)), C2419R.drawable.login_kakao_talk_icon, KGKakaoAuthType.KakaoTalk.getAuthType()), new Item(CoreManager.INSTANCE.getResourceString(y.ݮڮֲڭܩ(-628430836)), C2419R.drawable.login_kakao_account_icon, KGKakaoAuthType.KakaoWeb.getAuthType())});
        Dialog createSelectLoginTypeDialog = createSelectLoginTypeDialog(activity, listOf, new ArrayAdapter<Item>(activity, listOf) { // from class: com.kakaogame.idp.KGKakao2Auth$showKakaoAuthTypeSelectDialog$adapter$1
            final /* synthetic */ Activity $activity;
            final /* synthetic */ List<KGKakao2Auth.Item> $items;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(activity, R.layout.select_dialog_item, R.id.text1, listOf);
                this.$activity = activity;
                this.$items = listOf;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.widget.ArrayAdapter, android.widget.Adapter
            public View getView(int position, View view, ViewGroup parent) {
                Intrinsics.checkNotNullParameter(parent, y.ݮڮֲڭܩ(-628426636));
                if (view == null) {
                    Object systemService = getContext().getSystemService(y.دײܮڳܯ(2051526165));
                    Intrinsics.checkNotNull(systemService, y.ݬֲ֮ܲت(1512564599));
                    view = ((LayoutInflater) systemService).inflate(C2419R.layout.kakao_game_kakao_login_item, parent, false);
                }
                Intrinsics.checkNotNull(view);
                View findViewById = view.findViewById(C2419R.id.login_method_icon);
                Intrinsics.checkNotNull(findViewById, y.ݬֲ֮ܲت(1512437799));
                ((ImageView) findViewById).setImageDrawable(this.$activity.getResources().getDrawable(this.$items.get(position).getIcon(), getContext().getTheme()));
                View findViewById2 = view.findViewById(C2419R.id.login_method_text);
                Intrinsics.checkNotNull(findViewById2, y.֬ڱܱײٮ(-1158769727));
                ((TextView) findViewById2).setText(this.$items.get(position).getText());
                return view;
            }
        }, new Function1<String, Unit>() { // from class: com.kakaogame.idp.KGKakao2Auth$showKakaoAuthTypeSelectDialog$dialog$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(1);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str) {
                callback.invoke(str);
            }
        });
        createSelectLoginTypeDialog.setCanceledOnTouchOutside(false);
        createSelectLoginTypeDialog.setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.kakaogame.idp.KGKakao2Auth$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.content.DialogInterface.OnCancelListener
            public final void onCancel(DialogInterface dialogInterface) {
                KGKakao2Auth.showKakaoAuthTypeSelectDialog$lambda$18(Function1.this, dialogInterface);
            }
        });
        createSelectLoginTypeDialog.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void showKakaoAuthTypeSelectDialog$lambda$18(Function1 callback, DialogInterface dialogInterface) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        callback.invoke(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final Dialog createSelectLoginTypeDialog(Activity activity, final List<Item> authItems, ListAdapter adapter, final Function1<? super String, Unit> callback) {
        final Dialog dialog = new Dialog(activity, C2419R.style.KakaoLoginSelectDialog);
        dialog.requestWindowFeature(1);
        dialog.setContentView(C2419R.layout.kakao_game_kakao_login_dialog);
        if (dialog.getWindow() != null) {
            Window window = dialog.getWindow();
            Intrinsics.checkNotNull(window);
            window.setGravity(17);
        }
        View findViewById = dialog.findViewById(C2419R.id.login_list_view);
        Intrinsics.checkNotNull(findViewById, y.ݬֲ֮ܲت(1512562983));
        ListView listView = (ListView) findViewById;
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.kakaogame.idp.KGKakao2Auth$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.widget.AdapterView.OnItemClickListener
            public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
                KGKakao2Auth.createSelectLoginTypeDialog$lambda$19(authItems, callback, dialog, adapterView, view, i, j);
            }
        });
        View findViewById2 = dialog.findViewById(C2419R.id.login_close_button);
        Intrinsics.checkNotNull(findViewById2, "null cannot be cast to non-null type android.widget.Button");
        ((Button) findViewById2).setOnClickListener(new View.OnClickListener() { // from class: com.kakaogame.idp.KGKakao2Auth$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                KGKakao2Auth.createSelectLoginTypeDialog$lambda$20(Function1.this, dialog, view);
            }
        });
        return dialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void createSelectLoginTypeDialog$lambda$19(List authItems, Function1 callback, Dialog dialog, AdapterView adapterView, View view, int i, long j) {
        Intrinsics.checkNotNullParameter(authItems, "$authItems");
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        callback.invoke(((Item) authItems.get(i)).getAuthType());
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void createSelectLoginTypeDialog$lambda$20(Function1 callback, Dialog dialog, View view) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(dialog, "$dialog");
        callback.invoke(null);
        dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: KGKakao2Auth.kt */
    @Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\r"}, m839d2 = {"Lcom/kakaogame/idp/KGKakao2Auth$Item;", "", "text", "", "icon", "", "authType", "(Ljava/lang/String;ILjava/lang/String;)V", "getAuthType", "()Ljava/lang/String;", "getIcon", "()I", "getText", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    static final class Item {
        private final String authType;
        private final int icon;
        private final String text;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Item(String str, int i, String str2) {
            Intrinsics.checkNotNullParameter(str2, y.ۮڭڭܬި(862463915));
            this.text = str;
            this.icon = i;
            this.authType = str2;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getAuthType() {
            return this.authType;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final int getIcon() {
            return this.icon;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final String getText() {
            return this.text;
        }
    }

    /* compiled from: KGKakao2Auth.kt */
    @Metadata(m838d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010%\u001a\u00020&2\u001a\u0010'\u001a\u0016\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\n0)\u0012\u0004\u0012\u00020*0(H\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020-H\u0007J\u001a\u0010.\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u000200\u0018\u00010/0)J,\u00101\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0)2\u0006\u00102\u001a\u0002032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\n05H\u0082@¢\u0006\u0002\u00106J(\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\n0)2\b\u00102\u001a\u0004\u0018\u0001032\f\u00104\u001a\b\u0012\u0004\u0012\u00020\n05H\u0007R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u001d8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u0002\u001a\u0004\b\u001c\u0010\u001fR\u000e\u0010 \u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00068"}, m839d2 = {"Lcom/kakaogame/idp/KGKakao2Auth$Companion;", "", "()V", "KAKAO_PHASE", "Lcom/kakao/sdk/partner/model/KakaoPhase;", "getKAKAO_PHASE", "()Lcom/kakao/sdk/partner/model/KakaoPhase;", "setKAKAO_PHASE", "(Lcom/kakao/sdk/partner/model/KakaoPhase;)V", "KEY_ALLOW_MSG", "", "KEY_APP_REGISTERED", "KEY_CI", "KEY_IMPRESSION_ID", "KEY_MEMBER_KEY", "KEY_NICKNAME", "KEY_PROFILE_IMAGE_URL", "KEY_RECOMMENDED", "KEY_RECOMMEND_RANK", "KEY_REMAINING_GROUP_MSG_COUNT", "KEY_REMAINING_INVITE_COUNT", "KEY_SERVICE_USER_ID", "KEY_TALK_OS", "KEY_THUMBNAIL_IMAGE_URL", "KEY_UNREGISTERED", "KEY_UUID", "TAG", "appSecret", "isCheckAgeAuthOnGame", "", "isCheckAgeAuthOnGame$annotations", "()Z", "isInitialized", "sdkIdentifier", "Lcom/kakao/sdk/common/model/SdkIdentifier;", "serverHosts", "Lcom/kakao/sdk/common/model/ServerHosts;", "getLoginCallback", "Lcom/kakaogame/idp/KGKakao2Auth$LoginCallback;", "callback", "Lkotlin/Function1;", "Lcom/kakaogame/KGResult;", "", "initializeKakaoSdk", "context", "Landroid/content/Context;", "loadKakaoFriendProfiles", "", "Lcom/kakaogame/KGIdpProfile;", "loginWithNewScopesSync", "activity", "Landroid/app/Activity;", Constants.SCOPES, "", "(Landroid/app/Activity;Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateScope", "idp_kakao_release"}, m840k = 1, m841mv = {1, 9, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void isCheckAgeAuthOnGame$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KakaoPhase getKAKAO_PHASE() {
            return KGKakao2Auth.KAKAO_PHASE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final void setKAKAO_PHASE(KakaoPhase kakaoPhase) {
            KGKakao2Auth.KAKAO_PHASE = kakaoPhase;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final boolean isCheckAgeAuthOnGame() {
            return InfodeskHelper.INSTANCE.getAgeAuthLimit() > 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final boolean initializeKakaoSdk(Context context) {
            Intrinsics.checkNotNullParameter(context, y.ݬֲ֮ܲت(1512979991));
            Logger logger = Logger.INSTANCE;
            String str = y.٬ݯح׭٩(576533110);
            String str2 = y.دײܮڳܯ(2051536501);
            logger.m699d(str2, str);
            try {
                if (!KGKakao2Auth.isInitialized) {
                    String str3 = KGKakao2Auth.appSecret;
                    Intrinsics.checkNotNull(str3);
                    KakaoSdk.init$default(context, str3, null, false, KGKakao2Auth.serverHosts, null, KGKakao2Auth.sdkIdentifier, 36, null);
                    KGKakao2Auth.isInitialized = true;
                }
                return true;
            } catch (Exception e) {
                Logger.INSTANCE.m701e(str2, y.ۮڭڭܬި(862625747) + e);
                return false;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final Object loginWithNewScopesSync(Activity activity, List<String> list, Continuation<? super KGResult<String>> continuation) {
            SafeContinuation safeContinuation = new SafeContinuation(IntrinsicsKt.intercepted(continuation));
            final SafeContinuation safeContinuation2 = safeContinuation;
            UserApiClient.loginWithNewScopes$default(UserApiClient.INSTANCE.getInstance(), activity, list, null, new Function2<OAuthToken, Throwable, Unit>() { // from class: com.kakaogame.idp.KGKakao2Auth$Companion$loginWithNewScopesSync$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    super(2);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(OAuthToken oAuthToken, Throwable th) {
                    invoke2(oAuthToken, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(OAuthToken oAuthToken, Throwable th) {
                    KGResult successResult;
                    String str = y.دײܮڳܯ(2051536501);
                    if (th != null) {
                        Logger.INSTANCE.m699d(str, y.ݬֲ֮ܲت(1512558727) + th);
                        Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(th);
                        KGResult.Companion companion = KGResult.INSTANCE;
                        Object obj = classifyKakaoError.first;
                        Intrinsics.checkNotNullExpressionValue(obj, y.ۮڭڭܬި(862384955));
                        successResult = companion.getResult(((Number) obj).intValue(), (String) classifyKakaoError.second);
                    } else {
                        Logger.INSTANCE.m699d(str, y.֬ڱܱײٮ(-1158764455));
                        KGResult.Companion companion2 = KGResult.INSTANCE;
                        Intrinsics.checkNotNull(oAuthToken);
                        successResult = companion2.getSuccessResult(oAuthToken.getAccessToken());
                    }
                    Continuation<KGResult<String>> continuation2 = safeContinuation2;
                    Result.Companion companion3 = Result.INSTANCE;
                    continuation2.resumeWith(Result.m1440constructorimpl(successResult));
                }
            }, 4, null);
            Object orThrow = safeContinuation.getOrThrow();
            if (orThrow == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return orThrow;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public final KGResult<String> updateScope(Activity activity, List<String> scopes) {
            Object runBlocking$default;
            Intrinsics.checkNotNullParameter(scopes, y.٬ݯح׭٩(576533390));
            runBlocking$default = BuildersKt__BuildersKt.runBlocking$default(null, new KGKakao2Auth$Companion$updateScope$newAccessTokenResult$1(activity, scopes, null), 1, null);
            KGResult<String> kGResult = (KGResult) runBlocking$default;
            if (kGResult.isSuccess()) {
                String content = kGResult.getContent();
                Logger.INSTANCE.m699d(y.دײܮڳܯ(2051536501), y.دײܮڳܯ(2051536269) + content);
                CoreManager.INSTANCE.getInstance().updateIdpAccessToken(content);
            }
            return kGResult;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final KGResult<Map<String, KGIdpProfile>> loadKakaoFriendProfiles() {
            KGResult<Map<String, KGIdpProfile>> result;
            int component1;
            try {
                try {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (CoreManager.INSTANCE.getInstance().isKakaoCacheMode() && !CoreManager.INSTANCE.getInstance().tryKakaoReConnect().isSuccess()) {
                        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new KGKakao2Auth$Companion$loadKakaoFriendProfiles$1(CoreManager.INSTANCE.getInstance().getActivity(), null), 3, null);
                        Map<String, JSONObject> loadRegisteredFriends = KakaoCache.INSTANCE.loadRegisteredFriends(CoreManager.INSTANCE.getInstance().getContext());
                        if (loadRegisteredFriends != null && (!loadRegisteredFriends.isEmpty())) {
                            for (String str : loadRegisteredFriends.keySet()) {
                                linkedHashMap.put(str, new KGKakaoProfile(loadRegisteredFriends.get(str)));
                            }
                        }
                    } else {
                        ArrayList<Friend> arrayList = new ArrayList();
                        int i = 0;
                        do {
                            KGResult<Friends<Friend>> requestRegisteredFriends = KakaoGameAPI.INSTANCE.requestRegisteredFriends(i, 100);
                            if (requestRegisteredFriends.isNotSuccess()) {
                                KGResult<Map<String, KGIdpProfile>> result2 = KGResult.INSTANCE.getResult(requestRegisteredFriends);
                                KakaoUtil.convertResultCode(result2);
                                return result2;
                            }
                            Friends<Friend> content = requestRegisteredFriends.getContent();
                            Intrinsics.checkNotNull(content);
                            Friends<Friend> friends = content;
                            component1 = friends.component1();
                            List<Friend> component2 = friends.component2();
                            if (component2 == null || component2.isEmpty()) {
                                break;
                            }
                            arrayList.addAll(component2);
                            i += 100;
                        } while (component1 > arrayList.size());
                        for (Friend friend : arrayList) {
                            Long id = friend.getId();
                            if (id != null) {
                                linkedHashMap.put(String.valueOf(id.longValue()), new KGKakaoProfile(friend));
                            }
                        }
                    }
                    result = KGResult.INSTANCE.getSuccessResult(linkedHashMap);
                } catch (Exception e) {
                    Logger.INSTANCE.m702e(KGKakao2Auth.TAG, e.toString(), e);
                    result = KGResult.INSTANCE.getResult(4001, e.toString());
                }
                KakaoUtil.convertResultCode(result);
                return result;
            } catch (Throwable th) {
                KakaoUtil.convertResultCode(null);
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final LoginCallback getLoginCallback(final Function1<? super KGResult<String>, Unit> callback) {
            return new LoginCallback() { // from class: com.kakaogame.idp.KGKakao2Auth$Companion$getLoginCallback$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(OAuthToken oAuthToken, Throwable th) {
                    invoke2(oAuthToken, th);
                    return Unit.INSTANCE;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.idp.KGKakao2Auth.LoginCallback
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public void invoke2(OAuthToken oAuthToken, Throwable throwable) {
                    KGResult<String> successResult;
                    String str = y.ݬֲ֮ܲت(1512558727);
                    String str2 = y.دײܮڳܯ(2051536501);
                    try {
                        if (throwable != null) {
                            Logger.INSTANCE.m699d(str2, str + throwable);
                            Pair<Integer, String> classifyKakaoError = KakaoUtil.classifyKakaoError(throwable);
                            KGResult.Companion companion = KGResult.INSTANCE;
                            Object first = classifyKakaoError.first;
                            Intrinsics.checkNotNullExpressionValue(first, "first");
                            successResult = companion.getResult(((Number) first).intValue(), (String) classifyKakaoError.second);
                        } else {
                            Logger.INSTANCE.m699d(str2, "loginWithKakaoTalk Success");
                            KGResult.Companion companion2 = KGResult.INSTANCE;
                            Intrinsics.checkNotNull(oAuthToken);
                            successResult = companion2.getSuccessResult(oAuthToken.getAccessToken());
                        }
                        callback.invoke(successResult);
                    } catch (Exception unused) {
                        callback.invoke(KGResult.INSTANCE.getResult(4001));
                    }
                }
            };
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Object loginWithTypeSync(Activity activity, final String str, Continuation<? super KGResult<String>> continuation) {
        CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
        cancellableContinuationImpl.initCancellability();
        final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
        if (!INSTANCE.initializeKakaoSdk(activity)) {
            Result.Companion companion = Result.INSTANCE;
            cancellableContinuationImpl2.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(4010, y.٬ݯح׭٩(576520590))));
        } else {
            if (str == null) {
                str = InfodeskHelper.INSTANCE.getUseKakaoAuthType();
            }
            final Ref.LongRef longRef = new Ref.LongRef();
            longRef.element = KGAuthActivity.Companion.start$default(KGAuthActivity.INSTANCE, activity, new KGAuthActivity.KGActivityEventListener() { // from class: com.kakaogame.idp.KGKakao2Auth$loginWithTypeSync$2$eventListener$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityResult(int requestCode, int resultCode, Intent data) {
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onActivityStart(Activity activity2) {
                    Intrinsics.checkNotNullParameter(activity2, y.֬ڱܱײٮ(-1159305015));
                    KGKakao2Auth kGKakao2Auth = KGKakao2Auth.this;
                    String str2 = str;
                    final Ref.LongRef longRef2 = longRef;
                    final CancellableContinuation<KGResult<String>> cancellableContinuation = cancellableContinuationImpl2;
                    kGKakao2Auth.kakaoLoginWithType(activity2, str2, new Function1<KGResult<String>, Unit>() { // from class: com.kakaogame.idp.KGKakao2Auth$loginWithTypeSync$2$eventListener$1$onActivityStart$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        {
                            super(1);
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(KGResult<String> kGResult) {
                            invoke2(kGResult);
                            return Unit.INSTANCE;
                        }

                        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(KGResult<String> kGResult) {
                            Intrinsics.checkNotNullParameter(kGResult, y.ٲٴݴ״ٰ(1782134480));
                            AuthActivityManager.INSTANCE.getInstance().finishActivity(Ref.LongRef.this.element);
                            AuthActivityManager.INSTANCE.getInstance().removeResultListener(this);
                            CancellableContinuation<KGResult<String>> cancellableContinuation2 = cancellableContinuation;
                            Result.Companion companion2 = Result.INSTANCE;
                            cancellableContinuation2.resumeWith(Result.m1440constructorimpl(kGResult));
                        }
                    });
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.kakaogame.KGAuthActivity.KGActivityEventListener
                public void onDestroy() {
                    if (cancellableContinuationImpl2.isActive()) {
                        AuthActivityManager.INSTANCE.getInstance().finishActivity(longRef.element);
                        AuthActivityManager.INSTANCE.getInstance().removeResultListener(this);
                        CancellableContinuation<KGResult<String>> cancellableContinuation = cancellableContinuationImpl2;
                        Result.Companion companion2 = Result.INSTANCE;
                        cancellableContinuation.resumeWith(Result.m1440constructorimpl(KGResult.INSTANCE.getResult(9001)));
                    }
                }
            }, null, 4, null);
        }
        Object result = cancellableContinuationImpl.getResult();
        if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            DebugProbesKt.probeCoroutineSuspended(continuation);
        }
        return result;
    }
}
