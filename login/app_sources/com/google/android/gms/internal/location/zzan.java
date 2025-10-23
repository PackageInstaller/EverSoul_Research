package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationSettingsResult;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
public abstract class zzan extends zzb implements zzao {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzan() {
        super("com.google.android.gms.location.internal.ISettingsCallbacks");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb((LocationSettingsResult) zzc.zzb(parcel, LocationSettingsResult.CREATOR));
        return true;
    }
}
