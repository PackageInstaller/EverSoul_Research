package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class PlayerLevelInfo extends com.google.android.gms.games.internal.zzh {
    public static final Parcelable.Creator<PlayerLevelInfo> CREATOR = new zzs();
    private final long zza;
    private final long zzb;
    private final PlayerLevel zzc;
    private final PlayerLevel zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PlayerLevelInfo(long j, long j2, PlayerLevel playerLevel, PlayerLevel playerLevel2) {
        Preconditions.checkState(j != -1);
        Preconditions.checkNotNull(playerLevel);
        Preconditions.checkNotNull(playerLevel2);
        this.zza = j;
        this.zzb = j2;
        this.zzc = playerLevel;
        this.zzd = playerLevel2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (!(obj instanceof PlayerLevelInfo)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        PlayerLevelInfo playerLevelInfo = (PlayerLevelInfo) obj;
        return Objects.equal(Long.valueOf(this.zza), Long.valueOf(playerLevelInfo.zza)) && Objects.equal(Long.valueOf(this.zzb), Long.valueOf(playerLevelInfo.zzb)) && Objects.equal(this.zzc, playerLevelInfo.zzc) && Objects.equal(this.zzd, playerLevelInfo.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PlayerLevel getCurrentLevel() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getCurrentXpTotal() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getLastLevelUpTimestamp() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PlayerLevel getNextLevel() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.zza), Long.valueOf(this.zzb), this.zzc, this.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isMaxLevel() {
        return this.zzc.equals(this.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeLong(parcel, 1, getCurrentXpTotal());
        SafeParcelWriter.writeLong(parcel, 2, getLastLevelUpTimestamp());
        SafeParcelWriter.writeParcelable(parcel, 3, getCurrentLevel(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getNextLevel(), i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
