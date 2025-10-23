package com.google.firebase.perf.injection.modules;

import com.google.firebase.installations.FirebaseInstallationsApi;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory implements Factory<FirebaseInstallationsApi> {
    private final FirebasePerformanceModule module;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public FirebaseInstallationsApi get() {
        return providesFirebaseInstallations(this.module);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesFirebaseInstallationsFactory(firebasePerformanceModule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FirebaseInstallationsApi providesFirebaseInstallations(FirebasePerformanceModule firebasePerformanceModule) {
        return (FirebaseInstallationsApi) Preconditions.checkNotNull(firebasePerformanceModule.providesFirebaseInstallations(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
