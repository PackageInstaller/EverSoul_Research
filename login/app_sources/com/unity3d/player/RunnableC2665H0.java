package com.unity3d.player;

import android.app.Activity;
import android.os.SystemClock;
import android.view.KeyEvent;

/* renamed from: com.unity3d.player.H0 */
/* loaded from: classes3.dex */
final class RunnableC2665H0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1168a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2665H0(UnityPlayer unityPlayer) {
        this.f1168a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Activity activity;
        Activity activity2;
        long uptimeMillis = SystemClock.uptimeMillis();
        KeyEvent keyEvent = new KeyEvent(uptimeMillis, uptimeMillis, 0, 4, 1, 0, -1, 0, 0, 257);
        KeyEvent keyEvent2 = new KeyEvent(uptimeMillis, uptimeMillis + 1, 1, 4, 1, 0, -1, 0, 0, 257);
        activity = this.f1168a.mActivity;
        activity.dispatchKeyEvent(keyEvent);
        activity2 = this.f1168a.mActivity;
        activity2.dispatchKeyEvent(keyEvent2);
    }
}
