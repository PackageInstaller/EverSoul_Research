package com.google.android.gms.common.api;

import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.internal.BasePendingResult;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zag<R extends Result> extends BasePendingResult<R> {
    private final Result zae;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zag(GoogleApiClient googleApiClient, Result result) {
        super(googleApiClient);
        this.zae = result;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final R createFailedResult(Status status) {
        return (R) this.zae;
    }
}
