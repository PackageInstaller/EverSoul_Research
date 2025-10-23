package com.google.common.collect;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public enum BoundType {
    OPEN(false),
    CLOSED(true);

    final boolean inclusive;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BoundType(boolean z) {
        this.inclusive = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static BoundType forBoolean(boolean z) {
        return z ? CLOSED : OPEN;
    }
}
