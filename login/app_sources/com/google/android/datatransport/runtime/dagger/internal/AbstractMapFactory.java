package com.google.android.datatransport.runtime.dagger.internal;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
abstract class AbstractMapFactory<K, V, V2> implements Factory<Map<K, V2>> {
    private final Map<K, Provider<V>> contributingMap;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AbstractMapFactory(Map<K, Provider<V>> map) {
        this.contributingMap = Collections.unmodifiableMap(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Map<K, Provider<V>> contributingMap() {
        return this.contributingMap;
    }

    public static abstract class Builder<K, V, V2> {
        final LinkedHashMap<K, Provider<V>> map;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder(int i) {
            this.map = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder<K, V, V2> put(K k, Provider<V> provider) {
            this.map.put(Preconditions.checkNotNull(k, "key"), Preconditions.checkNotNull(provider, "provider"));
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder<K, V, V2> putAll(Provider<Map<K, V2>> provider) {
            if (!(provider instanceof DelegateFactory)) {
                this.map.putAll(((AbstractMapFactory) provider).contributingMap);
                return this;
            }
            return putAll(((DelegateFactory) provider).getDelegate());
        }
    }
}
