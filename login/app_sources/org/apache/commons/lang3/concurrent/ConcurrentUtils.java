package org.apache.commons.lang3.concurrent;

import com.liapp.y;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class ConcurrentUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ConcurrentUtils() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConcurrentException extractCause(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentException(executionException.getMessage(), executionException.getCause());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConcurrentRuntimeException extractCauseUnchecked(ExecutionException executionException) {
        if (executionException == null || executionException.getCause() == null) {
            return null;
        }
        throwCause(executionException);
        return new ConcurrentRuntimeException(executionException.getMessage(), executionException.getCause());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void handleCause(ExecutionException executionException) throws ConcurrentException {
        ConcurrentException extractCause = extractCause(executionException);
        if (extractCause != null) {
            throw extractCause;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void handleCauseUnchecked(ExecutionException executionException) {
        ConcurrentRuntimeException extractCauseUnchecked = extractCauseUnchecked(executionException);
        if (extractCauseUnchecked != null) {
            throw extractCauseUnchecked;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Throwable checkedException(Throwable th) {
        Validate.isTrue((th == null || (th instanceof RuntimeException) || (th instanceof Error)) ? false : true, y.֬ڱܱײٮ(-1159679335) + th, new Object[0]);
        return th;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void throwCause(ExecutionException executionException) {
        if (executionException.getCause() instanceof RuntimeException) {
            throw ((RuntimeException) executionException.getCause());
        }
        if (executionException.getCause() instanceof Error) {
            throw ((Error) executionException.getCause());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T initialize(ConcurrentInitializer<T> concurrentInitializer) throws ConcurrentException {
        if (concurrentInitializer != null) {
            return concurrentInitializer.get();
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T initializeUnchecked(ConcurrentInitializer<T> concurrentInitializer) {
        try {
            return (T) initialize(concurrentInitializer);
        } catch (ConcurrentException e) {
            throw new ConcurrentRuntimeException(e.getCause());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> V putIfAbsent(ConcurrentMap<K, V> concurrentMap, K k, V v) {
        if (concurrentMap == null) {
            return null;
        }
        V putIfAbsent = concurrentMap.putIfAbsent(k, v);
        return putIfAbsent != null ? putIfAbsent : v;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> V createIfAbsent(ConcurrentMap<K, V> concurrentMap, K k, ConcurrentInitializer<V> concurrentInitializer) throws ConcurrentException {
        if (concurrentMap == null || concurrentInitializer == null) {
            return null;
        }
        V v = concurrentMap.get(k);
        return v == null ? (V) putIfAbsent(concurrentMap, k, concurrentInitializer.get()) : v;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> V createIfAbsentUnchecked(ConcurrentMap<K, V> concurrentMap, K k, ConcurrentInitializer<V> concurrentInitializer) {
        try {
            return (V) createIfAbsent(concurrentMap, k, concurrentInitializer);
        } catch (ConcurrentException e) {
            throw new ConcurrentRuntimeException(e.getCause());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Future<T> constantFuture(T t) {
        return new ConstantFuture(t);
    }

    static final class ConstantFuture<T> implements Future<T> {
        private final T value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public boolean cancel(boolean z) {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public boolean isCancelled() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public boolean isDone() {
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ConstantFuture(T t) {
            this.value = t;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public T get() {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.concurrent.Future
        public T get(long j, TimeUnit timeUnit) {
            return this.value;
        }
    }
}
