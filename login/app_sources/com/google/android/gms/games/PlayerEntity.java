package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;
import com.google.android.gms.games.internal.player.MostRecentGameInfoEntity;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class PlayerEntity extends GamesDowngradeableSafeParcel implements Player {
    public static final Parcelable.Creator<PlayerEntity> CREATOR = new zzp();
    private String zza;
    private String zzb;
    private final Uri zzc;
    private final Uri zzd;
    private final long zze;
    private final int zzf;
    private final long zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final MostRecentGameInfoEntity zzk;
    private final PlayerLevelInfo zzl;
    private final boolean zzm;
    private final boolean zzn;
    private final String zzo;
    private final String zzp;
    private final Uri zzq;
    private final String zzr;
    private final Uri zzs;
    private final String zzt;
    private long zzu;
    private final zzt zzv;
    private final zza zzw;
    private boolean zzx;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PlayerEntity(Player player) {
        this.zza = player.getPlayerId();
        this.zzb = player.getDisplayName();
        this.zzc = player.getIconImageUri();
        this.zzh = player.getIconImageUrl();
        this.zzd = player.getHiResImageUri();
        this.zzi = player.getHiResImageUrl();
        long retrievedTimestamp = player.getRetrievedTimestamp();
        this.zze = retrievedTimestamp;
        this.zzf = player.zza();
        this.zzg = player.getLastPlayedWithTimestamp();
        this.zzj = player.getTitle();
        this.zzm = player.zzh();
        com.google.android.gms.games.internal.player.zza zzc = player.zzc();
        this.zzk = zzc == null ? null : new MostRecentGameInfoEntity(zzc);
        this.zzl = player.getLevelInfo();
        this.zzn = player.zzf();
        this.zzo = player.zzd();
        this.zzp = player.zze();
        this.zzq = player.getBannerImageLandscapeUri();
        this.zzr = player.getBannerImageLandscapeUrl();
        this.zzs = player.getBannerImagePortraitUri();
        this.zzt = player.getBannerImagePortraitUrl();
        this.zzu = player.zzb();
        PlayerRelationshipInfo relationshipInfo = player.getRelationshipInfo();
        this.zzv = relationshipInfo == null ? null : new zzt(relationshipInfo.freeze());
        CurrentPlayerInfo currentPlayerInfo = player.getCurrentPlayerInfo();
        this.zzw = (zza) (currentPlayerInfo != null ? currentPlayerInfo.freeze() : null);
        this.zzx = player.zzg();
        Asserts.checkNotNull(this.zza);
        Asserts.checkNotNull(this.zzb);
        Asserts.checkState(retrievedTimestamp > 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzi(Player player) {
        return Objects.hashCode(player.getPlayerId(), player.getDisplayName(), Boolean.valueOf(player.zzf()), player.getIconImageUri(), player.getHiResImageUri(), Long.valueOf(player.getRetrievedTimestamp()), player.getTitle(), player.getLevelInfo(), player.zzd(), player.zze(), player.getBannerImageLandscapeUri(), player.getBannerImagePortraitUri(), Long.valueOf(player.zzb()), player.getRelationshipInfo(), player.getCurrentPlayerInfo(), Boolean.valueOf(player.zzg()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zzk(Player player) {
        Objects.ToStringHelper add = Objects.toStringHelper(player).add("PlayerId", player.getPlayerId()).add("DisplayName", player.getDisplayName()).add("HasDebugAccess", Boolean.valueOf(player.zzf())).add("IconImageUri", player.getIconImageUri()).add("IconImageUrl", player.getIconImageUrl()).add("HiResImageUri", player.getHiResImageUri()).add("HiResImageUrl", player.getHiResImageUrl()).add("RetrievedTimestamp", Long.valueOf(player.getRetrievedTimestamp())).add("Title", player.getTitle()).add("LevelInfo", player.getLevelInfo()).add("GamerTag", player.zzd()).add("Name", player.zze()).add("BannerImageLandscapeUri", player.getBannerImageLandscapeUri()).add("BannerImageLandscapeUrl", player.getBannerImageLandscapeUrl()).add("BannerImagePortraitUri", player.getBannerImagePortraitUri()).add("BannerImagePortraitUrl", player.getBannerImagePortraitUrl()).add("CurrentPlayerInfo", player.getCurrentPlayerInfo()).add("TotalUnlockedAchievement", Long.valueOf(player.zzb()));
        if (player.zzg()) {
            add.add("AlwaysAutoSignIn", Boolean.valueOf(player.zzg()));
        }
        if (player.getRelationshipInfo() != null) {
            add.add("RelationshipInfo", player.getRelationshipInfo());
        }
        return add.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzn(Player player, Object obj) {
        if (!(obj instanceof Player)) {
            return false;
        }
        if (player == obj) {
            return true;
        }
        Player player2 = (Player) obj;
        return Objects.equal(player2.getPlayerId(), player.getPlayerId()) && Objects.equal(player2.getDisplayName(), player.getDisplayName()) && Objects.equal(Boolean.valueOf(player2.zzf()), Boolean.valueOf(player.zzf())) && Objects.equal(player2.getIconImageUri(), player.getIconImageUri()) && Objects.equal(player2.getHiResImageUri(), player.getHiResImageUri()) && Objects.equal(Long.valueOf(player2.getRetrievedTimestamp()), Long.valueOf(player.getRetrievedTimestamp())) && Objects.equal(player2.getTitle(), player.getTitle()) && Objects.equal(player2.getLevelInfo(), player.getLevelInfo()) && Objects.equal(player2.zzd(), player.zzd()) && Objects.equal(player2.zze(), player.zze()) && Objects.equal(player2.getBannerImageLandscapeUri(), player.getBannerImageLandscapeUri()) && Objects.equal(player2.getBannerImagePortraitUri(), player.getBannerImagePortraitUri()) && Objects.equal(Long.valueOf(player2.zzb()), Long.valueOf(player.zzb())) && Objects.equal(player2.getCurrentPlayerInfo(), player.getCurrentPlayerInfo()) && Objects.equal(player2.getRelationshipInfo(), player.getRelationshipInfo()) && Objects.equal(Boolean.valueOf(player2.zzg()), Boolean.valueOf(player.zzg()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return zzn(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public Player freeze() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Player freeze() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public Uri getBannerImageLandscapeUri() {
        return this.zzq;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getBannerImageLandscapeUrl() {
        return this.zzr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public Uri getBannerImagePortraitUri() {
        return this.zzs;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getBannerImagePortraitUrl() {
        return this.zzt;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public CurrentPlayerInfo getCurrentPlayerInfo() {
        return this.zzw;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getDisplayName() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public void getDisplayName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzb, charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public Uri getHiResImageUri() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getHiResImageUrl() {
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public Uri getIconImageUri() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getIconImageUrl() {
        return this.zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public long getLastPlayedWithTimestamp() {
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public PlayerLevelInfo getLevelInfo() {
        return this.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getPlayerId() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public PlayerRelationshipInfo getRelationshipInfo() {
        return this.zzv;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public long getRetrievedTimestamp() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public String getTitle() {
        return this.zzj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public void getTitle(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public boolean hasHiResImage() {
        return getHiResImageUri() != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public boolean hasIconImage() {
        return getIconImageUri() != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return zzi(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return zzk(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        if (shouldDowngrade()) {
            parcel.writeString(this.zza);
            parcel.writeString(this.zzb);
            Uri uri = this.zzc;
            parcel.writeString(uri == null ? null : uri.toString());
            Uri uri2 = this.zzd;
            parcel.writeString(uri2 != null ? uri2.toString() : null);
            parcel.writeLong(this.zze);
            return;
        }
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getPlayerId(), false);
        SafeParcelWriter.writeString(parcel, 2, getDisplayName(), false);
        SafeParcelWriter.writeParcelable(parcel, 3, getIconImageUri(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 4, getHiResImageUri(), i, false);
        SafeParcelWriter.writeLong(parcel, 5, getRetrievedTimestamp());
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeLong(parcel, 7, getLastPlayedWithTimestamp());
        SafeParcelWriter.writeString(parcel, 8, getIconImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 9, getHiResImageUrl(), false);
        SafeParcelWriter.writeString(parcel, 14, getTitle(), false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.zzk, i, false);
        SafeParcelWriter.writeParcelable(parcel, 16, getLevelInfo(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 18, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 19, this.zzn);
        SafeParcelWriter.writeString(parcel, 20, this.zzo, false);
        SafeParcelWriter.writeString(parcel, 21, this.zzp, false);
        SafeParcelWriter.writeParcelable(parcel, 22, getBannerImageLandscapeUri(), i, false);
        SafeParcelWriter.writeString(parcel, 23, getBannerImageLandscapeUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 24, getBannerImagePortraitUri(), i, false);
        SafeParcelWriter.writeString(parcel, 25, getBannerImagePortraitUrl(), false);
        SafeParcelWriter.writeLong(parcel, 29, this.zzu);
        SafeParcelWriter.writeParcelable(parcel, 33, getRelationshipInfo(), i, false);
        SafeParcelWriter.writeParcelable(parcel, 35, getCurrentPlayerInfo(), i, false);
        SafeParcelWriter.writeBoolean(parcel, 36, this.zzx);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final int zza() {
        return this.zzf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final long zzb() {
        return this.zzu;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final com.google.android.gms.games.internal.player.zza zzc() {
        return this.zzk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final String zzd() {
        return this.zzo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final String zze() {
        return this.zzp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final boolean zzf() {
        return this.zzn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final boolean zzg() {
        return this.zzx;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Player
    public final boolean zzh() {
        return this.zzm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    PlayerEntity(String str, String str2, Uri uri, Uri uri2, long j, int i, long j2, String str3, String str4, String str5, MostRecentGameInfoEntity mostRecentGameInfoEntity, PlayerLevelInfo playerLevelInfo, boolean z, boolean z2, String str6, String str7, Uri uri3, String str8, Uri uri4, String str9, long j3, zzt zztVar, zza zzaVar, boolean z3) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = uri;
        this.zzh = str3;
        this.zzd = uri2;
        this.zzi = str4;
        this.zze = j;
        this.zzf = i;
        this.zzg = j2;
        this.zzj = str5;
        this.zzm = z;
        this.zzk = mostRecentGameInfoEntity;
        this.zzl = playerLevelInfo;
        this.zzn = z2;
        this.zzo = str6;
        this.zzp = str7;
        this.zzq = uri3;
        this.zzr = str8;
        this.zzs = uri4;
        this.zzt = str9;
        this.zzu = j3;
        this.zzv = zztVar;
        this.zzw = zzaVar;
        this.zzx = z3;
    }
}
