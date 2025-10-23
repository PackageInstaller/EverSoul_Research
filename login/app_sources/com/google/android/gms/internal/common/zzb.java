package com.google.android.gms.internal.common;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes2.dex */
public class zzb extends Binder implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzb(String str) {
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
        return zza(i, parcel, parcel2, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }
}
