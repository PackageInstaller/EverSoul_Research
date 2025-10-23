package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzqc implements zzqd {
    private static final zzgv<Boolean> zza;
    private static final zzgv<Boolean> zzb;
    private static final zzgv<Boolean> zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzhd zza2 = new zzhd(zzgs.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.sgtm.client.dev", false);
        zzb = zza2.zza("measurement.sgtm.preview_mode_enabled.dev", false);
        zzc = zza2.zza("measurement.sgtm.service", false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zza() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzqd
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }
}
