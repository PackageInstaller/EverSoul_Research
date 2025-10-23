package com.google.android.gms.games;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public class PlayerBuffer extends AbstractDataBuffer<Player> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PlayerBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public Player get(int i) {
        return new PlayerRef(this.mDataHolder, i, null);
    }
}
