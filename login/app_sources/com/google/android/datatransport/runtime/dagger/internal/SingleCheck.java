package com.google.android.datatransport.runtime.dagger.internal;

import javax.inject.Provider;

/* loaded from: classes.dex */
public final class SingleCheck<T> implements Provider<T> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private static final Object UNINITIALIZED = new Object();
    private volatile Object instance = UNINITIALIZED;
    private volatile Provider<T> provider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SingleCheck(Provider<T> provider) {
        this.provider = provider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public T get() {
        T t = (T) this.instance;
        if (t != UNINITIALIZED) {
            return t;
        }
        Provider<T> provider = this.provider;
        if (provider == null) {
            return (T) this.instance;
        }
        T t2 = provider.get();
        this.instance = t2;
        this.provider = null;
        return t2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <P extends Provider<T>, T> Provider<T> provider(P p) {
        return ((p instanceof SingleCheck) || (p instanceof DoubleCheck)) ? p : new SingleCheck((Provider) Preconditions.checkNotNull(p));
    }
}
