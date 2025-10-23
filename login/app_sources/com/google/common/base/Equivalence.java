package com.google.common.base;

import java.io.Serializable;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class Equivalence<T> {
    protected abstract boolean doEquivalent(T t, T t2);

    protected abstract int doHash(T t);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected Equivalence() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equivalent(@CheckForNull T t, @CheckForNull T t2) {
        if (t == t2) {
            return true;
        }
        if (t == null || t2 == null) {
            return false;
        }
        return doEquivalent(t, t2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hash(@CheckForNull T t) {
        if (t == null) {
            return 0;
        }
        return doHash(t);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <F> Equivalence<F> onResultOf(Function<? super F, ? extends T> function) {
        return new FunctionalEquivalence(function, this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <S extends T> Wrapper<S> wrap(@ParametricNullness S s) {
        return new Wrapper<>(s);
    }

    public static final class Wrapper<T> implements Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<? super T> equivalence;

        @ParametricNullness
        private final T reference;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Wrapper(Equivalence<? super T> equivalence, @ParametricNullness T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.reference = t;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @ParametricNullness
        public T get() {
            return this.reference;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean equals(@CheckForNull Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Wrapper)) {
                return false;
            }
            Wrapper wrapper = (Wrapper) obj;
            if (this.equivalence.equals(wrapper.equivalence)) {
                return this.equivalence.equivalent(this.reference, wrapper.reference);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.equivalence.hash(this.reference);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.reference);
            return new StringBuilder(String.valueOf(valueOf).length() + 7 + String.valueOf(valueOf2).length()).append(valueOf).append(".wrap(").append(valueOf2).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <S extends T> Equivalence<Iterable<S>> pairwise() {
        return new PairwiseEquivalence(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Predicate<T> equivalentTo(@CheckForNull T t) {
        return new EquivalentToPredicate(this, t);
    }

    private static final class EquivalentToPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Equivalence<T> equivalence;

        @CheckForNull
        private final T target;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        EquivalentToPredicate(Equivalence<T> equivalence, @CheckForNull T t) {
            this.equivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
            this.target = t;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(@CheckForNull T t) {
            return this.equivalence.equivalent(t, this.target);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof EquivalentToPredicate)) {
                return false;
            }
            EquivalentToPredicate equivalentToPredicate = (EquivalentToPredicate) obj;
            return this.equivalence.equals(equivalentToPredicate.equivalence) && Objects.equal(this.target, equivalentToPredicate.target);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Objects.hashCode(this.equivalence, this.target);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.equivalence);
            String valueOf2 = String.valueOf(this.target);
            return new StringBuilder(String.valueOf(valueOf).length() + 15 + String.valueOf(valueOf2).length()).append(valueOf).append(".equivalentTo(").append(valueOf2).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Equivalence<Object> equals() {
        return Equals.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Equivalence<Object> identity() {
        return Identity.INSTANCE;
    }

    static final class Equals extends Equivalence<Object> implements Serializable {
        static final Equals INSTANCE = new Equals();
        private static final long serialVersionUID = 1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Equals() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object obj, Object obj2) {
            return obj.equals(obj2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Equivalence
        protected int doHash(Object obj) {
            return obj.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Object readResolve() {
            return INSTANCE;
        }
    }

    static final class Identity extends Equivalence<Object> implements Serializable {
        static final Identity INSTANCE = new Identity();
        private static final long serialVersionUID = 1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Equivalence
        protected boolean doEquivalent(Object obj, Object obj2) {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Identity() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Equivalence
        protected int doHash(Object obj) {
            return System.identityHashCode(obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Object readResolve() {
            return INSTANCE;
        }
    }
}
