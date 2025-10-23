package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zzy extends com.google.android.gms.internal.common.zza implements zzaa {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzy(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.ICertData");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.internal.zzaa
    public final int zzc() throws RemoteException {
        Parcel zzB = zzB(2, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.internal.zzaa
    public final IObjectWrapper zzd() throws RemoteException {
        Parcel zzB = zzB(1, zza());
        IObjectWrapper asInterface = IObjectWrapper.Stub.asInterface(zzB.readStrongBinder());
        zzB.recycle();
        return asInterface;
    }
}
