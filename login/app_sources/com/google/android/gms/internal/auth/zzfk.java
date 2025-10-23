package com.google.android.gms.internal.auth;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public final class zzfk<K, V> extends LinkedHashMap<K, V> {
    private static final zzfk zza;
    private boolean zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzfk zzfkVar = new zzfk();
        zza = zzfkVar;
        zzfkVar.zzb = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfk() {
        this.zzb = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <K, V> zzfk<K, V> zza() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzf(Object obj) {
        if (obj instanceof byte[]) {
            return zzev.zzb((byte[]) obj);
        }
        if (obj instanceof zzes) {
            throw new UnsupportedOperationException();
        }
        return obj.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final void zzg() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void clear() {
        zzg();
        super.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.LinkedHashMap, java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Set<Map.Entry<K, V>> entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            V value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.AbstractMap, java.util.Map
    public final int hashCode() {
        int i = 0;
        for (Map.Entry<K, V> entry : entrySet()) {
            i += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V put(K k, V v) {
        zzg();
        zzev.zze(k);
        zzev.zze(v);
        return (V) super.put(k, v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map<? extends K, ? extends V> map) {
        zzg();
        for (K k : map.keySet()) {
            zzev.zze(k);
            zzev.zze(map.get(k));
        }
        super.putAll(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final V remove(Object obj) {
        zzg();
        return (V) super.remove(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzfk<K, V> zzb() {
        return isEmpty() ? new zzfk<>() : new zzfk<>(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc() {
        this.zzb = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd(zzfk<K, V> zzfkVar) {
        zzg();
        if (zzfkVar.isEmpty()) {
            return;
        }
        putAll(zzfkVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zze() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfk(Map<K, V> map) {
        super(map);
        this.zzb = true;
    }
}
