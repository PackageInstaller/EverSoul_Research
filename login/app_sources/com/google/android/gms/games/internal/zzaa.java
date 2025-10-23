package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzaa extends zza {
    final /* synthetic */ zzak zza;
    private final TaskCompletionSource zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzaa(zzak zzakVar, TaskCompletionSource taskCompletionSource) {
        this.zza = zzakVar;
        this.zzb = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzf(DataHolder dataHolder, DataHolder dataHolder2) {
        int statusCode = dataHolder2.getStatusCode();
        boolean z = statusCode == 3;
        if (statusCode == 10003) {
            zzak.zzq(this.zza, this.zzb);
            dataHolder.close();
            dataHolder2.close();
            return;
        }
        if (statusCode != 0 && !z) {
            GamesStatusUtils.zza(this.zzb, statusCode);
            dataHolder.close();
            dataHolder2.close();
            return;
        }
        LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
        try {
            Leaderboard freeze = leaderboardBuffer.getCount() > 0 ? leaderboardBuffer.get(0).freeze() : null;
            leaderboardBuffer.close();
            this.zzb.setResult(new AnnotatedData(new LeaderboardsClient.LeaderboardScores(freeze, new LeaderboardScoreBuffer(dataHolder2)), z));
        } catch (Throwable th) {
            try {
                leaderboardBuffer.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }
}
