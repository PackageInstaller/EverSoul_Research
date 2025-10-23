package com.unity3d.player;

import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.O0 */
/* loaded from: classes3.dex */
final class RunnableC2680O0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Semaphore f1207a;

    /* renamed from: b */
    final /* synthetic */ UnityPlayer f1208b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2680O0(UnityPlayer unityPlayer, Semaphore semaphore) {
        this.f1208b = unityPlayer;
        this.f1207a = semaphore;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1208b.shutdown();
        this.f1207a.release();
    }
}
