package com.google.android.material.transition.platform;

import android.graphics.Path;
import android.graphics.PointF;
import android.transition.PathMotion;

/* loaded from: classes2.dex */
public final class MaterialArcMotion extends PathMotion {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.transition.PathMotion
    public Path getPath(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(f, f2);
        PointF controlPoint = getControlPoint(f, f2, f3, f4);
        path.quadTo(controlPoint.x, controlPoint.y, f3, f4);
        return path;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static PointF getControlPoint(float f, float f2, float f3, float f4) {
        if (f2 > f4) {
            return new PointF(f3, f2);
        }
        return new PointF(f, f4);
    }
}
