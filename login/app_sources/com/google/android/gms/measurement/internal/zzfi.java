package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IInterface;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public interface zzfi extends IInterface {
    zzaj zza(zzo zzoVar) throws RemoteException;

    List<zzmh> zza(zzo zzoVar, Bundle bundle) throws RemoteException;

    List<zznb> zza(zzo zzoVar, boolean z) throws RemoteException;

    List<zzae> zza(String str, String str2, zzo zzoVar) throws RemoteException;

    List<zzae> zza(String str, String str2, String str3) throws RemoteException;

    List<zznb> zza(String str, String str2, String str3, boolean z) throws RemoteException;

    List<zznb> zza(String str, String str2, boolean z, zzo zzoVar) throws RemoteException;

    void zza(long j, String str, String str2, String str3) throws RemoteException;

    void zza(Bundle bundle, zzo zzoVar) throws RemoteException;

    void zza(zzae zzaeVar) throws RemoteException;

    void zza(zzae zzaeVar, zzo zzoVar) throws RemoteException;

    void zza(zzbe zzbeVar, zzo zzoVar) throws RemoteException;

    void zza(zzbe zzbeVar, String str, String str2) throws RemoteException;

    void zza(zznb zznbVar, zzo zzoVar) throws RemoteException;

    byte[] zza(zzbe zzbeVar, String str) throws RemoteException;

    String zzb(zzo zzoVar) throws RemoteException;

    void zzc(zzo zzoVar) throws RemoteException;

    void zzd(zzo zzoVar) throws RemoteException;

    void zze(zzo zzoVar) throws RemoteException;

    void zzf(zzo zzoVar) throws RemoteException;
}
