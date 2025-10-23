package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.ArrayList;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzfk extends com.google.android.gms.internal.measurement.zzbu implements zzfi {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final zzaj zza(zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        Parcel zza = zza(21, m170a_);
        zzaj zzajVar = (zzaj) com.google.android.gms.internal.measurement.zzbw.zza(zza, zzaj.CREATOR);
        zza.recycle();
        return zzajVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final String zzb(zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        Parcel zza = zza(11, m170a_);
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zzmh> zza(zzo zzoVar, Bundle bundle) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, bundle);
        Parcel zza = zza(24, m170a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzmh.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zznb> zza(zzo zzoVar, boolean z) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, z);
        Parcel zza = zza(7, m170a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zznb.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zzae> zza(String str, String str2, zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        m170a_.writeString(str);
        m170a_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        Parcel zza = zza(16, m170a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzae.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zzae> zza(String str, String str2, String str3) throws RemoteException {
        Parcel m170a_ = m170a_();
        m170a_.writeString(str);
        m170a_.writeString(str2);
        m170a_.writeString(str3);
        Parcel zza = zza(17, m170a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zzae.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zznb> zza(String str, String str2, boolean z, zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        m170a_.writeString(str);
        m170a_.writeString(str2);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, z);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        Parcel zza = zza(14, m170a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zznb.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final List<zznb> zza(String str, String str2, String str3, boolean z) throws RemoteException {
        Parcel m170a_ = m170a_();
        m170a_.writeString(str);
        m170a_.writeString(str2);
        m170a_.writeString(str3);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, z);
        Parcel zza = zza(15, m170a_);
        ArrayList createTypedArrayList = zza.createTypedArrayList(zznb.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzfk(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zzc(zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        zzb(4, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zzbe zzbeVar, zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzbeVar);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        zzb(1, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zzbe zzbeVar, String str, String str2) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzbeVar);
        m170a_.writeString(str);
        m170a_.writeString(str2);
        zzb(5, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zzd(zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        zzb(18, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zzae zzaeVar, zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzaeVar);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        zzb(12, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zzae zzaeVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzaeVar);
        zzb(13, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zze(zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        zzb(20, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(long j, String str, String str2, String str3) throws RemoteException {
        Parcel m170a_ = m170a_();
        m170a_.writeLong(j);
        m170a_.writeString(str);
        m170a_.writeString(str2);
        m170a_.writeString(str3);
        zzb(10, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(Bundle bundle, zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, bundle);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        zzb(19, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zzf(zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        zzb(6, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final void zza(zznb zznbVar, zzo zzoVar) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zznbVar);
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzoVar);
        zzb(2, m170a_);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzfi
    public final byte[] zza(zzbe zzbeVar, String str) throws RemoteException {
        Parcel m170a_ = m170a_();
        com.google.android.gms.internal.measurement.zzbw.zza(m170a_, zzbeVar);
        m170a_.writeString(str);
        Parcel zza = zza(9, m170a_);
        byte[] createByteArray = zza.createByteArray();
        zza.recycle();
        return createByteArray;
    }
}
