package com.google.zxing.pdf417.encoder;

/* loaded from: classes3.dex */
final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BarcodeRow(int i) {
        this.row = new byte[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void set(int i, byte b) {
        this.row[i] = b;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void set(int i, boolean z) {
        this.row[i] = z ? (byte) 1 : (byte) 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void addBar(boolean z, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = this.currentLocation;
            this.currentLocation = i3 + 1;
            set(i3, z);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    byte[] getScaledRow(int i) {
        int length = this.row.length * i;
        byte[] bArr = new byte[length];
        for (int i2 = 0; i2 < length; i2++) {
            bArr[i2] = this.row[i2 / i];
        }
        return bArr;
    }
}
