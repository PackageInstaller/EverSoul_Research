package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzpp implements zzpm {
    private static final zzgv<Boolean> zza;
    private static final zzgv<Long> zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzhd zza2 = new zzhd(zzgs.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.remove_app_background.client", false);
        zzb = zza2.zza("measurement.id.remove_app_background.client", 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzpm
    public final boolean zza() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzpm
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }
}
