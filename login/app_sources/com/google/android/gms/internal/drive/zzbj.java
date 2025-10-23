package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
final class zzbj extends zzam {
    private final /* synthetic */ zzbi zzev;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbj(zzbi zzbiVar, GoogleApiClient googleApiClient) {
        super(googleApiClient);
        this.zzev = zzbiVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    protected final /* synthetic */ void doExecute(zzaw zzawVar) throws RemoteException {
        Contents contents;
        zzeo zzeoVar = (zzeo) zzawVar.getService();
        DriveId driveId = this.zzev.getDriveId();
        contents = this.zzev.zzes;
        zzeoVar.zza(new zzgj(driveId, DriveFile.MODE_WRITE_ONLY, contents.getRequestId()), new zzgl(this, null));
    }
}
