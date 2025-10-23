package com.google.android.material.shape;

import android.graphics.RectF;

/* loaded from: classes2.dex */
public class CornerTreatment {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void getCornerPath(float f, float f2, ShapePath shapePath) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getCornerPath(ShapePath shapePath, float f, float f2, float f3) {
        getCornerPath(f, f2, shapePath);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getCornerPath(ShapePath shapePath, float f, float f2, RectF rectF, CornerSize cornerSize) {
        getCornerPath(shapePath, f, f2, cornerSize.getCornerSize(rectF));
    }
}
