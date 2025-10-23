package com.google.common.primitives;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CheckReturnValue;
import com.google.errorprone.annotations.Immutable;
import java.io.Serializable;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;
import javax.annotation.CheckForNull;
import okhttp3.HttpUrl;

@ElementTypesAreNonnullByDefault
@Immutable
/* loaded from: classes2.dex */
public final class ImmutableDoubleArray implements Serializable {
    private static final ImmutableDoubleArray EMPTY = new ImmutableDoubleArray(new double[0]);
    private final double[] array;
    private final int end;
    private final transient int start;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static ImmutableDoubleArray m341of() {
        return EMPTY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static ImmutableDoubleArray m342of(double d) {
        return new ImmutableDoubleArray(new double[]{d});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static ImmutableDoubleArray m343of(double d, double d2) {
        return new ImmutableDoubleArray(new double[]{d, d2});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static ImmutableDoubleArray m344of(double d, double d2, double d3) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static ImmutableDoubleArray m345of(double d, double d2, double d3, double d4) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static ImmutableDoubleArray m346of(double d, double d2, double d3, double d4, double d5) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static ImmutableDoubleArray m347of(double d, double d2, double d3, double d4, double d5, double d6) {
        return new ImmutableDoubleArray(new double[]{d, d2, d3, d4, d5, d6});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static ImmutableDoubleArray m348of(double d, double... dArr) {
        Preconditions.checkArgument(dArr.length <= 2147483646, "the total number of elements must fit in an int");
        double[] dArr2 = new double[dArr.length + 1];
        dArr2[0] = d;
        System.arraycopy(dArr, 0, dArr2, 1, dArr.length);
        return new ImmutableDoubleArray(dArr2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ImmutableDoubleArray copyOf(double[] dArr) {
        if (dArr.length == 0) {
            return EMPTY;
        }
        return new ImmutableDoubleArray(Arrays.copyOf(dArr, dArr.length));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ImmutableDoubleArray copyOf(Collection<Double> collection) {
        return collection.isEmpty() ? EMPTY : new ImmutableDoubleArray(Doubles.toArray(collection));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static ImmutableDoubleArray copyOf(Iterable<Double> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection<Double>) iterable);
        }
        return builder().addAll(iterable).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder(int i) {
        Preconditions.checkArgument(i >= 0, "Invalid initialCapacity: %s", i);
        return new Builder(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Builder builder() {
        return new Builder(10);
    }

    public static final class Builder {
        private double[] array;
        private int count = 0;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder(int i) {
            this.array = new double[i];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder add(double d) {
            ensureRoomFor(1);
            double[] dArr = this.array;
            int i = this.count;
            dArr[i] = d;
            this.count = i + 1;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAll(double[] dArr) {
            ensureRoomFor(dArr.length);
            System.arraycopy(dArr, 0, this.array, this.count, dArr.length);
            this.count += dArr.length;
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAll(Iterable<Double> iterable) {
            if (iterable instanceof Collection) {
                return addAll((Collection<Double>) iterable);
            }
            Iterator<Double> it = iterable.iterator();
            while (it.hasNext()) {
                add(it.next().doubleValue());
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAll(Collection<Double> collection) {
            ensureRoomFor(collection.size());
            for (Double d : collection) {
                double[] dArr = this.array;
                int i = this.count;
                this.count = i + 1;
                dArr[i] = d.doubleValue();
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder addAll(ImmutableDoubleArray immutableDoubleArray) {
            ensureRoomFor(immutableDoubleArray.length());
            System.arraycopy(immutableDoubleArray.array, immutableDoubleArray.start, this.array, this.count, immutableDoubleArray.length());
            this.count += immutableDoubleArray.length();
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void ensureRoomFor(int i) {
            int i2 = this.count + i;
            double[] dArr = this.array;
            if (i2 > dArr.length) {
                this.array = Arrays.copyOf(dArr, expandedCapacity(dArr.length, i2));
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private static int expandedCapacity(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = i + (i >> 1) + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @CheckReturnValue
        public ImmutableDoubleArray build() {
            if (this.count == 0) {
                return ImmutableDoubleArray.EMPTY;
            }
            return new ImmutableDoubleArray(this.array, 0, this.count);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ImmutableDoubleArray(double[] dArr) {
        this(dArr, 0, dArr.length);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ImmutableDoubleArray(double[] dArr, int i, int i2) {
        this.array = dArr;
        this.start = i;
        this.end = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int length() {
        return this.end - this.start;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isEmpty() {
        return this.end == this.start;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double get(int i) {
        Preconditions.checkElementIndex(i, length());
        return this.array[this.start + i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int indexOf(double d) {
        for (int i = this.start; i < this.end; i++) {
            if (areEqual(this.array[i], d)) {
                return i - this.start;
            }
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int lastIndexOf(double d) {
        int i = this.end;
        do {
            i--;
            if (i < this.start) {
                return -1;
            }
        } while (!areEqual(this.array[i], d));
        return i - this.start;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean contains(double d) {
        return indexOf(d) >= 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public double[] toArray() {
        return Arrays.copyOfRange(this.array, this.start, this.end);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImmutableDoubleArray subArray(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, length());
        if (i == i2) {
            return EMPTY;
        }
        double[] dArr = this.array;
        int i3 = this.start;
        return new ImmutableDoubleArray(dArr, i + i3, i3 + i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public List<Double> asList() {
        return new AsList();
    }

    static class AsList extends AbstractList<Double> implements RandomAccess, Serializable {
        private final ImmutableDoubleArray parent;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private AsList(ImmutableDoubleArray immutableDoubleArray) {
            this.parent = immutableDoubleArray;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.parent.length();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractList, java.util.List
        public Double get(int i) {
            return Double.valueOf(this.parent.get(i));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public boolean contains(@CheckForNull Object obj) {
            return indexOf(obj) >= 0;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractList, java.util.List
        public int indexOf(@CheckForNull Object obj) {
            if (obj instanceof Double) {
                return this.parent.indexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractList, java.util.List
        public int lastIndexOf(@CheckForNull Object obj) {
            if (obj instanceof Double) {
                return this.parent.lastIndexOf(((Double) obj).doubleValue());
            }
            return -1;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractList, java.util.List
        public List<Double> subList(int i, int i2) {
            return this.parent.subArray(i, i2).asList();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public boolean equals(@CheckForNull Object obj) {
            if (obj instanceof AsList) {
                return this.parent.equals(((AsList) obj).parent);
            }
            if (!(obj instanceof List)) {
                return false;
            }
            List list = (List) obj;
            if (size() != list.size()) {
                return false;
            }
            int i = this.parent.start;
            for (Object obj2 : list) {
                if (obj2 instanceof Double) {
                    int i2 = i + 1;
                    if (ImmutableDoubleArray.areEqual(this.parent.array[i], ((Double) obj2).doubleValue())) {
                        i = i2;
                    }
                }
                return false;
            }
            return true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractList, java.util.Collection, java.util.List
        public int hashCode() {
            return this.parent.hashCode();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.util.AbstractCollection
        public String toString() {
            return this.parent.toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ImmutableDoubleArray)) {
            return false;
        }
        ImmutableDoubleArray immutableDoubleArray = (ImmutableDoubleArray) obj;
        if (length() != immutableDoubleArray.length()) {
            return false;
        }
        for (int i = 0; i < length(); i++) {
            if (!areEqual(get(i), immutableDoubleArray.get(i))) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean areEqual(double d, double d2) {
        return Double.doubleToLongBits(d) == Double.doubleToLongBits(d2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        int i = 1;
        for (int i2 = this.start; i2 < this.end; i2++) {
            i = (i * 31) + Doubles.hashCode(this.array[i2]);
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        if (isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb = new StringBuilder(length() * 5);
        sb.append('[').append(this.array[this.start]);
        int i = this.start;
        while (true) {
            i++;
            if (i < this.end) {
                sb.append(", ").append(this.array[i]);
            } else {
                sb.append(']');
                return sb.toString();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ImmutableDoubleArray trimmed() {
        return isPartialView() ? new ImmutableDoubleArray(toArray()) : this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean isPartialView() {
        return this.start > 0 || this.end < this.array.length;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Object writeReplace() {
        return trimmed();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Object readResolve() {
        return isEmpty() ? EMPTY : this;
    }
}
