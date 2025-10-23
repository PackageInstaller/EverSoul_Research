package com.unity3d.player;

/* renamed from: com.unity3d.player.N0 */
/* loaded from: classes3.dex */
final class RunnableC2678N0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1201a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2678N0(UnityPlayer unityPlayer) {
        this.f1201a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1201a.destroy();
    }
}
