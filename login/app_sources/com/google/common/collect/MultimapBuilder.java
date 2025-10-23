package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeMap;
import java.util.TreeSet;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class MultimapBuilder<K0, V0> {
    private static final int DEFAULT_EXPECTED_KEYS = 8;

    public abstract <K extends K0, V extends V0> Multimap<K, V> build();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MultimapBuilder() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MultimapBuilderWithKeys<Object> hashKeys() {
        return hashKeys(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MultimapBuilderWithKeys<Object> hashKeys(final int i) {
        CollectPreconditions.checkNonnegative(i, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() { // from class: com.google.common.collect.MultimapBuilder.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            <K, V> Map<K, Collection<V>> createMap() {
                return Platform.newHashMapWithExpectedSize(i);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MultimapBuilderWithKeys<Object> linkedHashKeys() {
        return linkedHashKeys(8);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MultimapBuilderWithKeys<Object> linkedHashKeys(final int i) {
        CollectPreconditions.checkNonnegative(i, "expectedKeys");
        return new MultimapBuilderWithKeys<Object>() { // from class: com.google.common.collect.MultimapBuilder.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            <K, V> Map<K, Collection<V>> createMap() {
                return Platform.newLinkedHashMapWithExpectedSize(i);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static MultimapBuilderWithKeys<Comparable> treeKeys() {
        return treeKeys(Ordering.natural());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K0> MultimapBuilderWithKeys<K0> treeKeys(final Comparator<K0> comparator) {
        Preconditions.checkNotNull(comparator);
        return new MultimapBuilderWithKeys<K0>() { // from class: com.google.common.collect.MultimapBuilder.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            <K extends K0, V> Map<K, Collection<V>> createMap() {
                return new TreeMap(comparator);
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K0 extends Enum<K0>> MultimapBuilderWithKeys<K0> enumKeys(final Class<K0> cls) {
        Preconditions.checkNotNull(cls);
        return new MultimapBuilderWithKeys<K0>() { // from class: com.google.common.collect.MultimapBuilder.4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys
            <K extends K0, V> Map<K, Collection<V>> createMap() {
                return new EnumMap(cls);
            }
        };
    }

    private static final class ArrayListSupplier<V> implements Supplier<List<V>>, Serializable {
        private final int expectedValuesPerKey;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ArrayListSupplier(int i) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Supplier
        public List<V> get() {
            return new ArrayList(this.expectedValuesPerKey);
        }
    }

    private enum LinkedListSupplier implements Supplier<List<?>> {
        INSTANCE;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static <V> Supplier<List<V>> instance() {
            return INSTANCE;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Supplier
        public List<?> get() {
            return new LinkedList();
        }
    }

    private static final class HashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        HashSetSupplier(int i) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Platform.newHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    private static final class LinkedHashSetSupplier<V> implements Supplier<Set<V>>, Serializable {
        private final int expectedValuesPerKey;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        LinkedHashSetSupplier(int i) {
            this.expectedValuesPerKey = CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return Platform.newLinkedHashSetWithExpectedSize(this.expectedValuesPerKey);
        }
    }

    private static final class TreeSetSupplier<V> implements Supplier<SortedSet<V>>, Serializable {
        private final Comparator<? super V> comparator;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        TreeSetSupplier(Comparator<? super V> comparator) {
            this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Supplier
        public SortedSet<V> get() {
            return new TreeSet(this.comparator);
        }
    }

    private static final class EnumSetSupplier<V extends Enum<V>> implements Supplier<Set<V>>, Serializable {
        private final Class<V> clazz;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        EnumSetSupplier(Class<V> cls) {
            this.clazz = (Class) Preconditions.checkNotNull(cls);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.base.Supplier
        public Set<V> get() {
            return EnumSet.noneOf(this.clazz);
        }
    }

    public static abstract class MultimapBuilderWithKeys<K0> {
        private static final int DEFAULT_EXPECTED_VALUES_PER_KEY = 2;

        abstract <K extends K0, V> Map<K, Collection<V>> createMap();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MultimapBuilderWithKeys() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ListMultimapBuilder<K0, Object> arrayListValues() {
            return arrayListValues(2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ListMultimapBuilder<K0, Object> arrayListValues(final int i) {
            CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
            return new ListMultimapBuilder<K0, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V> ListMultimap<K, V> build() {
                    return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), new ArrayListSupplier(i));
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public ListMultimapBuilder<K0, Object> linkedListValues() {
            return new ListMultimapBuilder<K0, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.2
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.collect.MultimapBuilder.ListMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V> ListMultimap<K, V> build() {
                    return Multimaps.newListMultimap(MultimapBuilderWithKeys.this.createMap(), LinkedListSupplier.instance());
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SetMultimapBuilder<K0, Object> hashSetValues() {
            return hashSetValues(2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SetMultimapBuilder<K0, Object> hashSetValues(final int i) {
            CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.3
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new HashSetSupplier(i));
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SetMultimapBuilder<K0, Object> linkedHashSetValues() {
            return linkedHashSetValues(2);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SetMultimapBuilder<K0, Object> linkedHashSetValues(final int i) {
            CollectPreconditions.checkNonnegative(i, "expectedValuesPerKey");
            return new SetMultimapBuilder<K0, Object>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.4
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new LinkedHashSetSupplier(i));
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public SortedSetMultimapBuilder<K0, Comparable> treeSetValues() {
            return treeSetValues(Ordering.natural());
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public <V0> SortedSetMultimapBuilder<K0, V0> treeSetValues(final Comparator<V0> comparator) {
            Preconditions.checkNotNull(comparator, "comparator");
            return new SortedSetMultimapBuilder<K0, V0>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.5
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.collect.MultimapBuilder.SortedSetMultimapBuilder, com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V extends V0> SortedSetMultimap<K, V> build() {
                    return Multimaps.newSortedSetMultimap(MultimapBuilderWithKeys.this.createMap(), new TreeSetSupplier(comparator));
                }
            };
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public <V0 extends Enum<V0>> SetMultimapBuilder<K0, V0> enumSetValues(final Class<V0> cls) {
            Preconditions.checkNotNull(cls, "valueClass");
            return new SetMultimapBuilder<K0, V0>() { // from class: com.google.common.collect.MultimapBuilder.MultimapBuilderWithKeys.6
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
                public <K extends K0, V extends V0> SetMultimap<K, V> build() {
                    return Multimaps.newSetMultimap(MultimapBuilderWithKeys.this.createMap(), new EnumSetSupplier(cls));
                }
            };
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <K extends K0, V extends V0> Multimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
        Multimap<K, V> build = build();
        build.putAll(multimap);
        return build;
    }

    public static abstract class ListMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> ListMultimap<K, V> build();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ListMultimapBuilder() {
            super();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> ListMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (ListMultimap) super.build((Multimap) multimap);
        }
    }

    public static abstract class SetMultimapBuilder<K0, V0> extends MultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SetMultimap<K, V> build();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SetMultimapBuilder() {
            super();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SetMultimap) super.build((Multimap) multimap);
        }
    }

    public static abstract class SortedSetMultimapBuilder<K0, V0> extends SetMultimapBuilder<K0, V0> {
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public abstract <K extends K0, V extends V0> SortedSetMultimap<K, V> build();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        SortedSetMultimapBuilder() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.collect.MultimapBuilder.SetMultimapBuilder, com.google.common.collect.MultimapBuilder
        public <K extends K0, V extends V0> SortedSetMultimap<K, V> build(Multimap<? extends K, ? extends V> multimap) {
            return (SortedSetMultimap) super.build((Multimap) multimap);
        }
    }
}
