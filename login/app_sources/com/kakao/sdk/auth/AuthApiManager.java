package com.kakao.sdk.auth;

import com.kakao.sdk.auth.AuthApi;
import com.kakao.sdk.auth.model.AccessTokenResponse;
import com.kakao.sdk.auth.model.AgtResponse;
import com.kakao.sdk.auth.model.CertTokenInfo;
import com.kakao.sdk.auth.model.CertType;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.model.PrepareResponse;
import com.kakao.sdk.common.model.ApplicationInfo;
import com.kakao.sdk.common.model.ApprovalType;
import com.kakao.sdk.common.model.AuthError;
import com.kakao.sdk.common.model.AuthErrorCause;
import com.kakao.sdk.common.model.AuthErrorResponse;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.model.ContextInfo;
import com.kakao.sdk.common.util.KakaoJson;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/* compiled from: AuthApiManager.kt */
@Metadata(m838d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 72\u00020\u0001:\u00017B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b¢\u0006\u0002\u0010\fJI\u0010\u0015\u001a\u00020\u00162:\u0010\u0017\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0015\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0018H\u0000¢\u0006\u0002\b\u001eJ\r\u0010\u001f\u001a\u00020 H\u0000¢\u0006\u0002\b!J]\u0010\"\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00192:\u0010\u0017\u001a6\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0018H\u0000¢\u0006\u0002\b'J]\u0010(\u001a\u00020\u00162\u0006\u0010#\u001a\u00020\u00192\n\b\u0002\u0010$\u001a\u0004\u0018\u00010\u00192:\u0010\u0017\u001a6\u0012\u0015\u0012\u0013\u0018\u00010)¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(*\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0018H\u0000¢\u0006\u0002\b+Ju\u0010,\u001a\u00020\u00162\n\b\u0002\u0010-\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010.\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010/\u001a\u0004\u0018\u00010\u00192\u0006\u00100\u001a\u0002012:\u0010\u0017\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(2\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0018H\u0000¢\u0006\u0002\b3J\u0017\u00104\u001a\u00020%2\b\b\u0002\u00105\u001a\u00020%H\u0000¢\u0006\u0002\b6JS\u00104\u001a\u00020\u00162\b\b\u0002\u00105\u001a\u00020%2:\u0010\u0017\u001a6\u0012\u0015\u0012\u0013\u0018\u00010%¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(&\u0012\u0015\u0012\u0013\u0018\u00010\u001c¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u00020\u00160\u0018H\u0001¢\u0006\u0002\b6R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u00068"}, m839d2 = {"Lcom/kakao/sdk/auth/AuthApiManager;", "", "authApi", "Lcom/kakao/sdk/auth/AuthApi;", "tokenManagerProvider", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "applicationInfo", "Lcom/kakao/sdk/common/model/ApplicationInfo;", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "approvalType", "Lcom/kakao/sdk/common/model/ApprovalType;", "(Lcom/kakao/sdk/auth/AuthApi;Lcom/kakao/sdk/auth/TokenManagerProvider;Lcom/kakao/sdk/common/model/ApplicationInfo;Lcom/kakao/sdk/common/model/ContextInfo;Lcom/kakao/sdk/common/model/ApprovalType;)V", "getApplicationInfo", "()Lcom/kakao/sdk/common/model/ApplicationInfo;", "getApprovalType", "()Lcom/kakao/sdk/common/model/ApprovalType;", "getContextInfo", "()Lcom/kakao/sdk/common/model/ContextInfo;", "getTokenManagerProvider", "()Lcom/kakao/sdk/auth/TokenManagerProvider;", Constants.AGT, "", "callback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "", "error", "agt$auth_release", "hasToken", "", "hasToken$auth_release", "issueAccessToken", "code", "codeVerifier", "Lcom/kakao/sdk/auth/model/OAuthToken;", com.kakao.sdk.partner.talk.Constants.TOKEN, "issueAccessToken$auth_release", "issueAccessTokenWithCert", "Lcom/kakao/sdk/auth/model/CertTokenInfo;", "certTokenInfo", "issueAccessTokenWithCert$auth_release", "prepare", "settleId", "signData", "txId", "certType", "Lcom/kakao/sdk/auth/model/CertType;", "kauthTxId", "prepare$auth_release", "refreshToken", "oldToken", "refreshToken$auth_release", "Companion", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthApiManager {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Lazy<AuthApiManager> instance$delegate = LazyKt.lazy(new Function0<AuthApiManager>() { // from class: com.kakao.sdk.auth.AuthApiManager$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final AuthApiManager invoke() {
            return new AuthApiManager(null, null, null, null, null, 31, null);
        }
    });
    private final ApplicationInfo applicationInfo;
    private final ApprovalType approvalType;
    private final AuthApi authApi;
    private final ContextInfo contextInfo;
    private final TokenManagerProvider tokenManagerProvider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthApiManager() {
        this(null, null, null, null, null, 31, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final AuthApiManager getInstance() {
        return INSTANCE.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void refreshToken$auth_release(Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(callback, "callback");
        refreshToken$auth_release$default(this, null, callback, 1, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AuthApiManager(AuthApi authApi, TokenManagerProvider tokenManagerProvider, ApplicationInfo applicationInfo, ContextInfo contextInfo, ApprovalType approvalType) {
        Intrinsics.checkNotNullParameter(authApi, "authApi");
        Intrinsics.checkNotNullParameter(tokenManagerProvider, "tokenManagerProvider");
        Intrinsics.checkNotNullParameter(applicationInfo, "applicationInfo");
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        Intrinsics.checkNotNullParameter(approvalType, "approvalType");
        this.authApi = authApi;
        this.tokenManagerProvider = tokenManagerProvider;
        this.applicationInfo = applicationInfo;
        this.contextInfo = contextInfo;
        this.approvalType = approvalType;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public /* synthetic */ AuthApiManager(com.kakao.sdk.auth.AuthApi r4, com.kakao.sdk.auth.TokenManagerProvider r5, com.kakao.sdk.common.model.ApplicationContextInfo r6, com.kakao.sdk.common.model.ApplicationContextInfo r7, com.kakao.sdk.common.model.ApprovalType r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L17
            com.kakao.sdk.network.ApiFactory r4 = com.kakao.sdk.network.ApiFactory.INSTANCE
            retrofit2.Retrofit r4 = com.kakao.sdk.auth.network.ApiFactoryKt.getKauth(r4)
            java.lang.Class<com.kakao.sdk.auth.AuthApi> r10 = com.kakao.sdk.auth.AuthApi.class
            java.lang.Object r4 = r4.create(r10)
            java.lang.String r10 = "ApiFactory.kauth.create(AuthApi::class.java)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r10)
            com.kakao.sdk.auth.AuthApi r4 = (com.kakao.sdk.auth.AuthApi) r4
        L17:
            r10 = r9 & 2
            if (r10 == 0) goto L21
            com.kakao.sdk.auth.TokenManagerProvider$Companion r5 = com.kakao.sdk.auth.TokenManagerProvider.INSTANCE
            com.kakao.sdk.auth.TokenManagerProvider r5 = r5.getInstance()
        L21:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L2f
            com.kakao.sdk.common.KakaoSdk r5 = com.kakao.sdk.common.KakaoSdk.INSTANCE
            com.kakao.sdk.common.model.ApplicationContextInfo r5 = r5.getApplicationContextInfo()
            r6 = r5
            com.kakao.sdk.common.model.ApplicationInfo r6 = (com.kakao.sdk.common.model.ApplicationInfo) r6
        L2f:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L3d
            com.kakao.sdk.common.KakaoSdk r5 = com.kakao.sdk.common.KakaoSdk.INSTANCE
            com.kakao.sdk.common.model.ApplicationContextInfo r5 = r5.getApplicationContextInfo()
            r7 = r5
            com.kakao.sdk.common.model.ContextInfo r7 = (com.kakao.sdk.common.model.ContextInfo) r7
        L3d:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L48
            com.kakao.sdk.common.KakaoSdk r5 = com.kakao.sdk.common.KakaoSdk.INSTANCE
            com.kakao.sdk.common.model.ApprovalType r8 = r5.getApprovalType()
        L48:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
            fill-array 0x0054: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.auth.AuthApiManager.<init>(com.kakao.sdk.auth.AuthApi, com.kakao.sdk.auth.TokenManagerProvider, com.kakao.sdk.common.model.ApplicationInfo, com.kakao.sdk.common.model.ContextInfo, com.kakao.sdk.common.model.ApprovalType, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TokenManagerProvider getTokenManagerProvider() {
        return this.tokenManagerProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApplicationInfo getApplicationInfo() {
        return this.applicationInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ContextInfo getContextInfo() {
        return this.contextInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ApprovalType getApprovalType() {
        return this.approvalType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean hasToken$auth_release() {
        return this.tokenManagerProvider.getManager().getToken() != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void issueAccessToken$auth_release$default(AuthApiManager authApiManager, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        authApiManager.issueAccessToken$auth_release(str, str2, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void issueAccessToken$auth_release(String code, String codeVerifier, final Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AuthApi.DefaultImpls.issueAccessToken$default(this.authApi, this.applicationInfo.getAppKey(), this.contextInfo.getSigningKeyHash(), code, this.applicationInfo.getRedirectUri(), codeVerifier, this.approvalType.getValue(), null, 64, null).enqueue(new Callback<AccessTokenResponse>() { // from class: com.kakao.sdk.auth.AuthApiManager$issueAccessToken$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onFailure(Call<AccessTokenResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                callback.invoke(null, t);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onResponse(Call<AccessTokenResponse> call, Response<AccessTokenResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    AccessTokenResponse body = response.body();
                    if (body != null) {
                        AuthApiManager authApiManager = this;
                        Function2<OAuthToken, Throwable, Unit> function2 = callback;
                        OAuthToken fromResponse$default = OAuthToken.Companion.fromResponse$default(OAuthToken.INSTANCE, body, null, 2, null);
                        authApiManager.getTokenManagerProvider().getManager().setToken(fromResponse$default);
                        function2.invoke(fromResponse$default, null);
                        return;
                    }
                    callback.invoke(null, new ClientError(ClientErrorCause.Unknown, "No body"));
                    return;
                }
                callback.invoke(null, AuthApiManager.INSTANCE.translateError(new HttpException(response)));
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void issueAccessTokenWithCert$auth_release$default(AuthApiManager authApiManager, String str, String str2, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            str2 = null;
        }
        authApiManager.issueAccessTokenWithCert$auth_release(str, str2, function2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void issueAccessTokenWithCert$auth_release(String code, String codeVerifier, final Function2<? super CertTokenInfo, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(code, "code");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AuthApi.DefaultImpls.issueAccessToken$default(this.authApi, this.applicationInfo.getAppKey(), this.contextInfo.getSigningKeyHash(), code, this.applicationInfo.getRedirectUri(), codeVerifier, this.approvalType.getValue(), null, 64, null).enqueue(new Callback<AccessTokenResponse>() { // from class: com.kakao.sdk.auth.AuthApiManager$issueAccessTokenWithCert$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onFailure(Call<AccessTokenResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                callback.invoke(null, t);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onResponse(Call<AccessTokenResponse> call, Response<AccessTokenResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    AccessTokenResponse body = response.body();
                    if (body != null) {
                        Function2<CertTokenInfo, Throwable, Unit> function2 = callback;
                        AuthApiManager authApiManager = this;
                        OAuthToken fromResponse$default = OAuthToken.Companion.fromResponse$default(OAuthToken.INSTANCE, body, null, 2, null);
                        String txId = body.getTxId();
                        if (txId == null) {
                            function2.invoke(null, new ClientError(ClientErrorCause.Unknown, "txId is null"));
                            return;
                        } else {
                            authApiManager.getTokenManagerProvider().getManager().setToken(fromResponse$default);
                            function2.invoke(new CertTokenInfo(fromResponse$default, txId), null);
                            return;
                        }
                    }
                    callback.invoke(null, new ClientError(ClientErrorCause.Unknown, "No body"));
                    return;
                }
                callback.invoke(null, AuthApiManager.INSTANCE.translateError(new HttpException(response)));
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ void refreshToken$auth_release$default(AuthApiManager authApiManager, OAuthToken oAuthToken, Function2 function2, int i, Object obj) {
        if ((i & 1) == 0 || (oAuthToken = authApiManager.tokenManagerProvider.getManager().getToken()) != null) {
            authApiManager.refreshToken$auth_release(oAuthToken, function2);
            return;
        }
        throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found. You must login first.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void refreshToken$auth_release(final OAuthToken oldToken, final Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(oldToken, "oldToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AuthApi.DefaultImpls.refreshToken$default(this.authApi, this.applicationInfo.getAppKey(), this.contextInfo.getSigningKeyHash(), oldToken.getRefreshToken(), this.approvalType.getValue(), null, 16, null).enqueue(new Callback<AccessTokenResponse>() { // from class: com.kakao.sdk.auth.AuthApiManager$refreshToken$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onFailure(Call<AccessTokenResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                callback.invoke(null, t);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onResponse(Call<AccessTokenResponse> call, Response<AccessTokenResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    AccessTokenResponse body = response.body();
                    if (body != null) {
                        OAuthToken oAuthToken = oldToken;
                        AuthApiManager authApiManager = this;
                        Function2<OAuthToken, Throwable, Unit> function2 = callback;
                        OAuthToken fromResponse = OAuthToken.INSTANCE.fromResponse(body, oAuthToken);
                        authApiManager.getTokenManagerProvider().getManager().setToken(fromResponse);
                        function2.invoke(fromResponse, null);
                        return;
                    }
                    callback.invoke(null, new ClientError(ClientErrorCause.Unknown, "No body"));
                    return;
                }
                callback.invoke(null, AuthApiManager.INSTANCE.translateError(new HttpException(response)));
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void agt$auth_release(final Function2<? super String, ? super Throwable, Unit> callback) {
        String accessToken;
        Unit unit;
        Intrinsics.checkNotNullParameter(callback, "callback");
        OAuthToken token = this.tokenManagerProvider.getManager().getToken();
        if (token == null || (accessToken = token.getAccessToken()) == null) {
            unit = null;
        } else {
            this.authApi.agt(getApplicationInfo().getAppKey(), accessToken).enqueue(new Callback<AgtResponse>() { // from class: com.kakao.sdk.auth.AuthApiManager$agt$1$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // retrofit2.Callback
                public void onFailure(Call<AgtResponse> call, Throwable t) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(t, "t");
                    callback.invoke(null, t);
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // retrofit2.Callback
                public void onResponse(Call<AgtResponse> call, Response<AgtResponse> response) {
                    Intrinsics.checkNotNullParameter(call, "call");
                    Intrinsics.checkNotNullParameter(response, "response");
                    AgtResponse body = response.body();
                    if (body != null) {
                        callback.invoke(body.getAgt(), null);
                    } else {
                        callback.invoke(null, AuthApiManager.INSTANCE.translateError(new HttpException(response)));
                    }
                }
            });
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            callback.invoke(null, new ClientError(ClientErrorCause.TokenNotFound, "Access token not found. You must login first."));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ OAuthToken refreshToken$auth_release$default(AuthApiManager authApiManager, OAuthToken oAuthToken, int i, Object obj) {
        if ((i & 1) == 0 || (oAuthToken = authApiManager.tokenManagerProvider.getManager().getToken()) != null) {
            return authApiManager.refreshToken$auth_release(oAuthToken);
        }
        throw new ClientError(ClientErrorCause.TokenNotFound, "Refresh token not found. You must login first.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final OAuthToken refreshToken$auth_release(OAuthToken oldToken) {
        Intrinsics.checkNotNullParameter(oldToken, "oldToken");
        Response execute = AuthApi.DefaultImpls.refreshToken$default(this.authApi, this.applicationInfo.getAppKey(), this.contextInfo.getSigningKeyHash(), oldToken.getRefreshToken(), this.approvalType.getValue(), null, 16, null).execute();
        AccessTokenResponse accessTokenResponse = (AccessTokenResponse) execute.body();
        OAuthToken fromResponse = accessTokenResponse == null ? null : OAuthToken.INSTANCE.fromResponse(accessTokenResponse, oldToken);
        if (fromResponse == null) {
            throw INSTANCE.translateError(new HttpException(execute));
        }
        this.tokenManagerProvider.getManager().setToken(fromResponse);
        return fromResponse;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void prepare$auth_release(String settleId, String signData, String txId, CertType certType, final Function2<? super String, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(certType, "certType");
        Intrinsics.checkNotNullParameter(callback, "callback");
        this.authApi.prepare(this.applicationInfo.getAppKey(), settleId, signData, txId, certType.getValue()).enqueue(new Callback<PrepareResponse>() { // from class: com.kakao.sdk.auth.AuthApiManager$prepare$1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onFailure(Call<PrepareResponse> call, Throwable t) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(t, "t");
                callback.invoke(null, t);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // retrofit2.Callback
            public void onResponse(Call<PrepareResponse> call, Response<PrepareResponse> response) {
                Intrinsics.checkNotNullParameter(call, "call");
                Intrinsics.checkNotNullParameter(response, "response");
                if (response.isSuccessful()) {
                    PrepareResponse body = response.body();
                    if (body != null) {
                        callback.invoke(body.getKauthTxId(), null);
                        return;
                    } else {
                        callback.invoke(null, new ClientError(ClientErrorCause.Unknown, "No body"));
                        return;
                    }
                }
                callback.invoke(null, AuthApiManager.INSTANCE.translateError(new HttpException(response)));
            }
        });
    }

    /* compiled from: AuthApiManager.kt */
    @Metadata(m838d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0003\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR!\u0010\u0003\u001a\u00020\u00048FX\u0087\u0084\u0002¢\u0006\u0012\n\u0004\b\b\u0010\t\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, m839d2 = {"Lcom/kakao/sdk/auth/AuthApiManager$Companion;", "", "()V", "instance", "Lcom/kakao/sdk/auth/AuthApiManager;", "getInstance$annotations", com.kakao.sdk.common.Constants.APP_LIFECYCLE_OBSERVER_SINGLETON_METHOD, "()Lcom/kakao/sdk/auth/AuthApiManager;", "instance$delegate", "Lkotlin/Lazy;", "translateError", "", "t", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
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
        public final Throwable translateError(Throwable t) {
            ResponseBody errorBody;
            Object m1440constructorimpl;
            Intrinsics.checkNotNullParameter(t, "t");
            try {
                if (!(t instanceof HttpException)) {
                    return t;
                }
                Response<?> response = ((HttpException) t).response();
                String str = null;
                if (response != null && (errorBody = response.errorBody()) != null) {
                    str = errorBody.string();
                }
                KakaoJson kakaoJson = KakaoJson.INSTANCE;
                Intrinsics.checkNotNull(str);
                AuthErrorResponse authErrorResponse = (AuthErrorResponse) kakaoJson.fromJson(str, AuthErrorResponse.class);
                try {
                    Result.Companion companion = Result.INSTANCE;
                    m1440constructorimpl = Result.m1440constructorimpl((AuthErrorCause) KakaoJson.INSTANCE.fromJson(authErrorResponse.getError(), AuthErrorCause.class));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    m1440constructorimpl = Result.m1440constructorimpl(ResultKt.createFailure(th));
                }
                AuthErrorCause authErrorCause = AuthErrorCause.Unknown;
                if (Result.m1446isFailureimpl(m1440constructorimpl)) {
                    m1440constructorimpl = authErrorCause;
                }
                return new AuthError(((HttpException) t).code(), (AuthErrorCause) m1440constructorimpl, authErrorResponse);
            } catch (Throwable th2) {
                return th2;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public final AuthApiManager getInstance() {
            return (AuthApiManager) AuthApiManager.instance$delegate.getValue();
        }
    }
}
