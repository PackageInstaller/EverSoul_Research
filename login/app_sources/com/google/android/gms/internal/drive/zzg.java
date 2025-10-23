package com.google.android.gms.internal.drive;

import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.internal.ICancelToken;
import com.google.android.gms.drive.events.ListenerToken;

/* loaded from: classes2.dex */
public final class zzg implements ListenerToken {
    private final ListenerHolder.ListenerKey zzcy;
    private ICancelToken zzcz = null;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzg(ListenerHolder.ListenerKey listenerKey) {
        this.zzcy = listenerKey;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ListenerHolder.ListenerKey zzad() {
        return this.zzcy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setCancelToken(ICancelToken iCancelToken) {
        this.zzcz = iCancelToken;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean cancel() {
        ICancelToken iCancelToken = this.zzcz;
        if (iCancelToken == null) {
            return false;
        }
        try {
            iCancelToken.cancel();
            return true;
        } catch (RemoteException unused) {
            return false;
        }
    }
}
