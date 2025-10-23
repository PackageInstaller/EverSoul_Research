package androidx.transition;

import android.view.View;

/* loaded from: classes5.dex */
class ViewUtilsApi19 extends ViewUtilsBase {
    private static boolean sTryHiddenTransitionAlpha = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsBase
    public void clearNonTransitionAlpha(View view) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsBase
    public void saveNonTransitionAlpha(View view) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ViewUtilsApi19() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsBase
    public void setTransitionAlpha(View view, float f) {
        if (sTryHiddenTransitionAlpha) {
            try {
                view.setTransitionAlpha(f);
                return;
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        view.setAlpha(f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // androidx.transition.ViewUtilsBase
    public float getTransitionAlpha(View view) {
        if (sTryHiddenTransitionAlpha) {
            try {
                return view.getTransitionAlpha();
            } catch (NoSuchMethodError unused) {
                sTryHiddenTransitionAlpha = false;
            }
        }
        return view.getAlpha();
    }
}
