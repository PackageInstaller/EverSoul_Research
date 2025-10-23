package com.google.android.play.core.review.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.play:review@@2.0.0 */
/* loaded from: classes2.dex */
public class zza implements IInterface {
    private final IBinder zza;
    private final String zzb = "com.google.android.play.core.inappreview.protocol.IInAppReviewService";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected zza(IBinder iBinder, String str) {
        this.zza = iBinder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.IInterface
    public final IBinder asBinder() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final Parcel zza() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzb);
        return obtain;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected final void zzb(int i, Parcel parcel) throws RemoteException {
        try {
            this.zza.transact(2, parcel, null, 1);
        } finally {
            parcel.recycle();
        }
    }
}
