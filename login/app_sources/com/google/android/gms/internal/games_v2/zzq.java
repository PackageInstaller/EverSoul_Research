package com.google.android.gms.internal.games_v2;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.internal.Objects;

/* compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* loaded from: classes2.dex */
public final class zzq implements Api.ApiOptions.Optional {
    public final int zza;
    public final String zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* synthetic */ zzq(int i, String str, zzp zzpVar) {
        this.zza = i;
        this.zzb = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzo zza() {
        return new zzo(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzq)) {
            return false;
        }
        zzq zzqVar = (zzq) obj;
        return this.zza == zzqVar.zza && Objects.equal(this.zzb, zzqVar.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.zza), this.zzb);
    }
}
