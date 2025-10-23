package com.unity3d.player;

/* renamed from: com.unity3d.player.X0 */
/* loaded from: classes3.dex */
final class RunnableC2698X0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ SurfaceHolderCallbackC2711a1 f1298a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2698X0(SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a1) {
        this.f1298a = surfaceHolderCallbackC2711a1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1298a.destroyPlayer();
        this.f1298a.m777a(3);
    }
}
