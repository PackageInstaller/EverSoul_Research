package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.util.List;

/* loaded from: classes2.dex */
final class zzdf extends TaskApiCall<zzaw, Void> {
    private final /* synthetic */ DriveResource zzfq;
    private final /* synthetic */ List zzgb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzdf(zzch zzchVar, DriveResource driveResource, List list) {
        this.zzfq = driveResource;
        this.zzgb = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<Void> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgw(this.zzfq.getDriveId(), this.zzgb), new zzhr(taskCompletionSource));
    }
}
