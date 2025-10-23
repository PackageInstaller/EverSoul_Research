package com.google.android.gms.internal.drive;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX WARN: Incorrect field signature: TK; */
/* loaded from: classes2.dex */
final class zzmp<K, V> implements Comparable<zzmp>, Map.Entry<K, V> {
    private V value;
    private final /* synthetic */ zzmi zzvk;
    private final Comparable zzvn;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmp(zzmi zzmiVar, Map.Entry<K, V> entry) {
        this(zzmiVar, (Comparable) entry.getKey(), entry.getValue());
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzmp(zzmi zzmiVar, K k, V v) {
        this.zzvk = zzmiVar;
        this.zzvn = k;
        this.value = v;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final V getValue() {
        return this.value;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final V setValue(V v) {
        this.zzvk.zzeu();
        V v2 = this.value;
        this.value = v;
        return v2;
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
        return equals(this.zzvn, entry.getKey()) && equals(this.value, entry.getValue());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final int hashCode() {
        Comparable comparable = this.zzvn;
        int hashCode = comparable == null ? 0 : comparable.hashCode();
        V v = this.value;
        return hashCode ^ (v != null ? v.hashCode() : 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        String valueOf = String.valueOf(this.zzvn);
        String valueOf2 = String.valueOf(this.value);
        return new StringBuilder(String.valueOf(valueOf).length() + 1 + String.valueOf(valueOf2).length()).append(valueOf).append("=").append(valueOf2).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean equals(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Map.Entry
    public final /* synthetic */ Object getKey() {
        return this.zzvn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Comparable
    public final /* synthetic */ int compareTo(zzmp zzmpVar) {
        return ((Comparable) getKey()).compareTo((Comparable) zzmpVar.getKey());
    }
}
