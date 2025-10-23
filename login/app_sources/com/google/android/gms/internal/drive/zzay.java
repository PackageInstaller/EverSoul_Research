package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class zzay extends zzav {
    private final /* synthetic */ zzee zzel;
    private final /* synthetic */ zzgs zzem;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzay(zzaw zzawVar, GoogleApiClient googleApiClient, zzgs zzgsVar, zzee zzeeVar) {
        super(googleApiClient);
        this.zzem = zzgsVar;
        this.zzel = zzeeVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(this.zzem, this.zzel, (String) null, new zzgy(this));
    }
}
