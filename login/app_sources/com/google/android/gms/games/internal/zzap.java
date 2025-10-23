package com.google.android.gms.games.internal;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.Contents;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.snapshot.SnapshotMetadataChangeEntity;
import com.kakaogame.KGResult;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzap extends com.google.android.gms.internal.games_v2.zza implements IInterface {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzap(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.games.internal.IGamesService");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzA(zzam zzamVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(6504, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzB(zzam zzamVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(6503, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzC(zzam zzamVar, Bundle bundle, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, bundle);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc(5021, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzD(zzam zzamVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(5020, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzE(zzam zzamVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(17001, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzF(zzam zzamVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(13006, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzG(zzam zzamVar, String str, int i, boolean z, boolean z2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeInt(i);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z2);
        zzc(9020, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzH(zzam zzamVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(12002, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzI(zzam zzamVar, String str, int i, int i2, int i3, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(i3);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(5019, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzJ(zzam zzamVar, String str, boolean z, int i) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zza.writeInt(i);
        zzc(15001, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzK(zzao zzaoVar, long j) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzaoVar);
        zza.writeLong(j);
        zzc(15501, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzL(zzam zzamVar, String str, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(27003, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzM(zzam zzamVar, String str, String str2, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeString(str2);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, contents);
        zzc(12033, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzN(zzam zzamVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, bundle);
        zzc(5023, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzO(zzam zzamVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, bundle);
        zzc(KGResult.KGResultCode.EXCEED_MAX_UPLOAD_SIZE, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzP(IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, bundle);
        zzc(5005, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzQ(zzam zzamVar) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zzc(KGResult.KGResultCode.DEVICE_NOTIFICATION_SETTING_OFF, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzR(zzam zzamVar, String str, long j, String str2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeLong(j);
        zza.writeString(str2);
        zzc(KGResult.KGResultCode.EXCEED_DAILY_USAGE, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzS(zzam zzamVar, String str, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, bundle);
        zzc(5024, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzd() throws RemoteException {
        Parcel zzb = zzb(12036, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zze() throws RemoteException {
        Parcel zzb = zzb(12035, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PendingIntent zzf() throws RemoteException {
        Parcel zzb = zzb(25015, zza());
        PendingIntent pendingIntent = (PendingIntent) com.google.android.gms.internal.games_v2.zzc.zza(zzb, PendingIntent.CREATOR);
        zzb.recycle();
        return pendingIntent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent zzg() throws RemoteException {
        Parcel zzb = zzb(9005, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent zzh() throws RemoteException {
        Parcel zzb = zzb(9003, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent zzi(PlayerEntity playerEntity) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, playerEntity);
        Parcel zzb = zzb(15503, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent zzj(String str, String str2, String str3) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(25016, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent zzk(String str, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeInt(i2);
        Parcel zzb = zzb(18001, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent zzl() throws RemoteException {
        Parcel zzb = zzb(9010, zza());
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Intent zzm(String str, boolean z, boolean z2, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z2);
        zza.writeInt(i);
        Parcel zzb = zzb(12001, zza);
        Intent intent = (Intent) com.google.android.gms.internal.games_v2.zzc.zza(zzb, Intent.CREATOR);
        zzb.recycle();
        return intent;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DataHolder zzn() throws RemoteException {
        Parcel zzb = zzb(5013, zza());
        DataHolder dataHolder = (DataHolder) com.google.android.gms.internal.games_v2.zzc.zza(zzb, DataHolder.CREATOR);
        zzb.recycle();
        return dataHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzo() throws RemoteException {
        Parcel zzb = zzb(5012, zza());
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzp() throws RemoteException {
        zzc(5006, zza());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzq(long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc(5001, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzr(zzam zzamVar, String str, SnapshotMetadataChangeEntity snapshotMetadataChangeEntity, Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, snapshotMetadataChangeEntity);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, contents);
        zzc(12007, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzs(zzam zzamVar, String str) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zzc(12020, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzt(Contents contents) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, contents);
        zzc(12019, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzu(zzam zzamVar, String str, String str2, int i, int i2) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(null);
        zza.writeString(str2);
        zza.writeInt(i);
        zza.writeInt(i2);
        zzc(KGResult.KGResultCode.FACEBOOK_NOT_INSTALLED, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzv(zzam zzamVar, String str, int i, IBinder iBinder, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        zza.writeString(str);
        zza.writeInt(i);
        zza.writeStrongBinder(iBinder);
        com.google.android.gms.internal.games_v2.zzc.zzd(zza, bundle);
        zzc(5025, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzw(String str, int i) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeInt(i);
        zzc(12017, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzx(zzam zzamVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(KGResult.KGResultCode.API_NOT_EXISTS, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzy(zzam zzamVar, boolean z) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zzc(12016, zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zzz(zzam zzamVar, boolean z, String[] strArr) throws RemoteException {
        Parcel zza = zza();
        com.google.android.gms.internal.games_v2.zzc.zzf(zza, zzamVar);
        com.google.android.gms.internal.games_v2.zzc.zzc(zza, z);
        zza.writeStringArray(strArr);
        zzc(12031, zza);
    }
}
