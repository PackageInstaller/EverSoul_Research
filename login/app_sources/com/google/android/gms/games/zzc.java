package com.google.android.gms.games;

import android.os.Parcel;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzc extends zzo implements CurrentPlayerInfo {
    private final com.google.android.gms.games.internal.player.zzd zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzc(DataHolder dataHolder, int i, com.google.android.gms.games.internal.player.zzd zzdVar) {
        super(dataHolder, i);
        this.zza = zzdVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final boolean equals(Object obj) {
        return zza.zzc(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ CurrentPlayerInfo freeze() {
        return new zza(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return zzp(this.zza.zzK, 0);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return zza.zza(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return zza.zzb(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(new zza(this), parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza() {
        return hasColumn(this.zza.zzK) && !hasNull(this.zza.zzK);
    }
}
