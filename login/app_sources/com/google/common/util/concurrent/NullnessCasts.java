package com.google.common.util.concurrent;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class NullnessCasts {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    static <T> T uncheckedCastNullableTToT(@CheckForNull T t) {
        return t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    static <T> T uncheckedNull() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private NullnessCasts() {
    }
}
