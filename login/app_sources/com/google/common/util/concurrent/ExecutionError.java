package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public class ExecutionError extends Error {
    private static final long serialVersionUID = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ExecutionError() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ExecutionError(@CheckForNull String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExecutionError(@CheckForNull String str, @CheckForNull Error error) {
        super(str, error);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ExecutionError(@CheckForNull Error error) {
        super(error);
    }
}
