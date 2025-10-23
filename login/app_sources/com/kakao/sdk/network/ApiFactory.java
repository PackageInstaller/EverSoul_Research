package com.kakao.sdk.network;

import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.util.KakaoJson;
import com.kakao.sdk.common.util.SdkLog;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* compiled from: ApiFactory.kt */
@Metadata(m838d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\"\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014R\u001b\u0010\u0003\u001a\u00020\u00048FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, m839d2 = {"Lcom/kakao/sdk/network/ApiFactory;", "", "()V", "kapi", "Lretrofit2/Retrofit;", "getKapi", "()Lretrofit2/Retrofit;", "kapi$delegate", "Lkotlin/Lazy;", "loggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "getLoggingInterceptor", "()Lokhttp3/logging/HttpLoggingInterceptor;", "loggingInterceptor$delegate", "withClientAndAdapter", "url", "", "clientBuilder", "Lokhttp3/OkHttpClient$Builder;", "factory", "Lretrofit2/CallAdapter$Factory;", "network_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ApiFactory {
    public static final ApiFactory INSTANCE = new ApiFactory();

    /* renamed from: loggingInterceptor$delegate, reason: from kotlin metadata */
    private static final Lazy loggingInterceptor = LazyKt.lazy(new Function0<HttpLoggingInterceptor>() { // from class: com.kakao.sdk.network.ApiFactory$loggingInterceptor$2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final HttpLoggingInterceptor invoke() {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() { // from class: com.kakao.sdk.network.ApiFactory$loggingInterceptor$2$interceptor$1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // okhttp3.logging.HttpLoggingInterceptor.Logger
                public void log(String message) {
                    Intrinsics.checkNotNullParameter(message, "message");
                    SdkLog.INSTANCE.m471i(message);
                }
            });
            httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.HEADERS);
            return httpLoggingInterceptor;
        }
    });

    /* renamed from: kapi$delegate, reason: from kotlin metadata */
    private static final Lazy kapi = LazyKt.lazy(new Function0<Retrofit>() { // from class: com.kakao.sdk.network.ApiFactory$kapi$2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // kotlin.jvm.functions.Function0
        public final Retrofit invoke() {
            int i = 1;
            return ApiFactory.withClientAndAdapter$default(ApiFactory.INSTANCE, Intrinsics.stringPlus("https://", KakaoSdk.INSTANCE.getHosts().getKapi()), new OkHttpClient.Builder().addInterceptor(new KakaoAgentInterceptor(null, i, 0 == true ? 1 : 0)).addInterceptor(new AppKeyInterceptor(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)).addInterceptor(ApiFactory.INSTANCE.getLoggingInterceptor()), null, 4, null);
        }
    });

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ApiFactory() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static /* synthetic */ Retrofit withClientAndAdapter$default(ApiFactory apiFactory, String str, OkHttpClient.Builder builder, CallAdapter.Factory factory, int i, Object obj) {
        if ((i & 4) != 0) {
            factory = null;
        }
        return apiFactory.withClientAndAdapter(str, builder, factory);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Retrofit withClientAndAdapter(String url, OkHttpClient.Builder clientBuilder, CallAdapter.Factory factory) {
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(clientBuilder, "clientBuilder");
        Retrofit.Builder client = new Retrofit.Builder().baseUrl(url).addConverterFactory(new KakaoRetrofitConverterFactory()).addConverterFactory(GsonConverterFactory.create(KakaoJson.INSTANCE.getBase())).client(clientBuilder.build());
        if (factory != null) {
            client.addCallAdapterFactory(factory);
        }
        Retrofit build = client.build();
        Intrinsics.checkNotNullExpressionValue(build, "builder.build()");
        return build;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final HttpLoggingInterceptor getLoggingInterceptor() {
        return (HttpLoggingInterceptor) loggingInterceptor.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Retrofit getKapi() {
        return (Retrofit) kapi.getValue();
    }
}
