package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzt extends com.google.android.gms.games.internal.zzh implements PlayerRelationshipInfo {
    public static final Parcelable.Creator<zzt> CREATOR = new zzu();
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzt(int i, String str, String str2, String str3) {
        this.zza = i;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzd(PlayerRelationshipInfo playerRelationshipInfo) {
        return Objects.hashCode(Integer.valueOf(playerRelationshipInfo.getFriendStatus()), playerRelationshipInfo.zzb(), playerRelationshipInfo.zza(), playerRelationshipInfo.zzc());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zze(PlayerRelationshipInfo playerRelationshipInfo) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(playerRelationshipInfo);
        stringHelper.add("FriendStatus", Integer.valueOf(playerRelationshipInfo.getFriendStatus()));
        if (playerRelationshipInfo.zzb() != null) {
            stringHelper.add("Nickname", playerRelationshipInfo.zzb());
        }
        if (playerRelationshipInfo.zza() != null) {
            stringHelper.add("InvitationNickname", playerRelationshipInfo.zza());
        }
        if (playerRelationshipInfo.zzc() != null) {
            stringHelper.add("NicknameAbuseReportToken", playerRelationshipInfo.zza());
        }
        return stringHelper.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzf(PlayerRelationshipInfo playerRelationshipInfo, Object obj) {
        if (!(obj instanceof PlayerRelationshipInfo)) {
            return false;
        }
        if (obj == playerRelationshipInfo) {
            return true;
        }
        PlayerRelationshipInfo playerRelationshipInfo2 = (PlayerRelationshipInfo) obj;
        return playerRelationshipInfo2.getFriendStatus() == playerRelationshipInfo.getFriendStatus() && Objects.equal(playerRelationshipInfo2.zzb(), playerRelationshipInfo.zzb()) && Objects.equal(playerRelationshipInfo2.zza(), playerRelationshipInfo.zza()) && Objects.equal(playerRelationshipInfo2.zzc(), playerRelationshipInfo.zzc());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        return zzf(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ PlayerRelationshipInfo freeze() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final int getFriendStatus() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return zzd(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return zze(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzu.zza(this, parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zza() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzb() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.PlayerRelationshipInfo
    public final String zzc() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzt(PlayerRelationshipInfo playerRelationshipInfo) {
        this.zza = playerRelationshipInfo.getFriendStatus();
        this.zzb = playerRelationshipInfo.zzb();
        this.zzc = playerRelationshipInfo.zza();
        this.zzd = playerRelationshipInfo.zzc();
    }
}
