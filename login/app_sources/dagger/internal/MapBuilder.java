package dagger.internal;

import java.util.Collections;
import java.util.Map;

/* loaded from: classes3.dex */
public final class MapBuilder<K, V> {
    private final Map<K, V> contributions;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapBuilder(int i) {
        this.contributions = DaggerCollections.newLinkedHashMapWithExpectedSize(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> MapBuilder<K, V> newMapBuilder(int i) {
        return new MapBuilder<>(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MapBuilder<K, V> put(K k, V v) {
        this.contributions.put(k, v);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MapBuilder<K, V> putAll(Map<K, V> map) {
        this.contributions.putAll(map);
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Map<K, V> build() {
        if (this.contributions.size() == 0) {
            return Collections.emptyMap();
        }
        return Collections.unmodifiableMap(this.contributions);
    }
}
