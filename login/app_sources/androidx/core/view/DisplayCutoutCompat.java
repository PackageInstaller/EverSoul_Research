package androidx.core.view;

import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import androidx.core.graphics.Insets;
import androidx.core.util.ObjectsCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes.dex */
public final class DisplayCutoutCompat {
    private final DisplayCutout mDisplayCutout;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DisplayCutoutCompat(Rect rect, List<Rect> list) {
        this(Build.VERSION.SDK_INT >= 28 ? Api28Impl.createDisplayCutout(rect, list) : null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DisplayCutoutCompat(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
        this(constructDisplayCutout(insets, rect, rect2, rect3, rect4, insets2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static DisplayCutout constructDisplayCutout(Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, Insets insets2) {
        if (Build.VERSION.SDK_INT >= 30) {
            return Api30Impl.createDisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4, insets2.toPlatformInsets());
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.createDisplayCutout(insets.toPlatformInsets(), rect, rect2, rect3, rect4);
        }
        if (Build.VERSION.SDK_INT < 28) {
            return null;
        }
        Rect rect5 = new Rect(insets.left, insets.top, insets.right, insets.bottom);
        ArrayList arrayList = new ArrayList();
        if (rect != null) {
            arrayList.add(rect);
        }
        if (rect2 != null) {
            arrayList.add(rect2);
        }
        if (rect3 != null) {
            arrayList.add(rect3);
        }
        if (rect4 != null) {
            arrayList.add(rect4);
        }
        return Api28Impl.createDisplayCutout(rect5, arrayList);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DisplayCutoutCompat(DisplayCutout displayCutout) {
        this.mDisplayCutout = displayCutout;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSafeInsetTop() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetTop(this.mDisplayCutout);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSafeInsetBottom() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetBottom(this.mDisplayCutout);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSafeInsetLeft() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetLeft(this.mDisplayCutout);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getSafeInsetRight() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getSafeInsetRight(this.mDisplayCutout);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Rect> getBoundingRects() {
        if (Build.VERSION.SDK_INT >= 28) {
            return Api28Impl.getBoundingRects(this.mDisplayCutout);
        }
        return Collections.emptyList();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Insets getWaterfallInsets() {
        if (Build.VERSION.SDK_INT >= 30) {
            return Insets.toCompatInsets(Api30Impl.getWaterfallInsets(this.mDisplayCutout));
        }
        return Insets.NONE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return ObjectsCompat.equals(this.mDisplayCutout, ((DisplayCutoutCompat) obj).mDisplayCutout);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        DisplayCutout displayCutout = this.mDisplayCutout;
        if (displayCutout == null) {
            return 0;
        }
        return displayCutout.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "DisplayCutoutCompat{" + this.mDisplayCutout + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static DisplayCutoutCompat wrap(DisplayCutout displayCutout) {
        if (displayCutout == null) {
            return null;
        }
        return new DisplayCutoutCompat(displayCutout);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DisplayCutout unwrap() {
        return this.mDisplayCutout;
    }

    static class Api28Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api28Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static DisplayCutout createDisplayCutout(Rect rect, List<Rect> list) {
            return new DisplayCutout(rect, list);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getSafeInsetTop(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetTop();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getSafeInsetBottom(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetBottom();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getSafeInsetLeft(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetLeft();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getSafeInsetRight(DisplayCutout displayCutout) {
            return displayCutout.getSafeInsetRight();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static List<Rect> getBoundingRects(DisplayCutout displayCutout) {
            return displayCutout.getBoundingRects();
        }
    }

    static class Api30Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api30Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static DisplayCutout createDisplayCutout(android.graphics.Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4, android.graphics.Insets insets2) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4, insets2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static android.graphics.Insets getWaterfallInsets(DisplayCutout displayCutout) {
            return displayCutout.getWaterfallInsets();
        }
    }

    static class Api29Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api29Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static DisplayCutout createDisplayCutout(android.graphics.Insets insets, Rect rect, Rect rect2, Rect rect3, Rect rect4) {
            return new DisplayCutout(insets, rect, rect2, rect3, rect4);
        }
    }
}
