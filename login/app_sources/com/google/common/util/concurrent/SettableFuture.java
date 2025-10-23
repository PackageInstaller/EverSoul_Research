package com.google.common.util.concurrent;

import com.google.common.util.concurrent.AbstractFuture;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class SettableFuture<V> extends AbstractFuture.TrustedFuture<V> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <V> SettableFuture<V> create() {
        return new SettableFuture<>();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean set(@ParametricNullness V v) {
        return super.set(v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setException(Throwable th) {
        return super.setException(th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.AbstractFuture
    public boolean setFuture(ListenableFuture<? extends V> listenableFuture) {
        return super.setFuture(listenableFuture);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SettableFuture() {
    }
}
