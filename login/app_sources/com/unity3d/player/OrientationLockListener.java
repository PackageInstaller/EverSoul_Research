package com.unity3d.player;

import android.content.Context;
import android.provider.Settings;

/* loaded from: classes3.dex */
public class OrientationLockListener implements InterfaceC2719d0 {

    /* renamed from: a */
    private C2725f0 f1209a;

    /* renamed from: b */
    private Context f1210b;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    OrientationLockListener(Context context) {
        this.f1210b = context;
        this.f1209a = new C2725f0(context);
        nativeUpdateOrientationLockState(Settings.System.getInt(context.getContentResolver(), "accelerometer_rotation", 0));
        this.f1209a.m788a(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public final void m738a() {
        this.f1209a.m787a();
        this.f1209a = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    public final void m739b() {
        nativeUpdateOrientationLockState(Settings.System.getInt(this.f1210b.getContentResolver(), "accelerometer_rotation", 0));
    }

    public final native void nativeUpdateOrientationLockState(int i);
}
