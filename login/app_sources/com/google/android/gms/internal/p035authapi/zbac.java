package com.google.android.gms.internal.p035authapi;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-auth@@20.2.0 */
/* loaded from: classes2.dex */
public abstract class zbac extends zbb implements zbad {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zbac() {
        super("com.google.android.gms.auth.api.identity.internal.IGetSignInIntentCallback");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.p035authapi.zbb
    protected final boolean zba(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        Status status = (Status) zbc.zba(parcel, Status.CREATOR);
        PendingIntent pendingIntent = (PendingIntent) zbc.zba(parcel, PendingIntent.CREATOR);
        zbc.zbb(parcel);
        zbb(status, pendingIntent);
        return true;
    }
}
