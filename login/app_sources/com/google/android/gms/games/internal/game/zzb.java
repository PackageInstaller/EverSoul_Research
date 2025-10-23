package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzb extends zzc {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzb() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.game.zzc, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.internal.game.zzc
    /* renamed from: zza */
    public final GameBadgeEntity createFromParcel(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzo;
        boolean canUnparcelSafely;
        unparcelClientVersion = GameBadgeEntity.getUnparcelClientVersion();
        zzo = GameBadgeEntity.zzo(unparcelClientVersion);
        if (!zzo) {
            canUnparcelSafely = GameBadgeEntity.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                int readInt = parcel.readInt();
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                return new GameBadgeEntity(readInt, readString, readString2, readString3 == null ? null : Uri.parse(readString3));
            }
        }
        return super.createFromParcel(parcel);
    }
}
