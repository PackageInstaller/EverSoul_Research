package org.apache.commons.lang3.tuple;

/* loaded from: classes2.dex */
public final class ImmutablePair<L, R> extends Pair<L, R> {
    private static final ImmutablePair NULL = m888of((Object) null, (Object) null);
    private static final long serialVersionUID = 4954918890077093841L;
    public final L left;
    public final R right;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <L, R> ImmutablePair<L, R> nullPair() {
        return NULL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <L, R> ImmutablePair<L, R> m888of(L l, R r) {
        return new ImmutablePair<>(l, r);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImmutablePair(L l, R r) {
        this.left = l;
        this.right = r;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Pair
    public L getLeft() {
        return this.left;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.tuple.Pair
    public R getRight() {
        return this.right;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public R setValue(R r) {
        throw new UnsupportedOperationException();
    }
}
