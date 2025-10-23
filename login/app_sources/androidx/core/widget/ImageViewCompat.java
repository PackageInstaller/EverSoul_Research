package androidx.core.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.widget.ImageView;

/* loaded from: classes.dex */
public class ImageViewCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ColorStateList getImageTintList(ImageView imageView) {
        return Api21Impl.getImageTintList(imageView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setImageTintList(ImageView imageView, ColorStateList colorStateList) {
        Api21Impl.setImageTintList(imageView, colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PorterDuff.Mode getImageTintMode(ImageView imageView) {
        return Api21Impl.getImageTintMode(imageView);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setImageTintMode(ImageView imageView, PorterDuff.Mode mode) {
        Api21Impl.setImageTintMode(imageView, mode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ImageViewCompat() {
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ColorStateList getImageTintList(ImageView imageView) {
            return imageView.getImageTintList();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setImageTintList(ImageView imageView, ColorStateList colorStateList) {
            imageView.setImageTintList(colorStateList);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static PorterDuff.Mode getImageTintMode(ImageView imageView) {
            return imageView.getImageTintMode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setImageTintMode(ImageView imageView, PorterDuff.Mode mode) {
            imageView.setImageTintMode(mode);
        }
    }
}
