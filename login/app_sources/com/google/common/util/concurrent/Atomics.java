package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceArray;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Atomics {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Atomics() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <V> AtomicReference<V> newReference() {
        return new AtomicReference<>();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <V> AtomicReference<V> newReference(@ParametricNullness V v) {
        return new AtomicReference<>(v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> AtomicReferenceArray<E> newReferenceArray(int i) {
        return new AtomicReferenceArray<>(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> AtomicReferenceArray<E> newReferenceArray(E[] eArr) {
        return new AtomicReferenceArray<>(eArr);
    }
}
