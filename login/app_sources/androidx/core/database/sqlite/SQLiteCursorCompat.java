package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteCursor;
import android.os.Build;

/* loaded from: classes.dex */
public final class SQLiteCursorCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SQLiteCursorCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setFillWindowForwardOnly(SQLiteCursor sQLiteCursor, boolean z) {
        if (Build.VERSION.SDK_INT >= 28) {
            Api28Impl.setFillWindowForwardOnly(sQLiteCursor, z);
        }
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setFillWindowForwardOnly(SQLiteCursor sQLiteCursor, boolean z) {
            sQLiteCursor.setFillWindowForwardOnly(z);
        }
    }
}
