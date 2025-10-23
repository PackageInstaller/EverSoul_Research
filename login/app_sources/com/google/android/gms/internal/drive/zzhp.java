package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.Metadata;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzhp extends zzhh<Metadata> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhp(TaskCompletionSource<Metadata> taskCompletionSource) {
        super(taskCompletionSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfy zzfyVar) throws RemoteException {
        zzay().setResult(new zzaa(zzfyVar.zzaw()));
    }
}
