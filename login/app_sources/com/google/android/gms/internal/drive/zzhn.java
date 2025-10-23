package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzhn extends zzhh<MetadataBuffer> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhn(TaskCompletionSource<MetadataBuffer> taskCompletionSource) {
        super(taskCompletionSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzft zzftVar) throws RemoteException {
        zzay().setResult(new MetadataBuffer(zzftVar.zzau()));
    }
}
