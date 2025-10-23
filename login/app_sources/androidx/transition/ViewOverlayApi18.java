package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewOverlay;

/* loaded from: classes5.dex */
class ViewOverlayApi18 implements ViewOverlayImpl {
    private final ViewOverlay mViewOverlay;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewOverlayApi18(View view) {
        this.mViewOverlay = view.getOverlay();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable drawable) {
        this.mViewOverlay.add(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable drawable) {
        this.mViewOverlay.remove(drawable);
    }
}
