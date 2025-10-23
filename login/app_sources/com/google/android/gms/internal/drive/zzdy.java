package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveResource;

/* loaded from: classes2.dex */
final class zzdy extends zzl {
    private final BaseImplementation.ResultHolder<DriveResource.MetadataResult> zzdx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzdy(BaseImplementation.ResultHolder<DriveResource.MetadataResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfy zzfyVar) throws RemoteException {
        this.zzdx.setResult(new zzdz(Status.RESULT_SUCCESS, new zzaa(zzfyVar.zzdn)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzdz(status, null));
    }
}
