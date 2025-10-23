package com.google.android.gms.auth.api.signin.internal;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
final class zbj extends zba {
    final /* synthetic */ zbk zba;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zbj(zbk zbkVar) {
        this.zba = zbkVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.auth.api.signin.internal.zba, com.google.android.gms.auth.api.signin.internal.zbr
    public final void zbb(Status status) throws RemoteException {
        this.zba.setResult((zbk) status);
    }
}
