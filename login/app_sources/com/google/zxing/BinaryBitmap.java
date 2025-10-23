package com.google.zxing;

import com.google.zxing.common.BitArray;
import com.google.zxing.common.BitMatrix;

/* loaded from: classes3.dex */
public final class BinaryBitmap {
    private final Binarizer binarizer;
    private BitMatrix matrix;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BinaryBitmap(Binarizer binarizer) {
        if (binarizer == null) {
            throw new IllegalArgumentException("Binarizer must be non-null.");
        }
        this.binarizer = binarizer;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getWidth() {
        return this.binarizer.getWidth();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getHeight() {
        return this.binarizer.getHeight();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitArray getBlackRow(int i, BitArray bitArray) throws NotFoundException {
        return this.binarizer.getBlackRow(i, bitArray);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BitMatrix getBlackMatrix() throws NotFoundException {
        if (this.matrix == null) {
            this.matrix = this.binarizer.getBlackMatrix();
        }
        return this.matrix;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCropSupported() {
        return this.binarizer.getLuminanceSource().isCropSupported();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BinaryBitmap crop(int i, int i2, int i3, int i4) {
        return new BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().crop(i, i2, i3, i4)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isRotateSupported() {
        return this.binarizer.getLuminanceSource().isRotateSupported();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BinaryBitmap rotateCounterClockwise() {
        return new BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().rotateCounterClockwise()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BinaryBitmap rotateCounterClockwise45() {
        return new BinaryBitmap(this.binarizer.createBinarizer(this.binarizer.getLuminanceSource().rotateCounterClockwise45()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        try {
            return getBlackMatrix().toString();
        } catch (NotFoundException unused) {
            return "";
        }
    }
}
