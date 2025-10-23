package androidx.core.widget;

import android.view.View;
import android.widget.PopupMenu;

/* loaded from: classes.dex */
public final class PopupMenuCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private PopupMenuCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static View.OnTouchListener getDragToOpenListener(Object obj) {
        return Api19Impl.getDragToOpenListener((PopupMenu) obj);
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static View.OnTouchListener getDragToOpenListener(PopupMenu popupMenu) {
            return popupMenu.getDragToOpenListener();
        }
    }
}
