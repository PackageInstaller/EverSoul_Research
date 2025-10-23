package com.unity3d.player;

/* renamed from: com.unity3d.player.Z0 */
/* loaded from: classes3.dex */
public final class RunnableC2702Z0 implements Runnable {

    /* renamed from: a */
    private SurfaceHolderCallbackC2711a1 f1301a;

    /* renamed from: b */
    private boolean f1302b = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RunnableC2702Z0(SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a1) {
        this.f1301a = surfaceHolderCallbackC2711a1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
        }
        if (this.f1302b) {
            return;
        }
        int i = SurfaceHolderCallbackC2711a1.f1310A;
        this.f1301a.cancelOnPrepare();
    }
}
