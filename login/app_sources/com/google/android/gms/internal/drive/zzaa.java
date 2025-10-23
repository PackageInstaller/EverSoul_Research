package com.google.android.gms.internal.drive;

import com.google.android.gms.drive.Metadata;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes2.dex */
public final class zzaa extends Metadata {
    private final MetadataBundle zzdt;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzaa(MetadataBundle metadataBundle) {
        this.zzdt = metadataBundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.Metadata
    public final <T> T zza(MetadataField<T> metadataField) {
        return (T) this.zzdt.zza(metadataField);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        String valueOf = String.valueOf(this.zzdt);
        return new StringBuilder(String.valueOf(valueOf).length() + 17).append("Metadata [mImpl=").append(valueOf).append("]").toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return this.zzdt != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Metadata freeze() {
        return new zzaa(this.zzdt.zzbf());
    }
}
