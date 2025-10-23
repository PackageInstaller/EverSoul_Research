package androidx.transition;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroupOverlay;

/* loaded from: classes5.dex */
class ViewGroupOverlayApi18 implements ViewGroupOverlayImpl {
    private final ViewGroupOverlay mViewGroupOverlay;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewGroupOverlayApi18(ViewGroup viewGroup) {
        this.mViewGroupOverlay = viewGroup.getOverlay();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewOverlayImpl
    public void add(Drawable drawable) {
        this.mViewGroupOverlay.add(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewOverlayImpl
    public void remove(Drawable drawable) {
        this.mViewGroupOverlay.remove(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View view) {
        this.mViewGroupOverlay.add(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View view) {
        this.mViewGroupOverlay.remove(view);
    }
}
