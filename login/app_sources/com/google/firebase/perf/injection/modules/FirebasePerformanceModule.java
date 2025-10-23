package com.google.firebase.perf.injection.modules;

import com.google.android.datatransport.TransportFactory;
import com.google.firebase.FirebaseApp;
import com.google.firebase.inject.Provider;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.perf.config.ConfigResolver;
import com.google.firebase.perf.config.RemoteConfigManager;
import com.google.firebase.perf.session.SessionManager;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import dagger.Module;
import dagger.Provides;

@Module
/* loaded from: classes2.dex */
public class FirebasePerformanceModule {
    private final FirebaseApp firebaseApp;
    private final FirebaseInstallationsApi firebaseInstallations;
    private final Provider<RemoteConfigComponent> remoteConfigComponentProvider;
    private final Provider<TransportFactory> transportFactoryProvider;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FirebasePerformanceModule(FirebaseApp firebaseApp, FirebaseInstallationsApi firebaseInstallationsApi, Provider<RemoteConfigComponent> provider, Provider<TransportFactory> provider2) {
        this.firebaseApp = firebaseApp;
        this.firebaseInstallations = firebaseInstallationsApi;
        this.remoteConfigComponentProvider = provider;
        this.transportFactoryProvider = provider2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    FirebaseApp providesFirebaseApp() {
        return this.firebaseApp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    FirebaseInstallationsApi providesFirebaseInstallations() {
        return this.firebaseInstallations;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    Provider<RemoteConfigComponent> providesRemoteConfigComponent() {
        return this.remoteConfigComponentProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    Provider<TransportFactory> providesTransportFactoryProvider() {
        return this.transportFactoryProvider;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    RemoteConfigManager providesRemoteConfigManager() {
        return RemoteConfigManager.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    ConfigResolver providesConfigResolver() {
        return ConfigResolver.getInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Provides
    SessionManager providesSessionManager() {
        return SessionManager.getInstance();
    }
}
