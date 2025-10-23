package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public class LeaderboardScoreBuffer extends AbstractDataBuffer<LeaderboardScore> {
    private final zza zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LeaderboardScoreBuffer(DataHolder dataHolder) {
        super(dataHolder);
        this.zza = new zza(dataHolder.getMetadata());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public LeaderboardScore get(int i) {
        return new LeaderboardScoreRef(this.mDataHolder, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zza zza() {
        return this.zza;
    }
}
