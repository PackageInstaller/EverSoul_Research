package com.google.zxing.pdf417.decoder;

/* loaded from: classes3.dex */
final class Codeword {
    private static final int BARCODE_ROW_UNKNOWN = -1;
    private final int bucket;
    private final int endX;
    private int rowNumber = -1;
    private final int startX;
    private final int value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Codeword(int i, int i2, int i3, int i4) {
        this.startX = i;
        this.endX = i2;
        this.bucket = i3;
        this.value = i4;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean hasValidRowNumber() {
        return isValidRowNumber(this.rowNumber);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isValidRowNumber(int i) {
        return i != -1 && this.bucket == (i % 3) * 3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setRowNumberAsRowIndicatorColumn() {
        this.rowNumber = ((this.value / 30) * 3) + (this.bucket / 3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getWidth() {
        return this.endX - this.startX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getStartX() {
        return this.startX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getEndX() {
        return this.endX;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getBucket() {
        return this.bucket;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getRowNumber() {
        return this.rowNumber;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setRowNumber(int i) {
        this.rowNumber = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.rowNumber + "|" + this.value;
    }
}
