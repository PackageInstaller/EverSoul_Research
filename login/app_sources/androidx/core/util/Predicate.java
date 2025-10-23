package androidx.core.util;

import java.util.Objects;

/* loaded from: classes.dex */
public interface Predicate<T> {
    boolean test(T t);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default Predicate<T> and(final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate() { // from class: androidx.core.util.Predicate$$ExternalSyntheticLambda3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return Predicate.lambda$and$0(Predicate.this, predicate, obj);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean lambda$and$0(Predicate _this, Predicate predicate, Object obj) {
        return _this.test(obj) && predicate.test(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean lambda$negate$1(Predicate _this, Object obj) {
        return !_this.test(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    default Predicate<T> negate() {
        return new Predicate() { // from class: androidx.core.util.Predicate$$ExternalSyntheticLambda4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return Predicate.lambda$negate$1(Predicate.this, obj);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    default Predicate<T> m36or(final Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return new Predicate() { // from class: androidx.core.util.Predicate$$ExternalSyntheticLambda0
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj) {
                return Predicate.lambda$or$2(Predicate.this, predicate, obj);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static /* synthetic */ boolean lambda$or$2(Predicate _this, Predicate predicate, Object obj) {
        return _this.test(obj) || predicate.test(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> Predicate<T> isEqual(final Object obj) {
        if (obj == null) {
            return new Predicate() { // from class: androidx.core.util.Predicate$$ExternalSyntheticLambda1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // androidx.core.util.Predicate
                public final boolean test(Object obj2) {
                    boolean isNull;
                    isNull = Objects.isNull(obj2);
                    return isNull;
                }
            };
        }
        return new Predicate() { // from class: androidx.core.util.Predicate$$ExternalSyntheticLambda2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.core.util.Predicate
            public final boolean test(Object obj2) {
                boolean equals;
                equals = obj.equals(obj2);
                return equals;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> Predicate<T> not(Predicate<? super T> predicate) {
        Objects.requireNonNull(predicate);
        return predicate.negate();
    }
}
