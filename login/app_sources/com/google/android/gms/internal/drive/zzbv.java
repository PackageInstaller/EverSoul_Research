package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveFolder;

/* loaded from: classes2.dex */
final class zzbv extends zzl {
    private final BaseImplementation.ResultHolder<DriveFolder.DriveFileResult> zzdx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbv(BaseImplementation.ResultHolder<DriveFolder.DriveFileResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) throws RemoteException {
        this.zzdx.setResult(new zzbx(Status.RESULT_SUCCESS, new zzbn(zzfnVar.zzdd)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzbx(status, null));
    }
}
