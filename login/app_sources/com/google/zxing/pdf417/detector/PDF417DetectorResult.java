package com.google.zxing.pdf417.detector;

import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitMatrix;
import java.util.List;

/* loaded from: classes3.dex */
public final class PDF417DetectorResult {
    private final BitMatrix bits;
    private final List<ResultPoint[]> points;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PDF417DetectorResult(BitMatrix bitMatrix, List<ResultPoint[]> list) {
        this.bits = bitMatrix;
        this.points = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitMatrix getBits() {
        return this.bits;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<ResultPoint[]> getPoints() {
        return this.points;
    }
}
