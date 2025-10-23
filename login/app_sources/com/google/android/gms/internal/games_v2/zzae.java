package com.google.android.gms.internal.games_v2;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzae extends zza implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzae(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.connect.IGamesConnectService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd(zzad zzadVar, zzy zzyVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzf(zza, zzadVar);
        zzc.zzd(zza, zzyVar);
        zzc(2, zza);
    }
}
