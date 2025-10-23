package com.unity3d.player;

/* renamed from: com.unity3d.player.V0 */
/* loaded from: classes3.dex */
abstract class AbstractRunnableC2694V0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ UnityPlayer f1288a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AbstractRunnableC2694V0(UnityPlayer unityPlayer) {
        this.f1288a = unityPlayer;
    }

    /* renamed from: a */
    public abstract void mo761a();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        if (this.f1288a.isFinishing()) {
            return;
        }
        mo761a();
    }
}
