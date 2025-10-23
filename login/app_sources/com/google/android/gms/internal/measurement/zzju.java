package com.google.android.gms.internal.measurement;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzju<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzjr> zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzjr zza() {
        return this.zza.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zza.getKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zza.getValue() == null) {
            return null;
        }
        return zzjr.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzkr)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.zza.getValue().zza((zzkr) obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzju(Map.Entry<K, zzjr> entry) {
        this.zza = entry;
    }
}
