package org.apache.commons.lang3.tuple;

/* loaded from: classes2.dex */
public class MutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final long serialVersionUID = 1;
    public L left;
    public M middle;
    public R right;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <L, M, R> MutableTriple<L, M, R> m891of(L l, M m, R r) {
        return new MutableTriple<>(l, m, r);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableTriple() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MutableTriple(L l, M m, R r) {
        this.left = l;
        this.middle = m;
        this.right = r;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Triple
    public L getLeft() {
        return this.left;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLeft(L l) {
        this.left = l;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Triple
    public M getMiddle() {
        return this.middle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setMiddle(M m) {
        this.middle = m;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Triple
    public R getRight() {
        return this.right;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setRight(R r) {
        this.right = r;
    }
}
