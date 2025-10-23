package com.google.android.gms.internal.games_v2;

import android.app.PendingIntent;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
final class zzbq {
    private final String zza;
    private final Status zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzbq(Status status, String str) {
        this.zzb = status;
        this.zza = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzbq zzb(Status status) {
        Preconditions.checkArgument(!status.isSuccess());
        return new zzbq(status, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzbq zzc(String str) {
        return new zzbq(Status.RESULT_SUCCESS, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbq)) {
            return false;
        }
        zzbq zzbqVar = (zzbq) obj;
        return Objects.equal(this.zzb, zzbqVar.zzb) && Objects.equal(this.zza, zzbqVar.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(this.zzb, this.zza);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return Objects.toStringHelper(this).add("status", this.zzb).add("gameRunToken", this.zza).toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final PendingIntent zza() {
        return this.zzb.getResolution();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zzd() {
        return this.zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zze() {
        return this.zzb.isSuccess();
    }
}
