package com.google.firebase.concurrent;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;

/* loaded from: classes2.dex */
public enum UiExecutor implements Executor {
    INSTANCE;

    private static final Handler HANDLER = new Handler(Looper.getMainLooper());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        HANDLER.post(runnable);
    }
}
