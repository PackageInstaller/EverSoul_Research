package com.google.zxing;

/* loaded from: classes3.dex */
public final class Dimension {
    private final int height;
    private final int width;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Dimension(int i, int i2) {
        if (i < 0 || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.width = i;
        this.height = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getWidth() {
        return this.width;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getHeight() {
        return this.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            if (this.width == dimension.width && this.height == dimension.height) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.width + "x" + this.height;
    }
}
