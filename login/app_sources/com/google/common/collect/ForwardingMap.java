package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.collect.Maps;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingMap<K, V> extends ForwardingObject implements Map<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Map<K, V> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingMap() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map
    public int size() {
        return delegate().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    public V remove(@CheckForNull Object obj) {
        return delegate().remove(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void clear() {
        delegate().clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map
    public boolean containsKey(@CheckForNull Object obj) {
        return delegate().containsKey(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean containsValue(@CheckForNull Object obj) {
        return delegate().containsValue(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map
    @CheckForNull
    public V get(@CheckForNull Object obj) {
        return delegate().get(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    public V put(@ParametricNullness K k, @ParametricNullness V v) {
        return delegate().put(k, v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void putAll(Map<? extends K, ? extends V> map) {
        delegate().putAll(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<K> keySet() {
        return delegate().keySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Collection<V> values() {
        return delegate().values();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Set<Map.Entry<K, V>> entrySet() {
        return delegate().entrySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map
    public int hashCode() {
        return delegate().hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void standardPutAll(Map<? extends K, ? extends V> map) {
        Maps.putAllImpl(this, map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    protected V standardRemove(@CheckForNull Object obj) {
        Iterator<Map.Entry<K, V>> it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<K, V> next = it.next();
            if (Objects.equal(next.getKey(), obj)) {
                V value = next.getValue();
                it.remove();
                return value;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void standardClear() {
        Iterators.clear(entrySet().iterator());
    }

    protected class StandardKeySet extends Maps.KeySet<K, V> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StandardKeySet(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardContainsKey(@CheckForNull Object obj) {
        return Maps.containsKeyImpl(this, obj);
    }

    protected class StandardValues extends Maps.Values<K, V> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StandardValues(ForwardingMap forwardingMap) {
            super(forwardingMap);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardContainsValue(@CheckForNull Object obj) {
        return Maps.containsValueImpl(this, obj);
    }

    protected abstract class StandardEntrySet extends Maps.EntrySet<K, V> {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public StandardEntrySet() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.Maps.EntrySet
        Map<K, V> map() {
            return ForwardingMap.this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardIsEmpty() {
        return !entrySet().iterator().hasNext();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean standardEquals(@CheckForNull Object obj) {
        return Maps.equalsImpl(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected int standardHashCode() {
        return Sets.hashCodeImpl(entrySet());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected String standardToString() {
        return Maps.toStringImpl(this);
    }
}
