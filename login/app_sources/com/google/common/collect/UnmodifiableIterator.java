package com.google.common.collect;

import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class UnmodifiableIterator<E> implements Iterator<E> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected UnmodifiableIterator() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
