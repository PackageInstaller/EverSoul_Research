package com.android.billingclient.api;

import java.util.concurrent.Callable;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes.dex */
final class zzau implements Callable {
    final /* synthetic */ String zza;
    final /* synthetic */ PurchaseHistoryResponseListener zzb;
    final /* synthetic */ BillingClientImpl zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzau(BillingClientImpl billingClientImpl, String str, PurchaseHistoryResponseListener purchaseHistoryResponseListener) {
        this.zza = str;
        this.zzb = purchaseHistoryResponseListener;
        this.zzc = billingClientImpl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.Callable
    public final /* bridge */ /* synthetic */ Object call() throws Exception {
        zzbk zzay;
        zzay = this.zzc.zzay(this.zza);
        this.zzb.onPurchaseHistoryResponse(zzay.zza(), zzay.zzb());
        return null;
    }
}
