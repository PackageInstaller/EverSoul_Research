package com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingMultimap<K, V> extends ForwardingObject implements Multimap<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.collect.ForwardingObject
    public abstract Multimap<K, V> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingMultimap() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public Map<K, Collection<V>> asMap() {
        return delegate().asMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public void clear() {
        delegate().clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public boolean containsEntry(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().containsEntry(obj, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public boolean containsKey(@CheckForNull Object obj) {
        return delegate().containsKey(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public boolean containsValue(@CheckForNull Object obj) {
        return delegate().containsValue(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public Collection<Map.Entry<K, V>> entries() {
        return delegate().entries();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Collection<V> get(@ParametricNullness K k) {
        return delegate().get(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public boolean isEmpty() {
        return delegate().isEmpty();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public Multiset<K> keys() {
        return delegate().keys();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public Set<K> keySet() {
        return delegate().keySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public boolean put(@ParametricNullness K k, @ParametricNullness V v) {
        return delegate().put(k, v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public boolean putAll(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return delegate().putAll(k, iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public boolean putAll(Multimap<? extends K, ? extends V> multimap) {
        return delegate().putAll(multimap);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public boolean remove(@CheckForNull Object obj, @CheckForNull Object obj2) {
        return delegate().remove(obj, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Collection<V> removeAll(@CheckForNull Object obj) {
        return delegate().removeAll(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Collection<V> replaceValues(@ParametricNullness K k, Iterable<? extends V> iterable) {
        return delegate().replaceValues(k, iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public int size() {
        return delegate().size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public Collection<V> values() {
        return delegate().values();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public boolean equals(@CheckForNull Object obj) {
        return obj == this || delegate().equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Multimap
    public int hashCode() {
        return delegate().hashCode();
    }
}
