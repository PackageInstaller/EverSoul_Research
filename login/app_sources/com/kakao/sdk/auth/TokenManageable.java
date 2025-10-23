package com.kakao.sdk.auth;

import com.kakao.sdk.auth.model.OAuthToken;
import kotlin.Metadata;

/* compiled from: TokenManageable.kt */
@Metadata(m838d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0005H&¨\u0006\b"}, m839d2 = {"Lcom/kakao/sdk/auth/TokenManageable;", "", "clear", "", "getToken", "Lcom/kakao/sdk/auth/model/OAuthToken;", "setToken", com.kakao.sdk.partner.talk.Constants.TOKEN, "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface TokenManageable {
    void clear();

    OAuthToken getToken();

    void setToken(OAuthToken token);
}
