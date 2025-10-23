package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzhk extends zzhh<DriveFolder> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhk(TaskCompletionSource<DriveFolder> taskCompletionSource) {
        super(taskCompletionSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) throws RemoteException {
        zzay().setResult(zzfnVar.getDriveId().asDriveFolder());
    }
}
