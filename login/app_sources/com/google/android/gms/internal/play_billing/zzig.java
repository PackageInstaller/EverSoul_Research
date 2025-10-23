package com.google.android.gms.internal.play_billing;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzig extends LinkedHashMap {
    private static final zzig zza;
    private boolean zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzig zzigVar = new zzig();
        zza = zzigVar;
        zzigVar.zzb = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzig() {
        this.zzb = true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzig zza() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int zzf(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof zzkn) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = zzhp.zzb;
        int length = bArr.length;
        int zzb = zzhp.zzb(length, bArr, 0, length);
        if (zzb == 0) {
            return 1;
        }
        return zzb;
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
    public final Set entrySet() {
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
        Iterator it = entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
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
        Iterator it = entrySet().iterator();
        int i = 0;
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            i += zzf(entry.getValue()) ^ zzf(entry.getKey());
        }
        return i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object put(Object obj, Object obj2) {
        zzg();
        byte[] bArr = zzhp.zzb;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final void putAll(Map map) {
        zzg();
        for (Object obj : map.keySet()) {
            byte[] bArr = zzhp.zzb;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.HashMap, java.util.AbstractMap, java.util.Map
    public final Object remove(Object obj) {
        zzg();
        return super.remove(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzig zzb() {
        return isEmpty() ? new zzig() : new zzig(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzc() {
        this.zzb = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd(zzig zzigVar) {
        zzg();
        if (zzigVar.isEmpty()) {
            return;
        }
        putAll(zzigVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zze() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzig(Map map) {
        super(map);
        this.zzb = true;
    }
}
