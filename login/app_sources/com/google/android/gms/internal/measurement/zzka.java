package com.google.android.gms.internal.measurement;

import java.util.List;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
abstract class zzka {
    private static final zzka zza = new zzjz();
    private static final zzka zzb = new zzkb();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzka zza() {
        return zza;
    }

    abstract <L> List<L> zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    abstract void zzb(Object obj, long j);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzka zzb() {
        return zzb;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzka() {
    }
}
