package androidx.core.view.animation;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.view.animation.Interpolator;

/* loaded from: classes.dex */
class PathInterpolatorApi14 implements Interpolator {
    private static final float PRECISION = 0.002f;

    /* renamed from: mX */
    private final float[] f85mX;

    /* renamed from: mY */
    private final float[] f86mY;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PathInterpolatorApi14(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int i = ((int) (length / 0.002f)) + 1;
        this.f85mX = new float[i];
        this.f86mY = new float[i];
        float[] fArr = new float[2];
        for (int i2 = 0; i2 < i; i2++) {
            pathMeasure.getPosTan((i2 * length) / (i - 1), fArr, null);
            this.f85mX[i2] = fArr[0];
            this.f86mY[i2] = fArr[1];
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PathInterpolatorApi14(float f, float f2) {
        this(createQuad(f, f2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PathInterpolatorApi14(float f, float f2, float f3, float f4) {
        this(createCubic(f, f2, f3, f4));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f <= 0.0f) {
            return 0.0f;
        }
        if (f >= 1.0f) {
            return 1.0f;
        }
        int length = this.f85mX.length - 1;
        int i = 0;
        while (length - i > 1) {
            int i2 = (i + length) / 2;
            if (f < this.f85mX[i2]) {
                length = i2;
            } else {
                i = i2;
            }
        }
        float[] fArr = this.f85mX;
        float f2 = fArr[length];
        float f3 = fArr[i];
        float f4 = f2 - f3;
        if (f4 == 0.0f) {
            return this.f86mY[i];
        }
        float f5 = (f - f3) / f4;
        float[] fArr2 = this.f86mY;
        float f6 = fArr2[i];
        return f6 + (f5 * (fArr2[length] - f6));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Path createQuad(float f, float f2) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f, f2, 1.0f, 1.0f);
        return path;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Path createCubic(float f, float f2, float f3, float f4) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f, f2, f3, f4, 1.0f, 1.0f);
        return path;
    }
}
