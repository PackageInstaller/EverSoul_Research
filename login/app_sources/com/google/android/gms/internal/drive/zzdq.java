package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;

/* loaded from: classes2.dex */
final class zzdq extends zzea {
    private final /* synthetic */ boolean zzga = false;
    private final /* synthetic */ zzdp zzgq;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdq(zzdp zzdpVar, GoogleApiClient googleApiClient, boolean z) {
        super(zzdpVar, googleApiClient, null);
        this.zzgq = zzdpVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzek(this.zzgq.zzk, this.zzga), new zzdy(this));
    }
}
