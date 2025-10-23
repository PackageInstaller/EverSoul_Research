package androidx.transition;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes5.dex */
class ViewGroupOverlayApi14 extends ViewOverlayApi14 implements ViewGroupOverlayImpl {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewGroupOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        super(context, viewGroup, view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ViewGroupOverlayApi14 createFrom(ViewGroup viewGroup) {
        return (ViewGroupOverlayApi14) ViewOverlayApi14.createFrom(viewGroup);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewGroupOverlayImpl
    public void add(View view) {
        this.mOverlayViewGroup.add(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewGroupOverlayImpl
    public void remove(View view) {
        this.mOverlayViewGroup.remove(view);
    }
}
