package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzox implements zzou {
    private static final zzgv<Boolean> zza;
    private static final zzgv<Boolean> zzb;
    private static final zzgv<Long> zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzhd zza2 = new zzhd(zzgs.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.item_scoped_custom_parameters.client", true);
        zzb = zza2.zza("measurement.item_scoped_custom_parameters.service", false);
        zzc = zza2.zza("measurement.id.item_scoped_custom_parameters.service", 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzou
    public final boolean zza() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzou
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzou
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }
}
