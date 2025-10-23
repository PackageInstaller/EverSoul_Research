package com.google.android.gms.internal.play_billing;

import java.io.Serializable;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzdc extends zzde implements Serializable {
    static final zzdc zza = new zzdc();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzdc() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.Comparator
    public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
        Comparable comparable = (Comparable) obj;
        Comparable comparable2 = (Comparable) obj2;
        comparable.getClass();
        comparable2.getClass();
        return comparable.compareTo(comparable2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "Ordering.natural()";
    }
}
