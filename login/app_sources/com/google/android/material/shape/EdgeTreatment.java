package com.google.android.material.shape;

/* loaded from: classes2.dex */
public class EdgeTreatment {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean forceIntersection() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public void getEdgePath(float f, float f2, ShapePath shapePath) {
        getEdgePath(f, f / 2.0f, f2, shapePath);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        shapePath.lineTo(f, 0.0f);
    }
}
