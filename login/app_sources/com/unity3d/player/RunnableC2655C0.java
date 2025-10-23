package com.unity3d.player;

/* renamed from: com.unity3d.player.C0 */
/* loaded from: classes3.dex */
final class RunnableC2655C0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1153a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2655C0(UnityPlayer unityPlayer) {
        this.f1153a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        IUnityPlayerLifecycleEvents iUnityPlayerLifecycleEvents;
        this.f1153a.setupUnityToBePaused();
        this.f1153a.windowFocusChanged(false);
        iUnityPlayerLifecycleEvents = this.f1153a.m_UnityPlayerLifecycleEvents;
        iUnityPlayerLifecycleEvents.onUnityPlayerUnloaded();
    }
}
