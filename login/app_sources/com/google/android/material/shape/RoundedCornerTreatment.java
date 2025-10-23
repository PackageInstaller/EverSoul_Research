package com.google.android.material.shape;

/* loaded from: classes2.dex */
public class RoundedCornerTreatment extends CornerTreatment {
    float radius;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public RoundedCornerTreatment() {
        this.radius = -1.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public RoundedCornerTreatment(float f) {
        this.radius = f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.material.shape.CornerTreatment
    public void getCornerPath(ShapePath shapePath, float f, float f2, float f3) {
        shapePath.reset(0.0f, f3 * f2, 180.0f, 180.0f - f);
        float f4 = f3 * 2.0f * f2;
        shapePath.addArc(0.0f, 0.0f, f4, f4, 180.0f, f);
    }
}
