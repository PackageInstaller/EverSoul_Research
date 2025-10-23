package com.google.common.collect;

import java.io.Serializable;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class ImmutableEntry<K, V> extends AbstractMapEntry<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    @ParametricNullness
    final K key;

    @ParametricNullness
    final V value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ImmutableEntry(@ParametricNullness K k, @ParametricNullness V v) {
        this.key = k;
        this.value = v;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @ParametricNullness
    public final K getKey() {
        return this.key;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @ParametricNullness
    public final V getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
    @ParametricNullness
    public final V setValue(@ParametricNullness V v) {
        throw new UnsupportedOperationException();
    }
}
