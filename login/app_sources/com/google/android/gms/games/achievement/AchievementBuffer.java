package com.google.android.gms.games.achievement;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public class AchievementBuffer extends AbstractDataBuffer<Achievement> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AchievementBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public Achievement get(int i) {
        return new AchievementRef(this.mDataHolder, i);
    }
}
