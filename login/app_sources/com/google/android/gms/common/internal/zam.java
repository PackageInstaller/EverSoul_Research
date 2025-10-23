package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public final class zam extends com.google.android.gms.internal.base.zaa implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zam(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ISignInButtonCreator");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final IObjectWrapper zae(IObjectWrapper iObjectWrapper, zax zaxVar) throws RemoteException {
        Parcel zaa = zaa();
        com.google.android.gms.internal.base.zac.zad(zaa, iObjectWrapper);
        com.google.android.gms.internal.base.zac.zac(zaa, zaxVar);
        Parcel zab = zab(2, zaa);
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zab.readStrongBinder());
        zab.recycle();
        return asInterface;
    }
}
