package com.kakao.sdk.common.model;

import com.google.gson.JsonObject;
import com.kakaogame.server.ServerConstants;
import kotlin.Metadata;

/* compiled from: ContextInfo.kt */
@Metadata(m838d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0005R\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0005¨\u0006\u0012"}, m839d2 = {"Lcom/kakao/sdk/common/model/ContextInfo;", "", ServerConstants.APP_VERSION, "", "getAppVer", "()Ljava/lang/String;", "extras", "Lcom/google/gson/JsonObject;", "getExtras", "()Lcom/google/gson/JsonObject;", "kaHeader", "getKaHeader", "salt", "", "getSalt", "()[B", "signingKeyHash", "getSigningKeyHash", "common_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public interface ContextInfo {
    String getAppVer();

    JsonObject getExtras();

    String getKaHeader();

    byte[] getSalt();

    String getSigningKeyHash();
}
