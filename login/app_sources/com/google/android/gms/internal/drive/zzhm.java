package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.drive.TransferPreferences;
import com.google.android.gms.drive.TransferPreferencesBuilder;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
public final class zzhm extends zzhh<TransferPreferences> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhm(TaskCompletionSource<TransferPreferences> taskCompletionSource) {
        super(taskCompletionSource);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzfj zzfjVar) throws RemoteException {
        zzay().setResult(new TransferPreferencesBuilder(zzfjVar.zzas()).build());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzl, com.google.android.gms.internal.drive.zzeq
    public final void zza(zzga zzgaVar) throws RemoteException {
        zzay().setResult(zzgaVar.zzax());
    }
}
