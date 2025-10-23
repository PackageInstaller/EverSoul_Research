package com.google.android.gms.internal.drive;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
public abstract class zzav extends zzau<Status> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzav(GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }
}
