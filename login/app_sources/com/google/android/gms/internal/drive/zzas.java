package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.BaseImplementation;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.MetadataBuffer;

/* loaded from: classes2.dex */
final class zzas extends zzl {
    private final BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> zzdx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzas(BaseImplementation.ResultHolder<DriveApi.MetadataBufferResult> resultHolder) {
        this.zzdx = resultHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzft zzftVar) throws RemoteException {
        this.zzdx.setResult(new zzaq(Status.RESULT_SUCCESS, new MetadataBuffer(zzftVar.zzii), zzftVar.zzea));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.zzdx.setResult(new zzaq(status, null, false));
    }
}
