package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
final class zzai extends zzap {
    private final /* synthetic */ String zzdw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzai(zzaf zzafVar, GoogleApiClient googleApiClient, String str) {
        super(googleApiClient);
        this.zzdw = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzek(DriveId.zza(this.zzdw), false), new zzan(this));
    }
}
