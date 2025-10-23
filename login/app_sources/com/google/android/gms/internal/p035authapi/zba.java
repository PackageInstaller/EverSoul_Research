package com.google.android.gms.internal.p035authapi;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
public class zba implements IInterface {
    private final IBinder zba;
    private final String zbb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zba(IBinder iBinder, String str) {
        this.zba = iBinder;
        this.zbb = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zba;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final Parcel zba() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zbb);
        return obtain;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zbb(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zba.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }
}
