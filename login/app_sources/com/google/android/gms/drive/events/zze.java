package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.DriveSpace;
import java.util.List;

/* loaded from: classes.dex */
public final class zze extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zze> CREATOR = new zzf();
    private final int zzbw;
    private final boolean zzbx;
    private final List<DriveSpace> zzby;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zze(int i, boolean z, List<DriveSpace> list) {
        this.zzbw = i;
        this.zzbx = z;
        this.zzby = list;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzbw);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzbx);
        SafeParcelWriter.writeTypedList(parcel, 4, this.zzby, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            if (obj == this) {
                return true;
            }
            zze zzeVar = (zze) obj;
            if (Objects.equal(this.zzby, zzeVar.zzby) && this.zzbw == zzeVar.zzbw && this.zzbx == zzeVar.zzbx) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(this.zzby, Integer.valueOf(this.zzbw), Boolean.valueOf(this.zzbx));
    }
}
