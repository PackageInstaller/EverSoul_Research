package com.google.zxing.qrcode.decoder;

/* loaded from: classes3.dex */
public enum ErrorCorrectionLevel {
    L(1),
    M(0),
    Q(3),
    H(2);

    private static final ErrorCorrectionLevel[] FOR_BITS;
    private final int bits;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        ErrorCorrectionLevel errorCorrectionLevel = L;
        ErrorCorrectionLevel errorCorrectionLevel2 = M;
        ErrorCorrectionLevel errorCorrectionLevel3 = Q;
        FOR_BITS = new ErrorCorrectionLevel[]{errorCorrectionLevel2, errorCorrectionLevel, H, errorCorrectionLevel3};
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ErrorCorrectionLevel(int i) {
        this.bits = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getBits() {
        return this.bits;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ErrorCorrectionLevel forBits(int i) {
        if (i >= 0) {
            ErrorCorrectionLevel[] errorCorrectionLevelArr = FOR_BITS;
            if (i < errorCorrectionLevelArr.length) {
                return errorCorrectionLevelArr[i];
            }
        }
        throw new IllegalArgumentException();
    }
}
