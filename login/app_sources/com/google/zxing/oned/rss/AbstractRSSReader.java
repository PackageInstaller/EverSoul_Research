package com.google.zxing.oned.rss;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.detector.MathUtils;
import com.google.zxing.oned.OneDReader;

/* loaded from: classes3.dex */
public abstract class AbstractRSSReader extends OneDReader {
    private static final float MAX_AVG_VARIANCE = 0.2f;
    private static final float MAX_FINDER_PATTERN_RATIO = 0.89285713f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.45f;
    private static final float MIN_FINDER_PATTERN_RATIO = 0.7916667f;
    private final int[] dataCharacterCounters;
    private final int[] evenCounts;
    private final int[] oddCounts;
    private final int[] decodeFinderCounters = new int[4];
    private final float[] oddRoundingErrors = new float[4];
    private final float[] evenRoundingErrors = new float[4];

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected AbstractRSSReader() {
        int[] iArr = new int[8];
        this.dataCharacterCounters = iArr;
        this.oddCounts = new int[iArr.length / 2];
        this.evenCounts = new int[iArr.length / 2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int[] getDecodeFinderCounters() {
        return this.decodeFinderCounters;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int[] getDataCharacterCounters() {
        return this.dataCharacterCounters;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final float[] getOddRoundingErrors() {
        return this.oddRoundingErrors;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final float[] getEvenRoundingErrors() {
        return this.evenRoundingErrors;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int[] getOddCounts() {
        return this.oddCounts;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final int[] getEvenCounts() {
        return this.evenCounts;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static int parseFinderValue(int[] iArr, int[][] iArr2) throws NotFoundException {
        for (int i = 0; i < iArr2.length; i++) {
            if (patternMatchVariance(iArr, iArr2[i], MAX_INDIVIDUAL_VARIANCE) < 0.2f) {
                return i;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    protected static int count(int[] iArr) {
        return MathUtils.sum(iArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static void increment(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 > f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static void decrement(int[] iArr, float[] fArr) {
        int i = 0;
        float f = fArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            float f2 = fArr[i2];
            if (f2 < f) {
                i = i2;
                f = f2;
            }
        }
        iArr[i] = iArr[i] - 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static boolean isFinderPattern(int[] iArr) {
        float f = (iArr[0] + iArr[1]) / ((iArr[2] + r1) + iArr[3]);
        if (f >= MIN_FINDER_PATTERN_RATIO && f <= MAX_FINDER_PATTERN_RATIO) {
            int i = Integer.MAX_VALUE;
            int i2 = Integer.MIN_VALUE;
            for (int i3 : iArr) {
                if (i3 > i2) {
                    i2 = i3;
                }
                if (i3 < i) {
                    i = i3;
                }
            }
            if (i2 < i * 10) {
                return true;
            }
        }
        return false;
    }
}
