package com.unity3d.player;

/* renamed from: com.unity3d.player.I0 */
/* loaded from: classes3.dex */
final class RunnableC2668I0 implements Runnable {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2668I0() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        try {
            AbstractC2715c.m779a();
        } catch (Exception e) {
            AbstractC2768z.Log(6, "Exception when hiding Activity Indicator " + e);
        }
    }
}
