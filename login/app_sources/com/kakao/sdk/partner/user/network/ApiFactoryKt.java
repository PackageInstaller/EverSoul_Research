package com.kakao.sdk.partner.user.network;

import com.kakao.sdk.auth.network.AccessTokenInterceptor;
import com.kakao.sdk.auth.network.RequiredScopesInterceptor;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.network.ApiFactory;
import com.kakao.sdk.network.KakaoAgentInterceptor;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* compiled from: ApiFactory.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0007"}, m839d2 = {"signupKapiWithOAuth", "Lretrofit2/Retrofit;", "Lcom/kakao/sdk/network/ApiFactory;", "getSignupKapiWithOAuth", "(Lcom/kakao/sdk/network/ApiFactory;)Lretrofit2/Retrofit;", "signupKapiWithOAuth$delegate", "Lkotlin/Lazy;", "partner-user_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ApiFactoryKt {
    private static final Lazy signupKapiWithOAuth$delegate = LazyKt.lazy(new Function0<Retrofit>() { // from class: com.kakao.sdk.partner.user.network.ApiFactoryKt$signupKapiWithOAuth$2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final Retrofit invoke() {
            int i = 1;
            return ApiFactory.withClientAndAdapter$default(ApiFactory.INSTANCE, Intrinsics.stringPlus("https://", KakaoSdk.INSTANCE.getHosts().getKapi()), new OkHttpClient.Builder().addInterceptor(new KakaoAgentInterceptor(null, i, 0 == true ? 1 : 0)).addInterceptor(new AccessTokenInterceptor(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)).addInterceptor(new RequiredScopesInterceptor(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)).addInterceptor(new RequiredAgeVerificationInterceptor(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)).addInterceptor(ApiFactory.INSTANCE.getLoggingInterceptor()), null, 4, null);
        }
    });

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Retrofit getSignupKapiWithOAuth(ApiFactory apiFactory) {
        Intrinsics.checkNotNullParameter(apiFactory, "<this>");
        return (Retrofit) signupKapiWithOAuth$delegate.getValue();
    }
}
