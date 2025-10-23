package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;

/* loaded from: classes2.dex */
final class zzat extends zzav {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzat(GoogleApiClient googleApiClient, Status status) {
        super(googleApiClient);
        setResult((zzat) status);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* bridge */ /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
    }
}
