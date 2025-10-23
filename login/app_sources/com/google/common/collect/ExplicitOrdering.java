package com.google.common.collect;

import com.google.common.collect.Ordering;
import java.io.Serializable;
import java.util.List;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class ExplicitOrdering<T> extends Ordering<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final ImmutableMap<T, Integer> rankMap;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExplicitOrdering(List<T> list) {
        this(Maps.indexMap(list));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ExplicitOrdering(ImmutableMap<T, Integer> immutableMap) {
        this.rankMap = immutableMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.Ordering, java.util.Comparator
    public int compare(T t, T t2) {
        return rank(t) - rank(t2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int rank(T t) {
        Integer num = this.rankMap.get(t);
        if (num == null) {
            throw new Ordering.IncomparableValueException(t);
        }
        return num.intValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Comparator
    public boolean equals(@CheckForNull Object obj) {
        if (obj instanceof ExplicitOrdering) {
            return this.rankMap.equals(((ExplicitOrdering) obj).rankMap);
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.rankMap.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        String valueOf = String.valueOf(this.rankMap.keySet());
        return new StringBuilder(String.valueOf(valueOf).length() + 19).append("Ordering.explicit(").append(valueOf).append(")").toString();
    }
}
