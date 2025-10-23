package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
public abstract class zzaj extends zzb implements zzak {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzaj() {
        super("com.google.android.gms.location.internal.IGeofencerCallbacks");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.location.zzb
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb(parcel.readInt(), parcel.createStringArray());
        } else if (i == 2) {
            zzc(parcel.readInt(), parcel.createStringArray());
        } else {
            if (i != 3) {
                return false;
            }
            zzd(parcel.readInt(), (PendingIntent) zzc.zzb(parcel, PendingIntent.CREATOR));
        }
        return true;
    }
}
