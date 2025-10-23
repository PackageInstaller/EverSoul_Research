package com.google.common.collect;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class Platform {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void checkGwtRpcEnabled() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int reduceExponentIfGwt(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int reduceIterationsIfGwt(int i) {
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <K, V> Map<K, V> newHashMapWithExpectedSize(int i) {
        return CompactHashMap.createWithExpectedSize(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <K, V> Map<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return CompactLinkedHashMap.createWithExpectedSize(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <E> Set<E> newHashSetWithExpectedSize(int i) {
        return CompactHashSet.createWithExpectedSize(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <E> Set<E> newLinkedHashSetWithExpectedSize(int i) {
        return CompactLinkedHashSet.createWithExpectedSize(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <K, V> Map<K, V> preservesInsertionOrderOnPutsMap() {
        return CompactHashMap.create();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <E> Set<E> preservesInsertionOrderOnAddsSet() {
        return CompactHashSet.create();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T[] newArray(T[] tArr, int i) {
        return (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> T[] copy(Object[] objArr, int i, int i2, T[] tArr) {
        return (T[]) Arrays.copyOfRange(objArr, i, i2, tArr.getClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static MapMaker tryWeakKeys(MapMaker mapMaker) {
        return mapMaker.weakKeys();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Platform() {
    }
}
