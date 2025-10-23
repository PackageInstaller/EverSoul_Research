package com.google.zxing.qrcode.decoder;

import com.google.zxing.common.BitMatrix;

/* loaded from: classes3.dex */
enum DataMask {
    DATA_MASK_000 { // from class: com.google.zxing.qrcode.decoder.DataMask.1
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return ((i + i2) & 1) == 0;
        }
    },
    DATA_MASK_001 { // from class: com.google.zxing.qrcode.decoder.DataMask.2
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (i & 1) == 0;
        }
    },
    DATA_MASK_010 { // from class: com.google.zxing.qrcode.decoder.DataMask.3
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return i2 % 3 == 0;
        }
    },
    DATA_MASK_011 { // from class: com.google.zxing.qrcode.decoder.DataMask.4
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (i + i2) % 3 == 0;
        }
    },
    DATA_MASK_100 { // from class: com.google.zxing.qrcode.decoder.DataMask.5
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (((i / 2) + (i2 / 3)) & 1) == 0;
        }
    },
    DATA_MASK_101 { // from class: com.google.zxing.qrcode.decoder.DataMask.6
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (i * i2) % 6 == 0;
        }
    },
    DATA_MASK_110 { // from class: com.google.zxing.qrcode.decoder.DataMask.7
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (i * i2) % 6 < 3;
        }
    },
    DATA_MASK_111 { // from class: com.google.zxing.qrcode.decoder.DataMask.8
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.zxing.qrcode.decoder.DataMask
        boolean isMasked(int i, int i2) {
            return (((i + i2) + ((i * i2) % 3)) & 1) == 0;
        }
    };

    abstract boolean isMasked(int i, int i2);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void unmaskBitMatrix(BitMatrix bitMatrix, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                if (isMasked(i2, i3)) {
                    bitMatrix.flip(i3, i2);
                }
            }
        }
    }
}
