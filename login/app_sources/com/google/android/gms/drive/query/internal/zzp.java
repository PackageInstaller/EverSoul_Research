package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.metadata.SearchableCollectionMetadataField;
import com.google.android.gms.drive.metadata.internal.MetadataBundle;
import java.util.Collection;
import java.util.Collections;

/* loaded from: classes.dex */
public final class zzp<T> extends zza {
    public static final zzq CREATOR = new zzq();
    private final MetadataBundle zzma;
    private final com.google.android.gms.drive.metadata.zzb<T> zzmn;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzp(MetadataBundle metadataBundle) {
        this.zzma = metadataBundle;
        this.zzmn = (com.google.android.gms.drive.metadata.zzb) zzi.zza(metadataBundle);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzp(SearchableCollectionMetadataField<T> searchableCollectionMetadataField, T t) {
        this(MetadataBundle.zza(searchableCollectionMetadataField, Collections.singleton(t)));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.Filter
    public final <F> F zza(zzj<F> zzjVar) {
        com.google.android.gms.drive.metadata.zzb<T> zzbVar = this.zzmn;
        return zzjVar.zza((com.google.android.gms.drive.metadata.zzb<com.google.android.gms.drive.metadata.zzb<T>>) zzbVar, (com.google.android.gms.drive.metadata.zzb<T>) ((Collection) this.zzma.zza(zzbVar)).iterator().next());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzma, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
