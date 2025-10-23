package com.unity3d.player;

import android.app.Activity;
import android.app.Dialog;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;

/* renamed from: com.unity3d.player.D */
/* loaded from: classes3.dex */
final class C2656D extends C2654C {

    /* renamed from: d */
    private OnBackInvokedCallback f1156d;

    /* renamed from: e */
    private OnBackInvokedDispatcher f1157e;

    /* renamed from: f */
    private int f1158f;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C2656D(OnBackInvokedDispatcher onBackInvokedDispatcher, int i, Runnable runnable) {
        super(runnable);
        this.f1156d = null;
        this.f1158f = i;
        this.f1157e = onBackInvokedDispatcher;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    public static C2654C m731a(Object obj, int i, Runnable runnable) {
        C2654C c2656d = PlatformSupport.TIRAMISU_SUPPORT && ((obj instanceof Activity) || (obj instanceof Dialog)) ? new C2656D(AbstractC2721e.m782a(obj), i, runnable) : new C2654C(runnable);
        c2656d.registerOnBackPressedCallback();
        return c2656d;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.C2654C
    protected void registerOnBackPressedCallback() {
        if (this.f1150a != null) {
            return;
        }
        super.registerOnBackPressedCallback();
        if (PlatformSupport.TIRAMISU_SUPPORT) {
            C2718d c2718d = new C2718d(this.f1150a);
            this.f1156d = c2718d;
            AbstractC2721e.m783a(this.f1157e, this.f1158f, c2718d);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.unity3d.player.C2654C
    protected void unregisterOnBackPressedCallback() {
        if (this.f1150a != null) {
            if (PlatformSupport.TIRAMISU_SUPPORT) {
                AbstractC2721e.m784a(this.f1157e, this.f1156d);
                this.f1156d = null;
            }
            super.unregisterOnBackPressedCallback();
        }
    }
}
