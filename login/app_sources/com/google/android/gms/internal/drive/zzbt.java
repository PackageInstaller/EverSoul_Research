package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.ExecutionOptions;
import com.google.android.gms.drive.MetadataChangeSet;

/* loaded from: classes2.dex */
final class zzbt extends zzby {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ int zzfe;
    private final /* synthetic */ int zzff;
    private final /* synthetic */ ExecutionOptions zzfg;
    private final /* synthetic */ zzbs zzfh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbt(zzbs zzbsVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, int i, int i2, ExecutionOptions executionOptions) {
        super(googleApiClient);
        this.zzfh = zzbsVar;
        this.zzfd = metadataChangeSet;
        this.zzfe = i;
        this.zzff = i2;
        this.zzfg = executionOptions;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.zzfd.zzq().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzw(this.zzfh.getDriveId(), this.zzfd.zzq(), this.zzfe, this.zzff, this.zzfg), new zzbv(this));
    }
}
