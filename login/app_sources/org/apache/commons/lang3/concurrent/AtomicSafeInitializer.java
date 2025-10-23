package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import kotlin.UByte$$ExternalSyntheticBackport0;

/* loaded from: classes2.dex */
public abstract class AtomicSafeInitializer<T> implements ConcurrentInitializer<T> {
    private final AtomicReference<AtomicSafeInitializer<T>> factory = new AtomicReference<>();
    private final AtomicReference<T> reference = new AtomicReference<>();

    protected abstract T initialize() throws ConcurrentException;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.ConcurrentInitializer
    public final T get() throws ConcurrentException {
        while (true) {
            T t = this.reference.get();
            if (t != null) {
                return t;
            }
            if (UByte$$ExternalSyntheticBackport0.m850m(this.factory, null, this)) {
                this.reference.set(initialize());
            }
        }
    }
}
