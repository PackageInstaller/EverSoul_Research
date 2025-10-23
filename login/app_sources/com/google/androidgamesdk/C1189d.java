package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* renamed from: com.google.androidgamesdk.d */
/* loaded from: classes2.dex */
final class C1189d extends Thread {

    /* renamed from: a */
    public Handler f281a;

    /* renamed from: b */
    private ReentrantLock f282b;

    /* renamed from: c */
    private Condition f283c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C1189d() {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.f282b = reentrantLock;
        this.f283c = reentrantLock.newCondition();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Log.i("SwappyDisplayManager", "Starting looper thread");
        this.f282b.lock();
        Looper.prepare();
        this.f281a = new Handler();
        this.f283c.signal();
        this.f282b.unlock();
        Looper.loop();
        Log.i("SwappyDisplayManager", "Terminating looper thread");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread
    public final void start() {
        this.f282b.lock();
        super.start();
        try {
            this.f283c.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.f282b.unlock();
    }
}
