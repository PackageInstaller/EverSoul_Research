package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzoy implements zzoz {
    private static final zzgv<Boolean> zza;
    private static final zzgv<Boolean> zzb;
    private static final zzgv<Boolean> zzc;
    private static final zzgv<Long> zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzhd zza2 = new zzhd(zzgs.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.sdk.collection.enable_extend_user_property_size", true);
        zzb = zza2.zza("measurement.sdk.collection.last_deep_link_referrer2", true);
        zzc = zza2.zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false);
        zzd = zza2.zza("measurement.id.sdk.collection.last_deep_link_referrer2", 0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzoz
    public final boolean zza() {
        return zzc.zza().booleanValue();
    }
}
