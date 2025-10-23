package androidx.appcompat.resources;

import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* loaded from: classes.dex */
public final class Compatibility {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Compatibility() {
    }

    public static class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void inflate(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
            drawable.inflate(resources, xmlPullParser, attributeSet, theme);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static int getChangingConfigurations(TypedArray typedArray) {
            return typedArray.getChangingConfigurations();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static Drawable createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
            return Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme);
        }
    }

    public static class Api18Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api18Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void setAutoCancel(ObjectAnimator objectAnimator, boolean z) {
            objectAnimator.setAutoCancel(z);
        }
    }

    public static class Api15Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api15Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void getValueForDensity(Resources resources, int i, int i2, TypedValue typedValue, boolean z) {
            resources.getValueForDensity(i, i2, typedValue, z);
        }
    }
}
