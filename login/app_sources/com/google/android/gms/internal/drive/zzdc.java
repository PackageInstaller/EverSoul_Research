package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzdc extends TaskApiCall<zzaw, Metadata> {
    private final /* synthetic */ DriveResource zzfq;
    private final /* synthetic */ boolean zzga = false;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdc(zzch zzchVar, DriveResource driveResource, boolean z) {
        this.zzfq = driveResource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<Metadata> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzek(this.zzfq.getDriveId(), this.zzga), new zzhp(taskCompletionSource));
    }
}
