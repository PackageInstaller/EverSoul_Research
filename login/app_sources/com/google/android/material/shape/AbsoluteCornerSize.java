package com.google.android.material.shape;

import android.graphics.RectF;
import java.util.Arrays;

/* loaded from: classes2.dex */
public final class AbsoluteCornerSize implements CornerSize {
    private final float size;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AbsoluteCornerSize(float f) {
        this.size = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.CornerSize
    public float getCornerSize(RectF rectF) {
        return this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getCornerSize() {
        return this.size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AbsoluteCornerSize) && this.size == ((AbsoluteCornerSize) obj).size;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Arrays.hashCode(new Object[]{Float.valueOf(this.size)});
    }
}
