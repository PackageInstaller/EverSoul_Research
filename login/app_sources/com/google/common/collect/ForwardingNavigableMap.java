package com.google.common.collect;

import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.SortedMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingNavigableMap<K, V> extends ForwardingSortedMap<K, V> implements NavigableMap<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingSortedMap, com.google.common.collect.ForwardingMap, com.google.common.collect.ForwardingObject
    public abstract NavigableMap<K, V> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingNavigableMap() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lowerEntry(@ParametricNullness K k) {
        return delegate().lowerEntry(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected Map.Entry<K, V> standardLowerEntry(@ParametricNullness K k) {
        return headMap(k, false).lastEntry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public K lowerKey(@ParametricNullness K k) {
        return delegate().lowerKey(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected K standardLowerKey(@ParametricNullness K k) {
        return (K) Maps.keyOrNull(lowerEntry(k));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> floorEntry(@ParametricNullness K k) {
        return delegate().floorEntry(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected Map.Entry<K, V> standardFloorEntry(@ParametricNullness K k) {
        return headMap(k, true).lastEntry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public K floorKey(@ParametricNullness K k) {
        return delegate().floorKey(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected K standardFloorKey(@ParametricNullness K k) {
        return (K) Maps.keyOrNull(floorEntry(k));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> ceilingEntry(@ParametricNullness K k) {
        return delegate().ceilingEntry(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected Map.Entry<K, V> standardCeilingEntry(@ParametricNullness K k) {
        return tailMap(k, true).firstEntry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public K ceilingKey(@ParametricNullness K k) {
        return delegate().ceilingKey(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected K standardCeilingKey(@ParametricNullness K k) {
        return (K) Maps.keyOrNull(ceilingEntry(k));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> higherEntry(@ParametricNullness K k) {
        return delegate().higherEntry(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected Map.Entry<K, V> standardHigherEntry(@ParametricNullness K k) {
        return tailMap(k, false).firstEntry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public K higherKey(@ParametricNullness K k) {
        return delegate().higherKey(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected K standardHigherKey(@ParametricNullness K k) {
        return (K) Maps.keyOrNull(higherEntry(k));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> firstEntry() {
        return delegate().firstEntry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected Map.Entry<K, V> standardFirstEntry() {
        return (Map.Entry) Iterables.getFirst(entrySet(), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected K standardFirstKey() {
        Map.Entry<K, V> firstEntry = firstEntry();
        if (firstEntry == null) {
            throw new NoSuchElementException();
        }
        return firstEntry.getKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> lastEntry() {
        return delegate().lastEntry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected Map.Entry<K, V> standardLastEntry() {
        return (Map.Entry) Iterables.getFirst(descendingMap().entrySet(), null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected K standardLastKey() {
        Map.Entry<K, V> lastEntry = lastEntry();
        if (lastEntry == null) {
            throw new NoSuchElementException();
        }
        return lastEntry.getKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> pollFirstEntry() {
        return delegate().pollFirstEntry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected Map.Entry<K, V> standardPollFirstEntry() {
        return (Map.Entry) Iterators.pollNext(entrySet().iterator());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    @CheckForNull
    public Map.Entry<K, V> pollLastEntry() {
        return delegate().pollLastEntry();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected Map.Entry<K, V> standardPollLastEntry() {
        return (Map.Entry) Iterators.pollNext(descendingMap().entrySet().iterator());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    public NavigableMap<K, V> descendingMap() {
        return delegate().descendingMap();
    }

    protected class StandardDescendingMap extends Maps.DescendingMap<K, V> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StandardDescendingMap() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.Maps.DescendingMap
        NavigableMap<K, V> forward() {
            return ForwardingNavigableMap.this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.Maps.DescendingMap
        protected Iterator<Map.Entry<K, V>> entryIterator() {
            return new Iterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.ForwardingNavigableMap.StandardDescendingMap.1

                @CheckForNull
                private Map.Entry<K, V> nextOrNull;

                @CheckForNull
                private Map.Entry<K, V> toRemove = null;

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                {
                    this.nextOrNull = StandardDescendingMap.this.forward().lastEntry();
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.Iterator
                public boolean hasNext() {
                    return this.nextOrNull != null;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.Iterator
                public Map.Entry<K, V> next() {
                    Map.Entry<K, V> entry = this.nextOrNull;
                    if (entry == null) {
                        throw new NoSuchElementException();
                    }
                    this.toRemove = entry;
                    this.nextOrNull = StandardDescendingMap.this.forward().lowerEntry(this.nextOrNull.getKey());
                    return entry;
                }

                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.util.Iterator
                public void remove() {
                    if (this.toRemove == null) {
                        throw new IllegalStateException("no calls to next() since the last call to remove()");
                    }
                    StandardDescendingMap.this.forward().remove(this.toRemove.getKey());
                    this.toRemove = null;
                }
            };
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    public NavigableSet<K> navigableKeySet() {
        return delegate().navigableKeySet();
    }

    protected class StandardNavigableKeySet extends Maps.NavigableKeySet<K, V> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StandardNavigableKeySet(ForwardingNavigableMap forwardingNavigableMap) {
            super(forwardingNavigableMap);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    public NavigableSet<K> descendingKeySet() {
        return delegate().descendingKeySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected NavigableSet<K> standardDescendingKeySet() {
        return descendingMap().navigableKeySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ForwardingSortedMap
    protected SortedMap<K, V> standardSubMap(@ParametricNullness K k, @ParametricNullness K k2) {
        return subMap(k, true, k2, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    public NavigableMap<K, V> subMap(@ParametricNullness K k, boolean z, @ParametricNullness K k2, boolean z2) {
        return delegate().subMap(k, z, k2, z2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    public NavigableMap<K, V> headMap(@ParametricNullness K k, boolean z) {
        return delegate().headMap(k, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.NavigableMap
    public NavigableMap<K, V> tailMap(@ParametricNullness K k, boolean z) {
        return delegate().tailMap(k, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected SortedMap<K, V> standardHeadMap(@ParametricNullness K k) {
        return headMap(k, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected SortedMap<K, V> standardTailMap(@ParametricNullness K k) {
        return tailMap(k, true);
    }
}
