package com.google.android.gms.drive.events;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* loaded from: classes.dex */
public final class zzo extends com.google.android.gms.drive.zzu implements DriveEvent {
    public static final Parcelable.Creator<zzo> CREATOR = new zzp();
    private final DataHolder zzav;
    private final boolean zzcq;
    private final int zzcr;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzo(DataHolder dataHolder, boolean z, int i) {
        this.zzav = dataHolder;
        this.zzcq = z;
        this.zzcr = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.events.DriveEvent
    public final int getType() {
        return 3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.drive.zzu
    public final void zza(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzav, i, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzcq);
        SafeParcelWriter.writeInt(parcel, 4, this.zzcr);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DataHolder zzz() {
        return this.zzav;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzaa() {
        return this.zzcq;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zzab() {
        return this.zzcr;
    }
}
