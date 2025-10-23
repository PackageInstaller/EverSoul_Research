package com.google.android.gms.location;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import com.facebook.AuthenticationTokenClaims;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-location@@18.0.0 */
/* loaded from: classes2.dex */
public final class LocationRequest extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<LocationRequest> CREATOR = new zzbf();
    public static final int PRIORITY_BALANCED_POWER_ACCURACY = 102;
    public static final int PRIORITY_HIGH_ACCURACY = 100;
    public static final int PRIORITY_LOW_POWER = 104;
    public static final int PRIORITY_NO_POWER = 105;
    int zza;
    long zzb;
    long zzc;
    boolean zzd;
    long zze;
    int zzf;
    float zzg;
    long zzh;
    boolean zzi;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public LocationRequest() {
        this.zza = 102;
        this.zzb = DateUtils.MILLIS_PER_HOUR;
        this.zzc = AuthenticationTokenClaims.MAX_TIME_SINCE_TOKEN_ISSUED;
        this.zzd = false;
        this.zze = Long.MAX_VALUE;
        this.zzf = Integer.MAX_VALUE;
        this.zzg = 0.0f;
        this.zzh = 0L;
        this.zzi = false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static LocationRequest create() {
        LocationRequest locationRequest = new LocationRequest();
        locationRequest.setWaitForAccurateLocation(true);
        return locationRequest;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void zza(long j) {
        if (j >= 0) {
            return;
        }
        StringBuilder sb = new StringBuilder(38);
        sb.append("invalid interval: ");
        sb.append(j);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(Object obj) {
        if (obj instanceof LocationRequest) {
            LocationRequest locationRequest = (LocationRequest) obj;
            if (this.zza == locationRequest.zza && this.zzb == locationRequest.zzb && this.zzc == locationRequest.zzc && this.zzd == locationRequest.zzd && this.zze == locationRequest.zze && this.zzf == locationRequest.zzf && this.zzg == locationRequest.zzg && getMaxWaitTime() == locationRequest.getMaxWaitTime() && this.zzi == locationRequest.zzi) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getExpirationTime() {
        return this.zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getFastestInterval() {
        return this.zzc;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getInterval() {
        return this.zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getMaxWaitTime() {
        long j = this.zzh;
        long j2 = this.zzb;
        return j < j2 ? j2 : j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getNumUpdates() {
        return this.zzf;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getPriority() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public float getSmallestDisplacement() {
        return this.zzg;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), Long.valueOf(this.zzb), Float.valueOf(this.zzg), Long.valueOf(this.zzh));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isFastestIntervalExplicitlySet() {
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isWaitForAccurateLocation() {
        return this.zzi;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setExpirationDuration(long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j2 = j <= Long.MAX_VALUE - elapsedRealtime ? j + elapsedRealtime : Long.MAX_VALUE;
        this.zze = j2;
        if (j2 < 0) {
            this.zze = 0L;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setExpirationTime(long j) {
        this.zze = j;
        if (j < 0) {
            this.zze = 0L;
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setFastestInterval(long j) {
        zza(j);
        this.zzd = true;
        this.zzc = j;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setInterval(long j) {
        zza(j);
        this.zzb = j;
        if (!this.zzd) {
            this.zzc = (long) (j / 6.0d);
        }
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setMaxWaitTime(long j) {
        zza(j);
        this.zzh = j;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setNumUpdates(int i) {
        if (i > 0) {
            this.zzf = i;
            return this;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("invalid numUpdates: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setPriority(int i) {
        if (i == 100 || i == 102 || i == 104 || i == 105) {
            this.zza = i;
            return this;
        }
        StringBuilder sb = new StringBuilder(28);
        sb.append("invalid quality: ");
        sb.append(i);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setSmallestDisplacement(float f) {
        if (f >= 0.0f) {
            this.zzg = f;
            return this;
        }
        StringBuilder sb = new StringBuilder(37);
        sb.append("invalid displacement: ");
        sb.append(f);
        throw new IllegalArgumentException(sb.toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public LocationRequest setWaitForAccurateLocation(boolean z) {
        this.zzi = z;
        return this;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder("Request[");
        int i = this.zza;
        sb.append(i != 100 ? i != 102 ? i != 104 ? i != 105 ? "???" : "PRIORITY_NO_POWER" : "PRIORITY_LOW_POWER" : "PRIORITY_BALANCED_POWER_ACCURACY" : "PRIORITY_HIGH_ACCURACY");
        if (this.zza != 105) {
            sb.append(" requested=");
            sb.append(this.zzb);
            sb.append("ms");
        }
        sb.append(" fastest=");
        sb.append(this.zzc);
        sb.append("ms");
        if (this.zzh > this.zzb) {
            sb.append(" maxWait=");
            sb.append(this.zzh);
            sb.append("ms");
        }
        if (this.zzg > 0.0f) {
            sb.append(" smallestDisplacement=");
            sb.append(this.zzg);
            sb.append("m");
        }
        long j = this.zze;
        if (j != Long.MAX_VALUE) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            sb.append(" expireIn=");
            sb.append(j - elapsedRealtime);
            sb.append("ms");
        }
        if (this.zzf != Integer.MAX_VALUE) {
            sb.append(" num=");
            sb.append(this.zzf);
        }
        sb.append(']');
        return sb.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeLong(parcel, 2, this.zzb);
        SafeParcelWriter.writeLong(parcel, 3, this.zzc);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzd);
        SafeParcelWriter.writeLong(parcel, 5, this.zze);
        SafeParcelWriter.writeInt(parcel, 6, this.zzf);
        SafeParcelWriter.writeFloat(parcel, 7, this.zzg);
        SafeParcelWriter.writeLong(parcel, 8, this.zzh);
        SafeParcelWriter.writeBoolean(parcel, 9, this.zzi);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    LocationRequest(int i, long j, long j2, boolean z, long j3, int i2, float f, long j4, boolean z2) {
        this.zza = i;
        this.zzb = j;
        this.zzc = j2;
        this.zzd = z;
        this.zze = j3;
        this.zzf = i2;
        this.zzg = f;
        this.zzh = j4;
        this.zzi = z2;
    }
}
