package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
final class zzbw extends zzl {
    private final BaseImplementation.ResultHolder<DriveFolder.DriveFolderResult> zzdx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbw(BaseImplementation.ResultHolder<DriveFolder.DriveFolderResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) throws RemoteException {
        this.zzdx.setResult(new zzbz(Status.RESULT_SUCCESS, new zzbs(zzfnVar.zzdd)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzbz(status, null));
    }
}
