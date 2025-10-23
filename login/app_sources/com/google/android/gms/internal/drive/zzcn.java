package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzcn extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource zzfq;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcn(zzch zzchVar, DriveResource driveResource) {
        this.zzfq = driveResource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzhd(this.zzfq.getDriveId()), new zzhr(taskCompletionSource));
    }
}
