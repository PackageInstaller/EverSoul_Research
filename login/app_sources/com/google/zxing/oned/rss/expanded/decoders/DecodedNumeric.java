package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

/* loaded from: classes3.dex */
final class DecodedNumeric extends DecodedObject {
    static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DecodedNumeric(int i, int i2, int i3) throws FormatException {
        super(i);
        if (i2 < 0 || i2 > 10 || i3 < 0 || i3 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.firstDigit = i2;
        this.secondDigit = i3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getFirstDigit() {
        return this.firstDigit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getSecondDigit() {
        return this.secondDigit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getValue() {
        return (this.firstDigit * 10) + this.secondDigit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isFirstDigitFNC1() {
        return this.firstDigit == 10;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isSecondDigitFNC1() {
        return this.secondDigit == 10;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isAnyFNC1() {
        return this.firstDigit == 10 || this.secondDigit == 10;
    }
}
