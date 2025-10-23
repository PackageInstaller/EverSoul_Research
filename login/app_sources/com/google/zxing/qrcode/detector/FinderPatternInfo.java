package com.google.zxing.qrcode.detector;

/* loaded from: classes3.dex */
public final class FinderPatternInfo {
    private final FinderPattern bottomLeft;
    private final FinderPattern topLeft;
    private final FinderPattern topRight;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FinderPatternInfo(FinderPattern[] finderPatternArr) {
        this.bottomLeft = finderPatternArr[0];
        this.topLeft = finderPatternArr[1];
        this.topRight = finderPatternArr[2];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FinderPattern getBottomLeft() {
        return this.bottomLeft;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FinderPattern getTopLeft() {
        return this.topLeft;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FinderPattern getTopRight() {
        return this.topRight;
    }
}
