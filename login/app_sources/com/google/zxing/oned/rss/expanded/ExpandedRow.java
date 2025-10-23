package com.google.zxing.oned.rss.expanded;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
final class ExpandedRow {
    private final List<ExpandedPair> pairs;
    private final int rowNumber;
    private final boolean wasReversed;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExpandedRow(List<ExpandedPair> list, int i, boolean z) {
        this.pairs = new ArrayList(list);
        this.rowNumber = i;
        this.wasReversed = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    List<ExpandedPair> getPairs() {
        return this.pairs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    int getRowNumber() {
        return this.rowNumber;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isReversed() {
        return this.wasReversed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isEquivalent(List<ExpandedPair> list) {
        return this.pairs.equals(list);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "{ " + this.pairs + " }";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof ExpandedRow)) {
            return false;
        }
        ExpandedRow expandedRow = (ExpandedRow) obj;
        return this.pairs.equals(expandedRow.getPairs()) && this.wasReversed == expandedRow.wasReversed;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.pairs.hashCode() ^ Boolean.valueOf(this.wasReversed).hashCode();
    }
}
