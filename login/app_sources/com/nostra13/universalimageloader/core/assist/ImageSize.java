package com.nostra13.universalimageloader.core.assist;

import com.liapp.y;

/* loaded from: classes3.dex */
public class ImageSize {
    private static final String SEPARATOR = "x";
    private static final int TO_STRING_MAX_LENGHT = 9;
    private final int height;
    private final int width;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageSize(int i, int i2) {
        this.width = i;
        this.height = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageSize(int i, int i2, int i3) {
        if (i3 % 180 == 0) {
            this.width = i;
            this.height = i2;
        } else {
            this.width = i2;
            this.height = i;
        }
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
    public ImageSize scaleDown(int i) {
        return new ImageSize(this.width / i, this.height / i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImageSize scale(float f) {
        return new ImageSize((int) (this.width * f), (int) (this.height * f));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return new StringBuilder(9).append(this.width).append(y.ٴسسݬߨ(1392956602)).append(this.height).toString();
    }
}
