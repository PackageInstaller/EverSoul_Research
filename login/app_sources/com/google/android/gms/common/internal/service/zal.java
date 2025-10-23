package com.google.android.gms.common.internal.service;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public final class zal extends com.google.android.gms.internal.base.zaa implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.service.ICommonService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zae(zak zakVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, zakVar);
        zad(1, zaa);
    }
}
