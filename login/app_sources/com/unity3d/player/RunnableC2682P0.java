package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.P0 */
/* loaded from: classes3.dex */
final class RunnableC2682P0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Semaphore f1216a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f1217b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2682P0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.f1217b = unityPlayer;
        this.f1216a = semaphore;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        boolean nativePause;
        nativePause = this.f1217b.nativePause();
        if (nativePause) {
            UnityPlayer unityPlayer = this.f1217b;
            unityPlayer.mQuitting = true;
            unityPlayer.shutdown();
            this.f1217b.queueDestroy();
        }
        this.f1216a.release();
    }
}
