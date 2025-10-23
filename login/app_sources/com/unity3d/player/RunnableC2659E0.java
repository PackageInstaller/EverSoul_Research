package com.unity3d.player;

/* renamed from: com.unity3d.player.E0 */
/* loaded from: classes3.dex */
final class RunnableC2659E0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ float f1160a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f1161b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2659E0(UnityPlayer unityPlayer, float f) {
        this.f1161b = unityPlayer;
        this.f1160a = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        C2734i0 c2734i0;
        c2734i0 = this.f1161b.mGlView;
        c2734i0.m794a(this.f1160a);
    }
}
