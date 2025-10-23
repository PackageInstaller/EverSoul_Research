package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes3.dex */
final class DecodedInformation extends DecodedObject {
    private final String newString;
    private final boolean remaining;
    private final int remainingValue;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DecodedInformation(int i, String str) {
        super(i);
        this.newString = str;
        this.remaining = false;
        this.remainingValue = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DecodedInformation(int i, String str, int i2) {
        super(i);
        this.remaining = true;
        this.remainingValue = i2;
        this.newString = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String getNewString() {
        return this.newString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isRemaining() {
        return this.remaining;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getRemainingValue() {
        return this.remainingValue;
    }
}
