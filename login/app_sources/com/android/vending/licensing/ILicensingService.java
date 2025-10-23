package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.android.vending.licensing.ILicenseResultListener;
import com.liapp.y;

/* loaded from: classes.dex */
public interface ILicensingService extends IInterface {
    void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException;

    public static abstract class Stub extends Binder implements ILicensingService {
        private static final String DESCRIPTOR = "com.android.vending.licensing.ILicensingService";
        static final int TRANSACTION_checkLicense = 1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Stub() {
            attachInterface(this, y.ۮڭڭܬި(862025139));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ILicensingService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(y.ۮڭڭܬި(862025139));
            if (queryLocalInterface != null && (queryLocalInterface instanceof ILicensingService)) {
                return (ILicensingService) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = y.ۮڭڭܬި(862025139);
            if (i == 1) {
                parcel.enforceInterface(str);
                checkLicense(parcel.readLong(), parcel.readString(), ILicenseResultListener.Stub.asInterface(parcel.readStrongBinder()));
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ILicensingService {
            private IBinder mRemote;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public String getInterfaceDescriptor() {
                return y.ۮڭڭܬި(862025139);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            Proxy(IBinder iBinder) {
                this.mRemote = iBinder;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.mRemote;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.android.vending.licensing.ILicensingService
            public void checkLicense(long j, String str, ILicenseResultListener iLicenseResultListener) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeLong(j);
                    obtain.writeString(str);
                    obtain.writeStrongBinder(iLicenseResultListener != null ? iLicenseResultListener.asBinder() : null);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
