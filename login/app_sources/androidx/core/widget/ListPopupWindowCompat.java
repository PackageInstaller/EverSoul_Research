package androidx.core.widget;

import android.view.View;
import android.widget.ListPopupWindow;

/* loaded from: classes.dex */
public final class ListPopupWindowCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ListPopupWindowCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static View.OnTouchListener createDragToOpenListener(Object obj, View view) {
        return createDragToOpenListener((ListPopupWindow) obj, view);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static View.OnTouchListener createDragToOpenListener(ListPopupWindow listPopupWindow, View view) {
        return Api19Impl.createDragToOpenListener(listPopupWindow, view);
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static View.OnTouchListener createDragToOpenListener(ListPopupWindow listPopupWindow, View view) {
            return listPopupWindow.createDragToOpenListener(view);
        }
    }
}
