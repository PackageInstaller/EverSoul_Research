package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
public abstract class zzah extends zzb implements zzai {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzah() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((zzaa) zzc.zzb(parcel, zzaa.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zzc();
        }
        return true;
    }
}
