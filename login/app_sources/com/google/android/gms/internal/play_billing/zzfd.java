package com.google.android.gms.internal.play_billing;

import java.util.concurrent.TimeoutException;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzfd extends TimeoutException {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzfd(String str, zzfe zzfeVar) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Throwable
    public final synchronized Throwable fillInStackTrace() {
        setStackTrace(new StackTraceElement[0]);
        return this;
    }
}
