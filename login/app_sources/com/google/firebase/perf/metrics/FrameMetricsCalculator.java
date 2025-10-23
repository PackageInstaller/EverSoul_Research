package com.google.firebase.perf.metrics;

import android.util.SparseIntArray;

/* loaded from: classes2.dex */
public class FrameMetricsCalculator {

    public static class PerfFrameMetrics {
        int frozenFrames;
        int slowFrames;
        int totalFrames;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PerfFrameMetrics(int i, int i2, int i3) {
            this.totalFrames = i;
            this.slowFrames = i2;
            this.frozenFrames = i3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getFrozenFrames() {
            return this.frozenFrames;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getSlowFrames() {
            return this.slowFrames;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int getTotalFrames() {
            return this.totalFrames;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public PerfFrameMetrics deltaFrameMetricsFromSnapshot(PerfFrameMetrics perfFrameMetrics) {
            return new PerfFrameMetrics(this.totalFrames - perfFrameMetrics.getTotalFrames(), this.slowFrames - perfFrameMetrics.getSlowFrames(), this.frozenFrames - perfFrameMetrics.getFrozenFrames());
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static PerfFrameMetrics calculateFrameMetrics(SparseIntArray[] sparseIntArrayArr) {
        int i;
        int i2;
        SparseIntArray sparseIntArray;
        int i3 = 0;
        if (sparseIntArrayArr == null || (sparseIntArray = sparseIntArrayArr[0]) == null) {
            i = 0;
            i2 = 0;
        } else {
            int i4 = 0;
            i = 0;
            i2 = 0;
            while (i3 < sparseIntArray.size()) {
                int keyAt = sparseIntArray.keyAt(i3);
                int valueAt = sparseIntArray.valueAt(i3);
                i4 += valueAt;
                if (keyAt > 700) {
                    i2 += valueAt;
                }
                if (keyAt > 16) {
                    i += valueAt;
                }
                i3++;
            }
            i3 = i4;
        }
        return new PerfFrameMetrics(i3, i, i2);
    }
}
