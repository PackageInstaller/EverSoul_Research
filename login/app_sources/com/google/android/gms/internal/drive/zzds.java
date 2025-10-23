package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import java.util.List;

/* loaded from: classes2.dex */
final class zzds extends zzav {
    private final /* synthetic */ List zzgb;
    private final /* synthetic */ zzdp zzgq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzds(zzdp zzdpVar, GoogleApiClient googleApiClient, List list) {
        super(googleApiClient);
        this.zzgq = zzdpVar;
        this.zzgb = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgw(this.zzgq.zzk, this.zzgb), new zzgy(this));
    }
}
