package com.google.android.gms.auth.account;

import android.os.IBinder;
import android.os.IInterface;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes.dex */
public abstract class zzd extends com.google.android.gms.internal.auth.zzb implements zze {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zze zzb(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.auth.account.IWorkAccountService");
        return queryLocalInterface instanceof zze ? (zze) queryLocalInterface : new zzc(iBinder);
    }
}
