package androidx.core.graphics;

import android.graphics.Rect;

/* loaded from: classes.dex */
public final class Insets {
    public static final Insets NONE = new Insets(0, 0, 0, 0);
    public final int bottom;
    public final int left;
    public final int right;
    public final int top;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Insets(int i, int i2, int i3, int i4) {
        this.left = i;
        this.top = i2;
        this.right = i3;
        this.bottom = i4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static Insets m13of(int i, int i2, int i3, int i4) {
        if (i == 0 && i2 == 0 && i3 == 0 && i4 == 0) {
            return NONE;
        }
        return new Insets(i, i2, i3, i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static Insets m14of(Rect rect) {
        return m13of(rect.left, rect.top, rect.right, rect.bottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Insets add(Insets insets, Insets insets2) {
        return m13of(insets.left + insets2.left, insets.top + insets2.top, insets.right + insets2.right, insets.bottom + insets2.bottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Insets subtract(Insets insets, Insets insets2) {
        return m13of(insets.left - insets2.left, insets.top - insets2.top, insets.right - insets2.right, insets.bottom - insets2.bottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Insets max(Insets insets, Insets insets2) {
        return m13of(Math.max(insets.left, insets2.left), Math.max(insets.top, insets2.top), Math.max(insets.right, insets2.right), Math.max(insets.bottom, insets2.bottom));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Insets min(Insets insets, Insets insets2) {
        return m13of(Math.min(insets.left, insets2.left), Math.min(insets.top, insets2.top), Math.min(insets.right, insets2.right), Math.min(insets.bottom, insets2.bottom));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Insets insets = (Insets) obj;
        return this.bottom == insets.bottom && this.left == insets.left && this.right == insets.right && this.top == insets.top;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (((((this.left * 31) + this.top) * 31) + this.right) * 31) + this.bottom;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Insets{left=" + this.left + ", top=" + this.top + ", right=" + this.right + ", bottom=" + this.bottom + '}';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static Insets wrap(android.graphics.Insets insets) {
        return toCompatInsets(insets);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Insets toCompatInsets(android.graphics.Insets insets) {
        return m13of(insets.left, insets.top, insets.right, insets.bottom);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public android.graphics.Insets toPlatformInsets() {
        return Api29Impl.m15of(this.left, this.top, this.right, this.bottom);
    }

    static class Api29Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api29Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: of */
        static android.graphics.Insets m15of(int i, int i2, int i3, int i4) {
            return android.graphics.Insets.of(i, i2, i3, i4);
        }
    }
}
