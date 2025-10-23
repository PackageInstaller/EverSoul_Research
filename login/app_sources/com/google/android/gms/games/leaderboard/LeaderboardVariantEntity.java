package com.google.android.gms.games.leaderboard;

import com.facebook.appevents.integrity.IntegrityManager;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.internal.games_v2.zzah;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class LeaderboardVariantEntity implements LeaderboardVariant {
    private final int zza;
    private final int zzb;
    private final boolean zzc;
    private final long zzd;
    private final String zze;
    private final long zzf;
    private final String zzg;
    private final String zzh;
    private final long zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LeaderboardVariantEntity(LeaderboardVariant leaderboardVariant) {
        this.zza = leaderboardVariant.getTimeSpan();
        this.zzb = leaderboardVariant.getCollection();
        this.zzc = leaderboardVariant.hasPlayerInfo();
        this.zzd = leaderboardVariant.getRawPlayerScore();
        this.zze = leaderboardVariant.getDisplayPlayerScore();
        this.zzf = leaderboardVariant.getPlayerRank();
        this.zzg = leaderboardVariant.getDisplayPlayerRank();
        this.zzh = leaderboardVariant.getPlayerScoreTag();
        this.zzi = leaderboardVariant.getNumScores();
        this.zzj = leaderboardVariant.zza();
        this.zzk = leaderboardVariant.zzc();
        this.zzl = leaderboardVariant.zzb();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zzd(LeaderboardVariant leaderboardVariant) {
        return Objects.hashCode(Integer.valueOf(leaderboardVariant.getTimeSpan()), Integer.valueOf(leaderboardVariant.getCollection()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo()), Long.valueOf(leaderboardVariant.getRawPlayerScore()), leaderboardVariant.getDisplayPlayerScore(), Long.valueOf(leaderboardVariant.getPlayerRank()), leaderboardVariant.getDisplayPlayerRank(), Long.valueOf(leaderboardVariant.getNumScores()), leaderboardVariant.zza(), leaderboardVariant.zzb(), leaderboardVariant.zzc());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zze(LeaderboardVariant leaderboardVariant) {
        String str;
        Objects.ToStringHelper add = Objects.toStringHelper(leaderboardVariant).add("TimeSpan", zzah.zza(leaderboardVariant.getTimeSpan()));
        int collection = leaderboardVariant.getCollection();
        if (collection == -1) {
            str = "UNKNOWN";
        } else if (collection == 0) {
            str = "PUBLIC";
        } else if (collection != 1) {
            str = "SOCIAL_1P";
            if (collection != 2) {
                if (collection == 3) {
                    str = ShareConstants.PEOPLE_IDS;
                } else if (collection != 4) {
                    StringBuilder sb = new StringBuilder(43);
                    sb.append("Unknown leaderboard collection: ");
                    sb.append(collection);
                    throw new IllegalArgumentException(sb.toString());
                }
            }
        } else {
            str = "SOCIAL";
        }
        Objects.ToStringHelper add2 = add.add("Collection", str);
        boolean hasPlayerInfo = leaderboardVariant.hasPlayerInfo();
        String str2 = IntegrityManager.INTEGRITY_TYPE_NONE;
        Objects.ToStringHelper add3 = add2.add("RawPlayerScore", hasPlayerInfo ? Long.valueOf(leaderboardVariant.getRawPlayerScore()) : IntegrityManager.INTEGRITY_TYPE_NONE).add("DisplayPlayerScore", leaderboardVariant.hasPlayerInfo() ? leaderboardVariant.getDisplayPlayerScore() : IntegrityManager.INTEGRITY_TYPE_NONE).add("PlayerRank", leaderboardVariant.hasPlayerInfo() ? Long.valueOf(leaderboardVariant.getPlayerRank()) : IntegrityManager.INTEGRITY_TYPE_NONE);
        if (leaderboardVariant.hasPlayerInfo()) {
            str2 = leaderboardVariant.getDisplayPlayerRank();
        }
        return add3.add("DisplayPlayerRank", str2).add("NumScores", Long.valueOf(leaderboardVariant.getNumScores())).add("TopPageNextToken", leaderboardVariant.zza()).add("WindowPageNextToken", leaderboardVariant.zzb()).add("WindowPagePrevToken", leaderboardVariant.zzc()).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzf(LeaderboardVariant leaderboardVariant, Object obj) {
        if (!(obj instanceof LeaderboardVariant)) {
            return false;
        }
        if (leaderboardVariant == obj) {
            return true;
        }
        LeaderboardVariant leaderboardVariant2 = (LeaderboardVariant) obj;
        return Objects.equal(Integer.valueOf(leaderboardVariant2.getTimeSpan()), Integer.valueOf(leaderboardVariant.getTimeSpan())) && Objects.equal(Integer.valueOf(leaderboardVariant2.getCollection()), Integer.valueOf(leaderboardVariant.getCollection())) && Objects.equal(Boolean.valueOf(leaderboardVariant2.hasPlayerInfo()), Boolean.valueOf(leaderboardVariant.hasPlayerInfo())) && Objects.equal(Long.valueOf(leaderboardVariant2.getRawPlayerScore()), Long.valueOf(leaderboardVariant.getRawPlayerScore())) && Objects.equal(leaderboardVariant2.getDisplayPlayerScore(), leaderboardVariant.getDisplayPlayerScore()) && Objects.equal(Long.valueOf(leaderboardVariant2.getPlayerRank()), Long.valueOf(leaderboardVariant.getPlayerRank())) && Objects.equal(leaderboardVariant2.getDisplayPlayerRank(), leaderboardVariant.getDisplayPlayerRank()) && Objects.equal(Long.valueOf(leaderboardVariant2.getNumScores()), Long.valueOf(leaderboardVariant.getNumScores())) && Objects.equal(leaderboardVariant2.zza(), leaderboardVariant.zza()) && Objects.equal(leaderboardVariant2.zzb(), leaderboardVariant.zzb()) && Objects.equal(leaderboardVariant2.zzc(), leaderboardVariant.zzc());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        return zzf(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ LeaderboardVariant freeze() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getCollection() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerRank() {
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getDisplayPlayerScore() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getNumScores() {
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getPlayerRank() {
        return this.zzf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String getPlayerScoreTag() {
        return this.zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final long getRawPlayerScore() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final int getTimeSpan() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final boolean hasPlayerInfo() {
        return this.zzc;
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
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zza() {
        return this.zzj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzb() {
        return this.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.leaderboard.LeaderboardVariant
    public final String zzc() {
        return this.zzk;
    }
}
