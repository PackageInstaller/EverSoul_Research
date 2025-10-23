package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;
import androidx.core.view.ViewCompat;

/* loaded from: classes5.dex */
class ViewUtils {
    static final Property<View, Rect> CLIP_BOUNDS;
    private static final ViewUtilsBase IMPL;
    private static final String TAG = "ViewUtils";
    static final Property<View, Float> TRANSITION_ALPHA;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        if (Build.VERSION.SDK_INT >= 29) {
            IMPL = new ViewUtilsApi29();
        } else {
            IMPL = new ViewUtilsApi23();
        }
        TRANSITION_ALPHA = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.util.Property
            public Float get(View view) {
                return Float.valueOf(ViewUtils.getTransitionAlpha(view));
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.util.Property
            public void set(View view, Float f) {
                ViewUtils.setTransitionAlpha(view, f.floatValue());
            }
        };
        CLIP_BOUNDS = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.util.Property
            public Rect get(View view) {
                return ViewCompat.getClipBounds(view);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.util.Property
            public void set(View view, Rect rect) {
                ViewCompat.setClipBounds(view, rect);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static ViewOverlayImpl getOverlay(View view) {
        return new ViewOverlayApi18(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static WindowIdImpl getWindowId(View view) {
        return new WindowIdApi18(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void setTransitionAlpha(View view, float f) {
        IMPL.setTransitionAlpha(view, f);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static float getTransitionAlpha(View view) {
        return IMPL.getTransitionAlpha(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void saveNonTransitionAlpha(View view) {
        IMPL.saveNonTransitionAlpha(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void clearNonTransitionAlpha(View view) {
        IMPL.clearNonTransitionAlpha(view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void setTransitionVisibility(View view, int i) {
        IMPL.setTransitionVisibility(view, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void transformMatrixToGlobal(View view, Matrix matrix) {
        IMPL.transformMatrixToGlobal(view, matrix);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void transformMatrixToLocal(View view, Matrix matrix) {
        IMPL.transformMatrixToLocal(view, matrix);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void setAnimationMatrix(View view, Matrix matrix) {
        IMPL.setAnimationMatrix(view, matrix);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void setLeftTopRightBottom(View view, int i, int i2, int i3, int i4) {
        IMPL.setLeftTopRightBottom(view, i, i2, i3, i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ViewUtils() {
    }
}
