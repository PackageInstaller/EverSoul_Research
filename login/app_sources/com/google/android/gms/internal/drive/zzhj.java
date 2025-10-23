package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzhj extends zzhh<DriveFile> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhj(TaskCompletionSource<DriveFile> taskCompletionSource) {
        super(taskCompletionSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) throws RemoteException {
        zzay().setResult(zzfnVar.getDriveId().asDriveFile());
    }
}
