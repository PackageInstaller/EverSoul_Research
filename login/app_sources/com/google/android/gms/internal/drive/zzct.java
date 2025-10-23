package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzct extends TaskApiCall<zzaw, DriveContents> {
    private final /* synthetic */ DriveFile zzfs;
    private final /* synthetic */ int zzft;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzct(zzch zzchVar, DriveFile driveFile, int i) {
        this.zzfs = driveFile;
        this.zzft = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<DriveContents> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgj(this.zzfs.getDriveId(), this.zzft, 0), new zzhi(taskCompletionSource));
    }
}
