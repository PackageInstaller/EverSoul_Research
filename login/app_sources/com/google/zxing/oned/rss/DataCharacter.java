package com.google.zxing.oned.rss;

/* loaded from: classes3.dex */
public class DataCharacter {
    private final int checksumPortion;
    private final int value;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public DataCharacter(int i, int i2) {
        this.value = i;
        this.checksumPortion = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int getChecksumPortion() {
        return this.checksumPortion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return this.value + "(" + this.checksumPortion + ')';
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (!(obj instanceof DataCharacter)) {
            return false;
        }
        DataCharacter dataCharacter = (DataCharacter) obj;
        return this.value == dataCharacter.value && this.checksumPortion == dataCharacter.checksumPortion;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return this.value ^ this.checksumPortion;
    }
}
