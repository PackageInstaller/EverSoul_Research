package com.google.android.gms.internal.games_v2;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzan extends com.google.android.gms.games.internal.zzh {
    public static final Parcelable.Creator<zzan> CREATOR = new zzao();
    private final Bundle zza;
    private final IBinder zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzan(Bundle bundle, IBinder iBinder) {
        this.zza = bundle;
        this.zzb = iBinder;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBundle(parcel, 1, this.zza, false);
        SafeParcelWriter.writeIBinder(parcel, 2, this.zzb, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzan(zzam zzamVar) {
        this.zza = zzamVar.zza();
        this.zzb = zzamVar.zza;
    }
}
