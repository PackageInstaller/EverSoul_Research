package com.kakao.sdk.friend.p021j;

import com.kakao.sdk.auth.network.AccessTokenInterceptor;
import com.kakao.sdk.auth.network.RequiredScopesInterceptor;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.network.ApiFactory;
import com.kakao.sdk.network.AppKeyInterceptor;
import com.kakao.sdk.network.KakaoAgentInterceptor;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/* renamed from: com.kakao.sdk.friend.j.a */
/* loaded from: classes3.dex */
public final class C2178a {

    /* renamed from: a */
    public static final Retrofit f805a;

    /* renamed from: b */
    public static final Retrofit f806b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        int i = 1;
        f805a = ApiFactory.withClientAndAdapter$default(ApiFactory.INSTANCE, Intrinsics.stringPlus("https://", KakaoSdk.INSTANCE.getHosts().getKapi()), new OkHttpClient.Builder().addInterceptor(new KakaoAgentInterceptor(null, i, 0 == true ? 1 : 0)).addInterceptor(new AccessTokenInterceptor(0 == true ? 1 : 0, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0)).addInterceptor(new RequiredScopesInterceptor(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)), null, 4, null);
        f806b = ApiFactory.withClientAndAdapter$default(ApiFactory.INSTANCE, Intrinsics.stringPlus("https://", KakaoSdk.INSTANCE.getHosts().getKapi()), new OkHttpClient.Builder().addInterceptor(new KakaoAgentInterceptor(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)).addInterceptor(new AppKeyInterceptor(0 == true ? 1 : 0, i, 0 == true ? 1 : 0)), null, 4, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static final Retrofit m530a() {
        return f806b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public static final Retrofit m531b() {
        return f805a;
    }
}
