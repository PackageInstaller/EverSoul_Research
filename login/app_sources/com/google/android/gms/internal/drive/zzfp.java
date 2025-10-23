package com.google.android.gms.internal.drive;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.drive.events.ChangeEvent;
import com.google.android.gms.drive.events.CompletionEvent;
import com.google.android.gms.drive.events.DriveEvent;

/* loaded from: classes2.dex */
public final class zzfp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzfp> CREATOR = new zzfq();
    private final int zzda;
    private final ChangeEvent zzib;
    private final CompletionEvent zzic;
    private final com.google.android.gms.drive.events.zzo zzid;
    private final com.google.android.gms.drive.events.zzb zzie;
    private final com.google.android.gms.drive.events.zzv zzif;
    private final com.google.android.gms.drive.events.zzr zzig;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.zzda);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzib, i, false);
        SafeParcelWriter.writeParcelable(parcel, 5, this.zzic, i, false);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzid, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.zzie, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.zzif, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.zzig, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzfp(int i, ChangeEvent changeEvent, CompletionEvent completionEvent, com.google.android.gms.drive.events.zzo zzoVar, com.google.android.gms.drive.events.zzb zzbVar, com.google.android.gms.drive.events.zzv zzvVar, com.google.android.gms.drive.events.zzr zzrVar) {
        this.zzda = i;
        this.zzib = changeEvent;
        this.zzic = completionEvent;
        this.zzid = zzoVar;
        this.zzie = zzbVar;
        this.zzif = zzvVar;
        this.zzig = zzrVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final DriveEvent zzat() {
        int i = this.zzda;
        if (i == 1) {
            return this.zzib;
        }
        if (i == 2) {
            return this.zzic;
        }
        if (i == 3) {
            return this.zzid;
        }
        if (i == 4) {
            return this.zzie;
        }
        if (i == 7) {
            return this.zzif;
        }
        if (i == 8) {
            return this.zzig;
        }
        throw new IllegalStateException(new StringBuilder(33).append("Unexpected event type ").append(this.zzda).toString());
    }
}
