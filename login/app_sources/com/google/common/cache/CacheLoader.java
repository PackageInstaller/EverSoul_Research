package com.google.common.cache;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.ListenableFutureTask;
import com.google.errorprone.annotations.CheckReturnValue;
import java.io.Serializable;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class CacheLoader<K, V> {
    public abstract V load(K k) throws Exception;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected CacheLoader() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ListenableFuture<V> reload(K k, V v) throws Exception {
        Preconditions.checkNotNull(k);
        Preconditions.checkNotNull(v);
        return Futures.immediateFuture(load(k));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
        throw new UnsupportedLoadingOperationException();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckReturnValue
    public static <K, V> CacheLoader<K, V> from(Function<K, V> function) {
        return new FunctionToCacheLoader(function);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckReturnValue
    public static <V> CacheLoader<Object, V> from(Supplier<V> supplier) {
        return new SupplierToCacheLoader(supplier);
    }

    private static final class FunctionToCacheLoader<K, V> extends CacheLoader<K, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Function<K, V> computingFunction;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FunctionToCacheLoader(Function<K, V> function) {
            this.computingFunction = (Function) Preconditions.checkNotNull(function);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.CacheLoader
        public V load(K k) {
            return (V) this.computingFunction.apply(Preconditions.checkNotNull(k));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckReturnValue
    public static <K, V> CacheLoader<K, V> asyncReloading(CacheLoader<K, V> cacheLoader, final Executor executor) {
        Preconditions.checkNotNull(cacheLoader);
        Preconditions.checkNotNull(executor);
        return new CacheLoader<K, V>() { // from class: com.google.common.cache.CacheLoader.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.cache.CacheLoader
            public V load(K k) throws Exception {
                return (V) CacheLoader.this.load(k);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.cache.CacheLoader
            public ListenableFuture<V> reload(final K k, final V v) throws Exception {
                ListenableFutureTask create = ListenableFutureTask.create(new Callable<V>() { // from class: com.google.common.cache.CacheLoader.1.1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // java.util.concurrent.Callable
                    public V call() throws Exception {
                        return CacheLoader.this.reload(k, v).get();
                    }
                });
                executor.execute(create);
                return create;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.cache.CacheLoader
            public Map<K, V> loadAll(Iterable<? extends K> iterable) throws Exception {
                return CacheLoader.this.loadAll(iterable);
            }
        };
    }

    private static final class SupplierToCacheLoader<V> extends CacheLoader<Object, V> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<V> computingSupplier;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SupplierToCacheLoader(Supplier<V> supplier) {
            this.computingSupplier = (Supplier) Preconditions.checkNotNull(supplier);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.cache.CacheLoader
        public V load(Object obj) {
            Preconditions.checkNotNull(obj);
            return this.computingSupplier.get();
        }
    }

    public static final class UnsupportedLoadingOperationException extends UnsupportedOperationException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        UnsupportedLoadingOperationException() {
        }
    }

    public static final class InvalidCacheLoadException extends RuntimeException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public InvalidCacheLoadException(String str) {
            super(str);
        }
    }
}
