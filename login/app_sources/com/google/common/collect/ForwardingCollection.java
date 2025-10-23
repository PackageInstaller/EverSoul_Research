package com.google.common.collect;

import com.google.common.base.Objects;
import java.util.Collection;
import java.util.Iterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingCollection<E> extends ForwardingObject implements Collection<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Collection<E> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingCollection() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Iterator<E> iterator() {
        return delegate().iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Collection
    public int size() {
        return delegate().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean removeAll(Collection<?> collection) {
        return delegate().removeAll(collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Collection
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(@CheckForNull Object obj) {
        return delegate().contains(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean add(@ParametricNullness E e) {
        return delegate().add(e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean remove(@CheckForNull Object obj) {
        return delegate().remove(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean containsAll(Collection<?> collection) {
        return delegate().containsAll(collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean addAll(Collection<? extends E> collection) {
        return delegate().addAll(collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean retainAll(Collection<?> collection) {
        return delegate().retainAll(collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        delegate().clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object[] toArray() {
        return delegate().toArray();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T> T[] toArray(T[] tArr) {
        return (T[]) delegate().toArray(tArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardContains(@CheckForNull Object obj) {
        return Iterators.contains(iterator(), obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardContainsAll(Collection<?> collection) {
        return Collections2.containsAllImpl(this, collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardAddAll(Collection<? extends E> collection) {
        return Iterators.addAll(this, collection.iterator());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardRemove(@CheckForNull Object obj) {
        Iterator<E> it = iterator();
        while (it.hasNext()) {
            if (Objects.equal(it.next(), obj)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardRemoveAll(Collection<?> collection) {
        return Iterators.removeAll(iterator(), collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardRetainAll(Collection<?> collection) {
        return Iterators.retainAll(iterator(), collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void standardClear() {
        Iterators.clear(iterator());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardIsEmpty() {
        return !iterator().hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String standardToString() {
        return Collections2.toStringImpl(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Object[] standardToArray() {
        return toArray(new Object[size()]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected <T> T[] standardToArray(T[] tArr) {
        return (T[]) ObjectArrays.toArrayImpl(this, tArr);
    }
}
