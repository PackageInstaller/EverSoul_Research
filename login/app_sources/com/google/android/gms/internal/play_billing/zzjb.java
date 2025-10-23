package com.google.android.gms.internal.play_billing;

import java.util.Map;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzjb implements Map.Entry, Comparable {
    final /* synthetic */ zzjf zza;
    private final Comparable zzb;
    private Object zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzjb(zzjf zzjfVar, Comparable comparable, Object obj) {
        this.zza = zzjfVar;
        this.zzb = comparable;
        this.zzc = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static final boolean zzb(Object obj, Object obj2) {
        return obj == null ? obj2 == null : obj.equals(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public final /* bridge */ /* synthetic */ int compareTo(Object obj) {
        return this.zzb.compareTo(((zzjb) obj).zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return zzb(this.zzb, entry.getKey()) && zzb(this.zzc, entry.getValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zzb;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.zzc;
        return hashCode ^ (obj != null ? obj.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.zza.zzo();
        Object obj2 = this.zzc;
        this.zzc = obj;
        return obj2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return String.valueOf(this.zzb) + "=" + String.valueOf(this.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Comparable zza() {
        return this.zzb;
    }
}
