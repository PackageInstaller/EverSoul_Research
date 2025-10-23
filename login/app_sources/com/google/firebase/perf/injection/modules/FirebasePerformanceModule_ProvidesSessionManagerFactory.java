package com.google.firebase.perf.injection.modules;

import com.google.firebase.perf.session.SessionManager;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

/* loaded from: classes2.dex */
public final class FirebasePerformanceModule_ProvidesSessionManagerFactory implements Factory<SessionManager> {
    private final FirebasePerformanceModule module;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebasePerformanceModule_ProvidesSessionManagerFactory(FirebasePerformanceModule firebasePerformanceModule) {
        this.module = firebasePerformanceModule;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // javax.inject.Provider
    public SessionManager get() {
        return providesSessionManager(this.module);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FirebasePerformanceModule_ProvidesSessionManagerFactory create(FirebasePerformanceModule firebasePerformanceModule) {
        return new FirebasePerformanceModule_ProvidesSessionManagerFactory(firebasePerformanceModule);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SessionManager providesSessionManager(FirebasePerformanceModule firebasePerformanceModule) {
        return (SessionManager) Preconditions.checkNotNull(firebasePerformanceModule.providesSessionManager(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
