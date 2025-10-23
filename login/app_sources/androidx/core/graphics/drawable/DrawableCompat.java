package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.InsetDrawable;
import android.util.AttributeSet;
import java.io.IOException;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class DrawableCompat {
    private static final String TAG = "DrawableCompat";
    private static Method sGetLayoutDirectionMethod;
    private static boolean sGetLayoutDirectionMethodFetched;
    private static Method sSetLayoutDirectionMethod;
    private static boolean sSetLayoutDirectionMethodFetched;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Drawable wrap(Drawable drawable) {
        return drawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void jumpToCurrentState(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setAutoMirrored(Drawable drawable, boolean z) {
        Api19Impl.setAutoMirrored(drawable, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAutoMirrored(Drawable drawable) {
        return Api19Impl.isAutoMirrored(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setHotspot(Drawable drawable, float f, float f2) {
        Api21Impl.setHotspot(drawable, f, f2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
        Api21Impl.setHotspotBounds(drawable, i, i2, i3, i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setTint(Drawable drawable, int i) {
        Api21Impl.setTint(drawable, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setTintList(Drawable drawable, ColorStateList colorStateList) {
        Api21Impl.setTintList(drawable, colorStateList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
        Api21Impl.setTintMode(drawable, mode);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getAlpha(Drawable drawable) {
        return Api19Impl.getAlpha(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void applyTheme(Drawable drawable, Resources.Theme theme) {
        Api21Impl.applyTheme(drawable, theme);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean canApplyTheme(Drawable drawable) {
        return Api21Impl.canApplyTheme(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ColorFilter getColorFilter(Drawable drawable) {
        return Api21Impl.getColorFilter(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void clearColorFilter(Drawable drawable) {
        drawable.clearColorFilter();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Api21Impl.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T extends Drawable> T unwrap(Drawable drawable) {
        return drawable instanceof WrappedDrawable ? (T) ((WrappedDrawable) drawable).getWrappedDrawable() : drawable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean setLayoutDirection(Drawable drawable, int i) {
        return Api23Impl.setLayoutDirection(drawable, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getLayoutDirection(Drawable drawable) {
        return Api23Impl.getLayoutDirection(drawable);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DrawableCompat() {
    }

    static class Api19Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api19Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setAutoMirrored(Drawable drawable, boolean z) {
            drawable.setAutoMirrored(z);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isAutoMirrored(Drawable drawable) {
            return drawable.isAutoMirrored();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getAlpha(Drawable drawable) {
            return drawable.getAlpha();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Drawable getChild(DrawableContainer.DrawableContainerState drawableContainerState, int i) {
            return drawableContainerState.getChild(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static Drawable getDrawable(InsetDrawable insetDrawable) {
            return insetDrawable.getDrawable();
        }
    }

    static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setHotspot(Drawable drawable, float f, float f2) {
            drawable.setHotspot(f, f2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setTint(Drawable drawable, int i) {
            drawable.setTint(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setTintList(Drawable drawable, ColorStateList colorStateList) {
            drawable.setTintList(colorStateList);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setTintMode(Drawable drawable, PorterDuff.Mode mode) {
            drawable.setTintMode(mode);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void applyTheme(Drawable drawable, Resources.Theme theme) {
            drawable.applyTheme(theme);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean canApplyTheme(Drawable drawable) {
            return drawable.canApplyTheme();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static ColorFilter getColorFilter(Drawable drawable) {
            return drawable.getColorFilter();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setHotspotBounds(Drawable drawable, int i, int i2, int i3, int i4) {
            drawable.setHotspotBounds(i, i2, i3, i4);
        }
    }

    static class Api23Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api23Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean setLayoutDirection(Drawable drawable, int i) {
            return drawable.setLayoutDirection(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getLayoutDirection(Drawable drawable) {
            return drawable.getLayoutDirection();
        }
    }
}
