package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import java.io.Serializable;
import java.lang.Comparable;
import java.util.Comparator;
import java.util.Iterator;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Range<C extends Comparable> extends RangeGwtSerializationDependencies implements Predicate<C>, Serializable {
    private static final Range<Comparable> ALL = new Range<>(Cut.belowAll(), Cut.aboveAll());
    private static final long serialVersionUID = 0;
    final Cut<C> lowerBound;
    final Cut<C> upperBound;

    static class LowerBoundFn implements Function<Range, Cut> {
        static final LowerBoundFn INSTANCE = new LowerBoundFn();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        LowerBoundFn() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public Cut apply(Range range) {
            return range.lowerBound;
        }
    }

    static class UpperBoundFn implements Function<Range, Cut> {
        static final UpperBoundFn INSTANCE = new UpperBoundFn();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        UpperBoundFn() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Function
        public Cut apply(Range range) {
            return range.upperBound;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> lowerBoundFn() {
        return LowerBoundFn.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <C extends Comparable<?>> Function<Range<C>, Cut<C>> upperBoundFn() {
        return UpperBoundFn.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <C extends Comparable<?>> Ordering<Range<C>> rangeLexOrdering() {
        return (Ordering<Range<C>>) RangeLexOrdering.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <C extends Comparable<?>> Range<C> create(Cut<C> cut, Cut<C> cut2) {
        return new Range<>(cut, cut2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> open(C c, C c2) {
        return create(Cut.aboveValue(c), Cut.belowValue(c2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> closed(C c, C c2) {
        return create(Cut.belowValue(c), Cut.aboveValue(c2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> closedOpen(C c, C c2) {
        return create(Cut.belowValue(c), Cut.belowValue(c2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> openClosed(C c, C c2) {
        return create(Cut.aboveValue(c), Cut.aboveValue(c2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> range(C c, BoundType boundType, C c2, BoundType boundType2) {
        Preconditions.checkNotNull(boundType);
        Preconditions.checkNotNull(boundType2);
        return create(boundType == BoundType.OPEN ? Cut.aboveValue(c) : Cut.belowValue(c), boundType2 == BoundType.OPEN ? Cut.belowValue(c2) : Cut.aboveValue(c2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> lessThan(C c) {
        return create(Cut.belowAll(), Cut.belowValue(c));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> atMost(C c) {
        return create(Cut.belowAll(), Cut.aboveValue(c));
    }

    /* renamed from: com.google.common.collect.Range$1 */
    static /* synthetic */ class C14451 {
        static final /* synthetic */ int[] $SwitchMap$com$google$common$collect$BoundType;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static {
            int[] iArr = new int[BoundType.values().length];
            $SwitchMap$com$google$common$collect$BoundType = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$google$common$collect$BoundType[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> upTo(C c, BoundType boundType) {
        int i = C14451.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
        if (i == 1) {
            return lessThan(c);
        }
        if (i == 2) {
            return atMost(c);
        }
        throw new AssertionError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> greaterThan(C c) {
        return create(Cut.aboveValue(c), Cut.aboveAll());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> atLeast(C c) {
        return create(Cut.belowValue(c), Cut.aboveAll());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> downTo(C c, BoundType boundType) {
        int i = C14451.$SwitchMap$com$google$common$collect$BoundType[boundType.ordinal()];
        if (i == 1) {
            return greaterThan(c);
        }
        if (i == 2) {
            return atLeast(c);
        }
        throw new AssertionError();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> all() {
        return (Range<C>) ALL;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> singleton(C c) {
        return closed(c, c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <C extends Comparable<?>> Range<C> encloseAll(Iterable<C> iterable) {
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return closed((Comparable) sortedSet.first(), (Comparable) sortedSet.last());
            }
        }
        Iterator<C> it = iterable.iterator();
        Comparable comparable = (Comparable) Preconditions.checkNotNull(it.next());
        Comparable comparable2 = comparable;
        while (it.hasNext()) {
            Comparable comparable3 = (Comparable) Preconditions.checkNotNull(it.next());
            comparable = (Comparable) Ordering.natural().min(comparable, comparable3);
            comparable2 = (Comparable) Ordering.natural().max(comparable2, comparable3);
        }
        return closed(comparable, comparable2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Range(Cut<C> cut, Cut<C> cut2) {
        this.lowerBound = (Cut) Preconditions.checkNotNull(cut);
        this.upperBound = (Cut) Preconditions.checkNotNull(cut2);
        if (cut.compareTo((Cut) cut2) > 0 || cut == Cut.aboveAll() || cut2 == Cut.belowAll()) {
            String valueOf = String.valueOf(toString(cut, cut2));
            throw new IllegalArgumentException(valueOf.length() != 0 ? "Invalid range: ".concat(valueOf) : new String("Invalid range: "));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasLowerBound() {
        return this.lowerBound != Cut.belowAll();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C lowerEndpoint() {
        return this.lowerBound.endpoint();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BoundType lowerBoundType() {
        return this.lowerBound.typeAsLowerBound();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasUpperBound() {
        return this.upperBound != Cut.aboveAll();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C upperEndpoint() {
        return this.upperBound.endpoint();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public BoundType upperBoundType() {
        return this.upperBound.typeAsUpperBound();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEmpty() {
        return this.lowerBound.equals(this.upperBound);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(C c) {
        Preconditions.checkNotNull(c);
        return this.lowerBound.isLessThan(c) && !this.upperBound.isLessThan(c);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.Predicate
    @Deprecated
    public boolean apply(C c) {
        return contains(c);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean containsAll(Iterable<? extends C> iterable) {
        if (Iterables.isEmpty(iterable)) {
            return true;
        }
        if (iterable instanceof SortedSet) {
            SortedSet sortedSet = (SortedSet) iterable;
            Comparator comparator = sortedSet.comparator();
            if (Ordering.natural().equals(comparator) || comparator == null) {
                return contains((Comparable) sortedSet.first()) && contains((Comparable) sortedSet.last());
            }
        }
        Iterator<? extends C> it = iterable.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean encloses(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.lowerBound) <= 0 && this.upperBound.compareTo((Cut) range.upperBound) >= 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isConnected(Range<C> range) {
        return this.lowerBound.compareTo((Cut) range.upperBound) <= 0 && range.lowerBound.compareTo((Cut) this.upperBound) <= 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Range<C> intersection(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo >= 0 && compareTo2 <= 0) {
            return this;
        }
        if (compareTo <= 0 && compareTo2 >= 0) {
            return range;
        }
        Cut<C> cut = compareTo >= 0 ? this.lowerBound : range.lowerBound;
        Cut<C> cut2 = compareTo2 <= 0 ? this.upperBound : range.upperBound;
        Preconditions.checkArgument(cut.compareTo((Cut) cut2) <= 0, "intersection is undefined for disconnected ranges %s and %s", this, range);
        return create(cut, cut2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Range<C> gap(Range<C> range) {
        if (this.lowerBound.compareTo((Cut) range.upperBound) < 0 && range.lowerBound.compareTo((Cut) this.upperBound) < 0) {
            String valueOf = String.valueOf(this);
            String valueOf2 = String.valueOf(range);
            throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 39 + String.valueOf(valueOf2).length()).append("Ranges have a nonempty intersection: ").append(valueOf).append(", ").append(valueOf2).toString());
        }
        boolean z = this.lowerBound.compareTo((Cut) range.lowerBound) < 0;
        Range<C> range2 = z ? this : range;
        if (!z) {
            range = this;
        }
        return create(range2.upperBound, range.lowerBound);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Range<C> span(Range<C> range) {
        int compareTo = this.lowerBound.compareTo((Cut) range.lowerBound);
        int compareTo2 = this.upperBound.compareTo((Cut) range.upperBound);
        if (compareTo <= 0 && compareTo2 >= 0) {
            return this;
        }
        if (compareTo < 0 || compareTo2 > 0) {
            return create(compareTo <= 0 ? this.lowerBound : range.lowerBound, compareTo2 >= 0 ? this.upperBound : range.upperBound);
        }
        return range;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Range<C> canonical(DiscreteDomain<C> discreteDomain) {
        Preconditions.checkNotNull(discreteDomain);
        Cut<C> canonical = this.lowerBound.canonical(discreteDomain);
        Cut<C> canonical2 = this.upperBound.canonical(discreteDomain);
        return (canonical == this.lowerBound && canonical2 == this.upperBound) ? this : create(canonical, canonical2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.base.Predicate
    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Range)) {
            return false;
        }
        Range range = (Range) obj;
        return this.lowerBound.equals(range.lowerBound) && this.upperBound.equals(range.upperBound);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return (this.lowerBound.hashCode() * 31) + this.upperBound.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return toString(this.lowerBound, this.upperBound);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String toString(Cut<?> cut, Cut<?> cut2) {
        StringBuilder sb = new StringBuilder(16);
        cut.describeAsLowerBound(sb);
        sb.append("..");
        cut2.describeAsUpperBound(sb);
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Object readResolve() {
        return equals(ALL) ? all() : this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int compareOrThrow(Comparable comparable, Comparable comparable2) {
        return comparable.compareTo(comparable2);
    }

    private static class RangeLexOrdering extends Ordering<Range<?>> implements Serializable {
        static final Ordering<Range<?>> INSTANCE = new RangeLexOrdering();
        private static final long serialVersionUID = 0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private RangeLexOrdering() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.Ordering, java.util.Comparator
        public int compare(Range<?> range, Range<?> range2) {
            return ComparisonChain.start().compare(range.lowerBound, range2.lowerBound).compare(range.upperBound, range2.upperBound).result();
        }
    }
}
