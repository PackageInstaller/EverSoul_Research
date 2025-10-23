package dagger.internal;

import dagger.Lazy;
import javax.inject.Provider;

/* loaded from: classes3.dex */
public final class ProviderOfLazy<T> implements Provider<Lazy<T>> {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    private final Provider<T> provider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ProviderOfLazy(Provider<T> provider) {
        this.provider = provider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public Lazy<T> get() {
        return DoubleCheck.lazy(this.provider);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Provider<Lazy<T>> create(Provider<T> provider) {
        return new ProviderOfLazy((Provider) Preconditions.checkNotNull(provider));
    }
}
