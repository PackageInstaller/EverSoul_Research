package twitter4j;

import java.io.Serializable;

/* loaded from: classes4.dex */
abstract class EntityIndex implements Comparable<EntityIndex>, Serializable {
    private static final long serialVersionUID = 3757474748266170719L;
    private int start = -1;
    private int end = -1;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    EntityIndex() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(EntityIndex entityIndex) {
        long j = this.start - entityIndex.start;
        if (j < -2147483648L) {
            return Integer.MIN_VALUE;
        }
        if (j > 2147483647L) {
            return Integer.MAX_VALUE;
        }
        return (int) j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setStart(int i) {
        this.start = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void setEnd(int i) {
        this.end = i;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getStart() {
        return this.start;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getEnd() {
        return this.end;
    }
}
