package androidx.core.widget;

import android.widget.ListView;

/* loaded from: classes.dex */
public final class ListViewCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void scrollListBy(ListView listView, int i) {
        Api19Impl.scrollListBy(listView, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean canScrollList(ListView listView, int i) {
        return Api19Impl.canScrollList(listView, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ListViewCompat() {
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void scrollListBy(ListView listView, int i) {
            listView.scrollListBy(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean canScrollList(ListView listView, int i) {
            return listView.canScrollList(i);
        }
    }
}
