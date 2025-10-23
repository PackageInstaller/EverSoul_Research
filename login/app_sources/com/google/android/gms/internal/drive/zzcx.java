package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzcx extends TaskApiCall<zzaw, DriveContents> {
    private final /* synthetic */ DriveContents zzfx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcx(zzch zzchVar, DriveContents driveContents) {
        this.zzfx = driveContents;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<DriveContents> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgj(this.zzfx.getDriveId(), DriveFile.MODE_WRITE_ONLY, this.zzfx.zzi().getRequestId()), new zzhi(taskCompletionSource));
    }
}
