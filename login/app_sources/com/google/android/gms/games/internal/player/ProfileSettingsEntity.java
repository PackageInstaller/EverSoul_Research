package com.google.android.gms.games.internal.player;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzh;
import com.google.android.gms.games.zzw;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public class ProfileSettingsEntity extends zzh implements zzw {
    public static final Parcelable.Creator<ProfileSettingsEntity> CREATOR = new zze();
    private final Status zza;
    private final String zzb;
    private final boolean zzc;
    private final boolean zzd;
    private final boolean zze;
    private final StockProfileImageEntity zzf;
    private final boolean zzg;
    private final boolean zzh;
    private final int zzi;
    private final boolean zzj;
    private final boolean zzk;
    private final int zzl;
    private final int zzm;
    private final boolean zzn;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ProfileSettingsEntity(Status status, String str, boolean z, boolean z2, boolean z3, StockProfileImageEntity stockProfileImageEntity, boolean z4, boolean z5, int i, boolean z6, boolean z7, int i2, int i3, boolean z8) {
        this.zza = status;
        this.zzb = str;
        this.zzc = z;
        this.zzd = z2;
        this.zze = z3;
        this.zzf = stockProfileImageEntity;
        this.zzg = z4;
        this.zzh = z5;
        this.zzi = i;
        this.zzj = z6;
        this.zzk = z7;
        this.zzl = i2;
        this.zzm = i3;
        this.zzn = z8;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (!(obj instanceof zzw)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        zzw zzwVar = (zzw) obj;
        return Objects.equal(this.zzb, zzwVar.zze()) && Objects.equal(Boolean.valueOf(this.zzc), Boolean.valueOf(zzwVar.zzi())) && Objects.equal(Boolean.valueOf(this.zzd), Boolean.valueOf(zzwVar.zzk())) && Objects.equal(Boolean.valueOf(this.zze), Boolean.valueOf(zzwVar.zzm())) && Objects.equal(this.zza, zzwVar.getStatus()) && Objects.equal(this.zzf, zzwVar.zzd()) && Objects.equal(Boolean.valueOf(this.zzg), Boolean.valueOf(zzwVar.zzj())) && Objects.equal(Boolean.valueOf(this.zzh), Boolean.valueOf(zzwVar.zzh())) && this.zzi == zzwVar.zzb() && this.zzj == zzwVar.zzl() && this.zzk == zzwVar.zzf() && this.zzl == zzwVar.zzc() && this.zzm == zzwVar.zza() && this.zzn == zzwVar.zzg();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.api.Result
    public final Status getStatus() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(this.zzb, Boolean.valueOf(this.zzc), Boolean.valueOf(this.zzd), Boolean.valueOf(this.zze), this.zza, this.zzf, Boolean.valueOf(this.zzg), Boolean.valueOf(this.zzh), Integer.valueOf(this.zzi), Boolean.valueOf(this.zzj), Boolean.valueOf(this.zzk), Integer.valueOf(this.zzl), Integer.valueOf(this.zzm), Boolean.valueOf(this.zzn));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return Objects.toStringHelper(this).add("GamerTag", this.zzb).add("IsGamerTagExplicitlySet", Boolean.valueOf(this.zzc)).add("IsProfileVisible", Boolean.valueOf(this.zzd)).add("IsVisibilityExplicitlySet", Boolean.valueOf(this.zze)).add("Status", this.zza).add("StockProfileImage", this.zzf).add("IsProfileDiscoverable", Boolean.valueOf(this.zzg)).add("AutoSignIn", Boolean.valueOf(this.zzh)).add("httpErrorCode", Integer.valueOf(this.zzi)).add("IsSettingsChangesProhibited", Boolean.valueOf(this.zzj)).add("AllowFriendInvites", Boolean.valueOf(this.zzk)).add("ProfileVisibility", Integer.valueOf(this.zzl)).add("global_friends_list_visibility", Integer.valueOf(this.zzm)).add("always_auto_sign_in", Boolean.valueOf(this.zzn)).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeString(parcel, 2, this.zzb, false);
        SafeParcelWriter.writeBoolean(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zze);
        SafeParcelWriter.writeParcelable(parcel, 6, this.zzf, i, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzh);
        SafeParcelWriter.writeInt(parcel, 9, this.zzi);
        SafeParcelWriter.writeBoolean(parcel, 10, this.zzj);
        SafeParcelWriter.writeBoolean(parcel, 11, this.zzk);
        SafeParcelWriter.writeInt(parcel, 12, this.zzl);
        SafeParcelWriter.writeInt(parcel, 13, this.zzm);
        SafeParcelWriter.writeBoolean(parcel, 14, this.zzn);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final int zza() {
        return this.zzm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final int zzb() {
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final int zzc() {
        return this.zzl;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final StockProfileImage zzd() {
        return this.zzf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final String zze() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final boolean zzf() {
        return this.zzk;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final boolean zzg() {
        return this.zzn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final boolean zzh() {
        return this.zzh;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final boolean zzi() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final boolean zzj() {
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final boolean zzk() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final boolean zzl() {
        return this.zzj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.games.zzw
    public final boolean zzm() {
        return this.zze;
    }
}
