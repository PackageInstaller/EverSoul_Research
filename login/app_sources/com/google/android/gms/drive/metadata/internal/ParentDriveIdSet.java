package com.google.android.gms.drive.metadata.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class ParentDriveIdSet extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<ParentDriveIdSet> CREATOR = new zzn();
    final List<zzq> zzjj;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ParentDriveIdSet(List<zzq> list) {
        this.zzjj = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ParentDriveIdSet() {
        this(new ArrayList());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeTypedList(parcel, 2, this.zzjj, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
