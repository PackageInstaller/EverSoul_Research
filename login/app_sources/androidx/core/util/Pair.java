package androidx.core.util;

import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class Pair<F, S> {
    public final F first;
    public final S second;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Pair(F f, S s) {
        this.first = f;
        this.second = s;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        return ObjectsCompat.equals(pair.first, this.first) && ObjectsCompat.equals(pair.second, this.second);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        F f = this.first;
        int hashCode = f == null ? 0 : f.hashCode();
        S s = this.second;
        return hashCode ^ (s != null ? s.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return "Pair{" + this.first + StringUtils.SPACE + this.second + "}";
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <A, B> Pair<A, B> create(A a2, B b) {
        return new Pair<>(a2, b);
    }
}
