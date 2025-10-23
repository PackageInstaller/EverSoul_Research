package com.google.android.gms.auth.api.signin.internal;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public final class zbs extends com.google.android.gms.internal.p035authapi.zba implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zbs(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.signin.internal.ISignInService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zbc(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        com.google.android.gms.internal.p035authapi.zbc.zbd(zba, zbrVar);
        com.google.android.gms.internal.p035authapi.zbc.zbc(zba, googleSignInOptions);
        zbb(103, zba);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zbd(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        com.google.android.gms.internal.p035authapi.zbc.zbd(zba, zbrVar);
        com.google.android.gms.internal.p035authapi.zbc.zbc(zba, googleSignInOptions);
        zbb(102, zba);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zbe(zbr zbrVar, GoogleSignInOptions googleSignInOptions) throws RemoteException {
        Parcel zba = zba();
        com.google.android.gms.internal.p035authapi.zbc.zbd(zba, zbrVar);
        com.google.android.gms.internal.p035authapi.zbc.zbc(zba, googleSignInOptions);
        zbb(101, zba);
    }
}
