package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.MetadataField;
import com.google.android.gms.drive.metadata.SearchableMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;

/* loaded from: classes.dex */
public final class zzn<T> extends zza {
    public static final zzo CREATOR = new zzo();
    private final MetadataBundle zzma;
    private final MetadataField<T> zzmb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzn(MetadataBundle metadataBundle) {
        this.zzma = metadataBundle;
        this.zzmb = (MetadataField<T>) zzi.zza(metadataBundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzn(SearchableMetadataField<T> searchableMetadataField, T t) {
        this(MetadataBundle.zza(searchableMetadataField, t));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.Filter
    public final <F> F zza(zzj<F> zzjVar) {
        MetadataField<T> metadataField = this.zzmb;
        return zzjVar.zzc(metadataField, this.zzma.zza(metadataField));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
