package com.google.android.gms.games.internal;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public abstract class zzan extends com.google.android.gms.internal.games_v2.zzb implements zzao {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzan() {
        super("com.google.android.gms.games.internal.IGamesClient");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1001) {
            return false;
        }
        com.google.android.gms.internal.games_v2.zzan zzb = zzb();
        parcel2.writeNoException();
        com.google.android.gms.internal.games_v2.zzc.zze(parcel2, zzb);
        return true;
    }
}
