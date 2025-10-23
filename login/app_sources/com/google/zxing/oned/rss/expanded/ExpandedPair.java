package com.google.zxing.oned.rss.expanded;

import com.google.zxing.oned.rss.DataCharacter;
import com.google.zxing.oned.rss.FinderPattern;

/* loaded from: classes3.dex */
final class ExpandedPair {
    private final FinderPattern finderPattern;
    private final DataCharacter leftChar;
    private final boolean mayBeLast;
    private final DataCharacter rightChar;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExpandedPair(DataCharacter dataCharacter, DataCharacter dataCharacter2, FinderPattern finderPattern, boolean z) {
        this.leftChar = dataCharacter;
        this.rightChar = dataCharacter2;
        this.finderPattern = finderPattern;
        this.mayBeLast = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean mayBeLast() {
        return this.mayBeLast;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DataCharacter getLeftChar() {
        return this.leftChar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    DataCharacter getRightChar() {
        return this.rightChar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    FinderPattern getFinderPattern() {
        return this.finderPattern;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean mustBeLast() {
        return this.rightChar == null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder("[ ").append(this.leftChar).append(" , ").append(this.rightChar).append(" : ");
        FinderPattern finderPattern = this.finderPattern;
        return append.append(finderPattern == null ? "null" : Integer.valueOf(finderPattern.getValue())).append(" ]").toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedPair)) {
            return false;
        }
        ExpandedPair expandedPair = (ExpandedPair) obj;
        return equalsOrNull(this.leftChar, expandedPair.leftChar) && equalsOrNull(this.rightChar, expandedPair.rightChar) && equalsOrNull(this.finderPattern, expandedPair.finderPattern);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean equalsOrNull(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (hashNotNull(this.leftChar) ^ hashNotNull(this.rightChar)) ^ hashNotNull(this.finderPattern);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int hashNotNull(Object obj) {
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }
}
