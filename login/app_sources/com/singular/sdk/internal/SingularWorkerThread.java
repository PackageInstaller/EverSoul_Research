package com.singular.sdk.internal;

import android.os.Handler;
import android.os.HandlerThread;

/* loaded from: classes3.dex */
public class SingularWorkerThread extends HandlerThread {
    private Handler handler;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SingularWorkerThread(String str) {
        super(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Handler getHandler() {
        ensureInit();
        return this.handler;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void post(Runnable runnable) {
        getHandler().post(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void postDelayed(Runnable runnable, int i) {
        getHandler().postDelayed(runnable, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void postAtFront(Runnable runnable) {
        getHandler().postAtFrontOfQueue(runnable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized void ensureInit() {
        if (this.handler == null) {
            this.handler = new Handler(getLooper());
        }
    }
}
