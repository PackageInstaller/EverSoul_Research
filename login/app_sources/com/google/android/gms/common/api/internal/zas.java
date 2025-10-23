package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.Result;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zas {
    final /* synthetic */ BasePendingResult zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zas(BasePendingResult basePendingResult, zar zarVar) {
        this.zaa = basePendingResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void finalize() throws Throwable {
        Result result;
        result = this.zaa.zaj;
        BasePendingResult.zal(result);
        super.finalize();
    }
}
