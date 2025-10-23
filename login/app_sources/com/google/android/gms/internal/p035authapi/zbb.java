package com.google.android.gms.internal.p035authapi;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
public class zbb extends Binder implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zbb(String str) {
        attachInterface(this, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Binder
    public final boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i <= 16777215) {
            parcel.enforceInterface(getInterfaceDescriptor());
        } else if (super.onTransact(i, parcel, parcel2, i2)) {
            return true;
        }
        return zba(i, parcel, parcel2, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        throw null;
    }
}
