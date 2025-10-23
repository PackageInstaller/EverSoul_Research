package androidx.core.database;

import android.database.CursorWindow;
import android.os.Build;

/* loaded from: classes.dex */
public final class CursorWindowCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CursorWindowCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static CursorWindow create(String str, long j) {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.createCursorWindow(str, j);
        }
        return Api15Impl.createCursorWindow(str);
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static CursorWindow createCursorWindow(String str, long j) {
            return new CursorWindow(str, j);
        }
    }

    static class Api15Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api15Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static CursorWindow createCursorWindow(String str) {
            return new CursorWindow(str);
        }
    }
}
