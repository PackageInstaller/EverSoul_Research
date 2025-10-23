package androidx.core.util;

import android.util.SizeF;
import com.facebook.appevents.internal.ViewHierarchyConstants;

/* loaded from: classes.dex */
public final class SizeFCompat {
    private final float mHeight;
    private final float mWidth;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SizeFCompat(float f, float f2) {
        this.mWidth = Preconditions.checkArgumentFinite(f, ViewHierarchyConstants.DIMENSION_WIDTH_KEY);
        this.mHeight = Preconditions.checkArgumentFinite(f2, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getWidth() {
        return this.mWidth;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getHeight() {
        return this.mHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SizeFCompat)) {
            return false;
        }
        SizeFCompat sizeFCompat = (SizeFCompat) obj;
        return sizeFCompat.mWidth == this.mWidth && sizeFCompat.mHeight == this.mHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Float.floatToIntBits(this.mWidth) ^ Float.floatToIntBits(this.mHeight);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.mWidth + "x" + this.mHeight;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SizeF toSizeF() {
        return Api21Impl.toSizeF(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SizeFCompat toSizeFCompat(SizeF sizeF) {
        return Api21Impl.toSizeFCompat(sizeF);
    }

    private static final class Api21Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api21Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static SizeFCompat toSizeFCompat(SizeF sizeF) {
            Preconditions.checkNotNull(sizeF);
            return new SizeFCompat(sizeF.getWidth(), sizeF.getHeight());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static SizeF toSizeF(SizeFCompat sizeFCompat) {
            Preconditions.checkNotNull(sizeFCompat);
            return new SizeF(sizeFCompat.getWidth(), sizeFCompat.getHeight());
        }
    }
}
