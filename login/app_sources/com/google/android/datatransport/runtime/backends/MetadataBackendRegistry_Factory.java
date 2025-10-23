package com.google.android.datatransport.runtime.backends;

import android.content.Context;
import com.google.android.datatransport.runtime.dagger.internal.Factory;
import javax.inject.Provider;

/* loaded from: classes.dex */
public final class MetadataBackendRegistry_Factory implements Factory<MetadataBackendRegistry> {
    private final Provider<Context> applicationContextProvider;
    private final Provider<CreationContextFactory> creationContextFactoryProvider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MetadataBackendRegistry_Factory(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        this.applicationContextProvider = provider;
        this.creationContextFactoryProvider = provider2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public MetadataBackendRegistry get() {
        return newInstance(this.applicationContextProvider.get(), this.creationContextFactoryProvider.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetadataBackendRegistry_Factory create(Provider<Context> provider, Provider<CreationContextFactory> provider2) {
        return new MetadataBackendRegistry_Factory(provider, provider2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MetadataBackendRegistry newInstance(Context context, Object obj) {
        return new MetadataBackendRegistry(context, (CreationContextFactory) obj);
    }
}
