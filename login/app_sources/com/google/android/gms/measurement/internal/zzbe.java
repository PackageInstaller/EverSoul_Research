package com.google.android.gms.measurement.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzbe extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbe> CREATOR = new zzbd();
    public final String zza;
    public final zzaz zzb;
    public final String zzc;
    public final long zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "origin=" + this.zzc + ",name=" + this.zza + ",params=" + String.valueOf(this.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzbe(zzbe zzbeVar, long j) {
        Preconditions.checkNotNull(zzbeVar);
        this.zza = zzbeVar.zza;
        this.zzb = zzbeVar.zzb;
        this.zzc = zzbeVar.zzc;
        this.zzd = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzbe(String str, zzaz zzazVar, String str2, long j) {
        this.zza = str;
        this.zzb = zzazVar;
        this.zzc = str2;
        this.zzd = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zza, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zzb, i, false);
        SafeParcelWriter.writeString(parcel, 4, this.zzc, false);
        SafeParcelWriter.writeLong(parcel, 5, this.zzd);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
