package com.google.android.gms.internal.drive;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: classes2.dex */
public final class zzlk<K, V> extends LinkedHashMap<K, V> {
    private static final zzlk zzty;
    private boolean zznh;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzlk() {
        this.zznh = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzlk(Map<K, V> map) {
        super(map);
        this.zznh = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> zzlk<K, V> zzdw() {
        return zzty;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(zzlk<K, V> zzlkVar) {
        zzdy();
        if (zzlkVar.isEmpty()) {
            return;
        }
        putAll(zzlkVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzdy();
        super.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzdy();
        zzkm.checkNotNull(k);
        zzkm.checkNotNull(v);
        return (V) super.put(k, v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzdy();
        for (K k : map.keySet()) {
            zzkm.checkNotNull(k);
            zzkm.checkNotNull(map.get(k));
        }
        super.putAll(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzdy();
        return (V) super.remove(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x005c A[RETURN] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L5d
            java.util.Map r7 = (java.util.Map) r7
            r0 = 1
            if (r6 == r7) goto L59
            int r2 = r6.size()
            int r3 = r7.size()
            if (r2 == r3) goto L16
        L14:
            r7 = r1
            goto L5a
        L16:
            java.util.Set r2 = r6.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L1e:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L59
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r3.getKey()
            boolean r4 = r7.containsKey(r4)
            if (r4 != 0) goto L35
            goto L14
        L35:
            java.lang.Object r4 = r3.getValue()
            java.lang.Object r3 = r3.getKey()
            java.lang.Object r3 = r7.get(r3)
            boolean r5 = r4 instanceof byte[]
            if (r5 == 0) goto L52
            boolean r5 = r3 instanceof byte[]
            if (r5 == 0) goto L52
            byte[] r4 = (byte[]) r4
            byte[] r3 = (byte[]) r3
            boolean r3 = java.util.Arrays.equals(r4, r3)
            goto L56
        L52:
            boolean r3 = r4.equals(r3)
        L56:
            if (r3 != 0) goto L1e
            goto L14
        L59:
            r7 = r0
        L5a:
            if (r7 == 0) goto L5d
            return r0
        L5d:
            return r1
            fill-array 0x005e: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.drive.zzlk.equals(java.lang.Object):boolean");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzg(Object obj) {
        if (obj instanceof byte[]) {
            return zzkm.hashCode((byte[]) obj);
        }
        if (obj instanceof zzkn) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += zzg(entry.getValue()) ^ zzg(entry.getKey());
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzlk<K, V> zzdx() {
        return isEmpty() ? new zzlk<>() : new zzlk<>(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzbp() {
        this.zznh = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isMutable() {
        return this.zznh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzdy() {
        if (!this.zznh) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzlk zzlkVar = new zzlk();
        zzty = zzlkVar;
        zzlkVar.zznh = false;
    }
}
