package com.unity3d.player;

/* renamed from: com.unity3d.player.V */
/* loaded from: classes3.dex */
final class RunnableC2693V implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C2697X f1287a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2693V(C2697X c2697x) {
        this.f1287a = c2697x;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1287a.f1256c.requestFocus();
        this.f1287a.m754f();
    }
}
