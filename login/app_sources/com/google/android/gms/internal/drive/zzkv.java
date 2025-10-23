package com.google.android.gms.internal.drive;

import java.util.Map;

/* loaded from: classes2.dex */
final class zzkv<K> implements Map.Entry<K, Object> {
    private Map.Entry<K, zzkt> zztf;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzkv(Map.Entry<K, zzkt> entry) {
        this.zztf = entry;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final K getKey() {
        return this.zztf.getKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (this.zztf.getValue() == null) {
            return null;
        }
        return zzkt.zzdp();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzkt zzdq() {
        return this.zztf.getValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (!(obj instanceof zzlq)) {
            throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
        }
        return this.zztf.getValue().zzi((zzlq) obj);
    }
}
