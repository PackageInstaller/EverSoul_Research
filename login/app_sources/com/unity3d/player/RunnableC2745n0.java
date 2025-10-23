package com.unity3d.player;

/* renamed from: com.unity3d.player.n0 */
/* loaded from: classes3.dex */
final class RunnableC2745n0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1423a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2745n0(UnityPlayer unityPlayer) {
        this.f1423a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        C2734i0 c2734i0;
        c2734i0 = this.f1423a.mGlView;
        if (c2734i0 != null) {
            c2734i0.m795b();
        }
    }
}
