package com.unity3d.player;

import android.view.ViewTreeObserver;

/* renamed from: com.unity3d.player.Z */
/* loaded from: classes3.dex */
final class ViewTreeObserverOnGlobalLayoutListenerC2701Z implements ViewTreeObserver.OnGlobalLayoutListener {

    /* renamed from: a */
    final /* synthetic */ C2716c0 f1300a;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewTreeObserverOnGlobalLayoutListenerC2701Z(C2716c0 c2716c0) {
        this.f1300a = c2716c0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        this.f1300a.reportSoftInputArea();
        this.f1300a.f1344h.m759b();
    }
}
