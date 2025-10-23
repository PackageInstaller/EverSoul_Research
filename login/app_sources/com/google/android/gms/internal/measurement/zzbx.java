package com.google.android.gms.internal.measurement;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public class zzbx extends Binder implements IInterface {
    private static zzbz zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.IInterface
    public IBinder asBinder() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzbx(String str) {
        attachInterface(this, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        boolean z;
        if (i > 16777215) {
            z = super.onTransact(i, parcel, parcel2, i2);
        } else {
            parcel.enforceInterface(getInterfaceDescriptor());
            z = false;
        }
        if (z) {
            return true;
        }
        return zza(i, parcel, parcel2, i2);
    }
}
