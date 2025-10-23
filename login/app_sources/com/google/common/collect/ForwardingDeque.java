package com.google.common.collect;

import java.util.Deque;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingDeque<E> extends ForwardingQueue<E> implements Deque<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingQueue, com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Deque<E> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingDeque() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    public void addFirst(@ParametricNullness E e) {
        delegate().addFirst(e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    public void addLast(@ParametricNullness E e) {
        delegate().addLast(e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    public Iterator<E> descendingIterator() {
        return delegate().descendingIterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @ParametricNullness
    public E getFirst() {
        return delegate().getFirst();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @ParametricNullness
    public E getLast() {
        return delegate().getLast();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    public boolean offerFirst(@ParametricNullness E e) {
        return delegate().offerFirst(e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    public boolean offerLast(@ParametricNullness E e) {
        return delegate().offerLast(e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @CheckForNull
    public E peekFirst() {
        return delegate().peekFirst();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @CheckForNull
    public E peekLast() {
        return delegate().peekLast();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @CheckForNull
    public E pollFirst() {
        return delegate().pollFirst();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @CheckForNull
    public E pollLast() {
        return delegate().pollLast();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @ParametricNullness
    public E pop() {
        return delegate().pop();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    public void push(@ParametricNullness E e) {
        delegate().push(e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @ParametricNullness
    public E removeFirst() {
        return delegate().removeFirst();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    @ParametricNullness
    public E removeLast() {
        return delegate().removeLast();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    public boolean removeFirstOccurrence(@CheckForNull Object obj) {
        return delegate().removeFirstOccurrence(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Deque
    public boolean removeLastOccurrence(@CheckForNull Object obj) {
        return delegate().removeLastOccurrence(obj);
    }
}
