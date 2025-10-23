package com.google.common.collect;

import java.util.ListIterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingListIterator<E> extends ForwardingIterator<E> implements ListIterator<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingIterator, com.google.common.collect.ForwardingObject
    public abstract ListIterator<E> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingListIterator() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public void add(@ParametricNullness E e) {
        delegate().add(e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return delegate().hasPrevious();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public int nextIndex() {
        return delegate().nextIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    @ParametricNullness
    public E previous() {
        return delegate().previous();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public int previousIndex() {
        return delegate().previousIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public void set(@ParametricNullness E e) {
        delegate().set(e);
    }
}
