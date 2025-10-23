package com.google.android.gms.measurement.internal;

import android.content.SharedPreferences;
import com.google.android.gms.common.internal.Preconditions;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzgh {
    private final String zza;
    private final String zzb;
    private boolean zzc;
    private String zzd;
    private final /* synthetic */ zzgb zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final String zza() {
        if (!this.zzc) {
            this.zzc = true;
            this.zzd = this.zze.zzg().getString(this.zza, null);
        }
        return this.zzd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public zzgh(zzgb zzgbVar, String str, String str2) {
        this.zze = zzgbVar;
        Preconditions.checkNotEmpty(str);
        this.zza = str;
        this.zzb = null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void zza(String str) {
        SharedPreferences.Editor edit = this.zze.zzg().edit();
        edit.putString(this.zza, str);
        edit.apply();
        this.zzd = str;
    }
}
