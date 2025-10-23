package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

/* loaded from: classes3.dex */
abstract class Token {
    static final Token EMPTY = new SimpleToken(null, 0, 0);
    private final Token previous;

    abstract void appendTo(BitArray bitArray, byte[] bArr);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Token(Token token) {
        this.previous = token;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Token getPrevious() {
        return this.previous;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Token add(int i, int i2) {
        return new SimpleToken(this, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Token addBinaryShift(int i, int i2) {
        return new BinaryShiftToken(this, i, i2);
    }
}
