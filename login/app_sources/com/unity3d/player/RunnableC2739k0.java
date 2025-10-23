package com.unity3d.player;

/* renamed from: com.unity3d.player.k0 */
/* loaded from: classes3.dex */
final class RunnableC2739k0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1396a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2739k0(UnityPlayer unityPlayer) {
        this.f1396a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1396a.nativeResume();
    }
}
