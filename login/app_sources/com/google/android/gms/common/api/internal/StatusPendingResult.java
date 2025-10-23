package com.google.android.gms.common.api.internal;

import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public class StatusPendingResult extends BasePendingResult<Status> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public StatusPendingResult(Looper looper) {
        super(looper);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* bridge */ /* synthetic */ Status createFailedResult(Status status) {
        return status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public StatusPendingResult(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }
}
