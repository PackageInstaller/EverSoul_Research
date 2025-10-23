package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public class zzhh<T> extends zzl {
    private TaskCompletionSource<T> zziv;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhh(TaskCompletionSource<T> taskCompletionSource) {
        this.zziv = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(Status status) throws RemoteException {
        this.zziv.setException(new ApiException(status));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TaskCompletionSource<T> zzay() {
        return this.zziv;
    }
}
