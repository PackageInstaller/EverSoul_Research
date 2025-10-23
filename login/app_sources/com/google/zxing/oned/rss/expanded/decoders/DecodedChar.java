package com.google.zxing.oned.rss.expanded.decoders;

/* loaded from: classes3.dex */
final class DecodedChar extends DecodedObject {
    static final char FNC1 = '$';
    private final char value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DecodedChar(int i, char c) {
        super(i);
        this.value = c;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    char getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isFNC1() {
        return this.value == '$';
    }
}
