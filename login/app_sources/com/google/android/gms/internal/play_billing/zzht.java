package com.google.android.gms.internal.play_billing;

import java.util.Map;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzht implements Map.Entry {
    private final Map.Entry zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.zza.getKey();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object getValue() {
        if (((zzhw) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        if (obj instanceof zzim) {
            return ((zzhw) this.zza.getValue()).zzc((zzim) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzhw zza() {
        return (zzhw) this.zza.getValue();
    }
}
