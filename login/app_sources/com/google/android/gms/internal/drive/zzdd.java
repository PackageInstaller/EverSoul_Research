package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzdd extends TaskApiCall<zzaw, Metadata> {
    private final /* synthetic */ MetadataChangeSet zzfd;
    private final /* synthetic */ DriveResource zzfq;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdd(zzch zzchVar, MetadataChangeSet metadataChangeSet, DriveResource driveResource) {
        this.zzfd = metadataChangeSet;
        this.zzfq = driveResource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<Metadata> taskCompletionSource) throws RemoteException {
        zzaw zzawVar2 = zzawVar;
        this.zzfd.zzq().zza(zzawVar2.getContext());
        ((zzeo) zzawVar2.getService()).zza(new zzhf(this.zzfq.getDriveId(), this.zzfd.zzq()), new zzhp(taskCompletionSource));
    }
}
