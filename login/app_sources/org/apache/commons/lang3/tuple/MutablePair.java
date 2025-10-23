package org.apache.commons.lang3.tuple;

/* loaded from: classes2.dex */
public class MutablePair<L, R> extends Pair<L, R> {
    private static final long serialVersionUID = 4954918890077093841L;
    public L left;
    public R right;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <L, R> MutablePair<L, R> m890of(L l, R r) {
        return new MutablePair<>(l, r);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutablePair() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLeft(L l) {
        this.left = l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRight(R r) {
        this.right = r;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public R setValue(R r) {
        R right = getRight();
        setRight(r);
        return right;
    }
}
