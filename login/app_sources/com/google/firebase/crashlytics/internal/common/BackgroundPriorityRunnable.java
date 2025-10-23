package com.google.firebase.crashlytics.internal.common;

import android.os.Process;

/* loaded from: classes2.dex */
public abstract class BackgroundPriorityRunnable implements Runnable {
    protected abstract void onRun();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Process.setThreadPriority(10);
        onRun();
    }
}
