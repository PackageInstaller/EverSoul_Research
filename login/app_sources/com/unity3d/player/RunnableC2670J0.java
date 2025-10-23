package com.unity3d.player;

import com.unity3d.player.p030a.C2709f;

/* renamed from: com.unity3d.player.J0 */
/* loaded from: classes3.dex */
final class RunnableC2670J0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1181a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2670J0(UnityPlayer unityPlayer) {
        this.f1181a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        C2709f c2709f;
        UnityPlayer unityPlayer = this.f1181a;
        c2709f = unityPlayer.m_SplashScreen;
        unityPlayer.removeView(c2709f);
        this.f1181a.m_SplashScreen = null;
    }
}
