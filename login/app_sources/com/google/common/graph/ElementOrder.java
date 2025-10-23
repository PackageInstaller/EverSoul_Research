package com.google.common.graph;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.common.collect.Ordering;
import com.google.errorprone.annotations.Immutable;
import java.util.Comparator;
import java.util.Map;
import javax.annotation.CheckForNull;

@Immutable
@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class ElementOrder<T> {

    @CheckForNull
    private final Comparator<T> comparator;
    private final Type type;

    public enum Type {
        UNORDERED,
        STABLE,
        INSERTION,
        SORTED
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    <T1 extends T> ElementOrder<T1> cast() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ElementOrder(Type type, @CheckForNull Comparator<T> comparator) {
        this.type = (Type) Preconditions.checkNotNull(type);
        this.comparator = comparator;
        Preconditions.checkState((type == Type.SORTED) == (comparator != null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <S> ElementOrder<S> unordered() {
        return new ElementOrder<>(Type.UNORDERED, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <S> ElementOrder<S> stable() {
        return new ElementOrder<>(Type.STABLE, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <S> ElementOrder<S> insertion() {
        return new ElementOrder<>(Type.INSERTION, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <S extends Comparable<? super S>> ElementOrder<S> natural() {
        return new ElementOrder<>(Type.SORTED, Ordering.natural());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <S> ElementOrder<S> sorted(Comparator<S> comparator) {
        return new ElementOrder<>(Type.SORTED, (Comparator) Preconditions.checkNotNull(comparator));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Type type() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Comparator<T> comparator() {
        Comparator<T> comparator = this.comparator;
        if (comparator != null) {
            return comparator;
        }
        throw new UnsupportedOperationException("This ordering does not define a comparator.");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ElementOrder)) {
            return false;
        }
        ElementOrder elementOrder = (ElementOrder) obj;
        return this.type == elementOrder.type && Objects.equal(this.comparator, elementOrder.comparator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hashCode(this.type, this.comparator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        MoreObjects.ToStringHelper add = MoreObjects.toStringHelper(this).add("type", this.type);
        Comparator<T> comparator = this.comparator;
        if (comparator != null) {
            add.add("comparator", comparator);
        }
        return add.toString();
    }

    /* renamed from: com.google.common.graph.ElementOrder$1 */
    static /* synthetic */ class C15341 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$graph$ElementOrder$Type;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$google$common$graph$ElementOrder$Type = iArr;
            try {
                iArr[Type.UNORDERED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.INSERTION.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.STABLE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$google$common$graph$ElementOrder$Type[Type.SORTED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    <K extends T, V> Map<K, V> createMap(int i) {
        int i2 = C15341.$SwitchMap$com$google$common$graph$ElementOrder$Type[this.type.ordinal()];
        if (i2 == 1) {
            return Maps.newHashMapWithExpectedSize(i);
        }
        if (i2 == 2 || i2 == 3) {
            return Maps.newLinkedHashMapWithExpectedSize(i);
        }
        if (i2 == 4) {
            return Maps.newTreeMap(comparator());
        }
        throw new AssertionError();
    }
}
