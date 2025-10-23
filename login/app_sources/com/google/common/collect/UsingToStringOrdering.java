package com.google.common.collect;

import java.io.Serializable;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class UsingToStringOrdering extends Ordering<Object> implements Serializable {
    static final UsingToStringOrdering INSTANCE = new UsingToStringOrdering();
    private static final long serialVersionUID = 0;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Ordering.usingToString()";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return obj.toString().compareTo(obj2.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Object readResolve() {
        return INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UsingToStringOrdering() {
    }
}
