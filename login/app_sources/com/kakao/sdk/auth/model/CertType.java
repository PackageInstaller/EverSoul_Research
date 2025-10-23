package com.kakao.sdk.auth.model;

import kotlin.Metadata;

/* compiled from: CertType.kt */
@Metadata(m838d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, m839d2 = {"Lcom/kakao/sdk/auth/model/CertType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue", "()Ljava/lang/String;", "K2100", "K2220", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public enum CertType {
    K2100("k2100"),
    K2220("k2220");

    private final String value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CertType(String str) {
        this.value = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getValue() {
        return this.value;
    }
}
