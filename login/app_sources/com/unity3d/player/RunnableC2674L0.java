package com.unity3d.player;

import android.view.Surface;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.L0 */
/* loaded from: classes3.dex */
final class RunnableC2674L0 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f1189a;

    /* renamed from: b */
    final /* synthetic */ Surface f1190b;

    /* renamed from: c */
    final /* synthetic */ Semaphore f1191c;

    /* renamed from: d */
    final /* synthetic */ UnityPlayer f1192d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2674L0(UnityPlayer unityPlayer, int i, Surface surface, Semaphore semaphore) {
        this.f1192d = unityPlayer;
        this.f1189a = i;
        this.f1190b = surface;
        this.f1191c = semaphore;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        this.f1192d.nativeRecreateGfxState(this.f1189a, this.f1190b);
        this.f1191c.release();
    }
}
