package com.unity3d.player;

/* renamed from: com.unity3d.player.f1 */
/* loaded from: classes3.dex */
final class RunnableC2726f1 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2735i1 f1361a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2726f1(C2735i1 c2735i1) {
        this.f1361a = c2735i1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a1;
        UnityPlayer unityPlayer;
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a12;
        C2735i1 c2735i1 = this.f1361a;
        surfaceHolderCallbackC2711a1 = c2735i1.f1386f;
        if (surfaceHolderCallbackC2711a1 != null) {
            unityPlayer = c2735i1.f1381a;
            unityPlayer.addViewToPlayer(surfaceHolderCallbackC2711a1, true);
            C2735i1 c2735i12 = this.f1361a;
            c2735i12.f1389i = true;
            surfaceHolderCallbackC2711a12 = c2735i12.f1386f;
            surfaceHolderCallbackC2711a12.requestFocus();
        }
    }
}
