package com.kakao.sdk.user;

import android.content.Context;
import com.facebook.gamingservices.internal.TournamentShareDialogURIBuilder;
import com.kakao.sdk.auth.AuthApiClient;
import com.kakao.sdk.auth.AuthCodeClient;
import com.kakao.sdk.auth.TokenManagerProvider;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.model.Prompt;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ApiCallback;
import com.kakao.sdk.user.UserApi;
import com.kakao.sdk.user.model.AccessTokenInfo;
import com.kakao.sdk.user.model.ScopeInfo;
import com.kakao.sdk.user.model.User;
import com.kakao.sdk.user.model.UserRevokedServiceTerms;
import com.kakao.sdk.user.model.UserServiceTerms;
import com.kakao.sdk.user.model.UserShippingAddresses;
import java.util.Date;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: UserApiClient.kt */
@Metadata(m838d1 = {"\u0000ª\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\u0018\u0000 C2\u00020\u0001:\u0001CB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JB\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nJ\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\u009a\u0001\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\u0010\b\u0002\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\u00172\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nH\u0007J\u0086\u0001\u0010 \u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nH\u0007Jd\u0010#\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001a2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001e¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nJ+\u0010%\u001a\u00020\b2#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0&J`\u0010'\u001a\u00020\b2\u0010\b\u0002\u0010(\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172\b\b\u0002\u0010)\u001a\u00020\u00122:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010*¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(+\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nH\u0007JP\u0010,\u001a\u00020\b2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010-¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(.\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nJP\u0010/\u001a\u00020\b2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00172:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u000101¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nJT\u0010$\u001a\u00020\b2\u0010\b\u0002\u0010$\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010-¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(.\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nJ`\u0010\u001d\u001a\u00020\b2\u0010\b\u0002\u00100\u001a\n\u0012\u0004\u0012\u00020\u001a\u0018\u00010\u00172\n\b\u0002\u00103\u001a\u0004\u0018\u00010\u001a2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u000104¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(5\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nJa\u00106\u001a\u00020\b2\n\b\u0002\u00107\u001a\u0004\u0018\u0001082\n\b\u0002\u00109\u001a\u0004\u0018\u00010\"2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nH\u0007¢\u0006\u0002\u0010<JJ\u00106\u001a\u00020\b2\u0006\u0010=\u001a\u00020>2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010:¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(;\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0\nJC\u0010?\u001a\u00020\b2\u0016\b\u0002\u0010(\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a\u0018\u00010@2#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0&J+\u0010A\u001a\u00020\b2#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0&J?\u0010B\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\u001a0@2#\u0010\t\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\b0&R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006D"}, m839d2 = {"Lcom/kakao/sdk/user/UserApiClient;", "", "userApi", "Lcom/kakao/sdk/user/UserApi;", "tokenManagerProvider", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "(Lcom/kakao/sdk/user/UserApi;Lcom/kakao/sdk/auth/TokenManagerProvider;)V", "accessTokenInfo", "", "callback", "Lkotlin/Function2;", "Lcom/kakao/sdk/user/model/AccessTokenInfo;", "Lkotlin/ParameterName;", "name", "tokenInfo", "", "error", "isKakaoTalkLoginAvailable", "", "context", "Landroid/content/Context;", "loginWithKakaoAccount", "prompts", "", "Lcom/kakao/sdk/auth/model/Prompt;", "loginHint", "", "nonce", "channelPublicIds", "serviceTerms", "Lcom/kakao/sdk/auth/model/OAuthToken;", com.kakao.sdk.partner.talk.Constants.TOKEN, "loginWithKakaoTalk", "requestCode", "", "loginWithNewScopes", Constants.SCOPES, "logout", "Lkotlin/Function1;", TournamentShareDialogURIBuilder.me, Constants.PROPERTIES, "secureResource", "Lcom/kakao/sdk/user/model/User;", "user", "revokeScopes", "Lcom/kakao/sdk/user/model/ScopeInfo;", "scopeInfo", "revokeServiceTerms", Constants.TAGS, "Lcom/kakao/sdk/user/model/UserRevokedServiceTerms;", "userRevokedServiceTerms", "result", "Lcom/kakao/sdk/user/model/UserServiceTerms;", "userServiceTerms", "shippingAddresses", "fromUpdatedAt", "Ljava/util/Date;", "pageSize", "Lcom/kakao/sdk/user/model/UserShippingAddresses;", "userShippingAddresses", "(Ljava/util/Date;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;)V", "addressId", "", "signup", "", "unlink", "updateProfile", "Companion", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class UserApiClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<UserApiClient> instance$delegate = LazyKt.lazy(new Function0<UserApiClient>() { // from class: com.kakao.sdk.user.UserApiClient$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final UserApiClient invoke() {
            return new UserApiClient(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
    });
    private final TokenManagerProvider tokenManagerProvider;
    private final UserApi userApi;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserApiClient() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final UserApiClient getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoAccount(Context context, List<? extends Prompt> list, String str, String str2, List<String> list2, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(this, context, list, str, str2, list2, null, callback, 32, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoAccount(Context context, List<? extends Prompt> list, String str, String str2, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(this, context, list, str, str2, null, null, callback, 48, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoAccount(Context context, List<? extends Prompt> list, String str, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(this, context, list, str, null, null, null, callback, 56, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoAccount(Context context, List<? extends Prompt> list, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(this, context, list, null, null, null, null, callback, 60, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoAccount(Context context, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoAccount$default(this, context, null, null, null, null, null, callback, 62, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoTalk(Context context, int i, String str, List<String> list, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoTalk$default(this, context, i, str, list, null, callback, 16, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoTalk(Context context, int i, String str, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoTalk$default(this, context, i, str, null, null, callback, 24, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoTalk(Context context, int i, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoTalk$default(this, context, i, null, null, null, callback, 28, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoTalk(Context context, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        loginWithKakaoTalk$default(this, context, 0, null, null, null, callback, 30, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: me */
    public final void m694me(List<String> list, Function2<? super User, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        me$default(this, list, false, callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: me */
    public final void m696me(Function2<? super User, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        me$default(this, null, false, callback, 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shippingAddresses(Date date, Function2<? super UserShippingAddresses, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        shippingAddresses$default(this, date, null, callback, 2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shippingAddresses(Function2<? super UserShippingAddresses, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        shippingAddresses$default(this, null, null, callback, 3, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public UserApiClient(UserApi userApi, TokenManagerProvider tokenManagerProvider) {
        Intrinsics.checkNotNullParameter(userApi, "userApi");
        Intrinsics.checkNotNullParameter(tokenManagerProvider, "tokenManagerProvider");
        this.userApi = userApi;
        this.tokenManagerProvider = tokenManagerProvider;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ UserApiClient(com.kakao.sdk.user.UserApi r1, com.kakao.sdk.auth.TokenManagerProvider r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L17
            com.kakao.sdk.network.ApiFactory r1 = com.kakao.sdk.network.ApiFactory.INSTANCE
            retrofit2.Retrofit r1 = com.kakao.sdk.auth.network.ApiFactoryKt.getKapiWithOAuth(r1)
            java.lang.Class<com.kakao.sdk.user.UserApi> r4 = com.kakao.sdk.user.UserApi.class
            java.lang.Object r1 = r1.create(r4)
            java.lang.String r4 = "ApiFactory.kapiWithOAuth…eate(UserApi::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
            com.kakao.sdk.user.UserApi r1 = (com.kakao.sdk.user.UserApi) r1
        L17:
            r3 = r3 & 2
            if (r3 == 0) goto L21
            com.kakao.sdk.auth.TokenManagerProvider$Companion r2 = com.kakao.sdk.auth.TokenManagerProvider.INSTANCE
            com.kakao.sdk.auth.TokenManagerProvider r2 = r2.getInstance()
        L21:
            r0.<init>(r1, r2)
            return
            fill-array 0x0026: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.user.UserApiClient.<init>(com.kakao.sdk.user.UserApi, com.kakao.sdk.auth.TokenManagerProvider, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isKakaoTalkLoginAvailable(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return AuthCodeClient.INSTANCE.getInstance().isKakaoTalkLoginAvailable(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void loginWithKakaoTalk$default(UserApiClient userApiClient, Context context, int i, String str, List list, List list2, Function2 function2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = AuthCodeClient.DEFAULT_REQUEST_CODE;
        }
        userApiClient.loginWithKakaoTalk(context, i, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : list, (i2 & 16) != 0 ? null : list2, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoTalk(Context context, int requestCode, String nonce, List<String> channelPublicIds, List<String> serviceTerms, final Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String codeVerifier = AuthCodeClient.INSTANCE.codeVerifier();
        AuthCodeClient.authorizeWithKakaoTalk$default(AuthCodeClient.INSTANCE.getInstance(), context, null, requestCode, nonce, channelPublicIds, serviceTerms, codeVerifier, null, new Function2<String, Throwable, Unit>() { // from class: com.kakao.sdk.user.UserApiClient$loginWithKakaoTalk$1
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
                String str2 = codeVerifier;
                final Function2<OAuthToken, Throwable, Unit> function2 = callback;
                companion.issueAccessToken(str, str2, new Function2<OAuthToken, Throwable, Unit>() { // from class: com.kakao.sdk.user.UserApiClient$loginWithKakaoTalk$1.1
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
        }, 128, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void loginWithKakaoAccount$default(UserApiClient userApiClient, Context context, List list, String str, String str2, List list2, List list3, Function2 function2, int i, Object obj) {
        userApiClient.loginWithKakaoAccount(context, (i & 2) != 0 ? null : list, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : str2, (i & 16) != 0 ? null : list2, (i & 32) != 0 ? null : list3, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithKakaoAccount(Context context, List<? extends Prompt> prompts, String loginHint, String nonce, List<String> channelPublicIds, List<String> serviceTerms, final Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(callback, "callback");
        final String codeVerifier = AuthCodeClient.INSTANCE.codeVerifier();
        AuthCodeClient.authorizeWithKakaoAccount$default(AuthCodeClient.INSTANCE.getInstance(), context, prompts, null, nonce, null, channelPublicIds, serviceTerms, false, loginHint, null, codeVerifier, null, null, null, new Function2<String, Throwable, Unit>() { // from class: com.kakao.sdk.user.UserApiClient$loginWithKakaoAccount$1
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
                String str2 = codeVerifier;
                final Function2<OAuthToken, Throwable, Unit> function2 = callback;
                companion.issueAccessToken(str, str2, new Function2<OAuthToken, Throwable, Unit>() { // from class: com.kakao.sdk.user.UserApiClient$loginWithKakaoAccount$1.1
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
        }, 14996, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void loginWithNewScopes$default(UserApiClient userApiClient, Context context, List list, String str, Function2 function2, int i, Object obj) {
        if ((i & 4) != 0) {
            str = null;
        }
        userApiClient.loginWithNewScopes(context, list, str, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void loginWithNewScopes(final Context context, final List<String> scopes, final String nonce, final Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AuthApiClient.INSTANCE.getInstance().agt(new Function2<String, Throwable, Unit>() { // from class: com.kakao.sdk.user.UserApiClient$loginWithNewScopes$1
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
                final String codeVerifier = AuthCodeClient.INSTANCE.codeVerifier();
                AuthCodeClient companion = AuthCodeClient.INSTANCE.getInstance();
                Context context2 = context;
                List<String> list = scopes;
                String str2 = nonce;
                final Function2<OAuthToken, Throwable, Unit> function2 = callback;
                AuthCodeClient.authorizeWithKakaoAccount$default(companion, context2, null, list, str2, str, null, null, false, null, null, codeVerifier, null, null, null, new Function2<String, Throwable, Unit>() { // from class: com.kakao.sdk.user.UserApiClient$loginWithNewScopes$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    {
                        super(2);
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(String str3, Throwable th2) {
                        invoke2(str3, th2);
                        return Unit.INSTANCE;
                    }

                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String str3, Throwable th2) {
                        if (th2 != null) {
                            function2.invoke(null, th2);
                            return;
                        }
                        AuthApiClient companion2 = AuthApiClient.INSTANCE.getInstance();
                        Intrinsics.checkNotNull(str3);
                        String str4 = codeVerifier;
                        final Function2<OAuthToken, Throwable, Unit> function22 = function2;
                        companion2.issueAccessToken(str3, str4, new Function2<OAuthToken, Throwable, Unit>() { // from class: com.kakao.sdk.user.UserApiClient.loginWithNewScopes.1.1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(2);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(OAuthToken oAuthToken, Throwable th3) {
                                invoke2(oAuthToken, th3);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(OAuthToken oAuthToken, Throwable th3) {
                                function22.invoke(oAuthToken, th3);
                            }
                        });
                    }
                }, 15330, null);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void me$default(UserApiClient userApiClient, List list, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            z = true;
        }
        userApiClient.m695me(list, z, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: me */
    public final void m695me(List<String> properties, boolean secureResource, final Function2<? super User, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.m693me(secureResource, properties == null ? null : KakaoJson.INSTANCE.toJson(properties)).enqueue(new ApiCallback<User>() { // from class: com.kakao.sdk.user.UserApiClient$me$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(User model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void signup$default(UserApiClient userApiClient, Map map, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            map = null;
        }
        userApiClient.signup(map, function1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void signup(Map<String, String> properties, final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.signup(properties).enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.user.UserApiClient$signup$1
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
    public final void accessTokenInfo(final Function2<? super AccessTokenInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.accessTokenInfo().enqueue(new ApiCallback<AccessTokenInfo>() { // from class: com.kakao.sdk.user.UserApiClient$accessTokenInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(AccessTokenInfo model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void updateProfile(Map<String, String> properties, final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(properties, "properties");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.updateProfile(properties).enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.user.UserApiClient$updateProfile$1
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
    public final void logout(final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.logout().enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.user.UserApiClient$logout$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Unit model, Throwable error) {
                TokenManagerProvider tokenManagerProvider;
                tokenManagerProvider = UserApiClient.this.tokenManagerProvider;
                tokenManagerProvider.getManager().clear();
                callback.invoke(error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void unlink(final Function1<? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.unlink().enqueue(new ApiCallback<Unit>() { // from class: com.kakao.sdk.user.UserApiClient$unlink$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(Unit model, Throwable error) {
                TokenManagerProvider tokenManagerProvider;
                if (error == null) {
                    tokenManagerProvider = UserApiClient.this.tokenManagerProvider;
                    tokenManagerProvider.getManager().clear();
                }
                callback.invoke(error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void shippingAddresses$default(UserApiClient userApiClient, Date date, Integer num, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            date = null;
        }
        if ((i & 2) != 0) {
            num = null;
        }
        userApiClient.shippingAddresses(date, num, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shippingAddresses(Date fromUpdatedAt, Integer pageSize, final Function2<? super UserShippingAddresses, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        UserApi.DefaultImpls.shippingAddresses$default(this.userApi, null, fromUpdatedAt, pageSize, 1, null).enqueue(new ApiCallback<UserShippingAddresses>() { // from class: com.kakao.sdk.user.UserApiClient$shippingAddresses$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(UserShippingAddresses model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void shippingAddresses(long addressId, final Function2<? super UserShippingAddresses, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        UserApi.DefaultImpls.shippingAddresses$default(this.userApi, Long.valueOf(addressId), null, null, 6, null).enqueue(new ApiCallback<UserShippingAddresses>() { // from class: com.kakao.sdk.user.UserApiClient$shippingAddresses$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(UserShippingAddresses model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void scopes$default(UserApiClient userApiClient, List list, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        userApiClient.scopes(list, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void scopes(List<String> scopes, final Function2<? super ScopeInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.scopes(scopes == null ? null : KakaoJson.INSTANCE.toJson(scopes)).enqueue(new ApiCallback<ScopeInfo>() { // from class: com.kakao.sdk.user.UserApiClient$scopes$1
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
    public final void revokeScopes(List<String> scopes, final Function2<? super ScopeInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(scopes, "scopes");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.revokeScopes(KakaoJson.INSTANCE.toJson(scopes)).enqueue(new ApiCallback<ScopeInfo>() { // from class: com.kakao.sdk.user.UserApiClient$revokeScopes$1
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

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void serviceTerms$default(UserApiClient userApiClient, List list, String str, Function2 function2, int i, Object obj) {
        if ((i & 1) != 0) {
            list = null;
        }
        if ((i & 2) != 0) {
            str = null;
        }
        userApiClient.serviceTerms(list, str, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void serviceTerms(List<String> tags, String result, final Function2<? super UserServiceTerms, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.serviceTerms(tags == null ? null : CollectionsKt.joinToString$default(tags, ",", null, null, 0, null, null, 62, null), result).enqueue(new ApiCallback<UserServiceTerms>() { // from class: com.kakao.sdk.user.UserApiClient$serviceTerms$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(UserServiceTerms model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void revokeServiceTerms(List<String> tags, final Function2<? super UserRevokedServiceTerms, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(tags, "tags");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.userApi.revokeServiceTerms(CollectionsKt.joinToString$default(tags, ",", null, null, 0, null, null, 62, null)).enqueue(new ApiCallback<UserRevokedServiceTerms>() { // from class: com.kakao.sdk.user.UserApiClient$revokeServiceTerms$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            {
                super(false, 1, null);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.kakao.sdk.network.ApiCallback
            public void onComplete(UserRevokedServiceTerms model, Throwable error) {
                callback.invoke(model, error);
            }
        });
    }

    /* compiled from: UserApiClient.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m839d2 = {"Lcom/kakao/sdk/user/UserApiClient$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/user/UserApiClient;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/user/UserApiClient;", "instance$delegate", "Lkotlin/Lazy;", "user_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
    public static final class Companion {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @JvmStatic
        public static /* synthetic */ void getInstance$annotations() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Companion() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final UserApiClient getInstance() {
            return (UserApiClient) UserApiClient.instance$delegate.getValue();
        }
    }
}
