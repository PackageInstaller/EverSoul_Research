package com.google.zxing;

import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes3.dex */
public abstract class LuminanceSource {
    private final int height;
    private final int width;

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i, byte[] bArr);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isCropSupported() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isRotateSupported() {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected LuminanceSource(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getWidth() {
        return this.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getHeight() {
        return this.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LuminanceSource crop(int i, int i2, int i3, int i4) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        byte[] bArr = new byte[this.width];
        StringBuilder sb = new StringBuilder(this.height * (this.width + 1));
        for (int i = 0; i < this.height; i++) {
            bArr = getRow(i, bArr);
            for (int i2 = 0; i2 < this.width; i2++) {
                int i3 = bArr[i2] & 255;
                sb.append(i3 < 64 ? '#' : i3 < 128 ? '+' : i3 < 192 ? ClassUtils.PACKAGE_SEPARATOR_CHAR : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
