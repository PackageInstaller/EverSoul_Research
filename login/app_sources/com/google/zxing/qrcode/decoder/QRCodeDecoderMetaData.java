package com.google.zxing.qrcode.decoder;

import com.google.zxing.ResultPoint;

/* loaded from: classes3.dex */
public final class QRCodeDecoderMetaData {
    private final boolean mirrored;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    QRCodeDecoderMetaData(boolean z) {
        this.mirrored = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isMirrored() {
        return this.mirrored;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void applyMirroredCorrection(ResultPoint[] resultPointArr) {
        if (!this.mirrored || resultPointArr == null || resultPointArr.length < 3) {
            return;
        }
        ResultPoint resultPoint = resultPointArr[0];
        resultPointArr[0] = resultPointArr[2];
        resultPointArr[2] = resultPoint;
    }
}
