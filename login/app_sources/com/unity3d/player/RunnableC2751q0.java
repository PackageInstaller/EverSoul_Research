package com.unity3d.player;

import android.graphics.Rect;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.q0 */
/* loaded from: classes3.dex */
final class RunnableC2751q0 implements Runnable {

    /* renamed from: a */
    boolean f1433a = false;

    /* renamed from: b */
    boolean f1434b = false;

    /* renamed from: c */
    final /* synthetic */ Semaphore f1435c;

    /* renamed from: d */
    final /* synthetic */ UnityPlayer f1436d;

    /* renamed from: e */
    final /* synthetic */ UnityPlayer f1437e;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2751q0(UnityPlayer unityPlayer, Semaphore semaphore, UnityPlayer unityPlayer2) {
        this.f1437e = unityPlayer;
        this.f1435c = semaphore;
        this.f1436d = unityPlayer2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1437e.reportSoftInputArea(new Rect());
        this.f1437e.reportSoftInputIsVisible(false);
        if (this.f1437e.mSoftInput != null) {
            this.f1436d.setOnHandleFocusListener(new C2747o0(this));
            UnityPlayer unityPlayer = this.f1437e;
            unityPlayer.mSoftInput.f1260g = new C2749p0(this);
            unityPlayer.dismissSoftInput();
        }
    }
}
