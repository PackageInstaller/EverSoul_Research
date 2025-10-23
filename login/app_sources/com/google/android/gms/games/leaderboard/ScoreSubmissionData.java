package com.google.android.gms.games.leaderboard;

import android.util.SparseArray;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.games_v2.zzah;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class ScoreSubmissionData {
    private static final String[] zza = {"leaderboardId", "playerId", "timeSpan", "hasResult", "rawScore", "formattedScore", "newBest", "scoreTag"};
    private String zzb;
    private String zzc;
    private int zzd;
    private SparseArray zze = new SparseArray();

    /* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    public static final class Result {
        public final String formattedScore;
        public final boolean newBest;
        public final long rawScore;
        public final String scoreTag;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Result(long j, String str, String str2, boolean z) {
            this.rawScore = j;
            this.formattedScore = str;
            this.scoreTag = str2;
            this.newBest = z;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return Objects.toStringHelper(this).add("RawScore", Long.valueOf(this.rawScore)).add("FormattedScore", this.formattedScore).add("ScoreTag", this.scoreTag).add("NewBest", Boolean.valueOf(this.newBest)).toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ScoreSubmissionData(DataHolder dataHolder) {
        this.zzd = dataHolder.getStatusCode();
        int count = dataHolder.getCount();
        Preconditions.checkArgument(count == 3);
        int i = 0;
        while (i < count) {
            int windowIndex = dataHolder.getWindowIndex(i);
            if (i == 0) {
                this.zzb = dataHolder.getString("leaderboardId", 0, windowIndex);
                this.zzc = dataHolder.getString("playerId", 0, windowIndex);
                i = 0;
            }
            if (dataHolder.getBoolean("hasResult", i, windowIndex)) {
                this.zze.put(dataHolder.getInteger("timeSpan", i, windowIndex), new Result(dataHolder.getLong("rawScore", i, windowIndex), dataHolder.getString("formattedScore", i, windowIndex), dataHolder.getString("scoreTag", i, windowIndex), dataHolder.getBoolean("newBest", i, windowIndex)));
            }
            i++;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getLeaderboardId() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getPlayerId() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Result getScoreResult(int i) {
        return (Result) this.zze.get(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        Objects.ToStringHelper add = Objects.toStringHelper(this).add("PlayerId", this.zzc).add("StatusCode", Integer.valueOf(this.zzd));
        for (int i = 0; i < 3; i++) {
            Result result = (Result) this.zze.get(i);
            add.add("TimesSpan", zzah.zza(i));
            add.add("Result", result == null ? "null" : result.toString());
        }
        return add.toString();
    }
}
