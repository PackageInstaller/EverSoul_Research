package com.google.android.datatransport.runtime.dagger.internal;

import com.google.android.datatransport.runtime.dagger.Lazy;

/* loaded from: classes.dex */
public final class InstanceFactory<T> implements Factory<T>, Lazy<T> {
    private static final InstanceFactory<Object> NULL_INSTANCE_FACTORY = new InstanceFactory<>(null);
    private final T instance;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Factory<T> create(T t) {
        return new InstanceFactory(Preconditions.checkNotNull(t, "instance cannot be null"));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Factory<T> createNullable(T t) {
        if (t == null) {
            return nullInstanceFactory();
        }
        return new InstanceFactory(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> InstanceFactory<T> nullInstanceFactory() {
        return (InstanceFactory<T>) NULL_INSTANCE_FACTORY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private InstanceFactory(T t) {
        this.instance = t;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public T get() {
        return this.instance;
    }
}
