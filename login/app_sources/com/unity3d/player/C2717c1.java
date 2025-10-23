package com.unity3d.player;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.unity3d.player.c1 */
/* loaded from: classes3.dex */
final class C2717c1 implements InterfaceC2700Y0 {

    /* renamed from: a */
    final /* synthetic */ RunnableC2720d1 f1345a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2717c1(RunnableC2720d1 runnableC2720d1) {
        this.f1345a = runnableC2720d1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m781a(int i) {
        ReentrantLock reentrantLock;
        ReentrantLock reentrantLock2;
        Semaphore semaphore;
        boolean z;
        reentrantLock = this.f1345a.f1354h.f1385e;
        reentrantLock.lock();
        C2735i1 c2735i1 = this.f1345a.f1354h;
        c2735i1.f1387g = i;
        if (i == 3) {
            z = c2735i1.f1389i;
            if (z) {
                c2735i1.runOnUiThread(new RunnableC2714b1(this));
            }
        }
        if (i != 0) {
            semaphore = this.f1345a.f1354h.f1384d;
            semaphore.release();
        }
        reentrantLock2 = this.f1345a.f1354h.f1385e;
        reentrantLock2.unlock();
    }
}
