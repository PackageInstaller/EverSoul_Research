package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScoreEntity;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzz extends zza {
    final /* synthetic */ zzak zza;
    private final TaskCompletionSource zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzz(zzak zzakVar, TaskCompletionSource taskCompletionSource) {
        this.zza = zzakVar;
        this.zzb = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzh(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        boolean z = statusCode == 3;
        if (statusCode == 10003) {
            zzak.zzq(this.zza, this.zzb);
            dataHolder.close();
            return;
        }
        if (statusCode != 0 && !z) {
            GamesStatusUtils.zza(this.zzb, statusCode);
            dataHolder.close();
            return;
        }
        LeaderboardScoreBuffer leaderboardScoreBuffer = new LeaderboardScoreBuffer(dataHolder);
        try {
            LeaderboardScoreEntity leaderboardScoreEntity = leaderboardScoreBuffer.getCount() > 0 ? new LeaderboardScoreEntity(leaderboardScoreBuffer.get(0)) : null;
            leaderboardScoreBuffer.close();
            this.zzb.setResult(new AnnotatedData(leaderboardScoreEntity, z));
        } catch (Throwable th) {
            try {
                leaderboardScoreBuffer.close();
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
