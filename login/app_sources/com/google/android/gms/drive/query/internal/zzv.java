package com.google.android.gms.drive.query.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.query.Filter;

/* loaded from: classes.dex */
public final class zzv extends zza {
    public static final Parcelable.Creator<zzv> CREATOR = new zzw();
    private final FilterHolder zzmp;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzv(FilterHolder filterHolder) {
        this.zzmp = filterHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzv(Filter filter) {
        this(new FilterHolder(filter));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.query.Filter
    public final <T> T zza(zzj<T> zzjVar) {
        return (T) zzjVar.zza(this.zzmp.getFilter().zza(zzjVar));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zzmp, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
