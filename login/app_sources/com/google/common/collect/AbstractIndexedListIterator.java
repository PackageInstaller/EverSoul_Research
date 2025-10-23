package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class AbstractIndexedListIterator<E> extends UnmodifiableListIterator<E> {
    private int position;
    private final int size;

    @ParametricNullness
    protected abstract E get(int i);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AbstractIndexedListIterator(int i) {
        this(i, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AbstractIndexedListIterator(int i, int i2) {
        Preconditions.checkPositionIndex(i2, i);
        this.size = i;
        this.position = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator, java.util.ListIterator
    public final boolean hasNext() {
        return this.position < this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Iterator, java.util.ListIterator
    @ParametricNullness
    public final E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int i = this.position;
        this.position = i + 1;
        return get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.position;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.position > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    @ParametricNullness
    public final E previous() {
        if (!hasPrevious()) {
            throw new NoSuchElementException();
        }
        int i = this.position - 1;
        this.position = i;
        return get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.position - 1;
    }
}
