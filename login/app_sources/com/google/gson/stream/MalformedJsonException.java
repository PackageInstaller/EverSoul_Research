package com.google.gson.stream;

import java.io.IOException;

/* loaded from: classes2.dex */
public final class MalformedJsonException extends IOException {
    private static final long serialVersionUID = 1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MalformedJsonException(String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MalformedJsonException(String str, Throwable th) {
        super(str);
        initCause(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MalformedJsonException(Throwable th) {
        initCause(th);
    }
}
