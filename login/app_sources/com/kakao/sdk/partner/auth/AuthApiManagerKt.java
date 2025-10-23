package com.kakao.sdk.partner.auth;

import com.kakao.sdk.auth.AuthApiManager;
import com.kakao.sdk.auth.model.AccessTokenResponse;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.auth.network.ApiFactoryKt;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.network.ApiFactory;
import com.kakao.sdk.partner.auth.PartnerAuthApi;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.HttpException;
import retrofit2.Response;

/* compiled from: AuthApiManager.kt */
@Metadata(m838d1 = {"\u00002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001aP\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2:\u0010\t\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00050\nH\u0000\"\u0014\u0010\u0000\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0011"}, m839d2 = {"authApi", "Lcom/kakao/sdk/partner/auth/PartnerAuthApi;", "getAuthApi", "()Lcom/kakao/sdk/partner/auth/PartnerAuthApi;", "issueAccessToken", "", "Lcom/kakao/sdk/auth/AuthApiManager;", "groupRefreshToken", "", "callback", "Lkotlin/Function2;", "Lcom/kakao/sdk/auth/model/OAuthToken;", "Lkotlin/ParameterName;", "name", com.kakao.sdk.partner.talk.Constants.TOKEN, "", "error", "partner-auth_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthApiManagerKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final PartnerAuthApi getAuthApi() {
        Object create = ApiFactoryKt.getKauth(ApiFactory.INSTANCE).create(PartnerAuthApi.class);
        Intrinsics.checkNotNullExpressionValue(create, "ApiFactory.kauth.create(…rtnerAuthApi::class.java)");
        return (PartnerAuthApi) create;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void issueAccessToken(final AuthApiManager authApiManager, String groupRefreshToken, final Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(authApiManager, "<this>");
        Intrinsics.checkNotNullParameter(groupRefreshToken, "groupRefreshToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        PartnerAuthApi.DefaultImpls.issueAccessToken$default(getAuthApi(), groupRefreshToken, authApiManager.getApplicationInfo().getAppKey(), authApiManager.getContextInfo().getSigningKeyHash(), authApiManager.getApprovalType().getValue(), null, 16, null).enqueue(new Callback<AccessTokenResponse>() { // from class: com.kakao.sdk.partner.auth.AuthApiManagerKt$issueAccessToken$1
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
                        AuthApiManager authApiManager2 = authApiManager;
                        Function2<OAuthToken, Throwable, Unit> function2 = callback;
                        OAuthToken fromResponse$default = OAuthToken.Companion.fromResponse$default(OAuthToken.INSTANCE, body, null, 2, null);
                        authApiManager2.getTokenManagerProvider().getManager().setToken(fromResponse$default);
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
}
