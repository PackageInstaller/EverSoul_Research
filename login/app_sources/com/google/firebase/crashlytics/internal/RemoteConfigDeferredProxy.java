package com.google.firebase.crashlytics.internal;

import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.firebase.inject.Deferred;
import com.google.firebase.inject.Provider;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import com.google.firebase.remoteconfig.interop.FirebaseRemoteConfigInterop;

/* loaded from: classes2.dex */
public class RemoteConfigDeferredProxy {
    private final Deferred<FirebaseRemoteConfigInterop> remoteConfigInteropDeferred;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RemoteConfigDeferredProxy(Deferred<FirebaseRemoteConfigInterop> deferred) {
        this.remoteConfigInteropDeferred = deferred;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setupListener(UserMetadata userMetadata) {
        if (userMetadata == null) {
            Logger.getLogger().m398w("Didn't successfully register with UserMetadata for rollouts listener");
        } else {
            final CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener = new CrashlyticsRemoteConfigListener(userMetadata);
            this.remoteConfigInteropDeferred.whenAvailable(new Deferred.DeferredHandler() { // from class: com.google.firebase.crashlytics.internal.RemoteConfigDeferredProxy$$ExternalSyntheticLambda0
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.firebase.inject.Deferred.DeferredHandler
                public final void handle(Provider provider) {
                    RemoteConfigDeferredProxy.lambda$setupListener$0(CrashlyticsRemoteConfigListener.this, provider);
                }
            });
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ void lambda$setupListener$0(CrashlyticsRemoteConfigListener crashlyticsRemoteConfigListener, Provider provider) {
        ((FirebaseRemoteConfigInterop) provider.get()).registerRolloutsStateSubscriber(RemoteConfigComponent.DEFAULT_NAMESPACE, crashlyticsRemoteConfigListener);
        Logger.getLogger().m390d("Registering RemoteConfig Rollouts subscriber");
    }
}
