package com.kakao.sdk.network;

import com.kakao.sdk.common.Constants;
import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ApplicationContextInfo;
import com.kakao.sdk.common.model.ContextInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* compiled from: KakaoAgentInterceptor.kt */
@Metadata(m838d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, m839d2 = {"Lcom/kakao/sdk/network/KakaoAgentInterceptor;", "Lokhttp3/Interceptor;", "contextInfo", "Lcom/kakao/sdk/common/model/ContextInfo;", "(Lcom/kakao/sdk/common/model/ContextInfo;)V", "getContextInfo", "()Lcom/kakao/sdk/common/model/ContextInfo;", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "network_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class KakaoAgentInterceptor implements Interceptor {
    private final ContextInfo contextInfo;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KakaoAgentInterceptor() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public KakaoAgentInterceptor(ContextInfo contextInfo) {
        Intrinsics.checkNotNullParameter(contextInfo, "contextInfo");
        this.contextInfo = contextInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public /* synthetic */ KakaoAgentInterceptor(ApplicationContextInfo applicationContextInfo, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? KakaoSdk.INSTANCE.getApplicationContextInfo() : applicationContextInfo);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ContextInfo getContextInfo() {
        return this.contextInfo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) {
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request = chain.request();
        return chain.proceed(request.newBuilder().addHeader(Constants.KA, this.contextInfo.getKaHeader()).build());
    }
}
