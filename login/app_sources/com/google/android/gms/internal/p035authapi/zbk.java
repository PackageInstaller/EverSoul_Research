package com.google.android.gms.internal.p035authapi;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
final class zbk extends zbd {
    private final BaseImplementation.ResultHolder zba;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zbk(BaseImplementation.ResultHolder resultHolder) {
        this.zba = resultHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p035authapi.zbd, com.google.android.gms.internal.p035authapi.zbs
    public final void zbc(Status status) {
        this.zba.setResult(status);
    }
}
