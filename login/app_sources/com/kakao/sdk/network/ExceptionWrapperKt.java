package com.kakao.sdk.network;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExceptionWrapper.kt */
@Metadata(m838d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\"\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, m839d2 = {"origin", "", "getOrigin", "(Ljava/lang/Throwable;)Ljava/lang/Throwable;", "network_release"}, m840k = 2, m841mv = {1, 6, 0}, m843xi = 48)
/* loaded from: classes3.dex */
public final class ExceptionWrapperKt {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static final Throwable getOrigin(Throwable th) {
        Intrinsics.checkNotNullParameter(th, "<this>");
        return th instanceof ExceptionWrapper ? ((ExceptionWrapper) th).getOrigin() : th;
    }
}
