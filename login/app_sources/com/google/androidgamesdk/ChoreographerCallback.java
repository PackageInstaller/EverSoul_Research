package com.google.androidgamesdk;

import android.view.Choreographer;

/* loaded from: classes2.dex */
public class ChoreographerCallback implements Choreographer.FrameCallback {
    private static final String LOG_TAG = "ChoreographerCallback";
    private long mCookie;
    private C1187b mLooper;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ChoreographerCallback(long j) {
        this.mCookie = j;
        C1187b c1187b = new C1187b();
        this.mLooper = c1187b;
        c1187b.start();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        nOnChoreographer(this.mCookie, j);
    }

    public native void nOnChoreographer(long j, long j2);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void postFrameCallback() {
        this.mLooper.f278a.post(new RunnableC1186a(this));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void postFrameCallbackDelayed(long j) {
        Choreographer.getInstance().postFrameCallbackDelayed(this, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void terminate() {
        this.mLooper.f278a.getLooper().quit();
    }
}
