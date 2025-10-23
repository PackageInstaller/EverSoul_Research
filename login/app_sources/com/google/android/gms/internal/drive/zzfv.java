package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes2.dex */
public final class zzfv extends com.google.android.gms.drive.zzu {
    public static final Parcelable.Creator<zzfv> CREATOR = new zzfw();
    final DataHolder zzij;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.zzu
    protected final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzij, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzfv(DataHolder dataHolder) {
        this.zzij = dataHolder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DataHolder zzav() {
        return this.zzij;
    }
}
