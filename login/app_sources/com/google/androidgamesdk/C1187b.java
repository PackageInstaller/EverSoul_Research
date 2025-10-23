package com.google.androidgamesdk;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;

/* renamed from: com.google.androidgamesdk.b */
/* loaded from: classes2.dex */
final class C1187b extends Thread {

    /* renamed from: a */
    public Handler f278a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C1187b() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        Log.i("ChoreographerCallback", "Starting looper thread");
        Looper.prepare();
        this.f278a = new Handler();
        Looper.loop();
        Log.i("ChoreographerCallback", "Terminating looper thread");
    }
}
