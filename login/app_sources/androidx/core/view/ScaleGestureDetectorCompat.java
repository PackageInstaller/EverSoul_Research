package androidx.core.view;

import android.view.ScaleGestureDetector;

/* loaded from: classes.dex */
public final class ScaleGestureDetectorCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ScaleGestureDetectorCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void setQuickScaleEnabled(Object obj, boolean z) {
        setQuickScaleEnabled((ScaleGestureDetector) obj, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z) {
        Api19Impl.setQuickScaleEnabled(scaleGestureDetector, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean isQuickScaleEnabled(Object obj) {
        return isQuickScaleEnabled((ScaleGestureDetector) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
        return Api19Impl.isQuickScaleEnabled(scaleGestureDetector);
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector, boolean z) {
            scaleGestureDetector.setQuickScaleEnabled(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isQuickScaleEnabled(ScaleGestureDetector scaleGestureDetector) {
            return scaleGestureDetector.isQuickScaleEnabled();
        }
    }
}
