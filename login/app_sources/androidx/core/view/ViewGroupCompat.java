package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public final class ViewGroupCompat {
    public static final int LAYOUT_MODE_CLIP_BOUNDS = 0;
    public static final int LAYOUT_MODE_OPTICAL_BOUNDS = 1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ViewGroupCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return viewGroup.onRequestSendAccessibilityEvent(view, accessibilityEvent);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void setMotionEventSplittingEnabled(ViewGroup viewGroup, boolean z) {
        viewGroup.setMotionEventSplittingEnabled(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getLayoutMode(ViewGroup viewGroup) {
        return Api18Impl.getLayoutMode(viewGroup);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setLayoutMode(ViewGroup viewGroup, int i) {
        Api18Impl.setLayoutMode(viewGroup, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
        Api21Impl.setTransitionGroup(viewGroup, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isTransitionGroup(ViewGroup viewGroup) {
        return Api21Impl.isTransitionGroup(viewGroup);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getNestedScrollAxes(ViewGroup viewGroup) {
        return Api21Impl.getNestedScrollAxes(viewGroup);
    }

    static class Api18Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api18Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getLayoutMode(ViewGroup viewGroup) {
            return viewGroup.getLayoutMode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setLayoutMode(ViewGroup viewGroup, int i) {
            viewGroup.setLayoutMode(i);
        }
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setTransitionGroup(ViewGroup viewGroup, boolean z) {
            viewGroup.setTransitionGroup(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isTransitionGroup(ViewGroup viewGroup) {
            return viewGroup.isTransitionGroup();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getNestedScrollAxes(ViewGroup viewGroup) {
            return viewGroup.getNestedScrollAxes();
        }
    }
}
