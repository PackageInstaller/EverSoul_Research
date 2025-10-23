package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzpv implements zzps {
    private static final zzgv<Boolean> zza;
    private static final zzgv<Boolean> zzb;
    private static final zzgv<Boolean> zzc;
    private static final zzgv<Boolean> zzd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzhd zza2 = new zzhd(zzgs.zza("com.google.android.gms.measurement")).zzb().zza();
        zza = zza2.zza("measurement.collection.enable_session_stitching_token.client.dev", true);
        zzb = zza2.zza("measurement.collection.enable_session_stitching_token.first_open_fix", true);
        zzc = zza2.zza("measurement.session_stitching_token_enabled", false);
        zzd = zza2.zza("measurement.link_sst_to_sid", true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zza() {
        return true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zzb() {
        return zza.zza().booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zzc() {
        return zzb.zza().booleanValue();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzps
    public final boolean zzd() {
        return zzc.zza().booleanValue();
    }
}
