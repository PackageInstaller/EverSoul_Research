package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class MapFieldLite<K, V> extends LinkedHashMap<K, V> {
    private static final MapFieldLite EMPTY_MAP_FIELD;
    private boolean isMutable;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite() {
        this.isMutable = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MapFieldLite(Map<K, V> map) {
        super(map);
        this.isMutable = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        MapFieldLite mapFieldLite = new MapFieldLite();
        EMPTY_MAP_FIELD = mapFieldLite;
        mapFieldLite.makeImmutable();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> MapFieldLite<K, V> emptyMapField() {
        return EMPTY_MAP_FIELD;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void mergeFrom(MapFieldLite<K, V> mapFieldLite) {
        ensureMutable();
        if (mapFieldLite.isEmpty()) {
            return;
        }
        putAll(mapFieldLite);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void clear() {
        ensureMutable();
        super.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V put(K k, V v) {
        ensureMutable();
        Internal.checkNotNull(k);
        Internal.checkNotNull(v);
        return (V) super.put(k, v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public V put(Map.Entry<K, V> entry) {
        return put(entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public void putAll(Map<? extends K, ? extends V> map) {
        ensureMutable();
        checkForNullKeysAndValues(map);
        super.putAll(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public V remove(Object obj) {
        ensureMutable();
        return (V) super.remove(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void checkForNullKeysAndValues(Map<?, ?> map) {
        for (Object obj : map.keySet()) {
            Internal.checkNotNull(obj);
            Internal.checkNotNull(map.get(obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean equals(Object obj, Object obj2) {
        if ((obj instanceof byte[]) && (obj2 instanceof byte[])) {
            return Arrays.equals((byte[]) obj, (byte[]) obj2);
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <K, V> boolean equals(Map<K, V> map, Map<K, V> map2) {
        if (map == map2) {
            return true;
        }
        if (map.size() != map2.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (!map2.containsKey(entry.getKey()) || !equals(entry.getValue(), map2.get(entry.getKey()))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean equals(Object obj) {
        return (obj instanceof Map) && equals((Map) this, (Map) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int calculateHashCodeForObject(Object obj) {
        if (obj instanceof byte[]) {
            return Internal.hashCode((byte[]) obj);
        }
        if (obj instanceof Internal.EnumLite) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <K, V> int calculateHashCodeForMap(Map<K, V> map) {
        int i = 0;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            i += calculateHashCodeForObject(entry.getValue()) ^ calculateHashCodeForObject(entry.getKey());
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public int hashCode() {
        return calculateHashCodeForMap(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Object copy(Object obj) {
        if (!(obj instanceof byte[])) {
            return obj;
        }
        byte[] bArr = (byte[]) obj;
        return Arrays.copyOf(bArr, bArr.length);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <K, V> Map<K, V> copy(Map<K, V> map) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            linkedHashMap.put(entry.getKey(), copy(entry.getValue()));
        }
        return linkedHashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MapFieldLite<K, V> mutableCopy() {
        return isEmpty() ? new MapFieldLite<>() : new MapFieldLite<>(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void makeImmutable() {
        this.isMutable = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isMutable() {
        return this.isMutable;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void ensureMutable() {
        if (!isMutable()) {
            throw new UnsupportedOperationException();
        }
    }
}
