package org.apache.commons.lang3;

import com.liapp.y;
import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes2.dex */
public final class Range<T> implements Serializable {
    private static final long serialVersionUID = 1;
    private final Comparator<T> comparator;
    private transient int hashCode;
    private final T maximum;
    private final T minimum;
    private transient String toString;

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: is */
    public static Range m884is(Comparable comparable) {
        return between(comparable, comparable, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: is */
    public static <T> Range<T> m885is(T t, Comparator<T> comparator) {
        return between(t, t, comparator);
    }

    /* JADX WARN: Incorrect types in method signature: <T::Ljava/lang/Comparable<TT;>;>(TT;TT;)Lorg/apache/commons/lang3/Range<TT;>; */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Range between(Comparable comparable, Comparable comparable2) {
        return between(comparable, comparable2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Range<T> between(T t, T t2, Comparator<T> comparator) {
        return new Range<>(t, t2, comparator);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Range(T t, T t2, Comparator<T> comparator) {
        if (t == null || t2 == null) {
            throw new IllegalArgumentException(y.֬ڱܱײٮ(-1159262103) + t + y.ٴسسݬߨ(1392987778) + t2);
        }
        if (comparator == null) {
            this.comparator = ComparableComparator.INSTANCE;
        } else {
            this.comparator = comparator;
        }
        if (this.comparator.compare(t, t2) < 1) {
            this.minimum = t;
            this.maximum = t2;
        } else {
            this.minimum = t2;
            this.maximum = t;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T getMinimum() {
        return this.minimum;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public T getMaximum() {
        return this.maximum;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Comparator<T> getComparator() {
        return this.comparator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isNaturalOrdering() {
        return this.comparator == ComparableComparator.INSTANCE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(T t) {
        return t != null && this.comparator.compare(t, this.minimum) > -1 && this.comparator.compare(t, this.maximum) < 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAfter(T t) {
        return t != null && this.comparator.compare(t, this.minimum) < 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isStartedBy(T t) {
        return t != null && this.comparator.compare(t, this.minimum) == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEndedBy(T t) {
        return t != null && this.comparator.compare(t, this.maximum) == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isBefore(T t) {
        return t != null && this.comparator.compare(t, this.maximum) > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int elementCompareTo(T t) {
        Validate.notNull(t, y.ݮڮֲڭܩ(-628917484), new Object[0]);
        if (isAfter(t)) {
            return -1;
        }
        return isBefore(t) ? 1 : 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean containsRange(Range<T> range) {
        return range != null && contains(range.minimum) && contains(range.maximum);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isAfterRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isAfter(range.maximum);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isOverlappedBy(Range<T> range) {
        if (range == null) {
            return false;
        }
        return range.contains(this.minimum) || range.contains(this.maximum) || contains(range.minimum);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isBeforeRange(Range<T> range) {
        if (range == null) {
            return false;
        }
        return isBefore(range.minimum);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Range<T> intersectionWith(Range<T> range) {
        if (!isOverlappedBy(range)) {
            throw new IllegalArgumentException(String.format("Cannot calculate intersection with non-overlapping range %s", range));
        }
        if (equals(range)) {
            return this;
        }
        return between(getComparator().compare(this.minimum, range.minimum) < 0 ? range.minimum : this.minimum, getComparator().compare(this.maximum, range.maximum) < 0 ? this.maximum : range.maximum, getComparator());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        Range range = (Range) obj;
        return this.minimum.equals(range.minimum) && this.maximum.equals(range.maximum);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int i = this.hashCode;
        if (i != 0) {
            return i;
        }
        int hashCode = this.maximum.hashCode() + ((((629 + getClass().hashCode()) * 37) + this.minimum.hashCode()) * 37);
        this.hashCode = hashCode;
        return hashCode;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        if (this.toString == null) {
            this.toString = y.ٴسسݬߨ(1392956562) + this.minimum + y.ٲٴݴ״ٰ(1781682392) + this.maximum + y.ۮڭڭܬި(862078387);
        }
        return this.toString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString(String str) {
        return String.format(str, this.minimum, this.maximum, this.comparator);
    }

    private enum ComparableComparator implements Comparator {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.Comparator
        public int compare(Object obj, Object obj2) {
            return ((Comparable) obj).compareTo(obj2);
        }
    }
}
