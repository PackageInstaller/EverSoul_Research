package androidx.core.app;

import android.app.Dialog;
import android.os.Build;
import android.view.View;

/* loaded from: classes.dex */
public class DialogCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DialogCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static View requireViewById(Dialog dialog, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (View) Api28Impl.requireViewById(dialog, i);
        }
        View findViewById = dialog.findViewById(i);
        if (findViewById != null) {
            return findViewById;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Dialog");
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> T requireViewById(Dialog dialog, int i) {
            return (T) dialog.requireViewById(i);
        }
    }
}
