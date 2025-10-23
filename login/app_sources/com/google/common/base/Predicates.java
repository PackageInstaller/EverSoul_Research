package com.google.common.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Predicates {

    enum ObjectPredicate implements Predicate<Object> {
        ALWAYS_TRUE { // from class: com.google.common.base.Predicates.ObjectPredicate.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Predicate
            public boolean apply(@CheckForNull Object obj) {
                return true;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysTrue()";
            }
        },
        ALWAYS_FALSE { // from class: com.google.common.base.Predicates.ObjectPredicate.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Predicate
            public boolean apply(@CheckForNull Object obj) {
                return false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.alwaysFalse()";
            }
        },
        IS_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Predicate
            public boolean apply(@CheckForNull Object obj) {
                return obj == null;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.isNull()";
            }
        },
        NOT_NULL { // from class: com.google.common.base.Predicates.ObjectPredicate.4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.base.Predicate
            public boolean apply(@CheckForNull Object obj) {
                return obj != null;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Enum
            public String toString() {
                return "Predicates.notNull()";
            }
        };

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        <T> Predicate<T> withNarrowedType() {
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Predicates() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> alwaysTrue() {
        return ObjectPredicate.ALWAYS_TRUE.withNarrowedType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> alwaysFalse() {
        return ObjectPredicate.ALWAYS_FALSE.withNarrowedType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> isNull() {
        return ObjectPredicate.IS_NULL.withNarrowedType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> notNull() {
        return ObjectPredicate.NOT_NULL.withNarrowedType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> not(Predicate<T> predicate) {
        return new NotPredicate(predicate);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> and(Iterable<? extends Predicate<? super T>> iterable) {
        return new AndPredicate(defensiveCopy(iterable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public static <T> Predicate<T> and(Predicate<? super T>... predicateArr) {
        return new AndPredicate(defensiveCopy(predicateArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> and(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new AndPredicate(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    public static <T> Predicate<T> m191or(Iterable<? extends Predicate<? super T>> iterable) {
        return new OrPredicate(defensiveCopy(iterable));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    /* renamed from: or */
    public static <T> Predicate<T> m192or(Predicate<? super T>... predicateArr) {
        return new OrPredicate(defensiveCopy(predicateArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: or */
    public static <T> Predicate<T> m190or(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return new OrPredicate(asList((Predicate) Preconditions.checkNotNull(predicate), (Predicate) Preconditions.checkNotNull(predicate2)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> equalTo(@ParametricNullness T t) {
        if (t == null) {
            return isNull();
        }
        return new IsEqualToPredicate(t).withNarrowedType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Predicate<T> instanceOf(Class<?> cls) {
        return new InstanceOfPredicate(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Predicate<Class<?>> subtypeOf(Class<?> cls) {
        return new SubtypeOfPredicate(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: in */
    public static <T> Predicate<T> m189in(Collection<? extends T> collection) {
        return new InPredicate(collection);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <A, B> Predicate<A> compose(Predicate<B> predicate, Function<A, ? extends B> function) {
        return new CompositionPredicate(predicate, function);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Predicate<CharSequence> containsPattern(String str) {
        return new ContainsPatternFromStringPredicate(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Predicate<CharSequence> contains(Pattern pattern) {
        return new ContainsPatternPredicate(new JdkPattern(pattern));
    }

    private static class NotPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        final Predicate<T> predicate;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        NotPredicate(Predicate<T> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T t) {
            return !this.predicate.apply(t);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return ~this.predicate.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof NotPredicate) {
                return this.predicate.equals(((NotPredicate) obj).predicate);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.predicate);
            return new StringBuilder(String.valueOf(valueOf).length() + 16).append("Predicates.not(").append(valueOf).append(")").toString();
        }
    }

    private static class AndPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AndPredicate(List<? extends Predicate<? super T>> list) {
            this.components = list;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (!this.components.get(i).apply(t)) {
                    return false;
                }
            }
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.components.hashCode() + 306654252;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AndPredicate) {
                return this.components.equals(((AndPredicate) obj).components);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return Predicates.toStringHelper("and", this.components);
        }
    }

    private static class OrPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final List<? extends Predicate<? super T>> components;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private OrPredicate(List<? extends Predicate<? super T>> list) {
            this.components = list;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T t) {
            for (int i = 0; i < this.components.size(); i++) {
                if (this.components.get(i).apply(t)) {
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.components.hashCode() + 87855567;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof OrPredicate) {
                return this.components.equals(((OrPredicate) obj).components);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return Predicates.toStringHelper("or", this.components);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String toStringHelper(String str, Iterable<?> iterable) {
        StringBuilder append = new StringBuilder("Predicates.").append(str).append('(');
        boolean z = true;
        for (Object obj : iterable) {
            if (!z) {
                append.append(',');
            }
            append.append(obj);
            z = false;
        }
        return append.append(')').toString();
    }

    private static class IsEqualToPredicate implements Predicate<Object>, Serializable {
        private static final long serialVersionUID = 0;
        private final Object target;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        <T> Predicate<T> withNarrowedType() {
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private IsEqualToPredicate(Object obj) {
            this.target = obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(@CheckForNull Object obj) {
            return this.target.equals(obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.target.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof IsEqualToPredicate) {
                return this.target.equals(((IsEqualToPredicate) obj).target);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.target);
            return new StringBuilder(String.valueOf(valueOf).length() + 20).append("Predicates.equalTo(").append(valueOf).append(")").toString();
        }
    }

    private static class InstanceOfPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InstanceOfPredicate(Class<?> cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T t) {
            return this.clazz.isInstance(t);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.clazz.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            return (obj instanceof InstanceOfPredicate) && this.clazz == ((InstanceOfPredicate) obj).clazz;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String name = this.clazz.getName();
            return new StringBuilder(String.valueOf(name).length() + 23).append("Predicates.instanceOf(").append(name).append(")").toString();
        }
    }

    private static class SubtypeOfPredicate implements Predicate<Class<?>>, Serializable {
        private static final long serialVersionUID = 0;
        private final Class<?> clazz;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SubtypeOfPredicate(Class<?> cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(Class<?> cls) {
            return this.clazz.isAssignableFrom(cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.clazz.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            return (obj instanceof SubtypeOfPredicate) && this.clazz == ((SubtypeOfPredicate) obj).clazz;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String name = this.clazz.getName();
            return new StringBuilder(String.valueOf(name).length() + 22).append("Predicates.subtypeOf(").append(name).append(")").toString();
        }
    }

    private static class InPredicate<T> implements Predicate<T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Collection<?> target;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private InPredicate(Collection<?> collection) {
            this.target = (Collection) Preconditions.checkNotNull(collection);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness T t) {
            try {
                return this.target.contains(t);
            } catch (ClassCastException | NullPointerException unused) {
                return false;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof InPredicate) {
                return this.target.equals(((InPredicate) obj).target);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.target.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.target);
            return new StringBuilder(String.valueOf(valueOf).length() + 15).append("Predicates.in(").append(valueOf).append(")").toString();
        }
    }

    private static class CompositionPredicate<A, B> implements Predicate<A>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f */
        final Function<A, ? extends B> f352f;

        /* renamed from: p */
        final Predicate<B> f353p;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private CompositionPredicate(Predicate<B> predicate, Function<A, ? extends B> function) {
            this.f353p = (Predicate) Preconditions.checkNotNull(predicate);
            this.f352f = (Function) Preconditions.checkNotNull(function);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(@ParametricNullness A a2) {
            return this.f353p.apply(this.f352f.apply(a2));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof CompositionPredicate)) {
                return false;
            }
            CompositionPredicate compositionPredicate = (CompositionPredicate) obj;
            return this.f352f.equals(compositionPredicate.f352f) && this.f353p.equals(compositionPredicate.f353p);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.f352f.hashCode() ^ this.f353p.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.f353p);
            String valueOf2 = String.valueOf(this.f352f);
            return new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length()).append(valueOf).append("(").append(valueOf2).append(")").toString();
        }
    }

    private static class ContainsPatternPredicate implements Predicate<CharSequence>, Serializable {
        private static final long serialVersionUID = 0;
        final CommonPattern pattern;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ContainsPatternPredicate(CommonPattern commonPattern) {
            this.pattern = (CommonPattern) Preconditions.checkNotNull(commonPattern);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean apply(CharSequence charSequence) {
            return this.pattern.matcher(charSequence).find();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Objects.hashCode(this.pattern.pattern(), Integer.valueOf(this.pattern.flags()));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicate
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ContainsPatternPredicate)) {
                return false;
            }
            ContainsPatternPredicate containsPatternPredicate = (ContainsPatternPredicate) obj;
            return Objects.equal(this.pattern.pattern(), containsPatternPredicate.pattern.pattern()) && this.pattern.flags() == containsPatternPredicate.pattern.flags();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String toStringHelper = MoreObjects.toStringHelper(this.pattern).add("pattern", this.pattern.pattern()).add("pattern.flags", this.pattern.flags()).toString();
            return new StringBuilder(String.valueOf(toStringHelper).length() + 21).append("Predicates.contains(").append(toStringHelper).append(")").toString();
        }
    }

    private static class ContainsPatternFromStringPredicate extends ContainsPatternPredicate {
        private static final long serialVersionUID = 0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ContainsPatternFromStringPredicate(String str) {
            super(Platform.compilePattern(str));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Predicates.ContainsPatternPredicate
        public String toString() {
            String pattern = this.pattern.pattern();
            return new StringBuilder(String.valueOf(pattern).length() + 28).append("Predicates.containsPattern(").append(pattern).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> List<Predicate<? super T>> asList(Predicate<? super T> predicate, Predicate<? super T> predicate2) {
        return Arrays.asList(predicate, predicate2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <T> List<T> defensiveCopy(T... tArr) {
        return defensiveCopy(Arrays.asList(tArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> List<T> defensiveCopy(Iterable<T> iterable) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(Preconditions.checkNotNull(it.next()));
        }
        return arrayList;
    }
}
