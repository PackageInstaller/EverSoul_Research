package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;
import com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory;
import java.util.Map;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MapProviderFactory<K, V> extends AbstractMapFactory<K, V, Provider<V>> implements Lazy<Map<K, Provider<V>>> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> Builder<K, V> builder(int i) {
        return new Builder<>(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapProviderFactory(Map<K, Provider<V>> map) {
        super(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public Map<K, Provider<V>> get() {
        return contributingMap();
    }

    public static final class Builder<K, V> extends AbstractMapFactory.Builder<K, V, Provider<V>> {
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public /* bridge */ /* synthetic */ AbstractMapFactory.Builder put(Object obj, Provider provider) {
            return put((Builder<K, V>) obj, provider);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Builder(int i) {
            super(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> put(K k, Provider<V> provider) {
            super.put((Builder<K, V>) k, (Provider) provider);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.datatransport.runtime.dagger.internal.AbstractMapFactory.Builder
        public Builder<K, V> putAll(Provider<Map<K, Provider<V>>> provider) {
            super.putAll((Provider) provider);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public MapProviderFactory<K, V> build() {
            return new MapProviderFactory<>(this.map);
        }
    }
}
