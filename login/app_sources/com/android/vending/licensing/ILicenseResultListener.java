package com.android.vending.licensing;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.liapp.y;

/* loaded from: classes.dex */
public interface ILicenseResultListener extends IInterface {
    void verifyLicense(int i, String str, String str2) throws RemoteException;

    public static abstract class Stub extends Binder implements ILicenseResultListener {
        private static final String DESCRIPTOR = "com.android.vending.licensing.ILicenseResultListener";
        static final int TRANSACTION_verifyLicense = 1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Stub() {
            attachInterface(this, y.֬ڱܱײٮ(-1159372823));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static ILicenseResultListener asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(y.֬ڱܱײٮ(-1159372823));
            if (queryLocalInterface != null && (queryLocalInterface instanceof ILicenseResultListener)) {
                return (ILicenseResultListener) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = y.֬ڱܱײٮ(-1159372823);
            if (i == 1) {
                parcel.enforceInterface(str);
                verifyLicense(parcel.readInt(), parcel.readString(), parcel.readString());
                return true;
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements ILicenseResultListener {
            private IBinder mRemote;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public String getInterfaceDescriptor() {
                return y.֬ڱܱײٮ(-1159372823);
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
            @Override // com.android.vending.licensing.ILicenseResultListener
            public void verifyLicense(int i, String str, String str2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(Stub.DESCRIPTOR);
                    obtain.writeInt(i);
                    obtain.writeString(str);
                    obtain.writeString(str2);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
