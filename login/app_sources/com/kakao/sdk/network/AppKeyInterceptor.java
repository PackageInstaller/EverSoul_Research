package com.kakao.sdk.network;

import com.kakao.sdk.common.KakaoSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Response;

/* compiled from: AppKeyInterceptor.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, m839d2 = {"Lcom/kakao/sdk/network/AppKeyInterceptor;", "Lokhttp3/Interceptor;", "appKey", "", "(Ljava/lang/String;)V", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "network_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AppKeyInterceptor implements Interceptor {
    private final String appKey;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppKeyInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AppKeyInterceptor(String appKey) {
        Intrinsics.checkNotNullParameter(appKey, "appKey");
        this.appKey = appKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ AppKeyInterceptor(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo().getAppKey() : str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        return chain.proceed(chain.request().newBuilder().addHeader("Authorization", Intrinsics.stringPlus("KakaoAK ", this.appKey)).build());
    }
}
