package com.kakao.sdk.auth;

import com.kakao.sdk.auth.model.CertTokenInfo;
import com.kakao.sdk.auth.model.CertType;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthApiClient.kt */
@Metadata(m838d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 &2\u00020\u0001:\u0001&B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JB\u0010\t\u001a\u00020\n2:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\fJ\u0006\u0010\u0012\u001a\u00020\u0013JV\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\fJV\u0010\u0019\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\r2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r2:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u001a¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u001b\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\fJn\u0010\u001c\u001a\u00020\n2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\r2\u0006\u0010 \u001a\u00020!2:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\fJN\u0010#\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\u00172:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\fH\u0007JN\u0010%\u001a\u00020\n2\b\b\u0002\u0010$\u001a\u00020\u00172:\u0010\u000b\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0017¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0018\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\n0\fH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006'"}, m839d2 = {"Lcom/kakao/sdk/auth/AuthApiClient;", "", "manager", "Lcom/kakao/sdk/auth/AuthApiManager;", "tokenManagerProvider", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "(Lcom/kakao/sdk/auth/AuthApiManager;Lcom/kakao/sdk/auth/TokenManagerProvider;)V", "getTokenManagerProvider", "()Lcom/kakao/sdk/auth/TokenManagerProvider;", Constants.AGT, "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "", "error", "hasToken", "", "issueAccessToken", "code", "codeVerifier", "Lcom/kakao/sdk/auth/model/OAuthToken;", com.kakao.sdk.partner.talk.Constants.TOKEN, "issueAccessTokenWithCert", "Lcom/kakao/sdk/auth/model/CertTokenInfo;", "certTokenInfo", "prepare", "settleId", "signData", "txId", "certType", "Lcom/kakao/sdk/auth/model/CertType;", "kauthTxId", "refreshAccessToken", "oldToken", "refreshToken", "Companion", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthApiClient {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<AuthApiClient> instance$delegate = LazyKt.lazy(new Function0<AuthApiClient>() { // from class: com.kakao.sdk.auth.AuthApiClient$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final AuthApiClient invoke() {
            return new AuthApiClient(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
        }
    });
    private final AuthApiManager manager;
    private final TokenManagerProvider tokenManagerProvider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthApiClient() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final AuthApiClient getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "이 메서드는 더 이상 사용되지 않으므로 refreshToken()을 사용합니다.")
    public final void refreshAccessToken(Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        refreshAccessToken$default(this, null, callback, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void refreshToken(Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        refreshToken$default(this, null, callback, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthApiClient(AuthApiManager manager, TokenManagerProvider tokenManagerProvider) {
        Intrinsics.checkNotNullParameter(manager, "manager");
        Intrinsics.checkNotNullParameter(tokenManagerProvider, "tokenManagerProvider");
        this.manager = manager;
        this.tokenManagerProvider = tokenManagerProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AuthApiClient(AuthApiManager authApiManager, TokenManagerProvider tokenManagerProvider, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? AuthApiManager.INSTANCE.getInstance() : authApiManager, (i & 2) != 0 ? TokenManagerProvider.INSTANCE.getInstance() : tokenManagerProvider);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TokenManagerProvider getTokenManagerProvider() {
        return this.tokenManagerProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasToken() {
        return this.manager.hasToken$auth_release();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void issueAccessToken$default(AuthApiClient authApiClient, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        authApiClient.issueAccessToken(str, str2, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void issueAccessToken(String code, String codeVerifier, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.manager.issueAccessToken$auth_release(code, codeVerifier, callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void issueAccessTokenWithCert$default(AuthApiClient authApiClient, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        authApiClient.issueAccessTokenWithCert(str, str2, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void issueAccessTokenWithCert(String code, String codeVerifier, Function2<? super CertTokenInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.manager.issueAccessTokenWithCert$auth_release(code, codeVerifier, callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void refreshAccessToken$default(AuthApiClient authApiClient, OAuthToken oAuthToken, Function2 function2, int i, Object obj) {
        if ((i & 1) == 0 || (oAuthToken = authApiClient.tokenManagerProvider.getManager().getToken()) != null) {
            authApiClient.refreshAccessToken(oAuthToken, function2);
            return;
        }
        throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found. You must login first.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated(message = "이 메서드는 더 이상 사용되지 않으므로 refreshToken()을 사용합니다.")
    public final void refreshAccessToken(OAuthToken oldToken, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(oldToken, "oldToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.manager.refreshToken$auth_release(oldToken, callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void refreshToken$default(AuthApiClient authApiClient, OAuthToken oAuthToken, Function2 function2, int i, Object obj) {
        if ((i & 1) == 0 || (oAuthToken = authApiClient.tokenManagerProvider.getManager().getToken()) != null) {
            authApiClient.refreshToken(oAuthToken, function2);
            return;
        }
        throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found. You must login first.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void refreshToken(OAuthToken oldToken, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(oldToken, "oldToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.manager.refreshToken$auth_release(oldToken, callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void agt(Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.manager.agt$auth_release(callback);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void prepare(String settleId, String signData, String txId, CertType certType, Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(certType, "certType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.manager.prepare$auth_release(settleId, signData, txId, certType, callback);
    }

    /* compiled from: AuthApiClient.kt */
    @Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\n"}, m839d2 = {"Lcom/kakao/sdk/auth/AuthApiClient$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/auth/AuthApiClient;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/auth/AuthApiClient;", "instance$delegate", "Lkotlin/Lazy;", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
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
        public final AuthApiClient getInstance() {
            return (AuthApiClient) AuthApiClient.instance$delegate.getValue();
        }
    }
}
