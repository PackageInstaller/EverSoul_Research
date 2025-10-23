package com.google.android.gms.internal.play_billing;

import java.io.Serializable;
import java.util.Set;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzct extends zzbi implements Serializable {
    private static final zzct zza;
    private static final zzct zzb;
    private final transient zzco zzc;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        int i = zzco.zzd;
        zza = new zzct(zzdk.zza);
        zzb = new zzct(zzco.zzm(zzdh.zza()));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzct(zzco zzcoVar) {
        this.zzc = zzcoVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzct zza() {
        return zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzct zzb() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.play_billing.zzdj
    public final /* bridge */ /* synthetic */ Set zzc() {
        return this.zzc.isEmpty() ? zzdq.zza : new zzdr(this.zzc, zzdg.zza);
    }
}
