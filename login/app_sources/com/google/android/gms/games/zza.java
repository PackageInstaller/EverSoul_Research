package com.google.android.gms.games;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class zza extends com.google.android.gms.games.internal.zzh implements CurrentPlayerInfo {
    public static final Parcelable.Creator<zza> CREATOR = new zzb();
    private final int zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zza(int i) {
        this.zza = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int zza(CurrentPlayerInfo currentPlayerInfo) {
        return Objects.hashCode(Integer.valueOf(currentPlayerInfo.getFriendsListVisibilityStatus()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String zzb(CurrentPlayerInfo currentPlayerInfo) {
        Objects.ToStringHelper stringHelper = Objects.toStringHelper(currentPlayerInfo);
        stringHelper.add("FriendsListVisibilityStatus", Integer.valueOf(currentPlayerInfo.getFriendsListVisibilityStatus()));
        return stringHelper.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean zzc(CurrentPlayerInfo currentPlayerInfo, Object obj) {
        if (obj instanceof CurrentPlayerInfo) {
            return obj == currentPlayerInfo || ((CurrentPlayerInfo) obj).getFriendsListVisibilityStatus() == currentPlayerInfo.getFriendsListVisibilityStatus();
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        return zzc(this, obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ CurrentPlayerInfo freeze() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.CurrentPlayerInfo
    public final int getFriendsListVisibilityStatus() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return zza(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return zzb(this);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        zzb.zza(this, parcel, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zza(CurrentPlayerInfo currentPlayerInfo) {
        this.zza = currentPlayerInfo.getFriendsListVisibilityStatus();
    }
}
