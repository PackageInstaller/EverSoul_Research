package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.games.internal.zzh;
import com.google.common.net.HttpHeaders;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes.dex */
public final class ScreenshotEntity extends zzh implements Freezable, Parcelable {
    public static final Parcelable.Creator<ScreenshotEntity> CREATOR = new zzd();
    private final Uri zza;
    private final int zzb;
    private final int zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ScreenshotEntity(Uri uri, int i, int i2) {
        this.zza = uri;
        this.zzb = i;
        this.zzc = i2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (!(obj instanceof ScreenshotEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ScreenshotEntity screenshotEntity = (ScreenshotEntity) obj;
        return Objects.equal(screenshotEntity.zza, this.zza) && Objects.equal(Integer.valueOf(screenshotEntity.zzb), Integer.valueOf(this.zzb)) && Objects.equal(Integer.valueOf(screenshotEntity.zzc), Integer.valueOf(this.zzc));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final /* bridge */ /* synthetic */ Object freeze() {
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(this.zza, Integer.valueOf(this.zzb), Integer.valueOf(this.zzc));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.common.data.Freezable
    public final boolean isDataValid() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return Objects.toStringHelper(this).add("Uri", this.zza).add(HttpHeaders.WIDTH, Integer.valueOf(this.zzb)).add("Height", Integer.valueOf(this.zzc)).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeParcelable(parcel, 1, this.zza, i, false);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeInt(parcel, 3, this.zzc);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
