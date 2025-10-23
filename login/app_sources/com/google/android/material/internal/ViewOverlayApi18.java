package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes2.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay viewOverlay;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewOverlayApi18(View view) {
        this.viewOverlay = view.getOverlay();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void add(Drawable drawable) {
        this.viewOverlay.add(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.internal.ViewOverlayImpl
    public void remove(Drawable drawable) {
        this.viewOverlay.remove(drawable);
    }
}
