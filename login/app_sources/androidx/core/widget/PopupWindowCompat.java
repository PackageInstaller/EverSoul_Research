package androidx.core.widget;

import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class PopupWindowCompat {
    private static final String TAG = "PopupWindowCompatApi21";
    private static Method sGetWindowLayoutTypeMethod;
    private static boolean sGetWindowLayoutTypeMethodAttempted;
    private static Field sOverlapAnchorField;
    private static boolean sOverlapAnchorFieldAttempted;
    private static Method sSetWindowLayoutTypeMethod;
    private static boolean sSetWindowLayoutTypeMethodAttempted;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PopupWindowCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
        Api19Impl.showAsDropDown(popupWindow, view, i, i2, i3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
        Api23Impl.setOverlapAnchor(popupWindow, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean getOverlapAnchor(PopupWindow popupWindow) {
        return Api23Impl.getOverlapAnchor(popupWindow);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setWindowLayoutType(PopupWindow popupWindow, int i) {
        Api23Impl.setWindowLayoutType(popupWindow, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getWindowLayoutType(PopupWindow popupWindow) {
        return Api23Impl.getWindowLayoutType(popupWindow);
    }

    static class Api23Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api23Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setOverlapAnchor(PopupWindow popupWindow, boolean z) {
            popupWindow.setOverlapAnchor(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean getOverlapAnchor(PopupWindow popupWindow) {
            return popupWindow.getOverlapAnchor();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setWindowLayoutType(PopupWindow popupWindow, int i) {
            popupWindow.setWindowLayoutType(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getWindowLayoutType(PopupWindow popupWindow) {
            return popupWindow.getWindowLayoutType();
        }
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void showAsDropDown(PopupWindow popupWindow, View view, int i, int i2, int i3) {
            popupWindow.showAsDropDown(view, i, i2, i3);
        }
    }
}
