package com.google.common.cache;

import com.google.common.base.Preconditions;
import java.util.AbstractMap;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class RemovalNotification<K, V> extends AbstractMap.SimpleImmutableEntry<K, V> {
    private static final long serialVersionUID = 0;
    private final RemovalCause cause;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> RemovalNotification<K, V> create(@CheckForNull K k, @CheckForNull V v, RemovalCause removalCause) {
        return new RemovalNotification<>(k, v, removalCause);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private RemovalNotification(@CheckForNull K k, @CheckForNull V v, RemovalCause removalCause) {
        super(k, v);
        this.cause = (RemovalCause) Preconditions.checkNotNull(removalCause);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RemovalCause getCause() {
        return this.cause;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean wasEvicted() {
        return this.cause.wasEvicted();
    }
}
