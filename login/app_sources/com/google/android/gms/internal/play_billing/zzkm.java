package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
final class zzkm implements zzhm {
    static final zzhm zza = new zzkm();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzkm() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final boolean zza(int i) {
        return (i != 0 ? i != 1 ? i != 2 ? i != 3 ? null : zzkn.ALTERNATIVE_BILLING_ACTION : zzkn.LOCAL_PURCHASES_UPDATED_ACTION : zzkn.PURCHASES_UPDATED_ACTION : zzkn.BROADCAST_ACTION_UNSPECIFIED) != null;
    }
}
