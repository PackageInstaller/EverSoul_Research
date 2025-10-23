package com.google.androidgamesdk;

import android.view.Choreographer;

/* renamed from: com.google.androidgamesdk.a */
/* loaded from: classes2.dex */
final class RunnableC1186a implements Runnable {

    /* renamed from: a */
    final /* synthetic */ ChoreographerCallback f277a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC1186a(ChoreographerCallback choreographerCallback) {
        this.f277a = choreographerCallback;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Choreographer.getInstance().postFrameCallback(this.f277a);
    }
}
