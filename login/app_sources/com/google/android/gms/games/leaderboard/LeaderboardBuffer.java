package com.google.android.gms.games.leaderboard;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.data.EntityBuffer;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public class LeaderboardBuffer extends EntityBuffer<Leaderboard> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LeaderboardBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final /* bridge */ /* synthetic */ Leaderboard getEntry(int i, int i2) {
        return new LeaderboardRef(this.mDataHolder, i, i2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.EntityBuffer
    protected final String getPrimaryDataMarkerColumn() {
        return "external_leaderboard_id";
    }
}
