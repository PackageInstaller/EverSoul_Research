package com.google.android.material.shape;

/* loaded from: classes2.dex */
public class CutCornerTreatment extends CornerTreatment {
    float size;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public CutCornerTreatment() {
        this.size = -1.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public CutCornerTreatment(float f) {
        this.size = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(ShapePath shapePath, float f, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f);
        double d = f3;
        double d2 = f2;
        shapePath.lineTo((float) (Math.sin(Math.toRadians(f)) * d * d2), (float) (Math.sin(Math.toRadians(90.0f - f)) * d * d2));
    }
}
