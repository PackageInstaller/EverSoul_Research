package dagger.internal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes3.dex */
public final class DaggerCollections {
    private static final int MAX_POWER_OF_TWO = 1073741824;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int calculateInitialCapacity(int i) {
        if (i < 3) {
            return i + 1;
        }
        if (i < 1073741824) {
            return (int) ((i / 0.75f) + 1.0f);
        }
        return Integer.MAX_VALUE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private DaggerCollections() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> List<T> presizedList(int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        return new ArrayList(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean hasDuplicates(List<?> list) {
        if (list.size() < 2) {
            return false;
        }
        return list.size() != new HashSet(list).size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <T> HashSet<T> newHashSetWithExpectedSize(int i) {
        return new HashSet<>(calculateInitialCapacity(i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> LinkedHashMap<K, V> newLinkedHashMapWithExpectedSize(int i) {
        return new LinkedHashMap<>(calculateInitialCapacity(i));
    }
}
