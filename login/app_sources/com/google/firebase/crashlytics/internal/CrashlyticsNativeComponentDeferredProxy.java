package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import java.io.File;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: classes2.dex */
public final class CrashlyticsNativeComponentDeferredProxy implements CrashlyticsNativeComponent {
    private static final NativeSessionFileProvider MISSING_NATIVE_SESSION_FILE_PROVIDER = new MissingNativeSessionFileProvider();
    private final AtomicReference<CrashlyticsNativeComponent> availableNativeComponent = new AtomicReference<>(null);
    private final Deferred<CrashlyticsNativeComponent> deferredNativeComponent;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CrashlyticsNativeComponentDeferredProxy(Deferred<CrashlyticsNativeComponent> deferred) {
        this.deferredNativeComponent = deferred;
        deferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                CrashlyticsNativeComponentDeferredProxy.this.m389x5c12a4b9(provider);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$new$0$com-google-firebase-crashlytics-internal-CrashlyticsNativeComponentDeferredProxy */
    /* synthetic */ void m389x5c12a4b9(Provider provider) {
        Logger.getLogger().m390d("Crashlytics native component now available.");
        this.availableNativeComponent.set((CrashlyticsNativeComponent) provider.get());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean hasCrashDataForCurrentSession() {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.hasCrashDataForCurrentSession();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean hasCrashDataForSession(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        return crashlyticsNativeComponent != null && crashlyticsNativeComponent.hasCrashDataForSession(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public void prepareNativeSession(final String str, final String str2, final long j, final StaticSessionData staticSessionData) {
        Logger.getLogger().m396v("Deferring native open session: " + str);
        this.deferredNativeComponent.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.CrashlyticsNativeComponentDeferredProxy$$ExternalSyntheticLambda1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.firebase.inject.Deferred.DeferredHandler
            public final void handle(Provider provider) {
                ((CrashlyticsNativeComponent) provider.get()).prepareNativeSession(str, str2, j, staticSessionData);
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public NativeSessionFileProvider getSessionFileProvider(String str) {
        CrashlyticsNativeComponent crashlyticsNativeComponent = this.availableNativeComponent.get();
        if (crashlyticsNativeComponent == null) {
            return MISSING_NATIVE_SESSION_FILE_PROVIDER;
        }
        return crashlyticsNativeComponent.getSessionFileProvider(str);
    }

    private static final class MissingNativeSessionFileProvider implements NativeSessionFileProvider {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getAppFile() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public CrashlyticsReport.ApplicationExitInfo getApplicationExitInto() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getBinaryImagesFile() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getDeviceFile() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getMetadataFile() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getMinidumpFile() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getOsFile() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.firebase.crashlytics.internal.NativeSessionFileProvider
        public File getSessionFile() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private MissingNativeSessionFileProvider() {
        }
    }
}
