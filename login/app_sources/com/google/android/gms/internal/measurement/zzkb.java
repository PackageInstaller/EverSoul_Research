package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkb extends zzka {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static <E> zzjn<E> zzc(Object obj, long j) {
        return (zzjn) zzmo.zze(obj, j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzka
    final <L> List<L> zza(Object obj, long j) {
        zzjn zzc = zzc(obj, j);
        if (zzc.zzc()) {
            return zzc;
        }
        int size = zzc.size();
        zzjn zza = zzc.zza(size == 0 ? 10 : size << 1);
        zzmo.zza(obj, j, zza);
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzkb() {
        super();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzka
    final void zzb(Object obj, long j) {
        zzc(obj, j).mo171i_();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzka
    final <E> void zza(Object obj, Object obj2, long j) {
        zzjn zzc = zzc(obj, j);
        zzjn zzc2 = zzc(obj2, j);
        int size = zzc.size();
        int size2 = zzc2.size();
        if (size > 0 && size2 > 0) {
            if (!zzc.zzc()) {
                zzc = zzc.zza(size2 + size);
            }
            zzc.addAll(zzc2);
        }
        if (size > 0) {
            zzc2 = zzc;
        }
        zzmo.zza(obj, j, zzc2);
    }
}
