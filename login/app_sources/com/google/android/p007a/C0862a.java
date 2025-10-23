package com.google.android.p007a;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: BaseProxy.java */
/* renamed from: com.google.android.a.a */
/* loaded from: classes.dex */
public class C0862a implements IInterface {

    /* renamed from: a */
    private final IBinder f223a;

    /* renamed from: b */
    private final String f224b = "com.google.android.finsky.externalreferrer.IGetInstallReferrerService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected C0862a(IBinder iBinder) {
        this.f223a = iBinder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    protected final Parcel m100a() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.f224b);
        return obtain;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.f223a;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: b */
    protected final Parcel m101b(Parcel parcel) throws RemoteException {
        Parcel obtain = Parcel.obtain();
        try {
            try {
                this.f223a.transact(1, parcel, obtain, 0);
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
}
