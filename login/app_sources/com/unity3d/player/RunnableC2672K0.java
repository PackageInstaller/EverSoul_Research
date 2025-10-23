package com.unity3d.player;

/* renamed from: com.unity3d.player.K0 */
/* loaded from: classes3.dex */
final class RunnableC2672K0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1184a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2672K0(UnityPlayer unityPlayer) {
        this.f1184a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1184a.nativeSendSurfaceChangedEvent();
    }
}
