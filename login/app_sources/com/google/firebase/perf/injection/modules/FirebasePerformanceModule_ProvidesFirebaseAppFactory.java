package com.google.firebase.perf.injection.modules;

import com.google.firebase.FirebaseApp;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesFirebaseAppFactory implements Factory<FirebaseApp> {
    private final FirebasePerformanceModule module;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebasePerformanceModule_ProvidesFirebaseAppFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public FirebaseApp get() {
        return providesFirebaseApp(this.module);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FirebasePerformanceModule_ProvidesFirebaseAppFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesFirebaseAppFactory(firebasePerformanceModule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FirebaseApp providesFirebaseApp(FirebasePerformanceModule firebasePerformanceModule) {
        return (FirebaseApp) Preconditions.checkNotNull(firebasePerformanceModule.providesFirebaseApp(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
