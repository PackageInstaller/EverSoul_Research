package com.google.android.gms.measurement.internal;

import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
final class zzgv implements com.google.android.gms.internal.measurement.zzo {
    private final /* synthetic */ String zza;
    private final /* synthetic */ zzgn zzb;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map;
        map = this.zzb.zzc;
        Map map2 = (Map) map.get(this.zza);
        if (map2 == null || !map2.containsKey(str)) {
            return null;
        }
        return (String) map2.get(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzgv(zzgn zzgnVar, String str) {
        this.zza = str;
        this.zzb = zzgnVar;
    }
}
