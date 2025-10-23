package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
final class zaba implements GoogleApiClient.OnConnectionFailedListener {
    final /* synthetic */ StatusPendingResult zaa;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zaba(zabe zabeVar, StatusPendingResult statusPendingResult) {
        this.zaa = statusPendingResult;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.OnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        this.zaa.setResult(new Status(8));
    }
}
