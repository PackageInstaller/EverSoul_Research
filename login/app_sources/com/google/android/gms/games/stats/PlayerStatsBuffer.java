package com.google.android.gms.games.stats;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class PlayerStatsBuffer extends AbstractDataBuffer<PlayerStats> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PlayerStatsBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    /* renamed from: zza, reason: merged with bridge method [inline-methods] */
    public final PlayerStats get(int i) {
        return new zzb(this.mDataHolder, i);
    }
}
