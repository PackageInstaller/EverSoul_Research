package com.unity3d.player;

import android.content.Context;
import java.util.concurrent.Semaphore;

/* renamed from: com.unity3d.player.d1 */
/* loaded from: classes3.dex */
final class RunnableC2720d1 implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f1347a;

    /* renamed from: b */
    final /* synthetic */ int f1348b;

    /* renamed from: c */
    final /* synthetic */ int f1349c;

    /* renamed from: d */
    final /* synthetic */ int f1350d;

    /* renamed from: e */
    final /* synthetic */ boolean f1351e;

    /* renamed from: f */
    final /* synthetic */ long f1352f;

    /* renamed from: g */
    final /* synthetic */ long f1353g;

    /* renamed from: h */
    final /* synthetic */ C2735i1 f1354h;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    RunnableC2720d1(C2735i1 c2735i1, String str, int i, int i2, int i3, boolean z, long j, long j2) {
        this.f1354h = c2735i1;
        this.f1347a = str;
        this.f1348b = i;
        this.f1349c = i2;
        this.f1350d = i3;
        this.f1351e = z;
        this.f1352f = j;
        this.f1353g = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a1;
        Context context;
        UnityPlayer unityPlayer;
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a12;
        UnityPlayer unityPlayer2;
        UnityPlayer unityPlayer3;
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a13;
        Semaphore semaphore;
        C2735i1 c2735i1 = this.f1354h;
        surfaceHolderCallbackC2711a1 = c2735i1.f1386f;
        if (surfaceHolderCallbackC2711a1 != null) {
            AbstractC2768z.Log(5, "Video already playing");
            C2735i1 c2735i12 = this.f1354h;
            c2735i12.f1387g = 2;
            semaphore = c2735i12.f1384d;
            semaphore.release();
            return;
        }
        C2735i1 c2735i13 = this.f1354h;
        context = c2735i13.f1382b;
        unityPlayer = c2735i13.f1381a;
        c2735i1.f1386f = new SurfaceHolderCallbackC2711a1(context, unityPlayer, this.f1347a, this.f1348b, this.f1349c, this.f1350d, this.f1351e, this.f1352f, this.f1353g, new C2717c1(this));
        C2735i1 c2735i14 = this.f1354h;
        surfaceHolderCallbackC2711a12 = c2735i14.f1386f;
        if (surfaceHolderCallbackC2711a12 != null) {
            unityPlayer2 = c2735i14.f1381a;
            unityPlayer2.bringToFront();
            C2735i1 c2735i15 = this.f1354h;
            unityPlayer3 = c2735i15.f1381a;
            surfaceHolderCallbackC2711a13 = c2735i15.f1386f;
            unityPlayer3.addView(surfaceHolderCallbackC2711a13);
        }
    }
}
