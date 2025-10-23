package com.google.android.gms.internal.games_v2;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzy extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzy> CREATOR = new zzz();
    private final int zza;
    private final zzaf zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzy(int i, zzaf zzafVar) {
        this.zza = i;
        this.zzb = zzafVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzy zzb(int i) {
        return new zzy(i, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzy zzc(int i, zzaf zzafVar) {
        return new zzy(i, zzafVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzy)) {
            return false;
        }
        zzy zzyVar = (zzy) obj;
        return this.zza == zzyVar.zza && Objects.equal(this.zzb, zzyVar.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return Objects.toStringHelper(this).add("signInType", Integer.valueOf(this.zza)).add("previousStepResolutionResult", this.zzb).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zzb, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zzd() {
        return this.zzb == null;
    }
}
