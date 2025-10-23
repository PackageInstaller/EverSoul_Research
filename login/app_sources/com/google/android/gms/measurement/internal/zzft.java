package com.google.android.gms.measurement.internal;

import android.os.Bundle;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzft {
    public String zza;
    public Bundle zzb;
    private String zzc;
    private long zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzbe zza() {
        return new zzbe(this.zza, new zzaz(new Bundle(this.zzb)), this.zzc, this.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzft zza(zzbe zzbeVar) {
        return new zzft(zzbeVar.zza, zzbeVar.zzc, zzbeVar.zzb.zzb(), zzbeVar.zzd);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String toString() {
        return "origin=" + this.zzc + ",name=" + this.zza + ",params=" + String.valueOf(this.zzb);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzft(String str, String str2, Bundle bundle, long j) {
        this.zza = str;
        this.zzc = str2;
        this.zzb = bundle == null ? new Bundle() : bundle;
        this.zzd = j;
    }
}
