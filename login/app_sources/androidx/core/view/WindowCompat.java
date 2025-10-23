package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class WindowCompat {
    public static final int FEATURE_ACTION_BAR = 8;
    public static final int FEATURE_ACTION_BAR_OVERLAY = 9;
    public static final int FEATURE_ACTION_MODE_OVERLAY = 10;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private WindowCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends View> T requireViewById(Window window, int i) {
        if (Build.VERSION.SDK_INT >= 28) {
            return (T) Api28Impl.requireViewById(window, i);
        }
        T t = (T) window.findViewById(i);
        if (t != null) {
            return t;
        }
        throw new IllegalArgumentException("ID does not reference a View inside this Window");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setDecorFitsSystemWindows(Window window, boolean z) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.setDecorFitsSystemWindows(window, z);
        } else {
            Api16Impl.setDecorFitsSystemWindows(window, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static WindowInsetsControllerCompat getInsetsController(Window window, View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setDecorFitsSystemWindows(Window window, boolean z) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    static class Api30Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api30Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setDecorFitsSystemWindows(Window window, boolean z) {
            window.setDecorFitsSystemWindows(z);
        }
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static <T> T requireViewById(Window window, int i) {
            return (T) window.requireViewById(i);
        }
    }
}
