package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public abstract class zbq extends com.google.android.gms.internal.p035authapi.zbb implements zbr {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zbq() {
        super("com.google.android.gms.auth.api.signin.internal.ISignInCallbacks");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p035authapi.zbb
    protected final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 101:
                GoogleSignInAccount googleSignInAccount = (GoogleSignInAccount) com.google.android.gms.internal.p035authapi.zbc.zba(parcel, GoogleSignInAccount.CREATOR);
                Status status = (Status) com.google.android.gms.internal.p035authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p035authapi.zbc.zbb(parcel);
                zbd(googleSignInAccount, status);
                break;
            case 102:
                Status status2 = (Status) com.google.android.gms.internal.p035authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p035authapi.zbc.zbb(parcel);
                zbc(status2);
                break;
            case 103:
                Status status3 = (Status) com.google.android.gms.internal.p035authapi.zbc.zba(parcel, Status.CREATOR);
                com.google.android.gms.internal.p035authapi.zbc.zbb(parcel);
                zbb(status3);
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
