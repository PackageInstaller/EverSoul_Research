package com.kakao.sdk.auth.model;

import com.google.gson.annotations.SerializedName;
import java.lang.annotation.Annotation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Prompt.kt */
@Metadata(m838d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000b¨\u0006\f"}, m839d2 = {"Lcom/kakao/sdk/auth/model/Prompt;", "", "(Ljava/lang/String;I)V", "value", "", "getValue", "()Ljava/lang/String;", "LOGIN", "CREATE", "SELECT_ACCOUNT", "CERT", "UNIFY_DAUM", "auth_release"}, m840k = 1, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public enum Prompt {
    LOGIN,
    CREATE,
    SELECT_ACCOUNT,
    CERT,
    UNIFY_DAUM;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String getValue() {
        Annotation annotation = getClass().getField(name()).getAnnotation(SerializedName.class);
        Intrinsics.checkNotNull(annotation);
        return ((SerializedName) annotation).value();
    }
}
