package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzhq extends zzhh<Boolean> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhq(TaskCompletionSource<Boolean> taskCompletionSource) {
        super(taskCompletionSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void onSuccess() throws RemoteException {
        zzay().setResult(true);
    }
}
