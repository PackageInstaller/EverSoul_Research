package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class RelativeCornerSize implements CornerSize {
    private final float percent;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RelativeCornerSize(float f) {
        this.percent = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getRelativePercent() {
        return this.percent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(RectF rectF) {
        return this.percent * rectF.height();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof RelativeCornerSize) && this.percent == ((RelativeCornerSize) obj).percent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.percent)});
    }
}
