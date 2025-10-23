package com.google.common.base;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Functions {

    private enum IdentityFunction implements Function<Object, Object> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        @CheckForNull
        public Object apply(@CheckForNull Object obj) {
            return obj;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Enum
        public String toString() {
            return "Functions.identity()";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Functions() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Function<Object, String> toStringFunction() {
        return ToStringFunction.INSTANCE;
    }

    private enum ToStringFunction implements Function<Object, String> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Enum
        public String toString() {
            return "Functions.toStringFunction()";
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public String apply(Object obj) {
            Preconditions.checkNotNull(obj);
            return obj.toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> Function<E, E> identity() {
        return IdentityFunction.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> Function<K, V> forMap(Map<K, V> map) {
        return new FunctionForMapNoDefault(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> Function<K, V> forMap(Map<K, ? extends V> map, @ParametricNullness V v) {
        return new ForMapWithDefault(map, v);
    }

    private static class FunctionForMapNoDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;
        final Map<K, V> map;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        FunctionForMapNoDefault(Map<K, V> map) {
            this.map = (Map) Preconditions.checkNotNull(map);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        @ParametricNullness
        public V apply(@ParametricNullness K k) {
            V v = this.map.get(k);
            Preconditions.checkArgument(v != null || this.map.containsKey(k), "Key '%s' not present in map", k);
            return (V) NullnessCasts.uncheckedCastNullableTToT(v);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof FunctionForMapNoDefault) {
                return this.map.equals(((FunctionForMapNoDefault) obj).map);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.map.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.map);
            return new StringBuilder(String.valueOf(valueOf).length() + 18).append("Functions.forMap(").append(valueOf).append(")").toString();
        }
    }

    private static class ForMapWithDefault<K, V> implements Function<K, V>, Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        final V defaultValue;
        final Map<K, ? extends V> map;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ForMapWithDefault(Map<K, ? extends V> map, @ParametricNullness V v) {
            this.map = (Map) Preconditions.checkNotNull(map);
            this.defaultValue = v;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        @ParametricNullness
        public V apply(@ParametricNullness K k) {
            V v = this.map.get(k);
            if (v != null || this.map.containsKey(k)) {
                return (V) NullnessCasts.uncheckedCastNullableTToT(v);
            }
            return this.defaultValue;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof ForMapWithDefault)) {
                return false;
            }
            ForMapWithDefault forMapWithDefault = (ForMapWithDefault) obj;
            return this.map.equals(forMapWithDefault.map) && Objects.equal(this.defaultValue, forMapWithDefault.defaultValue);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return Objects.hashCode(this.map, this.defaultValue);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.map);
            String valueOf2 = String.valueOf(this.defaultValue);
            return new StringBuilder(String.valueOf(valueOf).length() + 33 + String.valueOf(valueOf2).length()).append("Functions.forMap(").append(valueOf).append(", defaultValue=").append(valueOf2).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <A, B, C> Function<A, C> compose(Function<B, C> function, Function<A, ? extends B> function2) {
        return new FunctionComposition(function, function2);
    }

    private static class FunctionComposition<A, B, C> implements Function<A, C>, Serializable {
        private static final long serialVersionUID = 0;

        /* renamed from: f */
        private final Function<A, ? extends B> f350f;

        /* renamed from: g */
        private final Function<B, C> f351g;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public FunctionComposition(Function<B, C> function, Function<A, ? extends B> function2) {
            this.f351g = (Function) Preconditions.checkNotNull(function);
            this.f350f = (Function) Preconditions.checkNotNull(function2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        @ParametricNullness
        public C apply(@ParametricNullness A a2) {
            return (C) this.f351g.apply(this.f350f.apply(a2));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (!(obj instanceof FunctionComposition)) {
                return false;
            }
            FunctionComposition functionComposition = (FunctionComposition) obj;
            return this.f350f.equals(functionComposition.f350f) && this.f351g.equals(functionComposition.f351g);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.f350f.hashCode() ^ this.f351g.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.f351g);
            String valueOf2 = String.valueOf(this.f350f);
            return new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length()).append(valueOf).append("(").append(valueOf2).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Function<T, Boolean> forPredicate(Predicate<T> predicate) {
        return new PredicateFunction(predicate);
    }

    private static class PredicateFunction<T> implements Function<T, Boolean>, Serializable {
        private static final long serialVersionUID = 0;
        private final Predicate<T> predicate;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public /* bridge */ /* synthetic */ Boolean apply(@ParametricNullness Object obj) {
            return apply((PredicateFunction<T>) obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private PredicateFunction(Predicate<T> predicate) {
            this.predicate = (Predicate) Preconditions.checkNotNull(predicate);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public Boolean apply(@ParametricNullness T t) {
            return Boolean.valueOf(this.predicate.apply(t));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof PredicateFunction) {
                return this.predicate.equals(((PredicateFunction) obj).predicate);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.predicate.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.predicate);
            return new StringBuilder(String.valueOf(valueOf).length() + 24).append("Functions.forPredicate(").append(valueOf).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> Function<Object, E> constant(@ParametricNullness E e) {
        return new ConstantFunction(e);
    }

    private static class ConstantFunction<E> implements Function<Object, E>, Serializable {
        private static final long serialVersionUID = 0;

        @ParametricNullness
        private final E value;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ConstantFunction(@ParametricNullness E e) {
            this.value = e;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        @ParametricNullness
        public E apply(@CheckForNull Object obj) {
            return this.value;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof ConstantFunction) {
                return Objects.equal(this.value, ((ConstantFunction) obj).value);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            E e = this.value;
            if (e == null) {
                return 0;
            }
            return e.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.value);
            return new StringBuilder(String.valueOf(valueOf).length() + 20).append("Functions.constant(").append(valueOf).append(")").toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <F, T> Function<F, T> forSupplier(Supplier<T> supplier) {
        return new SupplierFunction(supplier);
    }

    private static class SupplierFunction<F, T> implements Function<F, T>, Serializable {
        private static final long serialVersionUID = 0;
        private final Supplier<T> supplier;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private SupplierFunction(Supplier<T> supplier) {
            this.supplier = (Supplier) Preconditions.checkNotNull(supplier);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        @ParametricNullness
        public T apply(@ParametricNullness F f) {
            return this.supplier.get();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof SupplierFunction) {
                return this.supplier.equals(((SupplierFunction) obj).supplier);
            }
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public int hashCode() {
            return this.supplier.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            String valueOf = String.valueOf(this.supplier);
            return new StringBuilder(String.valueOf(valueOf).length() + 23).append("Functions.forSupplier(").append(valueOf).append(")").toString();
        }
    }
}
