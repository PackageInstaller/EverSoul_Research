package com.google.common.cache;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableMap;
import java.util.concurrent.ExecutionException;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ForwardingLoadingCache<K, V> extends ForwardingCache<K, V> implements LoadingCache<K, V> {
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
    public abstract LoadingCache<K, V> delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ForwardingLoadingCache() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.cache.LoadingCache
    public V get(K k) throws ExecutionException {
        return delegate().get(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.cache.LoadingCache
    public V getUnchecked(K k) {
        return delegate().getUnchecked(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.cache.LoadingCache
    public ImmutableMap<K, V> getAll(Iterable<? extends K> iterable) throws ExecutionException {
        return delegate().getAll(iterable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
    public V apply(K k) {
        return delegate().apply(k);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.cache.LoadingCache
    public void refresh(K k) {
        delegate().refresh(k);
    }

    public static abstract class SimpleForwardingLoadingCache<K, V> extends ForwardingLoadingCache<K, V> {
        private final LoadingCache<K, V> delegate;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected SimpleForwardingLoadingCache(LoadingCache<K, V> loadingCache) {
            this.delegate = (LoadingCache) Preconditions.checkNotNull(loadingCache);
        }

        /* JADX INFO: Access modifiers changed from: protected */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.ForwardingLoadingCache, com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        public final LoadingCache<K, V> delegate() {
            return this.delegate;
        }
    }
}
