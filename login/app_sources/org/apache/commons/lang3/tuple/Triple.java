package org.apache.commons.lang3.tuple;

import com.liapp.y;
import java.io.Serializable;
import java.util.Objects;
import org.apache.commons.lang3.builder.CompareToBuilder;

/* loaded from: classes2.dex */
public abstract class Triple<L, M, R> implements Comparable<Triple<L, M, R>>, Serializable {
    private static final long serialVersionUID = 1;

    public abstract L getLeft();

    public abstract M getMiddle();

    public abstract R getRight();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <L, M, R> Triple<L, M, R> m893of(L l, M m, R r) {
        return new ImmutableTriple(l, m, r);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public int compareTo(Triple<L, M, R> triple) {
        return new CompareToBuilder().append(getLeft(), triple.getLeft()).append(getMiddle(), triple.getMiddle()).append(getRight(), triple.getRight()).toComparison();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Triple)) {
            return false;
        }
        Triple triple = (Triple) obj;
        return Objects.equals(getLeft(), triple.getLeft()) && Objects.equals(getMiddle(), triple.getMiddle()) && Objects.equals(getRight(), triple.getRight());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return ((getLeft() == null ? 0 : getLeft().hashCode()) ^ (getMiddle() == null ? 0 : getMiddle().hashCode())) ^ (getRight() != null ? getRight().hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder append = new StringBuilder(y.٬ݯح׭٩(575982094)).append(getLeft());
        String str = y.ٲٴݴ״ٰ(1781559176);
        return append.append(str).append(getMiddle()).append(str).append(getRight()).append(y.ٴسسݬߨ(1392959042)).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString(String str) {
        return String.format(str, getLeft(), getMiddle(), getRight());
    }
}
