package com.kakao.sdk.auth.network;

import android.content.Context;
import com.kakao.sdk.auth.AuthApiClient;
import com.kakao.sdk.auth.AuthCodeClient;
import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApiError;
import com.kakao.sdk.common.model.ApiErrorCause;
import com.kakao.sdk.common.model.ApiErrorResponse;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.network.ExceptionWrapper;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import okhttp3.Interceptor;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: RequiredScopesInterceptor.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m839d2 = {"Lcom/kakao/sdk/auth/network/RequiredScopesInterceptor;", "Lokhttp3/Interceptor;", "contextInfo", "Lcom/kakao/sdk/common/model/ApplicationContextInfo;", "(Lcom/kakao/sdk/common/model/ApplicationContextInfo;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class RequiredScopesInterceptor implements Interceptor {
    private final ApplicationContextInfo contextInfo;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequiredScopesInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RequiredScopesInterceptor(ApplicationContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        this.contextInfo = contextInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ RequiredScopesInterceptor(ApplicationContextInfo applicationContextInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        String accessToken;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Response proceed = chain.proceed(chain.request());
        ResponseBody body = proceed.body();
        Response response = null;
        String string = body == null ? null : body.string();
        Response build = proceed.newBuilder().body(string == null ? null : ResponseBody.INSTANCE.create(string, body.contentType())).build();
        if (string != null) {
            ResponseBody.INSTANCE.create(string, body.contentType());
        }
        if (!build.isSuccessful()) {
            ApiErrorResponse apiErrorResponse = string == null ? null : (ApiErrorResponse) KakaoJson.INSTANCE.fromJson(string, ApiErrorResponse.class);
            ApiErrorCause apiErrorCause = apiErrorResponse == null ? null : (ApiErrorCause) KakaoJson.INSTANCE.fromJson(String.valueOf(apiErrorResponse.getCode()), ApiErrorCause.class);
            if (apiErrorCause != null) {
                ApiError apiError = new ApiError(build.code(), apiErrorCause, apiErrorResponse);
                final List<String> requiredScopes = apiError.getResponse().getRequiredScopes();
                if (apiError.getReason() != ApiErrorCause.InsufficientScope) {
                    return build;
                }
                List<String> list = requiredScopes;
                if (list == null || list.isEmpty()) {
                    throw new ExceptionWrapper(new ApiError(apiError.getStatusCode(), ApiErrorCause.Unknown, new ApiErrorResponse(ApiErrorCause.Unknown.getErrorCode(), "requiredScopes not exist", null, apiError.getResponse().getRequiredScopes(), apiError.getResponse().getAllowedScopes(), 4, null)));
                }
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                final Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
                final CountDownLatch countDownLatch = new CountDownLatch(1);
                AuthApiClient.INSTANCE.getInstance().agt(new Function2<String, Throwable, Unit>() { // from class: com.kakao.sdk.auth.network.RequiredScopesInterceptor$intercept$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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

                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(String str, Throwable th) {
                        ApplicationContextInfo applicationContextInfo;
                        if (th != 0) {
                            objectRef2.element = th;
                            countDownLatch.countDown();
                            return;
                        }
                        final String codeVerifier = AuthCodeClient.INSTANCE.codeVerifier();
                        AuthCodeClient companion = AuthCodeClient.INSTANCE.getInstance();
                        applicationContextInfo = this.contextInfo;
                        Context applicationContext = applicationContextInfo.getApplicationContext();
                        List<String> list2 = requiredScopes;
                        final Ref.ObjectRef<Throwable> objectRef3 = objectRef2;
                        final CountDownLatch countDownLatch2 = countDownLatch;
                        final Ref.ObjectRef<OAuthToken> objectRef4 = objectRef;
                        AuthCodeClient.authorizeWithKakaoAccount$default(companion, applicationContext, null, list2, null, str, null, null, false, null, null, codeVerifier, null, null, null, new Function2<String, Throwable, Unit>() { // from class: com.kakao.sdk.auth.network.RequiredScopesInterceptor$intercept$1$1.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            {
                                super(2);
                            }

                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(String str2, Throwable th2) {
                                invoke2(str2, th2);
                                return Unit.INSTANCE;
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String str2, Throwable th2) {
                                if (th2 != 0) {
                                    objectRef3.element = th2;
                                    countDownLatch2.countDown();
                                    return;
                                }
                                AuthApiClient companion2 = AuthApiClient.INSTANCE.getInstance();
                                Intrinsics.checkNotNull(str2);
                                String str3 = codeVerifier;
                                final Ref.ObjectRef<OAuthToken> objectRef5 = objectRef4;
                                final Ref.ObjectRef<Throwable> objectRef6 = objectRef3;
                                final CountDownLatch countDownLatch3 = countDownLatch2;
                                companion2.issueAccessToken(str2, str3, new Function2<OAuthToken, Throwable, Unit>() { // from class: com.kakao.sdk.auth.network.RequiredScopesInterceptor.intercept.1.1.1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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

                                    /* JADX WARN: Multi-variable type inference failed */
                                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                    public final void invoke2(OAuthToken oAuthToken, Throwable th3) {
                                        objectRef5.element = oAuthToken;
                                        objectRef6.element = th3;
                                        countDownLatch3.countDown();
                                    }
                                });
                            }
                        }, 15338, null);
                    }
                });
                countDownLatch.await();
                OAuthToken oAuthToken = (OAuthToken) objectRef.element;
                if (oAuthToken != null && (accessToken = oAuthToken.getAccessToken()) != null) {
                    response = chain.proceed(AccessTokenInterceptorKt.withAccessToken(build.request(), accessToken));
                }
                if (response != null) {
                    return response;
                }
                T t = objectRef2.element;
                Intrinsics.checkNotNull(t);
                throw new ExceptionWrapper((Throwable) t);
            }
        }
        return build;
    }
}
