package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.net.Uri;
import com.google.common.base.Function;
import javax.annotation.Nullable;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzhd {
    final String zza;
    final Uri zzb;
    final String zzc;
    final String zzd;
    final boolean zze;
    final boolean zzf;
    final boolean zzg;

    @Nullable
    final Function<Context, Boolean> zzh;
    private final boolean zzi;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzhd zza() {
        return new zzhd(this.zza, this.zzb, this.zzc, this.zzd, this.zze, this.zzf, true, this.zzg, this.zzh);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzhd zzb() {
        if (!this.zzc.isEmpty()) {
            throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
        }
        Function<Context, Boolean> function = this.zzh;
        if (function == null) {
            return new zzhd(this.zza, this.zzb, this.zzc, this.zzd, true, this.zzf, this.zzi, this.zzg, function);
        }
        throw new IllegalStateException("Cannot skip gservices both always and conditionally");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzgv<Double> zza(String str, double d) {
        return zzgv.zza(this, str, Double.valueOf(-3.0d), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzgv<Long> zza(String str, long j) {
        return zzgv.zza(this, str, Long.valueOf(j), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzgv<String> zza(String str, String str2) {
        return zzgv.zza(this, str, str2, true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzgv<Boolean> zza(String str, boolean z) {
        return zzgv.zza(this, str, Boolean.valueOf(z), true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzhd(Uri uri) {
        this(null, uri, "", "", false, false, false, false, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzhd(String str, Uri uri, String str2, String str3, boolean z, boolean z2, boolean z3, boolean z4, @Nullable Function<Context, Boolean> function) {
        this.zza = str;
        this.zzb = uri;
        this.zzc = str2;
        this.zzd = str3;
        this.zze = z;
        this.zzf = z2;
        this.zzi = z3;
        this.zzg = z4;
        this.zzh = function;
    }
}
