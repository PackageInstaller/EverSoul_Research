package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import java.util.Comparator;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingSortedMap<K, V> extends ForwardingMap<K, V> implements SortedMap<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract SortedMap<K, V> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingSortedMap() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.SortedMap
    @CheckForNull
    public Comparator<? super K> comparator() {
        return delegate().comparator();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.SortedMap
    @ParametricNullness
    public K firstKey() {
        return delegate().firstKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.SortedMap
    public SortedMap<K, V> headMap(@ParametricNullness K k) {
        return delegate().headMap(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.SortedMap
    @ParametricNullness
    public K lastKey() {
        return delegate().lastKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.SortedMap
    public SortedMap<K, V> subMap(@ParametricNullness K k, @ParametricNullness K k2) {
        return delegate().subMap(k, k2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.SortedMap
    public SortedMap<K, V> tailMap(@ParametricNullness K k) {
        return delegate().tailMap(k);
    }

    protected class StandardKeySet extends Maps.SortedKeySet<K, V> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StandardKeySet(ForwardingSortedMap forwardingSortedMap) {
            super(forwardingSortedMap);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int unsafeCompare(@CheckForNull Comparator<?> comparator, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (comparator == null) {
            return ((Comparable) obj).compareTo(obj2);
        }
        return comparator.compare(obj, obj2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingMap
    protected boolean standardContainsKey(@CheckForNull Object obj) {
        try {
            return unsafeCompare(comparator(), tailMap(obj).firstKey(), obj) == 0;
        } catch (ClassCastException | NullPointerException | NoSuchElementException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected SortedMap<K, V> standardSubMap(K k, K k2) {
        Preconditions.checkArgument(unsafeCompare(comparator(), k, k2) <= 0, "fromKey must be <= toKey");
        return tailMap(k).headMap(k2);
    }
}
