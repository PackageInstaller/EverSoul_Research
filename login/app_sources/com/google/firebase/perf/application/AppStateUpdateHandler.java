package com.google.firebase.perf.application;

import com.google.firebase.perf.application.AppStateMonitor;
import com.google.firebase.perf.p010v1.ApplicationProcessState;
import java.lang.ref.WeakReference;

/* loaded from: classes2.dex */
public abstract class AppStateUpdateHandler implements AppStateMonitor.AppStateCallback {
    private final WeakReference<AppStateMonitor.AppStateCallback> appStateCallback;
    private final AppStateMonitor appStateMonitor;
    private ApplicationProcessState currentAppState;
    private boolean isRegisteredForAppState;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AppStateUpdateHandler() {
        this(AppStateMonitor.getInstance());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AppStateUpdateHandler(AppStateMonitor appStateMonitor) {
        this.isRegisteredForAppState = false;
        this.currentAppState = ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN;
        this.appStateMonitor = appStateMonitor;
        this.appStateCallback = new WeakReference<>(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void registerForAppState() {
        if (this.isRegisteredForAppState) {
            return;
        }
        this.currentAppState = this.appStateMonitor.getAppState();
        this.appStateMonitor.registerForAppState(this.appStateCallback);
        this.isRegisteredForAppState = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void unregisterForAppState() {
        if (this.isRegisteredForAppState) {
            this.appStateMonitor.unregisterForAppState(this.appStateCallback);
            this.isRegisteredForAppState = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void incrementTsnsCount(int i) {
        this.appStateMonitor.incrementTsnsCount(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.firebase.perf.application.AppStateMonitor.AppStateCallback
    public void onUpdateAppState(ApplicationProcessState applicationProcessState) {
        if (this.currentAppState == ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN) {
            this.currentAppState = applicationProcessState;
        } else {
            if (this.currentAppState == applicationProcessState || applicationProcessState == ApplicationProcessState.APPLICATION_PROCESS_STATE_UNKNOWN) {
                return;
            }
            this.currentAppState = ApplicationProcessState.FOREGROUND_BACKGROUND;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ApplicationProcessState getAppState() {
        return this.currentAppState;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public WeakReference<AppStateMonitor.AppStateCallback> getAppStateCallback() {
        return this.appStateCallback;
    }
}
