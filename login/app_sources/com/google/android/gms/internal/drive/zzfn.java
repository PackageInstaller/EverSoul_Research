package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveId;

/* loaded from: classes2.dex */
public final class zzfn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfn> CREATOR = new zzfo();
    DriveId zzdd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzdd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzfn(DriveId driveId) {
        this.zzdd = driveId;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DriveId getDriveId() {
        return this.zzdd;
    }
}
