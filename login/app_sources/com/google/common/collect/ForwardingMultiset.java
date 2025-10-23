package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingMultiset<E> extends ForwardingCollection<E> implements Multiset<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract Multiset<E> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingMultiset() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multiset
    public int count(@CheckForNull Object obj) {
        return delegate().count(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multiset
    public int add(@ParametricNullness E e, int i) {
        return delegate().add(e, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multiset
    public int remove(@CheckForNull Object obj, int i) {
        return delegate().remove(obj, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<E> elementSet() {
        return delegate().elementSet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<Multiset.Entry<E>> entrySet() {
        return delegate().entrySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Collection, com.google.common.collect.Multiset
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Collection, com.google.common.collect.Multiset
    public int hashCode() {
        return delegate().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multiset
    public int setCount(@ParametricNullness E e, int i) {
        return delegate().setCount(e, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multiset
    public boolean setCount(@ParametricNullness E e, int i, int i2) {
        return delegate().setCount(e, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardContains(@CheckForNull Object obj) {
        return count(obj) > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingCollection
    protected void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int standardCount(@CheckForNull Object obj) {
        for (Multiset.Entry<E> entry : entrySet()) {
            if (Objects.equal(entry.getElement(), obj)) {
                return entry.getCount();
            }
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardAdd(@ParametricNullness E e) {
        add(e, 1);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardAddAll(Collection<? extends E> collection) {
        return Multisets.addAllImpl(this, collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemove(@CheckForNull Object obj) {
        return remove(obj, 1) > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRemoveAll(Collection<?> collection) {
        return Multisets.removeAllImpl(this, collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingCollection
    protected boolean standardRetainAll(Collection<?> collection) {
        return Multisets.retainAllImpl(this, collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int standardSetCount(@ParametricNullness E e, int i) {
        return Multisets.setCountImpl(this, e, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardSetCount(@ParametricNullness E e, int i, int i2) {
        return Multisets.setCountImpl(this, e, i, i2);
    }

    protected class StandardElementSet extends Multisets.ElementSet<E> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StandardElementSet() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.Multisets.ElementSet
        Multiset<E> multiset() {
            return ForwardingMultiset.this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.Multisets.ElementSet, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator<E> iterator() {
            return Multisets.elementIterator(multiset().entrySet().iterator());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Iterator<E> standardIterator() {
        return Multisets.iteratorImpl(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int standardSize() {
        return Multisets.linearTimeSizeImpl(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardEquals(@CheckForNull Object obj) {
        return Multisets.equalsImpl(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int standardHashCode() {
        return entrySet().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingCollection
    protected String standardToString() {
        return entrySet().toString();
    }
}
