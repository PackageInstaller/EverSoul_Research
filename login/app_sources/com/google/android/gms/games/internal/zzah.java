package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.ScoreSubmissionData;
import com.google.android.gms.tasks.TaskCompletionSource;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzah extends zza {
    private final TaskCompletionSource zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzah(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzk(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        if (statusCode != 0 && statusCode != 5) {
            GamesStatusUtils.zza(this.zza, statusCode);
            return;
        }
        try {
            this.zza.setResult(new ScoreSubmissionData(dataHolder));
        } finally {
            dataHolder.close();
        }
    }
}
