package androidx.transition;

import android.graphics.Matrix;
import android.view.View;

/* loaded from: classes5.dex */
class ViewUtilsApi29 extends ViewUtilsApi23 {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewUtilsApi29() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsApi19, androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(View view, float f) {
        view.setTransitionAlpha(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsApi19, androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(View view) {
        return view.getTransitionAlpha();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsApi23, androidx.transition.ViewUtilsBase
    public void setTransitionVisibility(View view, int i) {
        view.setTransitionVisibility(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsApi22, androidx.transition.ViewUtilsBase
    public void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        view.setLeftTopRightBottom(i, i2, i3, i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsBase
    public void transformMatrixToGlobal(View view, Matrix matrix) {
        view.transformMatrixToGlobal(matrix);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsBase
    public void transformMatrixToLocal(View view, Matrix matrix) {
        view.transformMatrixToLocal(matrix);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsApi21, androidx.transition.ViewUtilsBase
    public void setAnimationMatrix(View view, Matrix matrix) {
        view.setAnimationMatrix(matrix);
    }
}
