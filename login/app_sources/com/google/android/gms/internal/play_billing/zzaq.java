package com.google.android.gms.internal.play_billing;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public class zzaq implements IInterface {
    private final IBinder zza;
    private final String zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zzaq(IBinder iBinder, String str) {
        this.zza = iBinder;
        this.zzb = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final Parcel zzu() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        return obtain;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final Parcel zzv(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.zza.transact(i, parcel, obtain, 0);
                obtain.readException();
                return obtain;
            } catch (RuntimeException e) {
                obtain.recycle();
                throw e;
            }
        } finally {
            parcel.recycle();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzw(int i, Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            this.zza.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzx(int i, Parcel parcel) throws RemoteException {
        try {
            this.zza.transact(i, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
