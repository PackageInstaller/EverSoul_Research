package com.google.android.gms.games;

import android.database.CharArrayBuffer;
import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.kakao.sdk.user.Constants;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class GameRef extends DataBufferRef implements Game {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public GameRef(DataHolder dataHolder, int i) {
        super(dataHolder, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final boolean areSnapshotsEnabled() {
        return getInteger("snapshots_enabled") > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return GameEntity.zzm(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Game freeze() {
        return new GameEntity(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final int getAchievementTotalCount() {
        return getInteger("achievement_total_count");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final String getApplicationId() {
        return getString("external_game_id");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final String getDescription() {
        return getString("game_description");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final String getDeveloperName() {
        return getString("developer_name");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final String getDisplayName() {
        return getString(Constants.DISPLAY_NAME);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final Uri getFeaturedImageUri() {
        return parseUri("featured_image_uri");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public String getFeaturedImageUrl() {
        return getString("featured_image_url");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final Uri getHiResImageUri() {
        return parseUri("game_hi_res_image_uri");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public String getHiResImageUrl() {
        return getString("game_hi_res_image_url");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final Uri getIconImageUri() {
        return parseUri("game_icon_image_uri");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public String getIconImageUrl() {
        return getString("game_icon_image_url");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final int getLeaderboardCount() {
        return getInteger("leaderboard_count");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final String getPrimaryCategory() {
        return getString("primary_category");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final String getSecondaryCategory() {
        return getString("secondary_category");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final String getThemeColor() {
        return getString("theme_color");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final boolean hasGamepadSupport() {
        return getInteger("gamepad_support") > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return GameEntity.zzh(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return GameEntity.zzj(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        new GameEntity(this).writeToParcel(parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final String zza() {
        return getString("package_name");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final boolean zzb() {
        return getBoolean("identity_sharing_confirmed");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final boolean zzc() {
        return getInteger("installed") > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final boolean zzd() {
        return getBoolean("muted");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final boolean zze() {
        return getBoolean("play_enabled_game");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final boolean zzf() {
        return getInteger("real_time_support") > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final boolean zzg() {
        return getInteger("turn_based_support") > 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final void getDescription(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("game_description", charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final void getDeveloperName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer("developer_name", charArrayBuffer);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.Game
    public final void getDisplayName(CharArrayBuffer charArrayBuffer) {
        copyToBuffer(Constants.DISPLAY_NAME, charArrayBuffer);
    }
}
