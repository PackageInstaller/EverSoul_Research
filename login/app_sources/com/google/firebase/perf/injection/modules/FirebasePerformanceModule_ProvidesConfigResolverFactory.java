package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.config.ConfigResolver;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesConfigResolverFactory implements Factory<ConfigResolver> {
    private final FirebasePerformanceModule module;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebasePerformanceModule_ProvidesConfigResolverFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public ConfigResolver get() {
        return providesConfigResolver(this.module);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FirebasePerformanceModule_ProvidesConfigResolverFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesConfigResolverFactory(firebasePerformanceModule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ConfigResolver providesConfigResolver(FirebasePerformanceModule firebasePerformanceModule) {
        return (ConfigResolver) Preconditions.checkNotNull(firebasePerformanceModule.providesConfigResolver(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
