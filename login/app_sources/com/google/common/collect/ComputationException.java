package com.google.common.collect;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
@Deprecated
/* loaded from: classes2.dex */
public class ComputationException extends RuntimeException {
    private static final long serialVersionUID = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ComputationException(@CheckForNull Throwable th) {
        super(th);
    }
}
