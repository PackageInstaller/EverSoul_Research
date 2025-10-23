package com.google.android.gms.measurement.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.util.Iterator;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzaz extends AbstractSafeParcelable implements Iterable<String> {
    public static final Parcelable.Creator<zzaz> CREATOR = new zzbb();
    private final Bundle zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        return this.zza.size();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Bundle zzb() {
        return new Bundle(this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Double zza(String str) {
        return Double.valueOf(this.zza.getDouble(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Long zzb(String str) {
        return Long.valueOf(this.zza.getLong(str));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Object zzc(String str) {
        return this.zza.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final String zzd(String str) {
        return this.zza.getString(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return this.zza.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Iterable
    public final Iterator<String> iterator() {
        return new zzbc(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzaz(Bundle bundle) {
        this.zza = bundle;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 2, zzb(), false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
