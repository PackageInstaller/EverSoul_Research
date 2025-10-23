package com.unity3d.player;

/* renamed from: com.unity3d.player.j0 */
/* loaded from: classes3.dex */
final class RunnableC2737j0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1392a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2737j0(UnityPlayer unityPlayer) {
        this.f1392a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1392a.nativeLowMemory();
    }
}
