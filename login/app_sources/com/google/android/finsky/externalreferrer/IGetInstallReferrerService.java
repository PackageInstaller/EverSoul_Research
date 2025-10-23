package com.google.android.finsky.externalreferrer;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.p007a.BinderC0863b;
import com.google.android.p007a.C0862a;
import com.google.android.p007a.C0864c;

/* loaded from: classes.dex */
public interface IGetInstallReferrerService extends IInterface {

    public static abstract class Stub extends BinderC0863b implements IGetInstallReferrerService {

        public static class Proxy extends C0862a implements IGetInstallReferrerService {
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            Proxy(IBinder iBinder) {
                super(iBinder);
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.finsky.externalreferrer.IGetInstallReferrerService
            /* renamed from: c */
            public final Bundle mo140c(Bundle bundle) throws RemoteException {
                Parcel m100a = m100a();
                C0864c.m104b(m100a, bundle);
                Parcel m101b = m101b(m100a);
                Bundle bundle2 = (Bundle) C0864c.m103a(m101b, Bundle.CREATOR);
                m101b.recycle();
                return bundle2;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: b */
        public static IGetInstallReferrerService m141b(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
            return queryLocalInterface instanceof IGetInstallReferrerService ? (IGetInstallReferrerService) queryLocalInterface : new Proxy(iBinder);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.p007a.BinderC0863b
        /* renamed from: a */
        protected final boolean mo102a(int i, Parcel parcel, Parcel parcel2) throws RemoteException {
            if (i != 1) {
                return false;
            }
            Bundle c = mo140c((Bundle) C0864c.m103a(parcel, Bundle.CREATOR));
            parcel2.writeNoException();
            C0864c.m105c(parcel2, c);
            return true;
        }
    }

    /* renamed from: c */
    Bundle mo140c(Bundle bundle) throws RemoteException;
}
