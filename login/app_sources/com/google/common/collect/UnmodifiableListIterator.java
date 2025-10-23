package com.google.common.collect;

import java.util.ListIterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class UnmodifiableListIterator<E> extends UnmodifiableIterator<E> implements ListIterator<E> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected UnmodifiableListIterator() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    @Deprecated
    public final void add(@ParametricNullness E e) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    @Deprecated
    public final void set(@ParametricNullness E e) {
        throw new UnsupportedOperationException();
    }
}
