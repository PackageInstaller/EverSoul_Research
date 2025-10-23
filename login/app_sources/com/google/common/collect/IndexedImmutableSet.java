package com.google.common.collect;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class IndexedImmutableSet<E> extends ImmutableSet<E> {
    abstract E get(int i);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    IndexedImmutableSet() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public UnmodifiableIterator<E> iterator() {
        return asList().iterator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableCollection
    int copyIntoArray(Object[] objArr, int i) {
        return asList().copyIntoArray(objArr, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableSet
    ImmutableList<E> createAsList() {
        return new ImmutableList<E>() { // from class: com.google.common.collect.IndexedImmutableSet.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.List
            public E get(int i) {
                return (E) IndexedImmutableSet.this.get(i);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.collect.ImmutableCollection
            boolean isPartialView() {
                return IndexedImmutableSet.this.isPartialView();
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
            public int size() {
                return IndexedImmutableSet.this.size();
            }
        };
    }
}
