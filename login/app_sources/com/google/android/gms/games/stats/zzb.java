package com.google.android.gms.games.stats;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Asserts;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzb extends DataBufferRef implements PlayerStats {
    private Bundle zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzb(DataHolder dataHolder, int i) {
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
        return PlayerStatsEntity.zzd(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ PlayerStats freeze() {
        return new PlayerStatsEntity(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getAverageSessionLength() {
        return getFloat("ave_session_length_minutes");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getChurnProbability() {
        return getFloat("churn_probability");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getDaysSinceLastPlayed() {
        return getInteger("days_since_last_played");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getHighSpenderProbability() {
        if (hasColumn("high_spender_probability")) {
            return getFloat("high_spender_probability");
        }
        return -1.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfPurchases() {
        return getInteger("num_purchases");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final int getNumberOfSessions() {
        return getInteger("num_sessions");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSessionPercentile() {
        return getFloat("num_sessions_percentile");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendPercentile() {
        return getFloat("spend_percentile");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getSpendProbability() {
        if (hasColumn("spend_probability")) {
            return getFloat("spend_probability");
        }
        return -1.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final float getTotalSpendNext28Days() {
        if (hasColumn("total_spend_next_28_days")) {
            return getFloat("total_spend_next_28_days");
        }
        return -1.0f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return PlayerStatsEntity.zzb(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return PlayerStatsEntity.zzc(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zza.zza(new PlayerStatsEntity(this), parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.stats.PlayerStats
    public final Bundle zza() {
        Bundle bundle = this.zza;
        if (bundle != null) {
            return bundle;
        }
        this.zza = new Bundle();
        String string = getString("unknown_raw_keys");
        String string2 = getString("unknown_raw_values");
        if (string != null && string2 != null) {
            String[] split = string.split(",");
            String[] split2 = string2.split(",");
            Asserts.checkState(split.length <= split2.length, "Invalid raw arguments!");
            for (int i = 0; i < split.length; i++) {
                this.zza.putString(split[i], split2[i]);
            }
        }
        return this.zza;
    }
}
