package com.kakao.sdk.auth;

import com.kakao.sdk.common.util.SdkLog;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;

/* compiled from: TokenManager.kt */
@Metadata(m838d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\u0004\b\u0000\u0010\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0082\b¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, m839d2 = {"parseOrNull", "T", "f", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "auth_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class TokenManagerKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final <T> T parseOrNull(Function0<? extends T> function0) {
        try {
            return function0.invoke();
        } catch (Exception e) {
            SdkLog.INSTANCE.m470e(e);
            return null;
        }
    }
}
