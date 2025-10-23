package com.google.zxing;

import com.google.zxing.common.detector.MathUtils;

/* loaded from: classes3.dex */
public class ResultPoint {

    /* renamed from: x */
    private final float f522x;

    /* renamed from: y */
    private final float f523y;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ResultPoint(float f, float f2) {
        this.f522x = f;
        this.f523y = f2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float getX() {
        return this.f522x;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final float getY() {
        return this.f523y;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj instanceof ResultPoint) {
            ResultPoint resultPoint = (ResultPoint) obj;
            if (this.f522x == resultPoint.f522x && this.f523y == resultPoint.f523y) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return (Float.floatToIntBits(this.f522x) * 31) + Float.floatToIntBits(this.f523y);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "(" + this.f522x + ',' + this.f523y + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void orderBestPatterns(ResultPoint[] resultPointArr) {
        ResultPoint resultPoint;
        ResultPoint resultPoint2;
        ResultPoint resultPoint3;
        float distance = distance(resultPointArr[0], resultPointArr[1]);
        float distance2 = distance(resultPointArr[1], resultPointArr[2]);
        float distance3 = distance(resultPointArr[0], resultPointArr[2]);
        if (distance2 >= distance && distance2 >= distance3) {
            resultPoint = resultPointArr[0];
            resultPoint2 = resultPointArr[1];
            resultPoint3 = resultPointArr[2];
        } else if (distance3 >= distance2 && distance3 >= distance) {
            resultPoint = resultPointArr[1];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[2];
        } else {
            resultPoint = resultPointArr[2];
            resultPoint2 = resultPointArr[0];
            resultPoint3 = resultPointArr[1];
        }
        if (crossProductZ(resultPoint2, resultPoint, resultPoint3) < 0.0f) {
            ResultPoint resultPoint4 = resultPoint3;
            resultPoint3 = resultPoint2;
            resultPoint2 = resultPoint4;
        }
        resultPointArr[0] = resultPoint2;
        resultPointArr[1] = resultPoint;
        resultPointArr[2] = resultPoint3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static float distance(ResultPoint resultPoint, ResultPoint resultPoint2) {
        return MathUtils.distance(resultPoint.f522x, resultPoint.f523y, resultPoint2.f522x, resultPoint2.f523y);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static float crossProductZ(ResultPoint resultPoint, ResultPoint resultPoint2, ResultPoint resultPoint3) {
        float f = resultPoint2.f522x;
        float f2 = resultPoint2.f523y;
        return ((resultPoint3.f522x - f) * (resultPoint.f523y - f2)) - ((resultPoint3.f523y - f2) * (resultPoint.f522x - f));
    }
}
