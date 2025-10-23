package com.google.zxing.common;

import com.google.zxing.ResultPoint;

/* loaded from: classes3.dex */
public class DetectorResult {
    private final BitMatrix bits;
    private final ResultPoint[] points;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DetectorResult(BitMatrix bitMatrix, ResultPoint[] resultPointArr) {
        this.bits = bitMatrix;
        this.points = resultPointArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final BitMatrix getBits() {
        return this.bits;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ResultPoint[] getPoints() {
        return this.points;
    }
}
