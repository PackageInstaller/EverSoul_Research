package com.google.android.gms.games.snapshot;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class SnapshotMetadataBuffer extends AbstractDataBuffer<SnapshotMetadata> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public SnapshotMetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public SnapshotMetadata get(int i) {
        return new SnapshotMetadataRef(this.mDataHolder, i);
    }
}
