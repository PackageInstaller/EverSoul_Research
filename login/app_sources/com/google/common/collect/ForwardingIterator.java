package com.google.common.collect;

import java.util.Iterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingIterator<T> extends ForwardingObject implements Iterator<T> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Iterator<T> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingIterator() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator
    public boolean hasNext() {
        return delegate().hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @ParametricNullness
    public T next() {
        return delegate().next();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void remove() {
        delegate().remove();
    }
}
