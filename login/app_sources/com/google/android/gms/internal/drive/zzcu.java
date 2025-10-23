package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.events.OpenFileCallback;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzcu extends RegisterListenerMethod<zzaw, OpenFileCallback> {
    private final /* synthetic */ DriveFile zzfs;
    private final /* synthetic */ int zzft;
    private final /* synthetic */ zzg zzfu;
    private final /* synthetic */ ListenerHolder zzfv;
    private final /* synthetic */ zzch zzfw;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcu(zzch zzchVar, ListenerHolder listenerHolder, DriveFile driveFile, int i, zzg zzgVar, ListenerHolder listenerHolder2) {
        super(listenerHolder);
        this.zzfw = zzchVar;
        this.zzfs = driveFile;
        this.zzft = i;
        this.zzfu = zzgVar;
        this.zzfv = listenerHolder2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    protected final /* synthetic */ void registerListener(zzaw zzawVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        this.zzfu.setCancelToken(ICancelToken.Stub.asInterface(((zzeo) zzawVar.getService()).zza(new zzgj(this.zzfs.getDriveId(), this.zzft, 0), new zzdk(this.zzfw, this.zzfu, this.zzfv)).zzgs));
        taskCompletionSource.setResult(null);
    }
}
