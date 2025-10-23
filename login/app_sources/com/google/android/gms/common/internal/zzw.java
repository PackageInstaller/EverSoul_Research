package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-basement@@18.3.0 */
/* loaded from: classes.dex */
public final class zzw extends com.google.android.gms.internal.common.zza implements IAccountAccessor {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzw(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.common.internal.IAccountAccessor");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.internal.IAccountAccessor
    public final Account zzb() throws RemoteException {
        Parcel zzB = zzB(2, zza());
        Account account = (Account) com.google.android.gms.internal.common.zzc.zza(zzB, Account.CREATOR);
        zzB.recycle();
        return account;
    }
}
