package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;
import java.util.SortedSet;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    private static final int CUTOFF = 751619276;
    private static final double DESIRED_LOAD_FACTOR = 0.7d;
    static final int MAX_TABLE_SIZE = 1073741824;

    @CheckForNull
    @LazyInit
    private transient ImmutableList<E> asList;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean shouldTrim(int i, int i2) {
        return i < (i2 >> 1) + (i2 >> 2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isHashCodeFast() {
        return false;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet, com.google.common.collect.SortedIterable
    public abstract UnmodifiableIterator<E> iterator();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <E> ImmutableSet<E> m262of() {
        return RegularImmutableSet.EMPTY;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <E> ImmutableSet<E> m263of(E e) {
        return new SingletonImmutableSet(e);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <E> ImmutableSet<E> m264of(E e, E e2) {
        return construct(2, e, e2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <E> ImmutableSet<E> m265of(E e, E e2, E e3) {
        return construct(3, e, e2, e3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <E> ImmutableSet<E> m266of(E e, E e2, E e3, E e4) {
        return construct(4, e, e2, e3, e4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: of */
    public static <E> ImmutableSet<E> m267of(E e, E e2, E e3, E e4, E e5) {
        return construct(5, e, e2, e3, e4, e5);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    /* renamed from: of */
    public static <E> ImmutableSet<E> m268of(E e, E e2, E e3, E e4, E e5, E e6, E... eArr) {
        Preconditions.checkArgument(eArr.length <= 2147483641, "the total number of elements must fit in an int");
        int length = eArr.length + 6;
        Object[] objArr = new Object[length];
        objArr[0] = e;
        objArr[1] = e2;
        objArr[2] = e3;
        objArr[3] = e4;
        objArr[4] = e5;
        objArr[5] = e6;
        System.arraycopy(eArr, 0, objArr, 6, eArr.length);
        return construct(length, objArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> ImmutableSet<E> construct(int i, Object... objArr) {
        if (i == 0) {
            return m262of();
        }
        if (i == 1) {
            return m263of(Objects.requireNonNull(objArr[0]));
        }
        int chooseTableSize = chooseTableSize(i);
        Object[] objArr2 = new Object[chooseTableSize];
        int i2 = chooseTableSize - 1;
        int i3 = 0;
        int i4 = 0;
        for (int i5 = 0; i5 < i; i5++) {
            Object checkElementNotNull = ObjectArrays.checkElementNotNull(objArr[i5], i5);
            int hashCode = checkElementNotNull.hashCode();
            int smear = Hashing.smear(hashCode);
            while (true) {
                int i6 = smear & i2;
                Object obj = objArr2[i6];
                if (obj == null) {
                    objArr[i4] = checkElementNotNull;
                    objArr2[i6] = checkElementNotNull;
                    i3 += hashCode;
                    i4++;
                    break;
                }
                if (obj.equals(checkElementNotNull)) {
                    break;
                }
                smear++;
            }
        }
        Arrays.fill(objArr, i4, i, (Object) null);
        if (i4 == 1) {
            return new SingletonImmutableSet(Objects.requireNonNull(objArr[0]));
        }
        if (chooseTableSize(i4) < chooseTableSize / 2) {
            return construct(i4, objArr);
        }
        if (shouldTrim(i4, objArr.length)) {
            objArr = Arrays.copyOf(objArr, i4);
        }
        return new RegularImmutableSet(objArr, i3, objArr2, i2, i4);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int chooseTableSize(int i) {
        int max = Math.max(i, 2);
        if (max < CUTOFF) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (highestOneBit * DESIRED_LOAD_FACTOR < max) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        Preconditions.checkArgument(max < 1073741824, "collection too large");
        return 1073741824;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> ImmutableSet<E> copyOf(Collection<? extends E> collection) {
        if ((collection instanceof ImmutableSet) && !(collection instanceof SortedSet)) {
            ImmutableSet<E> immutableSet = (ImmutableSet) collection;
            if (!immutableSet.isPartialView()) {
                return immutableSet;
            }
        }
        Object[] array = collection.toArray();
        return construct(array.length, array);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> ImmutableSet<E> copyOf(Iterable<? extends E> iterable) {
        if (iterable instanceof Collection) {
            return copyOf((Collection) iterable);
        }
        return copyOf(iterable.iterator());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> ImmutableSet<E> copyOf(Iterator<? extends E> it) {
        if (!it.hasNext()) {
            return m262of();
        }
        E next = it.next();
        if (!it.hasNext()) {
            return m263of((Object) next);
        }
        return new Builder().add((Builder) next).addAll((Iterator) it).build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> ImmutableSet<E> copyOf(E[] eArr) {
        int length = eArr.length;
        if (length == 0) {
            return m262of();
        }
        if (length == 1) {
            return m263of((Object) eArr[0]);
        }
        return construct(eArr.length, (Object[]) eArr.clone());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ImmutableSet() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Collection, java.util.Set
    public boolean equals(@CheckForNull Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && isHashCodeFast() && ((ImmutableSet) obj).isHashCodeFast() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.equalsImpl(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        return Sets.hashCodeImpl(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableCollection
    public ImmutableList<E> asList() {
        ImmutableList<E> immutableList = this.asList;
        if (immutableList != null) {
            return immutableList;
        }
        ImmutableList<E> createAsList = createAsList();
        this.asList = createAsList;
        return createAsList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ImmutableList<E> createAsList() {
        return ImmutableList.asImmutableList(toArray());
    }

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Object readResolve() {
            return ImmutableSet.copyOf(this.elements);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.ImmutableCollection
    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> Builder<E> builder() {
        return new Builder<>();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> Builder<E> builderWithExpectedSize(int i) {
        CollectPreconditions.checkNonnegative(i, "expectedSize");
        return new Builder<>(i);
    }

    public static class Builder<E> extends ImmutableCollection.ArrayBasedBuilder<E> {
        private int hashCode;

        @CheckForNull
        Object[] hashTable;

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.ArrayBasedBuilder add(Object obj) {
            return add((Builder<E>) obj);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public /* bridge */ /* synthetic */ ImmutableCollection.Builder add(Object obj) {
            return add((Builder<E>) obj);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Builder() {
            super(4);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder(int i) {
            super(i);
            this.hashTable = new Object[ImmutableSet.chooseTableSize(i)];
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E e) {
            Preconditions.checkNotNull(e);
            if (this.hashTable != null && ImmutableSet.chooseTableSize(this.size) <= this.hashTable.length) {
                addDeduping(e);
                return this;
            }
            this.hashTable = null;
            super.add((Builder<E>) e);
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> add(E... eArr) {
            if (this.hashTable != null) {
                for (E e : eArr) {
                    add((Builder<E>) e);
                }
            } else {
                super.add((Object[]) eArr);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private void addDeduping(E e) {
            Objects.requireNonNull(this.hashTable);
            int length = this.hashTable.length - 1;
            int hashCode = e.hashCode();
            int smear = Hashing.smear(hashCode);
            while (true) {
                int i = smear & length;
                Object[] objArr = this.hashTable;
                Object obj = objArr[i];
                if (obj == null) {
                    objArr[i] = e;
                    this.hashCode += hashCode;
                    super.add((Builder<E>) e);
                    return;
                } else if (obj.equals(e)) {
                    return;
                } else {
                    smear = i + 1;
                }
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.ImmutableCollection.ArrayBasedBuilder, com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterable<? extends E> iterable) {
            Preconditions.checkNotNull(iterable);
            if (this.hashTable != null) {
                Iterator<? extends E> it = iterable.iterator();
                while (it.hasNext()) {
                    add((Builder<E>) it.next());
                }
            } else {
                super.addAll((Iterable) iterable);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public Builder<E> addAll(Iterator<? extends E> it) {
            Preconditions.checkNotNull(it);
            while (it.hasNext()) {
                add((Builder<E>) it.next());
            }
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Builder<E> combine(Builder<E> builder) {
            if (this.hashTable != null) {
                for (int i = 0; i < builder.size; i++) {
                    add((Builder<E>) Objects.requireNonNull(builder.contents[i]));
                }
            } else {
                addAll(builder.contents, builder.size);
            }
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.ImmutableCollection.Builder
        public ImmutableSet<E> build() {
            ImmutableSet<E> construct;
            int i = this.size;
            if (i == 0) {
                return ImmutableSet.m262of();
            }
            if (i == 1) {
                return ImmutableSet.m263of(Objects.requireNonNull(this.contents[0]));
            }
            if (this.hashTable == null || ImmutableSet.chooseTableSize(this.size) != this.hashTable.length) {
                construct = ImmutableSet.construct(this.size, this.contents);
                this.size = construct.size();
            } else {
                Object[] copyOf = ImmutableSet.shouldTrim(this.size, this.contents.length) ? Arrays.copyOf(this.contents, this.size) : this.contents;
                construct = new RegularImmutableSet<>(copyOf, this.hashCode, this.hashTable, r5.length - 1, this.size);
            }
            this.forceCopy = true;
            this.hashTable = null;
            return construct;
        }
    }
}
