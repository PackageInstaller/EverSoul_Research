package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzdb extends TaskApiCall<zzaw, DriveFolder> {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ DriveFolder zzfz;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdb(zzch zzchVar, MetadataChangeSet metadataChangeSet, DriveFolder driveFolder) {
        this.zzfd = metadataChangeSet;
        this.zzfz = driveFolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<DriveFolder> taskCompletionSource) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.zzfd.zzq().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzy(this.zzfz.getDriveId(), this.zzfd.zzq()), new zzhk(taskCompletionSource));
    }
}
