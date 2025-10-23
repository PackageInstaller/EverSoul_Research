package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class zzax extends zzav {
    private final /* synthetic */ zzj zzek;
    private final /* synthetic */ zzee zzel;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzax(zzaw zzawVar, GoogleApiClient googleApiClient, zzj zzjVar, zzee zzeeVar) {
        super(googleApiClient);
        this.zzek = zzjVar;
        this.zzel = zzeeVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(this.zzek, this.zzel, (String) null, new zzgy(this));
    }
}
