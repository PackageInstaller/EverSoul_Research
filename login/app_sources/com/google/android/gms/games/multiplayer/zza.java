package com.google.android.gms.games.multiplayer;

import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zza extends zzb {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zza() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.multiplayer.zzb, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.multiplayer.zzb
    /* renamed from: zza */
    public final ParticipantEntity createFromParcel(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzo;
        boolean canUnparcelSafely;
        unparcelClientVersion = ParticipantEntity.getUnparcelClientVersion();
        zzo = ParticipantEntity.zzo(unparcelClientVersion);
        if (!zzo) {
            canUnparcelSafely = ParticipantEntity.canUnparcelSafely(ParticipantEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                return new ParticipantEntity();
            }
        }
        return super.createFromParcel(parcel);
    }
}
