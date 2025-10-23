package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public abstract class zzac extends zzb implements zzad {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzac() {
        super("com.google.android.gms.games.internal.connect.IGamesConnectCallbacks");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.games_v2.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 2) {
            return false;
        }
        Status status = (Status) zzc.zza(parcel, Status.CREATOR);
        zzaa zzaaVar = (zzaa) zzc.zza(parcel, zzaa.CREATOR);
        zzc.zzb(parcel);
        zzb(status, zzaaVar);
        return true;
    }
}
