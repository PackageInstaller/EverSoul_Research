package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class PlayerRef extends zzo implements Player {
    private final com.google.android.gms.games.internal.player.zzd zza;
    private final PlayerLevelInfo zzb;
    private final com.google.android.gms.games.internal.player.zzc zzc;
    private final zzv zzd;
    private final zzc zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PlayerRef(DataHolder dataHolder, int i, String str) {
        super(dataHolder, i);
        com.google.android.gms.games.internal.player.zzd zzdVar = new com.google.android.gms.games.internal.player.zzd(null);
        this.zza = zzdVar;
        this.zzc = new com.google.android.gms.games.internal.player.zzc(dataHolder, i, zzdVar);
        this.zzd = new zzv(dataHolder, i, zzdVar);
        this.zze = new zzc(dataHolder, i, zzdVar);
        if (hasNull(zzdVar.zzj) || getLong(zzdVar.zzj) == -1) {
            this.zzb = null;
            return;
        }
        int integer = getInteger(zzdVar.zzk);
        int integer2 = getInteger(zzdVar.zzn);
        PlayerLevel playerLevel = new PlayerLevel(integer, getLong(zzdVar.zzl), getLong(zzdVar.zzm));
        this.zzb = new PlayerLevelInfo(getLong(zzdVar.zzj), getLong(zzdVar.zzp), playerLevel, integer != integer2 ? new PlayerLevel(integer2, getLong(zzdVar.zzm), getLong(zzdVar.zzo)) : playerLevel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return PlayerEntity.zzn(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Player freeze() {
        return new PlayerEntity(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImageLandscapeUri() {
        return parseUri(this.zza.zzB);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getBannerImageLandscapeUrl() {
        return getString(this.zza.zzC);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final Uri getBannerImagePortraitUri() {
        return parseUri(this.zza.zzD);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getBannerImagePortraitUrl() {
        return getString(this.zza.zzE);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final CurrentPlayerInfo getCurrentPlayerInfo() {
        if (this.zze.zza()) {
            return this.zze;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final String getDisplayName() {
        return getString(this.zza.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final Uri getHiResImageUri() {
        return parseUri(this.zza.zze);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getHiResImageUrl() {
        return getString(this.zza.zzf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final Uri getIconImageUri() {
        return parseUri(this.zza.zzc);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getIconImageUrl() {
        return getString(this.zza.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final long getLastPlayedWithTimestamp() {
        if (!hasColumn(this.zza.zzi) || hasNull(this.zza.zzi)) {
            return -1L;
        }
        return getLong(this.zza.zzi);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final PlayerLevelInfo getLevelInfo() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final String getPlayerId() {
        return getString(this.zza.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final PlayerRelationshipInfo getRelationshipInfo() {
        zzv zzvVar = this.zzd;
        if (zzvVar.getFriendStatus() == -1 && zzvVar.zzb() == null && zzvVar.zza() == null) {
            return null;
        }
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final long getRetrievedTimestamp() {
        return getLong(this.zza.zzg);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final String getTitle() {
        return getString(this.zza.zzq);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerEntity.zzi(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return PlayerEntity.zzk(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new PlayerEntity(this).writeToParcel(parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final int zza() {
        return getInteger(this.zza.zzh);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final long zzb() {
        String str = this.zza.zzF;
        if (!hasColumn(str) || hasNull(str)) {
            return -1L;
        }
        return getLong(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final com.google.android.gms.games.internal.player.zza zzc() {
        if (hasNull(this.zza.zzs)) {
            return null;
        }
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final String zzd() {
        return getString(this.zza.zzz);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final String zze() {
        return getString(this.zza.zzA);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final boolean zzf() {
        return getBoolean(this.zza.zzy);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final boolean zzg() {
        return hasColumn(this.zza.zzL) && getBoolean(this.zza.zzL);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final boolean zzh() {
        return getBoolean(this.zza.zzr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzb, charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final void getTitle(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(this.zza.zzq, charArrayBuffer);
    }
}
