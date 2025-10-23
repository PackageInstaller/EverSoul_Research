package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.MetadataChangeSet;

/* loaded from: classes2.dex */
final class zzbu extends zzca {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ zzbs zzfh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbu(zzbs zzbsVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet) {
        super(googleApiClient);
        this.zzfh = zzbsVar;
        this.zzfd = metadataChangeSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.zzfd.zzq().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzy(this.zzfh.getDriveId(), this.zzfd.zzq()), new zzbw(this));
    }
}
