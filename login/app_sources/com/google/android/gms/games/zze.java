package com.google.android.gms.games;

import android.net.Uri;
import android.os.Parcel;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
final class zze extends zzf {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zze() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzf, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzf
    /* renamed from: zza */
    public final GameEntity createFromParcel(Parcel parcel) {
        Integer unparcelClientVersion;
        boolean zzo;
        boolean canUnparcelSafely;
        unparcelClientVersion = GameEntity.getUnparcelClientVersion();
        zzo = GameEntity.zzo(unparcelClientVersion);
        if (!zzo) {
            canUnparcelSafely = GameEntity.canUnparcelSafely(GameEntity.class.getCanonicalName());
            if (!canUnparcelSafely) {
                String readString = parcel.readString();
                String readString2 = parcel.readString();
                String readString3 = parcel.readString();
                String readString4 = parcel.readString();
                String readString5 = parcel.readString();
                String readString6 = parcel.readString();
                String readString7 = parcel.readString();
                Uri parse = readString7 == null ? null : Uri.parse(readString7);
                String readString8 = parcel.readString();
                Uri parse2 = readString8 == null ? null : Uri.parse(readString8);
                String readString9 = parcel.readString();
                return new GameEntity(readString, readString2, readString3, readString4, readString5, readString6, parse, parse2, readString9 == null ? null : Uri.parse(readString9), parcel.readInt() > 0, parcel.readInt() > 0, parcel.readString(), parcel.readInt(), parcel.readInt(), parcel.readInt(), false, false, null, null, null, false, false, false, null, false);
            }
        }
        return super.createFromParcel(parcel);
    }
}
