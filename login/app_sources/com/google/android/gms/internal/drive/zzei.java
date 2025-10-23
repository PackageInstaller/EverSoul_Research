package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.FileUploadPreferences;
import com.google.android.gms.drive.TransferPreferences;

@Deprecated
/* loaded from: classes2.dex */
public final class zzei extends AbstractSafeParcelable implements FileUploadPreferences {
    public static final Parcelable.Creator<zzei> CREATOR = new zzej();
    private int zzbn;
    private int zzgy;
    private boolean zzgz;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzh(int i) {
        return i == 1 || i == 2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean zzi(int i) {
        return i == 256 || i == 257;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzgy);
        SafeParcelWriter.writeInt(parcel, 3, this.zzbn);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzgz);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzei(int i, int i2, boolean z) {
        this.zzgy = i;
        this.zzbn = i2;
        this.zzgz = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzei(TransferPreferences transferPreferences) {
        this(transferPreferences.getNetworkPreference(), transferPreferences.getBatteryUsagePreference(), transferPreferences.isRoamingAllowed());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final int getNetworkTypePreference() {
        if (zzh(this.zzgy)) {
            return this.zzgy;
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final void setNetworkTypePreference(int i) {
        if (!zzh(i)) {
            throw new IllegalArgumentException("Invalid data connection preference value.");
        }
        this.zzgy = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final int getBatteryUsagePreference() {
        if (zzi(this.zzbn)) {
            return this.zzbn;
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final void setBatteryUsagePreference(int i) {
        if (!zzi(i)) {
            throw new IllegalArgumentException("Invalid battery usage preference value.");
        }
        this.zzbn = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final boolean isRoamingAllowed() {
        return this.zzgz;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.FileUploadPreferences
    public final void setRoamingAllowed(boolean z) {
        this.zzgz = z;
    }
}
