package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.LeaderboardsClient;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzdj implements LeaderboardsClient {
    private final zzar zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzdj(zzar zzarVar) {
        this.zza = zzarVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<Intent> getAllLeaderboardsIntent() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcz
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdi
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzh());
                    }
                }).setMethodKey(6700).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<Intent> getLeaderboardIntent(String str) {
        return getLeaderboardIntent(str, -1, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardScore>> loadCurrentPlayerLeaderboardScore(final String str, final int i, final int i2) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcs
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdb
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzz((TaskCompletionSource) obj2, str2, i3, i4);
                    }
                }).setMethodKey(6703).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<Leaderboard>> loadLeaderboardMetadata(final String str, final boolean z) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcx
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final boolean z2 = z;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdg
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzC((TaskCompletionSource) obj2, str2, z2);
                    }
                }).setMethodKey(6702).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadMoreScores(final LeaderboardScoreBuffer leaderboardScoreBuffer, final int i, final int i2) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcq
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final LeaderboardScoreBuffer leaderboardScoreBuffer2 = LeaderboardScoreBuffer.this;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcp
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzE((TaskCompletionSource) obj2, LeaderboardScoreBuffer.this, i3, i4);
                    }
                }).setMethodKey(6706).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3) {
        return this.zza.zzb(new zzct(str, i, i2, i3, false));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3) {
        return this.zza.zzb(new zzcu(str, i, i2, i3, false));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final void submitScore(String str, long j) {
        this.zza.zzb(new zzcv(str, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<ScoreSubmissionData> submitScoreImmediate(String str, long j) {
        return this.zza.zzb(new zzcv(str, j));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<Intent> getLeaderboardIntent(String str, int i) {
        return getLeaderboardIntent(str, i, -1);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardBuffer>> loadLeaderboardMetadata(final boolean z) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcy
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z2 = z;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzdh
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((com.google.android.gms.games.internal.zzak) obj).zzD((TaskCompletionSource) obj2, z2);
                    }
                }).setMethodKey(6702).build());
            }
        });
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadPlayerCenteredScores(String str, int i, int i2, int i3, boolean z) {
        return this.zza.zzb(new zzct(str, i, i2, i3, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<AnnotatedData<LeaderboardsClient.LeaderboardScores>> loadTopScores(String str, int i, int i2, int i3, boolean z) {
        return this.zza.zzb(new zzcu(str, i, i2, i3, z));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final void submitScore(String str, long j, String str2) {
        this.zza.zzb(new zzcw(str, j, str2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<ScoreSubmissionData> submitScoreImmediate(String str, long j, String str2) {
        return this.zza.zzb(new zzcw(str, j, str2));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.LeaderboardsClient
    public final Task<Intent> getLeaderboardIntent(final String str, final int i, final int i2) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzcr
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final String str2 = str;
                final int i3 = i;
                final int i4 = i2;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzda
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        ((TaskCompletionSource) obj2).setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzk(str2, i3, i4));
                    }
                }).setMethodKey(6701).build());
            }
        });
    }
}
