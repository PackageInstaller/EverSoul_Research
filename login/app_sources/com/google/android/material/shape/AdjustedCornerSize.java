package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AdjustedCornerSize implements CornerSize {
    private final float adjustment;
    private final CornerSize other;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AdjustedCornerSize(float f, CornerSize cornerSize) {
        while (cornerSize instanceof AdjustedCornerSize) {
            cornerSize = ((AdjustedCornerSize) cornerSize).other;
            f += ((AdjustedCornerSize) cornerSize).adjustment;
        }
        this.other = cornerSize;
        this.adjustment = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(RectF rectF) {
        return Math.max(0.0f, this.other.getCornerSize(rectF) + this.adjustment);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdjustedCornerSize)) {
            return false;
        }
        AdjustedCornerSize adjustedCornerSize = (AdjustedCornerSize) obj;
        return this.other.equals(adjustedCornerSize.other) && this.adjustment == adjustedCornerSize.adjustment;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.other, Float.valueOf(this.adjustment)});
    }
}
