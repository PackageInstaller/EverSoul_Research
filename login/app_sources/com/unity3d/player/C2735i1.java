package com.unity3d.player;

import android.app.Activity;
import android.content.Context;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.unity3d.player.i1 */
/* loaded from: classes3.dex */
final class C2735i1 {

    /* renamed from: a */
    private UnityPlayer f1381a;

    /* renamed from: c */
    private InterfaceC2732h1 f1383c;

    /* renamed from: b */
    private Context f1382b = null;

    /* renamed from: d */
    private final Semaphore f1384d = new Semaphore(0);

    /* renamed from: e */
    private final ReentrantLock f1385e = new ReentrantLock();

    /* renamed from: f */
    private SurfaceHolderCallbackC2711a1 f1386f = null;

    /* renamed from: g */
    private int f1387g = 2;

    /* renamed from: h */
    private boolean f1388h = false;

    /* renamed from: i */
    private boolean f1389i = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2735i1(UnityPlayer unityPlayer) {
        this.f1381a = null;
        this.f1381a = unityPlayer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m797a() {
        this.f1385e.lock();
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a1 = this.f1386f;
        if (surfaceHolderCallbackC2711a1 != null) {
            surfaceHolderCallbackC2711a1.updateVideoLayout();
        }
        this.f1385e.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final boolean m798a(Context context, String str, int i, int i2, int i3, boolean z, long j, long j2, InterfaceC2732h1 interfaceC2732h1) {
        this.f1385e.lock();
        this.f1383c = interfaceC2732h1;
        this.f1382b = context;
        this.f1384d.drainPermits();
        this.f1387g = 2;
        runOnUiThread(new RunnableC2720d1(this, str, i, i2, i3, z, j, j2));
        boolean z2 = false;
        try {
            this.f1385e.unlock();
            this.f1384d.acquire();
            this.f1385e.lock();
            if (this.f1387g != 2) {
                z2 = true;
            }
        } catch (InterruptedException unused) {
        }
        runOnUiThread(new RunnableC2723e1(this));
        runOnUiThread((!z2 || this.f1387g == 3) ? new RunnableC2729g1(this) : new RunnableC2726f1(this));
        this.f1385e.unlock();
        return z2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m799b() {
        this.f1385e.lock();
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a1 = this.f1386f;
        if (surfaceHolderCallbackC2711a1 != null) {
            if (this.f1387g == 0) {
                surfaceHolderCallbackC2711a1.cancelOnPrepare();
            } else if (this.f1389i) {
                boolean m778a = surfaceHolderCallbackC2711a1.m778a();
                this.f1388h = m778a;
                if (!m778a) {
                    this.f1386f.pause();
                }
            }
        }
        this.f1385e.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: c */
    public final void m800c() {
        this.f1385e.lock();
        SurfaceHolderCallbackC2711a1 surfaceHolderCallbackC2711a1 = this.f1386f;
        if (surfaceHolderCallbackC2711a1 != null && this.f1389i && !this.f1388h) {
            surfaceHolderCallbackC2711a1.start();
        }
        this.f1385e.unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void runOnUiThread(Runnable runnable) {
        Context context = this.f1382b;
        if (context instanceof Activity) {
            ((Activity) context).runOnUiThread(runnable);
        } else {
            AbstractC2768z.Log(5, "Not running from an Activity; Ignoring execution request...");
        }
    }
}
