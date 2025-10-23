package com.google.zxing.pdf417.encoder;

/* loaded from: classes3.dex */
public final class Dimensions {
    private final int maxCols;
    private final int maxRows;
    private final int minCols;
    private final int minRows;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Dimensions(int i, int i2, int i3, int i4) {
        this.minCols = i;
        this.maxCols = i2;
        this.minRows = i3;
        this.maxRows = i4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMinCols() {
        return this.minCols;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxCols() {
        return this.maxCols;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMinRows() {
        return this.minRows;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getMaxRows() {
        return this.maxRows;
    }
}
