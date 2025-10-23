package com.google.android.gms.location;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
public abstract class zzaz extends com.google.android.gms.internal.location.zzb implements zzba {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzaz() {
        super("com.google.android.gms.location.ILocationCallback");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzba zzb(IBinder iBinder) {
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.location.ILocationCallback");
        return queryLocalInterface instanceof zzba ? (zzba) queryLocalInterface : new zzay(iBinder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzd((LocationResult) com.google.android.gms.internal.location.zzc.zzb(parcel, LocationResult.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zze((LocationAvailability) com.google.android.gms.internal.location.zzc.zzb(parcel, LocationAvailability.CREATOR));
        }
        return true;
    }
}
