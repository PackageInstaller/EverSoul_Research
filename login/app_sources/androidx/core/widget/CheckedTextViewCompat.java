package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CheckedTextView;
import java.lang.reflect.Field;

/* loaded from: classes.dex */
public final class CheckedTextViewCompat {
    private static final String TAG = "CheckedTextViewCompat";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private CheckedTextViewCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCheckMarkTintList(CheckedTextView checkedTextView, ColorStateList colorStateList) {
        Api21Impl.setCheckMarkTintList(checkedTextView, colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ColorStateList getCheckMarkTintList(CheckedTextView checkedTextView) {
        return Api21Impl.getCheckMarkTintList(checkedTextView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setCheckMarkTintMode(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
        Api21Impl.setCheckMarkTintMode(checkedTextView, mode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView checkedTextView) {
        return Api21Impl.getCheckMarkTintMode(checkedTextView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView) {
        return Api16Impl.getCheckMarkDrawable(checkedTextView);
    }

    private static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setCheckMarkTintList(CheckedTextView checkedTextView, ColorStateList colorStateList) {
            checkedTextView.setCheckMarkTintList(colorStateList);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ColorStateList getCheckMarkTintList(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintList();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setCheckMarkTintMode(CheckedTextView checkedTextView, PorterDuff.Mode mode) {
            checkedTextView.setCheckMarkTintMode(mode);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static PorterDuff.Mode getCheckMarkTintMode(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkTintMode();
        }
    }

    private static class Api16Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView) {
            return checkedTextView.getCheckMarkDrawable();
        }
    }

    private static class Api14Impl {
        private static Field sCheckMarkDrawableField;
        private static boolean sResolved;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api14Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Drawable getCheckMarkDrawable(CheckedTextView checkedTextView) {
            if (!sResolved) {
                try {
                    Field declaredField = CheckedTextView.class.getDeclaredField("mCheckMarkDrawable");
                    sCheckMarkDrawableField = declaredField;
                    declaredField.setAccessible(true);
                } catch (NoSuchFieldException e) {
                    Log.i(CheckedTextViewCompat.TAG, "Failed to retrieve mCheckMarkDrawable field", e);
                }
                sResolved = true;
            }
            Field field = sCheckMarkDrawableField;
            if (field != null) {
                try {
                    return (Drawable) field.get(checkedTextView);
                } catch (IllegalAccessException e2) {
                    Log.i(CheckedTextViewCompat.TAG, "Failed to get check mark drawable via reflection", e2);
                    sCheckMarkDrawableField = null;
                }
            }
            return null;
        }
    }
}
