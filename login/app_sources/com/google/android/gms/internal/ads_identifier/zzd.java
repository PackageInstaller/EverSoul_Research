package com.google.android.gms.internal.ads_identifier;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* compiled from: com.google.android.gms:play-services-ads-identifier@@17.1.0 */
/* loaded from: classes2.dex */
public final class zzd extends zza implements zzf {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzd(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final String zzc() throws RemoteException {
        Parcel zzb = zzb(1, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final boolean zzd() throws RemoteException {
        Parcel zzb = zzb(6, zza());
        boolean zzb2 = zzc.zzb(zzb);
        zzb.recycle();
        return zzb2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.ads_identifier.zzf
    public final boolean zze(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, true);
        Parcel zzb = zzb(2, zza);
        boolean zzb2 = zzc.zzb(zzb);
        zzb.recycle();
        return zzb2;
    }
}
