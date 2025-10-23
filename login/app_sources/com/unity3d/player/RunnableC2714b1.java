package com.unity3d.player;

/* renamed from: com.unity3d.player.b1 */
/* loaded from: classes3.dex */
final class RunnableC2714b1 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2717c1 f1339a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2714b1(C2717c1 c2717c1) {
        this.f1339a = c2717c1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a1;
        UnityPlayer unityPlayer;
        UnityPlayer unityPlayer2;
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a12;
        InterfaceC2732h1 interfaceC2732h1;
        C2735i1 c2735i1 = this.f1339a.f1345a.f1354h;
        surfaceHolderCallbackC2711a1 = c2735i1.f1386f;
        if (surfaceHolderCallbackC2711a1 != null) {
            unityPlayer2 = c2735i1.f1381a;
            unityPlayer2.removeViewFromPlayer(surfaceHolderCallbackC2711a1);
            c2735i1.f1389i = false;
            surfaceHolderCallbackC2711a12 = c2735i1.f1386f;
            surfaceHolderCallbackC2711a12.destroyPlayer();
            c2735i1.f1386f = null;
            interfaceC2732h1 = c2735i1.f1383c;
            if (interfaceC2732h1 != null) {
                ((C2651A0) interfaceC2732h1).m726a();
            }
        }
        unityPlayer = this.f1339a.f1345a.f1354h.f1381a;
        unityPlayer.onResume();
    }
}
