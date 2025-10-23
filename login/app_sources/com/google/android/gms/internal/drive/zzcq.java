package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;
import com.google.android.gms.drive.DriveResource;
import com.google.android.gms.tasks.TaskCompletionSource;

/* loaded from: classes2.dex */
final class zzcq extends UnregisterListenerMethod<zzaw, zzdi> {
    private final /* synthetic */ DriveResource zzfq;
    private final /* synthetic */ zzdi zzfr;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzcq(zzch zzchVar, ListenerHolder.ListenerKey listenerKey, DriveResource driveResource, zzdi zzdiVar) {
        super(listenerKey);
        this.zzfq = driveResource;
        this.zzfr = zzdiVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    protected final /* synthetic */ void unregisterListener(zzaw zzawVar, TaskCompletionSource taskCompletionSource) throws RemoteException {
        zzee zzeeVar;
        zzeo zzeoVar = (zzeo) zzawVar.getService();
        zzgs zzgsVar = new zzgs(this.zzfq.getDriveId(), 1);
        zzeeVar = this.zzfr.zzgh;
        zzeoVar.zza(zzgsVar, zzeeVar, (String) null, new zzhq(taskCompletionSource));
    }
}
