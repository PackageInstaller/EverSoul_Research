package com.google.android.gms.measurement.internal;

import java.util.BitSet;
import java.util.Map;
import java.util.Set;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzu extends zzmo {
    private String zza;
    private Set<Integer> zzb;
    private Map<Integer, zzw> zzc;
    private Long zzd;
    private Long zze;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final zzw zza(Integer num) {
        if (this.zzc.containsKey(num)) {
            return this.zzc.get(num);
        }
        zzw zzwVar = new zzw(this, this.zza);
        this.zzc.put(num, zzwVar);
        return zzwVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.measurement.internal.zzmo
    protected final boolean zzc() {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:129:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x0301 A[SYNTHETIC] */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    final java.util.List<com.google.android.gms.internal.measurement.zzfi.zzc> zza(java.lang.String r53, java.util.List<com.google.android.gms.internal.measurement.zzfi.zze> r54, java.util.List<com.google.android.gms.internal.measurement.zzfi.zzn> r55, java.lang.Long r56, java.lang.Long r57) {
        /*
            Method dump skipped, instructions count: 1802
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzu.zza(java.lang.String, java.util.List, java.util.List, java.lang.Long, java.lang.Long):java.util.List");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzu(zzmp zzmpVar) {
        super(zzmpVar);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private final boolean zza(int i, int i2) {
        BitSet bitSet;
        zzw zzwVar = this.zzc.get(Integer.valueOf(i));
        if (zzwVar == null) {
            return false;
        }
        bitSet = zzwVar.zzd;
        return bitSet.get(i2);
    }
}
