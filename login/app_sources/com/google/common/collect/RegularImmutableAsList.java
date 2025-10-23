package com.google.common.collect;

import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class RegularImmutableAsList<E> extends ImmutableAsList<E> {
    private final ImmutableCollection<E> delegate;
    private final ImmutableList<? extends E> delegateList;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, ImmutableList<? extends E> immutableList) {
        this.delegate = immutableCollection;
        this.delegateList = immutableList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RegularImmutableAsList(ImmutableCollection<E> immutableCollection, Object[] objArr, int i) {
        this(immutableCollection, ImmutableList.asImmutableList(objArr, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableAsList
    ImmutableCollection<E> delegateCollection() {
        return this.delegate;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ImmutableList<? extends E> delegateList() {
        return this.delegateList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableList, java.util.List
    public UnmodifiableListIterator<E> listIterator(int i) {
        return this.delegateList.listIterator(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i) {
        return this.delegateList.copyIntoArray(objArr, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableCollection
    @CheckForNull
    Object[] internalArray() {
        return this.delegateList.internalArray();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayStart() {
        return this.delegateList.internalArrayStart();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableCollection
    int internalArrayEnd() {
        return this.delegateList.internalArrayEnd();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.List
    public E get(int i) {
        return this.delegateList.get(i);
    }
}
