package com.unity3d.player;

/* renamed from: com.unity3d.player.t0 */
/* loaded from: classes3.dex */
final class RunnableC2757t0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ boolean f1445a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f1446b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2757t0(UnityPlayer unityPlayer, boolean z) {
        this.f1446b = unityPlayer;
        this.f1445a = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        AbstractC2687S abstractC2687S = this.f1446b.mSoftInput;
        if (abstractC2687S != null) {
            abstractC2687S.mo749a(this.f1445a);
        }
    }
}
