package com.google.android.gms.games.multiplayer.realtime;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzc extends zzd {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzc() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.multiplayer.realtime.zzd, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.multiplayer.realtime.zzd
    /* renamed from: zza */
    public final RoomEntity createFromParcel(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzo;
        boolean canUnparcelSafely;
        unparcelClientVersion = RoomEntity.getUnparcelClientVersion();
        zzo = RoomEntity.zzo(unparcelClientVersion);
        if (!zzo) {
            canUnparcelSafely = RoomEntity.canUnparcelSafely(RoomEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                return new RoomEntity();
            }
        }
        return super.createFromParcel(parcel);
    }
}
