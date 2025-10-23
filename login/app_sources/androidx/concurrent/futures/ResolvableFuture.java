package androidx.concurrent.futures;

import com.google.common.util.concurrent.ListenableFuture;

/* loaded from: classes.dex */
public final class ResolvableFuture<V> extends AbstractResolvableFuture<V> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <V> ResolvableFuture<V> create() {
        return new ResolvableFuture<>();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean set(V v) {
        return super.set(v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.concurrent.futures.AbstractResolvableFuture
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ResolvableFuture() {
    }
}
