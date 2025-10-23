package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.inject.Provider;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* renamed from: com.google.firebase.perf.injection.modules.FirebasePerformanceModule_ProvidesTransportFactoryProviderFactory */
/* loaded from: classes2.dex */
public final class C1817x3dbbb29c implements Factory<Provider<TransportFactory>> {
    private final FirebasePerformanceModule module;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C1817x3dbbb29c(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public Provider<TransportFactory> get() {
        return providesTransportFactoryProvider(this.module);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static C1817x3dbbb29c create(FirebasePerformanceModule firebasePerformanceModule) {
        return new C1817x3dbbb29c(firebasePerformanceModule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Provider<TransportFactory> providesTransportFactoryProvider(FirebasePerformanceModule firebasePerformanceModule) {
        return (Provider) Preconditions.checkNotNull(firebasePerformanceModule.providesTransportFactoryProvider(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
