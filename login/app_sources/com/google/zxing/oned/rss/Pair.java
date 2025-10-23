package com.google.zxing.oned.rss;

/* loaded from: classes3.dex */
final class Pair extends DataCharacter {
    private int count;
    private final FinderPattern finderPattern;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Pair(int i, int i2, FinderPattern finderPattern) {
        super(i, i2);
        this.finderPattern = finderPattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getCount() {
        return this.count;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void incrementCount() {
        this.count++;
    }
}
