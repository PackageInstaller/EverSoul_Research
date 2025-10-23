package com.google.firebase.crashlytics.ndk;

import android.content.Context;
import com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent;
import com.google.firebase.crashlytics.internal.Logger;
import com.google.firebase.crashlytics.internal.NativeSessionFileProvider;
import com.google.firebase.crashlytics.internal.model.StaticSessionData;
import com.google.firebase.crashlytics.internal.persistence.FileStore;

/* loaded from: classes2.dex */
class FirebaseCrashlyticsNdk implements CrashlyticsNativeComponent {
    private static FirebaseCrashlyticsNdk instance;
    private final CrashpadController controller;
    private String currentSessionId;
    private boolean installHandlerDuringPrepareSession;
    private SignalHandlerInstaller signalHandlerInstaller;

    /* JADX INFO: Access modifiers changed from: private */
    interface SignalHandlerInstaller {
        void installHandler();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static FirebaseCrashlyticsNdk create(Context context, boolean z) {
        FirebaseCrashlyticsNdk firebaseCrashlyticsNdk = new FirebaseCrashlyticsNdk(new CrashpadController(context, new JniNativeApi(context), new FileStore(context)), z);
        instance = firebaseCrashlyticsNdk;
        return firebaseCrashlyticsNdk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FirebaseCrashlyticsNdk(CrashpadController crashpadController, boolean z) {
        this.controller = crashpadController;
        this.installHandlerDuringPrepareSession = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean hasCrashDataForCurrentSession() {
        String str = this.currentSessionId;
        return str != null && hasCrashDataForSession(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public boolean hasCrashDataForSession(String str) {
        return this.controller.hasCrashDataForSession(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public synchronized void prepareNativeSession(final String str, final String str2, final long j, final StaticSessionData staticSessionData) {
        this.currentSessionId = str;
        SignalHandlerInstaller signalHandlerInstaller = new SignalHandlerInstaller() { // from class: com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.firebase.crashlytics.ndk.FirebaseCrashlyticsNdk.SignalHandlerInstaller
            public final void installHandler() {
                FirebaseCrashlyticsNdk.this.m405x251e82b0(str, str2, j, staticSessionData);
            }
        };
        this.signalHandlerInstaller = signalHandlerInstaller;
        if (this.installHandlerDuringPrepareSession) {
            signalHandlerInstaller.installHandler();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: lambda$prepareNativeSession$0$com-google-firebase-crashlytics-ndk-FirebaseCrashlyticsNdk */
    /* synthetic */ void m405x251e82b0(String str, String str2, long j, StaticSessionData staticSessionData) {
        Logger.getLogger().m390d("Initializing native session: " + str);
        if (this.controller.initialize(str, str2, j, staticSessionData)) {
            return;
        }
        Logger.getLogger().m398w("Failed to initialize Crashlytics NDK for session " + str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.crashlytics.internal.CrashlyticsNativeComponent
    public NativeSessionFileProvider getSessionFileProvider(String str) {
        return new SessionFilesProvider(this.controller.getFilesForSession(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void installSignalHandler() {
        SignalHandlerInstaller signalHandlerInstaller = this.signalHandlerInstaller;
        if (signalHandlerInstaller != null) {
            signalHandlerInstaller.installHandler();
            return;
        }
        if (this.installHandlerDuringPrepareSession) {
            Logger.getLogger().m398w("Native signal handler already installed; skipping re-install.");
        } else {
            Logger.getLogger().m390d("Deferring signal handler installation until the FirebaseCrashlyticsNdk session has been prepared");
            this.installHandlerDuringPrepareSession = true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static FirebaseCrashlyticsNdk getInstance() {
        FirebaseCrashlyticsNdk firebaseCrashlyticsNdk = instance;
        if (firebaseCrashlyticsNdk != null) {
            return firebaseCrashlyticsNdk;
        }
        throw new NullPointerException("FirebaseCrashlyticsNdk component is not present.");
    }
}
