package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zzp extends zzq {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzp() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzq, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzq
    /* renamed from: zza */
    public final PlayerEntity createFromParcel(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzo;
        boolean canUnparcelSafely;
        unparcelClientVersion = PlayerEntity.getUnparcelClientVersion();
        zzo = PlayerEntity.zzo(unparcelClientVersion);
        if (!zzo) {
            canUnparcelSafely = PlayerEntity.canUnparcelSafely(PlayerEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                return new PlayerEntity(readString, readString2, readString3 == null ? null : Uri.parse(readString3), readString4 == null ? null : Uri.parse(readString4), parcel.readLong(), -1, -1L, null, null, null, null, null, true, false, parcel.readString(), parcel.readString(), null, null, null, null, -1L, null, null, false);
            }
        }
        return super.createFromParcel(parcel);
    }
}
