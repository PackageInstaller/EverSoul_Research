package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
final class zzbk extends zzav {
    private final /* synthetic */ zzbi zzev;
    private final /* synthetic */ MetadataChangeSet zzew;
    private final /* synthetic */ com.google.android.gms.drive.zzn zzex;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbk(zzbi zzbiVar, GoogleApiClient googleApiClient, MetadataChangeSet metadataChangeSet, com.google.android.gms.drive.zzn zznVar) {
        super(googleApiClient);
        this.zzev = zzbiVar;
        this.zzew = metadataChangeSet;
        this.zzex = zznVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        Contents contents;
        Contents contents2;
        Contents contents3;
        zzaw zzawVar2 = zzawVar;
        this.zzew.zzq().zza(zzawVar2.getContext());
        zzeo zzeoVar = (zzeo) zzawVar2.getService();
        contents = this.zzev.zzes;
        DriveId driveId = contents.getDriveId();
        MetadataBundle zzq = this.zzew.zzq();
        contents2 = this.zzev.zzes;
        int requestId = contents2.getRequestId();
        contents3 = this.zzev.zzes;
        zzeoVar.zza(new zzm(driveId, zzq, requestId, contents3.zzb(), this.zzex), new zzgy(this));
    }
}
