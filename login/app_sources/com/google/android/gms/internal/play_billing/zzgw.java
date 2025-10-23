package com.google.android.gms.internal.play_billing;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public final class zzgw {
    static final zzgw zza = new zzgw(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc;
    private static volatile zzgw zzd;
    private final Map zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgw() {
        this.zze = new HashMap();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzgw zza() {
        zzgw zzgwVar = zzd;
        if (zzgwVar != null) {
            return zzgwVar;
        }
        synchronized (zzgw.class) {
            zzgw zzgwVar2 = zzd;
            if (zzgwVar2 != null) {
                return zzgwVar2;
            }
            int i = zziu.zza;
            zzgw zzb2 = zzhe.zzb(zzgw.class);
            zzd = zzb2;
            return zzb2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final zzhj zzb(zzim zzimVar, int i) {
        return (zzhj) this.zze.get(new zzgv(zzimVar, i));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgw(boolean z) {
        this.zze = Collections.emptyMap();
    }
}
