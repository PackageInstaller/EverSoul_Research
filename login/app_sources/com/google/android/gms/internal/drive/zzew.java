package com.google.android.gms.internal.drive;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: classes2.dex */
public final class zzew extends zza implements zzeu {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzew(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.drive.internal.IEventReleaseCallback");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzeu
    public final void zza(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.writeBoolean(zza, z);
        zzc(1, zza);
    }
}
