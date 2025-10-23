package com.kakao.sdk.partner.user;

import android.content.Context;
import com.kakao.sdk.auth.AuthApiClient;
import com.kakao.sdk.auth.AuthCodeClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.auth.network.ApiFactoryKt;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ApiCallback;
import com.kakao.sdk.network.ApiFactory;
import com.kakao.sdk.partner.user.model.AgeAuthInfo;
import com.kakao.sdk.partner.user.model.AgeAuthLevel;
import com.kakao.sdk.partner.user.model.AgeCriteria;
import com.kakao.sdk.partner.user.model.PartnerUser;
import com.kakao.sdk.user.UserApi;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.ScopeInfo;
import com.kakaogame.game.StringSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserApiClient.kt */
@Metadata(m838d1 = {"\u0000\u008e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aw\u0010\t\u001a\u00020\n*\u00020\u00022\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0014¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n0\u0013H\u0007¢\u0006\u0002\u0010\u001a\u001a»\u0001\u0010\u001b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020\u001f\u0018\u00010\u000e2\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\u000f2\u0010\b\u0002\u0010\"\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0010\b\u0002\u0010#\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\n\b\u0002\u0010$\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010%2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n0\u0013H\u0007¢\u0006\u0002\u0010)\u001ab\u0010\u001b\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f0+2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010'¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b((\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n0\u0013\u001ad\u0010,\u001a\u00020\n*\u00020\u00022\u0010\b\u0002\u0010\r\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\b\b\u0002\u0010-\u001a\u00020%2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u00010.¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(/\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n0\u0013H\u0007\u001aI\u00100\u001a\u00020\n*\u00020\u00022\u0016\b\u0002\u00101\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u000f\u0018\u00010+2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n02H\u0007\u001ab\u00103\u001a\u00020\n*\u00020\u00022\f\u00104\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\n\b\u0002\u00105\u001a\u0004\u0018\u00010\u000f2:\u0010\u0012\u001a6\u0012\u0015\u0012\u0013\u0018\u000106¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n0\u0013H\u0007\u001ax\u00107\u001a\u00020\n*\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u00108\u001a\u0004\u0018\u0001092\n\b\u0002\u0010:\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010;\u001a\u0004\u0018\u00010%2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010%2#\u0010\u0012\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u0018¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\n02¢\u0006\u0002\u0010=\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0015\u0010\u0005\u001a\u00020\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006>"}, m839d2 = {"partnerApi", "Lcom/kakao/sdk/partner/user/PartnerUserApi;", "Lcom/kakao/sdk/user/UserApiClient;", "getPartnerApi", "(Lcom/kakao/sdk/user/UserApiClient;)Lcom/kakao/sdk/partner/user/PartnerUserApi;", "partnerSignupApi", "Lcom/kakao/sdk/user/UserApi;", "getPartnerSignupApi", "(Lcom/kakao/sdk/user/UserApiClient;)Lcom/kakao/sdk/user/UserApi;", "ageAuthInfo", "", "ageLimit", "", "propertyKeys", "", "", "ageCriteria", "Lcom/kakao/sdk/partner/user/model/AgeCriteria;", "callback", "Lkotlin/Function2;", "Lcom/kakao/sdk/partner/user/model/AgeAuthInfo;", "Lkotlin/ParameterName;", "name", StringSet.info, "", "error", "(Lcom/kakao/sdk/user/UserApiClient;Ljava/lang/Integer;Ljava/util/List;Lcom/kakao/sdk/partner/user/model/AgeCriteria;Lkotlin/jvm/functions/Function2;)V", "loginWithKakaoAccount", "context", "Landroid/content/Context;", "prompts", "Lcom/kakao/sdk/auth/model/Prompt;", "loginHint", "nonce", "channelPublicIds", "serviceTerms", "accountsSkipIntro", "", "accountsTalkLoginVisible", "Lcom/kakao/sdk/auth/model/OAuthToken;", com.kakao.sdk.partner.talk.Constants.TOKEN, "(Lcom/kakao/sdk/user/UserApiClient;Landroid/content/Context;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/util/List;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function2;)V", "accountParameters", "", "meForPartner", "secureReSource", "Lcom/kakao/sdk/partner/user/model/PartnerUser;", "user", "signupForPartner", com.kakao.sdk.user.Constants.PROPERTIES, "Lkotlin/Function1;", "upgradeScopes", com.kakao.sdk.user.Constants.SCOPES, "guardianToken", "Lcom/kakao/sdk/user/model/ScopeInfo;", "verifyAge", "authLevel", "Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;", "skipTerms", "adultsOnly", "underAge", "(Lcom/kakao/sdk/user/UserApiClient;Landroid/content/Context;Ljava/lang/Integer;Lcom/kakao/sdk/partner/user/model/AgeAuthLevel;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/Boolean;Lkotlin/jvm/functions/Function1;)V", "partner-user_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class UserApiClientKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void ageAuthInfo(UserApiClient userApiClient, Integer num, List<String> list, Function2<? super AgeAuthInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ageAuthInfo$default(userApiClient, num, list, null, callback, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void ageAuthInfo(UserApiClient userApiClient, Integer num, Function2<? super AgeAuthInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ageAuthInfo$default(userApiClient, num, null, null, callback, 6, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void ageAuthInfo(UserApiClient userApiClient, Function2<? super AgeAuthInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        ageAuthInfo$default(userApiClient, null, null, null, callback, 7, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, List<? extends Prompt> list, String str, String str2, List<String> list2, List<String> list3, Boolean bool, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(userApiClient, context, list, str, str2, list2, list3, bool, null, callback, 128, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, List<? extends Prompt> list, String str, String str2, List<String> list2, List<String> list3, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(userApiClient, context, list, str, str2, list2, list3, null, null, callback, 192, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, List<? extends Prompt> list, String str, String str2, List<String> list2, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(userApiClient, context, list, str, str2, list2, null, null, null, callback, 224, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, List<? extends Prompt> list, String str, String str2, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(userApiClient, context, list, str, str2, null, null, null, null, callback, 240, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, List<? extends Prompt> list, String str, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(userApiClient, context, list, str, null, null, null, null, null, callback, 248, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, List<? extends Prompt> list, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(userApiClient, context, list, null, null, null, null, null, null, callback, 252, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(userApiClient, context, null, null, null, null, null, null, null, callback, 254, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void meForPartner(UserApiClient userApiClient, List<String> list, Function2<? super PartnerUser, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        meForPartner$default(userApiClient, list, false, callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void meForPartner(UserApiClient userApiClient, Function2<? super PartnerUser, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        meForPartner$default(userApiClient, null, false, callback, 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void signupForPartner(UserApiClient userApiClient, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        signupForPartner$default(userApiClient, null, callback, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void upgradeScopes(UserApiClient userApiClient, List<String> scopes, Function2<? super ScopeInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        upgradeScopes$default(userApiClient, scopes, null, callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final PartnerUserApi getPartnerApi(UserApiClient userApiClient) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Object create = ApiFactoryKt.getKapiWithOAuth(ApiFactory.INSTANCE).create(PartnerUserApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "ApiFactory.kapiWithOAuth…rtnerUserApi::class.java)");
        return (PartnerUserApi) create;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final UserApi getPartnerSignupApi(UserApiClient userApiClient) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Object create = com.kakao.sdk.partner.user.network.ApiFactoryKt.getSignupKapiWithOAuth(ApiFactory.INSTANCE).create(UserApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "ApiFactory.signupKapiWit…eate(UserApi::class.java)");
        return (UserApi) create;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, Map<String, String> accountParameters, final Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(accountParameters, "accountParameters");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AuthCodeClient.authorizeWithKakaoAccount$default(AuthCodeClient.INSTANCE.getInstance(), context, null, null, null, null, null, null, true, null, accountParameters, null, null, null, null, new Function2<String, Throwable, Unit>() { // from class: com.kakao.sdk.partner.user.UserApiClientKt$loginWithKakaoAccount$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str, Throwable th) {
                invoke2(str, th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str, Throwable th) {
                if (th != null) {
                    callback.invoke(null, th);
                    return;
                }
                AuthApiClient companion = AuthApiClient.INSTANCE.getInstance();
                Intrinsics.checkNotNull(str);
                final Function2<OAuthToken, Throwable, Unit> function2 = callback;
                AuthApiClient.issueAccessToken$default(companion, str, null, new Function2<OAuthToken, Throwable, Unit>() { // from class: com.kakao.sdk.partner.user.UserApiClientKt$loginWithKakaoAccount$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(2);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(OAuthToken oAuthToken, Throwable th2) {
                        invoke2(oAuthToken, th2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(OAuthToken oAuthToken, Throwable th2) {
                        function2.invoke(oAuthToken, th2);
                    }
                }, 2, null);
            }
        }, 15742, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void loginWithKakaoAccount$default(UserApiClient userApiClient, Context context, List list, String str, String str2, List list2, List list3, Boolean bool, Boolean bool2, Function2 function2, int i, Object obj) {
        loginWithKakaoAccount(userApiClient, context, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3, (i & 64) != 0 ? null : bool, (i & 128) != 0 ? null : bool2, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void loginWithKakaoAccount(UserApiClient userApiClient, Context context, List<? extends Prompt> list, String str, String str2, List<String> list2, List<String> list3, Boolean bool, Boolean bool2, final Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String codeVerifier = AuthCodeClient.INSTANCE.codeVerifier();
        AuthCodeClient.authorizeWithKakaoAccount$default(AuthCodeClient.INSTANCE.getInstance(), context, list, null, str2, null, list2, list3, false, str, null, codeVerifier, bool, bool2, null, new Function2<String, Throwable, Unit>() { // from class: com.kakao.sdk.partner.user.UserApiClientKt$loginWithKakaoAccount$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(2);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(String str3, Throwable th) {
                invoke2(str3, th);
                return Unit.INSTANCE;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String str3, Throwable th) {
                if (th != null) {
                    callback.invoke(null, th);
                    return;
                }
                AuthApiClient companion = AuthApiClient.INSTANCE.getInstance();
                Intrinsics.checkNotNull(str3);
                String str4 = codeVerifier;
                final Function2<OAuthToken, Throwable, Unit> function2 = callback;
                companion.issueAccessToken(str3, str4, new Function2<OAuthToken, Throwable, Unit>() { // from class: com.kakao.sdk.partner.user.UserApiClientKt$loginWithKakaoAccount$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(2);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(OAuthToken oAuthToken, Throwable th2) {
                        invoke2(oAuthToken, th2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(OAuthToken oAuthToken, Throwable th2) {
                        function2.invoke(oAuthToken, th2);
                    }
                });
            }
        }, 8852, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void meForPartner$default(UserApiClient userApiClient, List list, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        meForPartner(userApiClient, list, z, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void meForPartner(UserApiClient userApiClient, List<String> list, boolean z, final Function2<? super PartnerUser, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(userApiClient).m692me(list == null ? null : KakaoJson.INSTANCE.toJson(list), z).enqueue(new ApiCallback<PartnerUser>() { // from class: com.kakao.sdk.partner.user.UserApiClientKt$meForPartner$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(PartnerUser model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void signupForPartner$default(UserApiClient userApiClient, Map map, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        signupForPartner(userApiClient, map, function1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void signupForPartner(UserApiClient userApiClient, Map<String, String> map, final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerSignupApi(userApiClient).signup(map).enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.partner.user.UserApiClientKt$signupForPartner$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Unit model, Throwable error) {
                callback.invoke(error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void ageAuthInfo$default(UserApiClient userApiClient, Integer num, List list, AgeCriteria ageCriteria, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            num = null;
        }
        if ((i & 2) != 0) {
            list = null;
        }
        if ((i & 4) != 0) {
            ageCriteria = null;
        }
        ageAuthInfo(userApiClient, num, list, ageCriteria, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void ageAuthInfo(UserApiClient userApiClient, Integer num, List<String> list, AgeCriteria ageCriteria, final Function2<? super AgeAuthInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(userApiClient).ageAuthInfo(num, list == null ? null : KakaoJson.INSTANCE.toJson(list), ageCriteria).enqueue(new ApiCallback<AgeAuthInfo>() { // from class: com.kakao.sdk.partner.user.UserApiClientKt$ageAuthInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(AgeAuthInfo model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void upgradeScopes$default(UserApiClient userApiClient, List list, String str, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str = null;
        }
        upgradeScopes(userApiClient, list, str, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void upgradeScopes(UserApiClient userApiClient, List<String> scopes, String str, final Function2<? super ScopeInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        getPartnerApi(userApiClient).upgradeScopes(KakaoJson.INSTANCE.toJson(scopes), str).enqueue(new ApiCallback<ScopeInfo>() { // from class: com.kakao.sdk.partner.user.UserApiClientKt$upgradeScopes$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(ScopeInfo model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void verifyAge(UserApiClient userApiClient, Context context, Integer num, AgeAuthLevel ageAuthLevel, Boolean bool, Boolean bool2, Boolean bool3, Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(userApiClient, "<this>");
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AgeAuthManager.INSTANCE.getInstance().verifyAgeWithAuthentication(context, num, ageAuthLevel, bool, bool2, bool3, callback);
    }
}
