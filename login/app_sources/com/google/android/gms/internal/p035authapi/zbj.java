package com.google.android.gms.internal.p035authapi;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
final class zbj extends zbm {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zbj(zbl zblVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BasePendingResult
    protected final /* bridge */ /* synthetic */ Result createFailedResult(Status status) {
        return status;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p035authapi.zbm
    protected final void zba(Context context, zbt zbtVar) throws RemoteException {
        zbtVar.zbf(new zbk(this));
    }
}
