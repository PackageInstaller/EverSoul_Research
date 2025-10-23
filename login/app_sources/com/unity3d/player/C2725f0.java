package com.unity3d.player;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;

/* renamed from: com.unity3d.player.f0 */
/* loaded from: classes3.dex */
final class C2725f0 {

    /* renamed from: a */
    private Context f1359a;

    /* renamed from: b */
    private C2722e0 f1360b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C2725f0(Context context) {
        this.f1359a = context;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m787a() {
        if (this.f1360b != null) {
            this.f1359a.getContentResolver().unregisterContentObserver(this.f1360b);
            this.f1360b = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m788a(InterfaceC2719d0 interfaceC2719d0) {
        this.f1360b = new C2722e0(new Handler(Looper.getMainLooper()), interfaceC2719d0);
        this.f1359a.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f1360b);
    }
}
