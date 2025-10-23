package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzpd implements zzpa {
    private static final zzgv<Boolean> zza;
    private static final zzgv<Double> zzb;
    private static final zzgv<Long> zzc;
    private static final zzgv<Long> zzd;
    private static final zzgv<String> zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzpa
    public final double zza() {
        return zzb.zza().doubleValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzpa
    public final long zzb() {
        return zzc.zza().longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzpa
    public final long zzc() {
        return zzd.zza().longValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzpa
    public final String zzd() {
        return zze.zza();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzhd zza2 = new zzhd(zzgs.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.test.boolean_flag", false);
        zzb = zza2.zza("measurement.test.double_flag", -3.0d);
        zzc = zza2.zza("measurement.test.int_flag", -2L);
        zzd = zza2.zza("measurement.test.long_flag", -1L);
        zze = zza2.zza("measurement.test.string_flag", "---");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzpa
    public final boolean zze() {
        return zza.zza().booleanValue();
    }
}
