package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzge {
    private final String zza;
    private final boolean zzb;
    private boolean zzc;
    private boolean zzd;
    private final /* synthetic */ zzgb zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzge(zzgb zzgbVar, String str, boolean z) {
        this.zze = zzgbVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(boolean z) {
        SharedPreferences.Editor edit = this.zze.zzg().edit();
        edit.putBoolean(this.zza, z);
        edit.apply();
        this.zzd = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getBoolean(this.zza, this.zzb);
        }
        return this.zzd;
    }
}
