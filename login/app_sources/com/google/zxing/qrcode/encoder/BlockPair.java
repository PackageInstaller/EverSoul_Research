package com.google.zxing.qrcode.encoder;

/* loaded from: classes3.dex */
final class BlockPair {
    private final byte[] dataBytes;
    private final byte[] errorCorrectionBytes;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    BlockPair(byte[] bArr, byte[] bArr2) {
        this.dataBytes = bArr;
        this.errorCorrectionBytes = bArr2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] getDataBytes() {
        return this.dataBytes;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public byte[] getErrorCorrectionBytes() {
        return this.errorCorrectionBytes;
    }
}
