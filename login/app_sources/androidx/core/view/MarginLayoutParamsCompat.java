package androidx.core.view;

import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class MarginLayoutParamsCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.getMarginStart(marginLayoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.getMarginEnd(marginLayoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Api17Impl.setMarginStart(marginLayoutParams, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Api17Impl.setMarginEnd(marginLayoutParams, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
        return Api17Impl.isMarginRelative(marginLayoutParams);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
        int layoutDirection = Api17Impl.getLayoutDirection(marginLayoutParams);
        if (layoutDirection == 0 || layoutDirection == 1) {
            return layoutDirection;
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Api17Impl.setLayoutDirection(marginLayoutParams, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
        Api17Impl.resolveLayoutDirection(marginLayoutParams, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MarginLayoutParamsCompat() {
    }

    static class Api17Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api17Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginStart();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getMarginEnd();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setMarginStart(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setMarginStart(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setMarginEnd(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setMarginEnd(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isMarginRelative(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.isMarginRelative();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.getLayoutDirection();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.setLayoutDirection(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void resolveLayoutDirection(ViewGroup.MarginLayoutParams marginLayoutParams, int i) {
            marginLayoutParams.resolveLayoutDirection(i);
        }
    }
}
