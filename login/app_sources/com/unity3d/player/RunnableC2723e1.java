package com.unity3d.player;

/* renamed from: com.unity3d.player.e1 */
/* loaded from: classes3.dex */
final class RunnableC2723e1 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2735i1 f1356a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2723e1(C2735i1 c2735i1) {
        this.f1356a = c2735i1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        UnityPlayer unityPlayer;
        unityPlayer = this.f1356a.f1381a;
        unityPlayer.onPause();
    }
}
