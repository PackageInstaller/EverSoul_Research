package com.kakao.sdk.auth.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Request;

/* compiled from: AccessTokenInterceptor.kt */
@Metadata(m838d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, m839d2 = {"withAccessToken", "Lokhttp3/Request;", "accessToken", "", "auth_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AccessTokenInterceptorKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Request withAccessToken(Request request, String accessToken) {
        Intrinsics.checkNotNullParameter(request, "<this>");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        return request.newBuilder().removeHeader("Authorization").addHeader("Authorization", Intrinsics.stringPlus("Bearer ", accessToken)).build();
    }
}
