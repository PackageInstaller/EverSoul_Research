package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskUtil;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzhr extends zzhh<Void> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhr(TaskCompletionSource<Void> taskCompletionSource) {
        super(taskCompletionSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void onSuccess() throws RemoteException {
        TaskUtil.setResultOrApiException(Status.RESULT_SUCCESS, zzay());
    }
}
