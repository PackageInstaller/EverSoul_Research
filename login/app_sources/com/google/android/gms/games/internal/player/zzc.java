package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.data.DataBufferRef;
import com.google.android.gms.common.data.DataHolder;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zzc extends DataBufferRef implements zza {
    private final zzd zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzc(DataHolder dataHolder, int i, zzd zzdVar) {
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
        return MostRecentGameInfoEntity.zzi(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* synthetic */ Object freeze() {
        return new MostRecentGameInfoEntity(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.DataBufferRef
    public final int hashCode() {
        return MostRecentGameInfoEntity.zzg(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return MostRecentGameInfoEntity.zzh(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(new MostRecentGameInfoEntity(this), parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.player.zza
    public final long zza() {
        return getLong(this.zza.zzu);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzb() {
        return parseUri(this.zza.zzx);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzc() {
        return parseUri(this.zza.zzw);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.player.zza
    public final Uri zzd() {
        return parseUri(this.zza.zzv);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.player.zza
    public final String zze() {
        return getString(this.zza.zzs);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.player.zza
    public final String zzf() {
        return getString(this.zza.zzt);
    }
}
