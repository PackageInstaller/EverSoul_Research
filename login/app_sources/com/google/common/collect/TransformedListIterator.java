package com.google.common.collect;

import java.util.ListIterator;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class TransformedListIterator<F, T> extends TransformedIterator<F, T> implements ListIterator<T> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TransformedListIterator(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ListIterator<? extends F> backingIterator() {
        return Iterators.cast(this.backingIterator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return backingIterator().hasPrevious();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    @ParametricNullness
    public final T previous() {
        return transform(backingIterator().previous());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final int nextIndex() {
        return backingIterator().nextIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final int previousIndex() {
        return backingIterator().previousIndex();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void set(@ParametricNullness T t) {
        throw new UnsupportedOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public void add(@ParametricNullness T t) {
        throw new UnsupportedOperationException();
    }
}
