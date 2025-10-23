package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzcy extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ MetadataChangeSet zzew;
    private final /* synthetic */ DriveContents zzfx;
    private final /* synthetic */ com.google.android.gms.drive.zzn zzfy;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcy(zzch zzchVar, com.google.android.gms.drive.zzn zznVar, DriveContents driveContents, MetadataChangeSet metadataChangeSet) {
        this.zzfy = zznVar;
        this.zzfx = driveContents;
        this.zzew = metadataChangeSet;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        try {
            this.zzfy.zza(zzawVar2);
        } catch (IllegalStateException e) {
            taskCompletionSource.setException(e);
        }
        this.zzfx.zzj();
        this.zzew.zzq().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzm(this.zzfx.getDriveId(), this.zzew.zzq(), this.zzfx.zzi().getRequestId(), this.zzfx.zzi().zzb(), this.zzfy), new zzhr(taskCompletionSource));
    }
}
