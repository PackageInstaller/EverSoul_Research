package com.google.android.gms.games.achievement;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerRef;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class AchievementRef extends DataBufferRef implements Achievement {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    AchievementRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return AchievementEntity.zzf(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Achievement freeze() {
        return new AchievementEntity(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getAchievementId() {
        return getString("external_achievement_id");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getCurrentSteps() {
        Asserts.checkState(getInteger("type") == 1);
        return getInteger("current_steps");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getDescription() {
        return getString("description");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedCurrentSteps() {
        Asserts.checkState(getInteger("type") == 1);
        return getString("formatted_current_steps");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getFormattedTotalSteps() {
        Asserts.checkState(getInteger("type") == 1);
        return getString("formatted_total_steps");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getLastUpdatedTimestamp() {
        return getLong("last_updated_timestamp");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final String getName() {
        return getString("name");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player getPlayer() {
        return (Player) Preconditions.checkNotNull(zzb());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getRevealedImageUri() {
        return parseUri("revealed_icon_image_uri");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getRevealedImageUrl() {
        return getString("revealed_icon_image_url");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getState() {
        return getInteger("state");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getTotalSteps() {
        Asserts.checkState(getInteger("type") == 1);
        return getInteger("total_steps");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final int getType() {
        return getInteger("type");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final Uri getUnlockedImageUri() {
        return parseUri("unlocked_icon_image_uri");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public String getUnlockedImageUrl() {
        return getString("unlocked_icon_image_url");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final long getXpValue() {
        return (!hasColumn("instance_xp_value") || hasNull("instance_xp_value")) ? getLong("definition_xp_value") : getLong("instance_xp_value");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return AchievementEntity.zzd(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return AchievementEntity.zze(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new AchievementEntity(this).writeToParcel(parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final float zza() {
        if (!hasColumn("rarity_percent") || hasNull("rarity_percent")) {
            return -1.0f;
        }
        return getFloat("rarity_percent");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final Player zzb() {
        if (hasNull("external_player_id")) {
            return null;
        }
        return new PlayerRef(this.mDataHolder, this.mDataRow, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final String zzc() {
        return getString("external_game_id");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("description", charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("name", charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedCurrentSteps(CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getInteger("type") == 1);
        copyToBuffer("formatted_current_steps", charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.achievement.Achievement
    public final void getFormattedTotalSteps(CharArrayBuffer charArrayBuffer) {
        Asserts.checkState(getInteger("type") == 1);
        copyToBuffer("formatted_total_steps", charArrayBuffer);
    }
}
