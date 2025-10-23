package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;

/* loaded from: classes2.dex */
final class zzan extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.DriveIdResult> zzdx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzan(BaseImplementation.ResultHolder<DriveApi.DriveIdResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfy zzfyVar) throws RemoteException {
        this.zzdx.setResult(new zzao(Status.RESULT_SUCCESS, new zzaa(zzfyVar.zzdn).getDriveId()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfn zzfnVar) throws RemoteException {
        this.zzdx.setResult(new zzao(Status.RESULT_SUCCESS, zzfnVar.zzdd));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzao(status, null));
    }
}
