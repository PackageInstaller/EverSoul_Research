package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.drive.MetadataBuffer;
import com.google.android.gms.drive.query.Query;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzcz extends TaskApiCall<zzaw, MetadataBuffer> {
    private final /* synthetic */ Query zzdu;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcz(zzch zzchVar, Query query) {
        this.zzdu = query;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.TaskApiCall
    protected final /* synthetic */ void doExecute(zzaw zzawVar, TaskCompletionSource<MetadataBuffer> taskCompletionSource) throws RemoteException {
        ((zzeo) zzawVar.getService()).zza(new zzgq(this.zzdu), new zzhn(taskCompletionSource));
    }
}
