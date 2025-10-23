package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public final class zzgs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzgs> CREATOR = new zzgt();
    private final int zzda;
    private final com.google.android.gms.drive.events.zzt zzdc;
    private final DriveId zzk;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzk, i, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzdc, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgs(DriveId driveId, int i, com.google.android.gms.drive.events.zzt zztVar) {
        this.zzk = driveId;
        this.zzda = i;
        this.zzdc = zztVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzgs(DriveId driveId, int i) {
        this(driveId, i, null);
    }
}
