package com.unity.purchasing.common;

import android.os.Handler;
import android.os.Looper;

/* loaded from: classes3.dex */
public class DelayedHandler implements IDelayedExecutor {
    private Handler handler = new Handler(Looper.getMainLooper());

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity.purchasing.common.IDelayedExecutor
    public void ExecuteDelayed(Runnable runnable, long j) {
        this.handler.postDelayed(runnable, j);
    }
}
