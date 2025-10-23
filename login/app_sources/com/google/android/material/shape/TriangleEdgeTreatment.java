package com.google.android.material.shape;

/* loaded from: classes2.dex */
public class TriangleEdgeTreatment extends EdgeTreatment {
    private final boolean inside;
    private final float size;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TriangleEdgeTreatment(float f, boolean z) {
        this.size = f;
        this.inside = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.EdgeTreatment
    public void getEdgePath(float f, float f2, float f3, ShapePath shapePath) {
        shapePath.lineTo(f2 - (this.size * f3), 0.0f);
        shapePath.lineTo(f2, (this.inside ? this.size : -this.size) * f3);
        shapePath.lineTo(f2 + (this.size * f3), 0.0f);
        shapePath.lineTo(f, 0.0f);
    }
}
