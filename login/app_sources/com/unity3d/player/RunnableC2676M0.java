package com.unity3d.player;

/* renamed from: com.unity3d.player.M0 */
/* loaded from: classes3.dex */
final class RunnableC2676M0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1198a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2676M0(UnityPlayer unityPlayer) {
        this.f1198a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        boolean z;
        C2734i0 c2734i0;
        C2734i0 c2734i02;
        C2734i0 c2734i03;
        UnityPlayer unityPlayer = this.f1198a;
        z = unityPlayer.mMainDisplayOverride;
        if (z) {
            c2734i03 = unityPlayer.mGlView;
            unityPlayer.removeView(c2734i03);
            return;
        }
        c2734i0 = unityPlayer.mGlView;
        if (c2734i0.getParent() != null) {
            AbstractC2768z.Log(5, "Couldn't add view, because it's already assigned to another parent");
            return;
        }
        UnityPlayer unityPlayer2 = this.f1198a;
        c2734i02 = unityPlayer2.mGlView;
        unityPlayer2.addView(c2734i02);
    }
}
