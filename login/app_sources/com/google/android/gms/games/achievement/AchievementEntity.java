package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.util.DataUtils;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.internal.zzh;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class AchievementEntity extends zzh implements Achievement {
    public static final Parcelable.Creator<AchievementEntity> CREATOR = new zza();
    private final String zza;
    private final int zzb;
    private final String zzc;
    private final String zzd;
    private final Uri zze;
    private final String zzf;
    private final Uri zzg;
    private final String zzh;
    private final int zzi;
    private final String zzj;
    private final PlayerEntity zzk;
    private final int zzl;
    private final int zzm;
    private final String zzn;
    private final long zzo;
    private final long zzp;
    private final float zzq;
    private final String zzr;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AchievementEntity(Achievement achievement) {
        String achievementId = achievement.getAchievementId();
        this.zza = achievementId;
        this.zzb = achievement.getType();
        this.zzc = achievement.getName();
        String description = achievement.getDescription();
        this.zzd = description;
        this.zze = achievement.getUnlockedImageUri();
        this.zzf = achievement.getUnlockedImageUrl();
        this.zzg = achievement.getRevealedImageUri();
        this.zzh = achievement.getRevealedImageUrl();
        Player zzb = achievement.zzb();
        if (zzb != null) {
            this.zzk = new PlayerEntity(zzb);
        } else {
            this.zzk = null;
        }
        this.zzl = achievement.getState();
        this.zzo = achievement.getLastUpdatedTimestamp();
        this.zzp = achievement.getXpValue();
        this.zzq = achievement.zza();
        this.zzr = achievement.zzc();
        if (achievement.getType() == 1) {
            this.zzi = achievement.getTotalSteps();
            this.zzj = achievement.getFormattedTotalSteps();
            this.zzm = achievement.getCurrentSteps();
            this.zzn = achievement.getFormattedCurrentSteps();
        } else {
            this.zzi = 0;
            this.zzj = null;
            this.zzm = 0;
            this.zzn = null;
        }
        Asserts.checkNotNull(achievementId);
        Asserts.checkNotNull(description);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzd(Achievement achievement) {
        int i;
        int i2;
        if (achievement.getType() == 1) {
            i = achievement.getCurrentSteps();
            i2 = achievement.getTotalSteps();
        } else {
            i = 0;
            i2 = 0;
        }
        return Objects.hashCode(achievement.getAchievementId(), achievement.zzc(), achievement.getName(), Integer.valueOf(achievement.getType()), achievement.getDescription(), Long.valueOf(achievement.getXpValue()), Integer.valueOf(achievement.getState()), Long.valueOf(achievement.getLastUpdatedTimestamp()), achievement.zzb(), Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zze(Achievement achievement) {
        Objects.ToStringHelper add = Objects.toStringHelper(achievement).add("Id", achievement.getAchievementId()).add("Game Id", achievement.zzc()).add("Type", Integer.valueOf(achievement.getType())).add("Name", achievement.getName()).add("Description", achievement.getDescription()).add("Player", achievement.zzb()).add("State", Integer.valueOf(achievement.getState())).add("Rarity Percent", Float.valueOf(achievement.zza()));
        if (achievement.getType() == 1) {
            add.add("CurrentSteps", Integer.valueOf(achievement.getCurrentSteps()));
            add.add("TotalSteps", Integer.valueOf(achievement.getTotalSteps()));
        }
        return add.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzf(Achievement achievement, Object obj) {
        if (!(obj instanceof Achievement)) {
            return false;
        }
        if (achievement == obj) {
            return true;
        }
        Achievement achievement2 = (Achievement) obj;
        if (achievement2.getType() != achievement.getType()) {
            return false;
        }
        return (achievement.getType() != 1 || (achievement2.getCurrentSteps() == achievement.getCurrentSteps() && achievement2.getTotalSteps() == achievement.getTotalSteps())) && achievement2.getXpValue() == achievement.getXpValue() && achievement2.getState() == achievement.getState() && achievement2.getLastUpdatedTimestamp() == achievement.getLastUpdatedTimestamp() && Objects.equal(achievement2.getAchievementId(), achievement.getAchievementId()) && Objects.equal(achievement2.zzc(), achievement.zzc()) && Objects.equal(achievement2.getName(), achievement.getName()) && Objects.equal(achievement2.getDescription(), achievement.getDescription()) && Objects.equal(achievement2.zzb(), achievement.zzb()) && achievement2.zza() == achievement.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        return zzf(this, obj);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public Achievement freeze() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Achievement freeze() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getAchievementId() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public int getCurrentSteps() {
        Asserts.checkState(getType() == 1);
        return this.zzm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getDescription() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public void getDescription(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzd, charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getFormattedCurrentSteps() {
        Asserts.checkState(getType() == 1);
        return this.zzn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getFormattedTotalSteps() {
        Asserts.checkState(getType() == 1);
        return this.zzj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public long getLastUpdatedTimestamp() {
        return this.zzo;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getName() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public void getName(CharArrayBuffer charArrayBuffer) {
        DataUtils.copyStringToBuffer(this.zzc, charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public Player getPlayer() {
        return (Player) Preconditions.checkNotNull(this.zzk);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri getRevealedImageUri() {
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getRevealedImageUrl() {
        return this.zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public int getState() {
        return this.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public int getTotalSteps() {
        Asserts.checkState(getType() == 1);
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public int getType() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public Uri getUnlockedImageUri() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getUnlockedImageUrl() {
        return this.zzf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public long getXpValue() {
        return this.zzp;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return zzd(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return zze(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 1, getAchievementId(), false);
        SafeParcelWriter.writeInt(parcel, 2, getType());
        SafeParcelWriter.writeString(parcel, 3, getName(), false);
        SafeParcelWriter.writeString(parcel, 4, getDescription(), false);
        SafeParcelWriter.writeParcelable(parcel, 5, getUnlockedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 6, getUnlockedImageUrl(), false);
        SafeParcelWriter.writeParcelable(parcel, 7, getRevealedImageUri(), i, false);
        SafeParcelWriter.writeString(parcel, 8, getRevealedImageUrl(), false);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeString(parcel, 10, this.zzj, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 12, getState());
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeString(parcel, 14, this.zzn, false);
        SafeParcelWriter.writeLong(parcel, 15, getLastUpdatedTimestamp());
        SafeParcelWriter.writeLong(parcel, 16, getXpValue());
        SafeParcelWriter.writeFloat(parcel, 17, this.zzq);
        SafeParcelWriter.writeString(parcel, 18, this.zzr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final float zza() {
        return this.zzq;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player zzb() {
        return this.zzk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final String zzc() {
        return this.zzr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getType() == 1);
        DataUtils.copyStringToBuffer(this.zzn, charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getType() == 1);
        DataUtils.copyStringToBuffer(this.zzj, charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AchievementEntity(String str, int i, String str2, String str3, Uri uri, String str4, Uri uri2, String str5, int i2, String str6, PlayerEntity playerEntity, int i3, int i4, String str7, long j, long j2, float f, String str8) {
        this.zza = str;
        this.zzb = i;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = uri;
        this.zzf = str4;
        this.zzg = uri2;
        this.zzh = str5;
        this.zzi = i2;
        this.zzj = str6;
        this.zzk = playerEntity;
        this.zzl = i3;
        this.zzm = i4;
        this.zzn = str7;
        this.zzo = j;
        this.zzp = j2;
        this.zzq = f;
        this.zzr = str8;
    }
}
