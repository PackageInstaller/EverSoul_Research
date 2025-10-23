package dagger.internal;

import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class DelegateFactory<T> implements Factory<T> {
    private Provider<T> delegate;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public T get() {
        Provider<T> provider = this.delegate;
        if (provider == null) {
            throw new IllegalStateException();
        }
        return provider.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void setDelegatedProvider(Provider<T> provider) {
        setDelegate(this, provider);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> void setDelegate(Provider<T> provider, Provider<T> provider2) {
        Preconditions.checkNotNull(provider2);
        DelegateFactory delegateFactory = (DelegateFactory) provider;
        if (delegateFactory.delegate != null) {
            throw new IllegalStateException();
        }
        delegateFactory.delegate = provider2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Provider<T> getDelegate() {
        return (Provider) Preconditions.checkNotNull(this.delegate);
    }
}
