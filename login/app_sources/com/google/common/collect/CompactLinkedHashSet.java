package com.google.common.collect;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
class CompactLinkedHashSet<E> extends CompactHashSet<E> {
    private static final int ENDPOINT = -2;
    private transient int firstEntry;
    private transient int lastEntry;

    @CheckForNull
    private transient int[] predecessor;

    @CheckForNull
    private transient int[] successor;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> CompactLinkedHashSet<E> create() {
        return new CompactLinkedHashSet<>();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> CompactLinkedHashSet<E> create(Collection<? extends E> collection) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(collection.size());
        createWithExpectedSize.addAll(collection);
        return createWithExpectedSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @SafeVarargs
    public static <E> CompactLinkedHashSet<E> create(E... eArr) {
        CompactLinkedHashSet<E> createWithExpectedSize = createWithExpectedSize(eArr.length);
        Collections.addAll(createWithExpectedSize, eArr);
        return createWithExpectedSize;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <E> CompactLinkedHashSet<E> createWithExpectedSize(int i) {
        return new CompactLinkedHashSet<>(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CompactLinkedHashSet() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    CompactLinkedHashSet(int i) {
        super(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    void init(int i) {
        super.init(i);
        this.firstEntry = -2;
        this.lastEntry = -2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    int allocArrays() {
        int allocArrays = super.allocArrays();
        this.predecessor = new int[allocArrays];
        this.successor = new int[allocArrays];
        return allocArrays;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    Set<E> convertToHashFloodingResistantImplementation() {
        Set<E> convertToHashFloodingResistantImplementation = super.convertToHashFloodingResistantImplementation();
        this.predecessor = null;
        this.successor = null;
        return convertToHashFloodingResistantImplementation;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int getPredecessor(int i) {
        return requirePredecessors()[i] - 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    int getSuccessor(int i) {
        return requireSuccessors()[i] - 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setSuccessor(int i, int i2) {
        requireSuccessors()[i] = i2 + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setPredecessor(int i, int i2) {
        requirePredecessors()[i] = i2 + 1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void setSucceeds(int i, int i2) {
        if (i == -2) {
            this.firstEntry = i2;
        } else {
            setSuccessor(i, i2);
        }
        if (i2 == -2) {
            this.lastEntry = i;
        } else {
            setPredecessor(i2, i);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    void insertEntry(int i, @ParametricNullness E e, int i2, int i3) {
        super.insertEntry(i, e, i2, i3);
        setSucceeds(this.lastEntry, i);
        setSucceeds(i, -2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    void moveLastEntry(int i, int i2) {
        int size = size() - 1;
        super.moveLastEntry(i, i2);
        setSucceeds(getPredecessor(i), getSuccessor(i));
        if (i < size) {
            setSucceeds(getPredecessor(size), i);
            setSucceeds(i, getSuccessor(size));
        }
        requirePredecessors()[size] = 0;
        requireSuccessors()[size] = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    void resizeEntries(int i) {
        super.resizeEntries(i);
        this.predecessor = Arrays.copyOf(requirePredecessors(), i);
        this.successor = Arrays.copyOf(requireSuccessors(), i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    int firstEntryIndex() {
        return this.firstEntry;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet
    int adjustAfterRemove(int i, int i2) {
        return i >= size() ? i2 : i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        return ObjectArrays.toArrayImpl(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public <T> T[] toArray(T[] tArr) {
        return (T[]) ObjectArrays.toArrayImpl(this, tArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.collect.CompactHashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public void clear() {
        if (needsAllocArrays()) {
            return;
        }
        this.firstEntry = -2;
        this.lastEntry = -2;
        int[] iArr = this.predecessor;
        if (iArr != null && this.successor != null) {
            Arrays.fill(iArr, 0, size(), 0);
            Arrays.fill(this.successor, 0, size(), 0);
        }
        super.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int[] requirePredecessors() {
        return (int[]) Objects.requireNonNull(this.predecessor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private int[] requireSuccessors() {
        return (int[]) Objects.requireNonNull(this.successor);
    }
}
