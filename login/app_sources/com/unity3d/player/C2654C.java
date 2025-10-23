package com.unity3d.player;

import com.unity3d.player.p030a.InterfaceC2706c;

/* renamed from: com.unity3d.player.C */
/* loaded from: classes3.dex */
class C2654C {

    /* renamed from: b */
    protected Runnable f1151b;

    /* renamed from: a */
    protected InterfaceC2706c f1150a = null;

    /* renamed from: c */
    protected boolean f1152c = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected C2654C(Runnable runnable) {
        this.f1151b = runnable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void registerOnBackPressedCallback() {
        if (this.f1150a != null) {
            return;
        }
        this.f1150a = new C2652B(this.f1151b);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void unregisterOnBackPressedCallback() {
        this.f1150a = null;
    }
}
