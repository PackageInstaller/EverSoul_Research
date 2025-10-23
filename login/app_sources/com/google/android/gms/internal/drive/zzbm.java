package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;

/* loaded from: classes2.dex */
final class zzbm extends zzav {
    private final /* synthetic */ zzbi zzev;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbm(zzbi zzbiVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzev = zzbiVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        Contents contents;
        zzeo zzeoVar = (zzeo) zzawVar.getService();
        contents = this.zzev.zzes;
        zzeoVar.zza(new zzo(contents.getRequestId(), false), new zzgy(this));
    }
}
