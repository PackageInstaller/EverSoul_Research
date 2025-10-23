package com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingList<E> extends ForwardingCollection<E> implements List<E> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingCollection, com.google.common.collect.ForwardingObject
    public abstract List<E> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingList() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void add(int i, @ParametricNullness E e) {
        delegate().add(i, e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean addAll(int i, Collection<? extends E> collection) {
        return delegate().addAll(i, collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    @ParametricNullness
    public E get(int i) {
        return delegate().get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    public int indexOf(@CheckForNull Object obj) {
        return delegate().indexOf(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    public int lastIndexOf(@CheckForNull Object obj) {
        return delegate().lastIndexOf(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    public ListIterator<E> listIterator() {
        return delegate().listIterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    public ListIterator<E> listIterator(int i) {
        return delegate().listIterator(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    @ParametricNullness
    public E remove(int i) {
        return delegate().remove(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    @ParametricNullness
    public E set(int i, @ParametricNullness E e) {
        return delegate().set(i, e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    public List<E> subList(int i, int i2) {
        return delegate().subList(i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Collection, java.util.List
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Collection, java.util.List
    public int hashCode() {
        return delegate().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardAdd(@ParametricNullness E e) {
        add(size(), e);
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardAddAll(int i, Iterable<? extends E> iterable) {
        return Lists.addAllImpl(this, i, iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int standardIndexOf(@CheckForNull Object obj) {
        return Lists.indexOfImpl(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int standardLastIndexOf(@CheckForNull Object obj) {
        return Lists.lastIndexOfImpl(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Iterator<E> standardIterator() {
        return listIterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ListIterator<E> standardListIterator() {
        return listIterator(0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ListIterator<E> standardListIterator(int i) {
        return Lists.listIteratorImpl(this, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected List<E> standardSubList(int i, int i2) {
        return Lists.subListImpl(this, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardEquals(@CheckForNull Object obj) {
        return Lists.equalsImpl(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int standardHashCode() {
        return Lists.hashCodeImpl(this);
    }
}
