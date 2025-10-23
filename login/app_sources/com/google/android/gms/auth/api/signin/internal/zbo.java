package com.google.android.gms.auth.api.signin.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes.dex */
public abstract class zbo extends com.google.android.gms.internal.p035authapi.zbb implements zbp {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zbo() {
        super("com.google.android.gms.auth.api.signin.internal.IRevocationService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p035authapi.zbb
    protected final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zbc();
        } else {
            if (i != 2) {
                return false;
            }
            zbb();
        }
        return true;
    }
}
