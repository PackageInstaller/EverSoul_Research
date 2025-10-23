package com.kakao.sdk.partner.auth;

import com.kakao.sdk.auth.AuthApiClient;
import com.kakao.sdk.auth.AuthApiManager;
import com.kakao.sdk.auth.model.OAuthToken;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AuthApiClient.kt */
@Metadata(m838d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\u001aN\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042:\u0010\u0005\u001a6\u0012\u0015\u0012\u0013\u0018\u00010\u0007¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00010\u0006¨\u0006\r"}, m839d2 = {"issueAccessToken", "", "Lcom/kakao/sdk/auth/AuthApiClient;", "groupRefreshToken", "", "callback", "Lkotlin/Function2;", "Lcom/kakao/sdk/auth/model/OAuthToken;", "Lkotlin/ParameterName;", "name", com.kakao.sdk.partner.talk.Constants.TOKEN, "", "error", "partner-auth_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class AuthApiClientKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final void issueAccessToken(AuthApiClient authApiClient, String groupRefreshToken, Function2<? super OAuthToken, ? super Throwable, Unit> callback) {
        Intrinsics.checkNotNullParameter(authApiClient, "<this>");
        Intrinsics.checkNotNullParameter(groupRefreshToken, "groupRefreshToken");
        Intrinsics.checkNotNullParameter(callback, "callback");
        AuthApiManagerKt.issueAccessToken(AuthApiManager.INSTANCE.getInstance(), groupRefreshToken, callback);
    }
}
