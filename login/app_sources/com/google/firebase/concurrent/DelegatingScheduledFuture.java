package com.google.firebase.concurrent;

import androidx.concurrent.futures.AbstractResolvableFuture;
import java.util.concurrent.Delayed;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
class DelegatingScheduledFuture<V> extends AbstractResolvableFuture<V> implements ScheduledFuture<V> {
    private final ScheduledFuture<?> upstreamFuture;

    interface Completer<T> {
        void set(T t);

        void setException(Throwable th);
    }

    interface Resolver<T> {
        ScheduledFuture<?> addCompleter(Completer<T> completer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DelegatingScheduledFuture(Resolver<V> resolver) {
        this.upstreamFuture = resolver.addCompleter(new Completer<V>() { // from class: com.google.firebase.concurrent.DelegatingScheduledFuture.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Completer
            public void set(V v) {
                DelegatingScheduledFuture.this.set(v);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.firebase.concurrent.DelegatingScheduledFuture.Completer
            public void setException(Throwable th) {
                DelegatingScheduledFuture.this.setException(th);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    protected void afterDone() {
        this.upstreamFuture.cancel(wasInterrupted());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Delayed
    public long getDelay(TimeUnit timeUnit) {
        return this.upstreamFuture.getDelay(timeUnit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(Delayed delayed) {
        return this.upstreamFuture.compareTo(delayed);
    }
}
