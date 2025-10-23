package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzkj<K, V> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <K, V> int zza(zzkm<K, V> zzkmVar, K k, V v) {
        return zziy.zza(zzkmVar.zza, 1, k) + zziy.zza(zzkmVar.zzc, 2, v);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <K, V> void zza(zzio zzioVar, zzkm<K, V> zzkmVar, K k, V v) throws IOException {
        zziy.zza(zzioVar, zzkmVar.zza, 1, k);
        zziy.zza(zzioVar, zzkmVar.zzc, 2, v);
    }
}
