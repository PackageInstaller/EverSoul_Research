package androidx.core.app.unusedapprestrictions;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes.dex */
public interface IUnusedAppRestrictionsBackportCallback extends IInterface {
    public static final String DESCRIPTOR = "androidx$core$app$unusedapprestrictions$IUnusedAppRestrictionsBackportCallback".replace('$', ClassUtils.PACKAGE_SEPARATOR_CHAR);

    public static class Default implements IUnusedAppRestrictionsBackportCallback {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
        public void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) throws RemoteException {
        }
    }

    void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) throws RemoteException;

    public static abstract class Stub extends Binder implements IUnusedAppRestrictionsBackportCallback {
        static final int TRANSACTION_onIsPermissionRevocationEnabledForAppResult = 1;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Stub() {
            attachInterface(this, DESCRIPTOR);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static IUnusedAppRestrictionsBackportCallback asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(DESCRIPTOR);
            if (queryLocalInterface != null && (queryLocalInterface instanceof IUnusedAppRestrictionsBackportCallback)) {
                return (IUnusedAppRestrictionsBackportCallback) queryLocalInterface;
            }
            return new Proxy(iBinder);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = DESCRIPTOR;
            if (i >= 1 && i <= 16777215) {
                parcel.enforceInterface(str);
            }
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            if (i == 1) {
                onIsPermissionRevocationEnabledForAppResult(parcel.readInt() != 0, parcel.readInt() != 0);
                return true;
            }
            return super.onTransact(i, parcel, parcel2, i2);
        }

        private static class Proxy implements IUnusedAppRestrictionsBackportCallback {
            private IBinder mRemote;

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
            public String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // androidx.core.app.unusedapprestrictions.IUnusedAppRestrictionsBackportCallback
            public void onIsPermissionRevocationEnabledForAppResult(boolean z, boolean z2) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(DESCRIPTOR);
                    obtain.writeInt(z ? 1 : 0);
                    obtain.writeInt(z2 ? 1 : 0);
                    this.mRemote.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }
    }
}
