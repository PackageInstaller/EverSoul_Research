package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.TransferPreferences;

/* loaded from: classes2.dex */
public final class zzgo extends AbstractSafeParcelable implements TransferPreferences {
    public static final Parcelable.Creator<zzgo> CREATOR = new zzgp();
    private final boolean zzbm;
    private final int zzbn;
    private final int zzgy;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgo(int i, int i2, boolean z) {
        this.zzgy = i;
        this.zzbn = i2;
        this.zzbm = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgy);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbn);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzbm);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.TransferPreferences
    public final int getNetworkPreference() {
        return this.zzgy;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.TransferPreferences
    public final boolean isRoamingAllowed() {
        return this.zzbm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.TransferPreferences
    public final int getBatteryUsagePreference() {
        return this.zzbn;
    }
}
