package org.apache.commons.lang3.tuple;

/* loaded from: classes2.dex */
public final class ImmutableTriple<L, M, R> extends Triple<L, M, R> {
    private static final ImmutableTriple NULL = m889of((Object) null, (Object) null, (Object) null);
    private static final long serialVersionUID = 1;
    public final L left;
    public final M middle;
    public final R right;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <L, M, R> ImmutableTriple<L, M, R> nullTriple() {
        return NULL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <L, M, R> ImmutableTriple<L, M, R> m889of(L l, M m, R r) {
        return new ImmutableTriple<>(l, m, r);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImmutableTriple(L l, M m, R r) {
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
    @Override // org.apache.commons.lang3.tuple.Triple
    public M getMiddle() {
        return this.middle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Triple
    public R getRight() {
        return this.right;
    }
}
