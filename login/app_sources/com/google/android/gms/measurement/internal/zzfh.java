package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public abstract class zzfh extends com.google.android.gms.internal.measurement.zzbx implements zzfi {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzfh() {
        super("com.google.android.gms.measurement.internal.IMeasurementService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzbx
    protected final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        switch (i) {
            case 1:
                zzbe zzbeVar = (zzbe) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbe.CREATOR);
                zzo zzoVar = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzbeVar, zzoVar);
                parcel2.writeNoException();
                return true;
            case 2:
                zznb zznbVar = (zznb) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zznb.CREATOR);
                zzo zzoVar2 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zznbVar, zzoVar2);
                parcel2.writeNoException();
                return true;
            case 3:
            case 8:
            case 22:
            case 23:
            default:
                return false;
            case 4:
                zzo zzoVar3 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzc(zzoVar3);
                parcel2.writeNoException();
                return true;
            case 5:
                zzbe zzbeVar2 = (zzbe) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbe.CREATOR);
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzbeVar2, readString, readString2);
                parcel2.writeNoException();
                return true;
            case 6:
                zzo zzoVar4 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzf(zzoVar4);
                parcel2.writeNoException();
                return true;
            case 7:
                zzo zzoVar5 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                boolean zzc = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zznb> zza = zza(zzoVar5, zzc);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza);
                return true;
            case 9:
                zzbe zzbeVar3 = (zzbe) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzbe.CREATOR);
                String readString3 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                byte[] zza2 = zza(zzbeVar3, readString3);
                parcel2.writeNoException();
                parcel2.writeByteArray(zza2);
                return true;
            case 10:
                long readLong = parcel.readLong();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(readLong, readString4, readString5, readString6);
                parcel2.writeNoException();
                return true;
            case 11:
                zzo zzoVar6 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                String zzb = zzb(zzoVar6);
                parcel2.writeNoException();
                parcel2.writeString(zzb);
                return true;
            case 12:
                zzae zzaeVar = (zzae) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzae.CREATOR);
                zzo zzoVar7 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzaeVar, zzoVar7);
                parcel2.writeNoException();
                return true;
            case 13:
                zzae zzaeVar2 = (zzae) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzae.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(zzaeVar2);
                parcel2.writeNoException();
                return true;
            case 14:
                String readString7 = parcel.readString();
                String readString8 = parcel.readString();
                boolean zzc2 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                zzo zzoVar8 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zznb> zza3 = zza(readString7, readString8, zzc2, zzoVar8);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza3);
                return true;
            case 15:
                String readString9 = parcel.readString();
                String readString10 = parcel.readString();
                String readString11 = parcel.readString();
                boolean zzc3 = com.google.android.gms.internal.measurement.zzbw.zzc(parcel);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zznb> zza4 = zza(readString9, readString10, readString11, zzc3);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza4);
                return true;
            case 16:
                String readString12 = parcel.readString();
                String readString13 = parcel.readString();
                zzo zzoVar9 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzae> zza5 = zza(readString12, readString13, zzoVar9);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza5);
                return true;
            case 17:
                String readString14 = parcel.readString();
                String readString15 = parcel.readString();
                String readString16 = parcel.readString();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzae> zza6 = zza(readString14, readString15, readString16);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza6);
                return true;
            case 18:
                zzo zzoVar10 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzd(zzoVar10);
                parcel2.writeNoException();
                return true;
            case 19:
                Bundle bundle = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                zzo zzoVar11 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zza(bundle, zzoVar11);
                parcel2.writeNoException();
                return true;
            case 20:
                zzo zzoVar12 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zze(zzoVar12);
                parcel2.writeNoException();
                return true;
            case 21:
                zzo zzoVar13 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                zzaj zza7 = zza(zzoVar13);
                parcel2.writeNoException();
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel2, zza7);
                return true;
            case 24:
                zzo zzoVar14 = (zzo) com.google.android.gms.internal.measurement.zzbw.zza(parcel, zzo.CREATOR);
                Bundle bundle2 = (Bundle) com.google.android.gms.internal.measurement.zzbw.zza(parcel, Bundle.CREATOR);
                com.google.android.gms.internal.measurement.zzbw.zzb(parcel);
                List<zzmh> zza8 = zza(zzoVar14, bundle2);
                parcel2.writeNoException();
                parcel2.writeTypedList(zza8);
                return true;
        }
    }
}
