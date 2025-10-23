package com.google.android.gms.common.internal.service;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-base@@18.4.0 */
/* loaded from: classes.dex */
public abstract class zaj extends com.google.android.gms.internal.base.zab implements zak {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zaj() {
        super("com.google.android.gms.common.internal.service.ICommonCallbacks");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.base.zab
    protected final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        int readInt = parcel.readInt();
        com.google.android.gms.internal.base.zac.zab(parcel);
        zab(readInt);
        return true;
    }
}
