package com.unity3d.player;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* renamed from: com.unity3d.player.U0 */
/* loaded from: classes3.dex */
final class C2692U0 extends Thread {

    /* renamed from: a */
    Handler f1278a;

    /* renamed from: b */
    boolean f1279b;

    /* renamed from: c */
    boolean f1280c;

    /* renamed from: d */
    int f1281d;

    /* renamed from: e */
    int f1282e;

    /* renamed from: f */
    int f1283f;

    /* renamed from: g */
    int f1284g;

    /* renamed from: h */
    int f1285h;

    /* renamed from: i */
    final /* synthetic */ UnityPlayer f1286i;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C2692U0(UnityPlayer unityPlayer) {
        this.f1286i = unityPlayer;
        this.f1279b = false;
        this.f1280c = false;
        this.f1281d = 2;
        this.f1282e = 0;
        this.f1285h = 5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public void m760a(EnumC2688S0 enumC2688S0) {
        Handler handler = this.f1278a;
        if (handler != null) {
            Message.obtain(handler, 2269, enumC2688S0).sendToTarget();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() {
        setName("UnityMain");
        Looper.prepare();
        this.f1278a = new Handler(Looper.myLooper(), new C2690T0(this));
        Looper.loop();
    }
}
