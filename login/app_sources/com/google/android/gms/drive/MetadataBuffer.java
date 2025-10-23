package com.google.android.gms.drive;

import com.google.android.gms.common.data.AbstractDataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import com.google.android.gms.internal.drive.zzaa;
import com.google.android.gms.internal.drive.zzhs;

/* loaded from: classes.dex */
public final class MetadataBuffer extends AbstractDataBuffer<Metadata> {
    private zza zzau;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public MetadataBuffer(DataHolder dataHolder) {
        super(dataHolder);
        dataHolder.getMetadata().setClassLoader(MetadataBuffer.class.getClassLoader());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public final String getNextPageToken() {
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer
    public final Metadata get(int i) {
        zza zzaVar = this.zzau;
        if (zzaVar != null && zzaVar.row == i) {
            return zzaVar;
        }
        zza zzaVar2 = new zza(this.mDataHolder, i);
        this.zzau = zzaVar2;
        return zzaVar2;
    }

    static class zza extends Metadata {
        private final int row;
        private final DataHolder zzav;
        private final int zzaw;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public zza(DataHolder dataHolder, int i) {
            this.zzav = dataHolder;
            this.row = i;
            this.zzaw = dataHolder.getWindowIndex(i);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.drive.Metadata
        public final <T> T zza(MetadataField<T> metadataField) {
            return metadataField.zza(this.zzav, this.row, this.zzaw);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.common.data.Freezable
        public final boolean isDataValid() {
            return !this.zzav.isClosed();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.android.gms.common.data.Freezable
        public final /* synthetic */ Metadata freeze() {
            MetadataBundle zzbe = MetadataBundle.zzbe();
            for (MetadataField<?> metadataField : com.google.android.gms.drive.metadata.internal.zzf.zzbc()) {
                if (metadataField != zzhs.zzkq) {
                    metadataField.zza(this.zzav, zzbe, this.row, this.zzaw);
                }
            }
            return new zzaa(zzbe);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.AbstractDataBuffer, com.google.android.gms.common.data.DataBuffer, com.google.android.gms.common.api.Releasable
    public final void release() {
        if (this.mDataHolder != null) {
            com.google.android.gms.drive.metadata.internal.zzf.zza(this.mDataHolder);
        }
        super.release();
    }
}
