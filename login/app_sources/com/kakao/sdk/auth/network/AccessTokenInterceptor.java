package com.kakao.sdk.auth.network;

import com.kakao.sdk.auth.AuthApiManager;
import com.kakao.sdk.auth.TokenManagerProvider;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.model.ClientError;
import com.kakao.sdk.common.model.ClientErrorCause;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ExceptionWrapper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: AccessTokenInterceptor.kt */
@Metadata(m838d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, m839d2 = {"Lcom/kakao/sdk/auth/network/AccessTokenInterceptor;", "Lokhttp3/Interceptor;", "tokenManagerProvider", "Lcom/kakao/sdk/auth/TokenManagerProvider;", "manager", "Lcom/kakao/sdk/auth/AuthApiManager;", "(Lcom/kakao/sdk/auth/TokenManagerProvider;Lcom/kakao/sdk/auth/AuthApiManager;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AccessTokenInterceptor implements Interceptor {
    private final AuthApiManager manager;
    private final TokenManagerProvider tokenManagerProvider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessTokenInterceptor() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AccessTokenInterceptor(TokenManagerProvider tokenManagerProvider, AuthApiManager manager) {
        Intrinsics.checkNotNullParameter(tokenManagerProvider, "tokenManagerProvider");
        Intrinsics.checkNotNullParameter(manager, "manager");
        this.tokenManagerProvider = tokenManagerProvider;
        this.manager = manager;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AccessTokenInterceptor(TokenManagerProvider tokenManagerProvider, AuthApiManager authApiManager, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? TokenManagerProvider.INSTANCE.getInstance() : tokenManagerProvider, (i & 2) != 0 ? AuthApiManager.INSTANCE.getInstance() : authApiManager);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        String accessToken;
        Intrinsics.checkNotNullParameter(chain, "chain");
        OAuthToken token = this.tokenManagerProvider.getManager().getToken();
        String accessToken2 = token == null ? null : token.getAccessToken();
        Request withAccessToken = accessToken2 == null ? null : AccessTokenInterceptorKt.withAccessToken(chain.request(), accessToken2);
        if (withAccessToken == null) {
            throw new ExceptionWrapper(new ClientError(ClientErrorCause.TokenNotFound, null, 2, null));
        }
        Response proceed = chain.proceed(withAccessToken);
        ResponseBody body = proceed.body();
        String string = body == null ? null : body.string();
        Response build = proceed.newBuilder().body(string == null ? null : ResponseBody.INSTANCE.create(string, body.contentType())).build();
        if (string != null) {
            ResponseBody.INSTANCE.create(string, body.contentType());
        }
        if (!build.isSuccessful()) {
            ApiErrorResponse apiErrorResponse = string == null ? null : (ApiErrorResponse) KakaoJson.INSTANCE.fromJson(string, ApiErrorResponse.class);
            ApiErrorCause apiErrorCause = apiErrorResponse != null ? (ApiErrorCause) KakaoJson.INSTANCE.fromJson(String.valueOf(apiErrorResponse.getCode()), ApiErrorCause.class) : null;
            if (apiErrorCause != null && new ApiError(build.code(), apiErrorCause, apiErrorResponse).getReason() == ApiErrorCause.InvalidToken) {
                synchronized (this) {
                    OAuthToken token2 = this.tokenManagerProvider.getManager().getToken();
                    if (token2 != null) {
                        if (!Intrinsics.areEqual(token2.getAccessToken(), accessToken2)) {
                            accessToken = token2.getAccessToken();
                        } else {
                            try {
                                accessToken = this.manager.refreshToken$auth_release(token2).getAccessToken();
                            } catch (Throwable th) {
                                throw new ExceptionWrapper(th);
                            }
                        }
                        return chain.proceed(AccessTokenInterceptorKt.withAccessToken(withAccessToken, accessToken));
                    }
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
        return build;
    }
}
