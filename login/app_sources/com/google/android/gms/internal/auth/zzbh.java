package com.google.android.gms.internal.auth;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.auth.api.proxy.ProxyRequest;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
public final class zzbh extends zza implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbh(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.internal.IAuthService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzd(zzbg zzbgVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzbgVar);
        zzc(3, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zze(zzbg zzbgVar, ProxyRequest proxyRequest) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzbgVar);
        zzc.zzc(zza, proxyRequest);
        zzc(1, zza);
    }
}
