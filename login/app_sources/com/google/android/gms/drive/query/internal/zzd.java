package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public final class zzd extends zza {
    public static final Parcelable.Creator<zzd> CREATOR = new zze();
    private final MetadataBundle zzma;
    private final MetadataField<?> zzmb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzd(MetadataBundle metadataBundle) {
        this.zzma = metadataBundle;
        this.zzmb = zzi.zza(metadataBundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzd(SearchableMetadataField<?> searchableMetadataField) {
        this(MetadataBundle.zza(searchableMetadataField, null));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.Filter
    public final <T> T zza(zzj<T> zzjVar) {
        return zzjVar.zze(this.zzmb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
