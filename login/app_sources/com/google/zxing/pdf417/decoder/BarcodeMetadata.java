package com.google.zxing.pdf417.decoder;

/* loaded from: classes3.dex */
final class BarcodeMetadata {
    private final int columnCount;
    private final int errorCorrectionLevel;
    private final int rowCount;
    private final int rowCountLowerPart;
    private final int rowCountUpperPart;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BarcodeMetadata(int i, int i2, int i3, int i4) {
        this.columnCount = i;
        this.errorCorrectionLevel = i4;
        this.rowCountUpperPart = i2;
        this.rowCountLowerPart = i3;
        this.rowCount = i2 + i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getColumnCount() {
        return this.columnCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getRowCount() {
        return this.rowCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getRowCountUpperPart() {
        return this.rowCountUpperPart;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getRowCountLowerPart() {
        return this.rowCountLowerPart;
    }
}
