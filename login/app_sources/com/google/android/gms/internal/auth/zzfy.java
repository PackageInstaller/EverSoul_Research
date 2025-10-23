package com.google.android.gms.internal.auth;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzfy {
    private static final zzfy zza = new zzfy();
    private final ConcurrentMap<Class<?>, zzgb<?>> zzc = new ConcurrentHashMap();
    private final zzgc zzb = new zzfi();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzfy() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzfy zza() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> zzgb<T> zzb(Class<T> cls) {
        zzev.zzf(cls, "messageType");
        zzgb<T> zzgbVar = (zzgb) this.zzc.get(cls);
        if (zzgbVar == null) {
            zzgbVar = this.zzb.zza(cls);
            zzev.zzf(cls, "messageType");
            zzev.zzf(zzgbVar, "schema");
            zzgb<T> zzgbVar2 = (zzgb) this.zzc.putIfAbsent(cls, zzgbVar);
            if (zzgbVar2 != null) {
                return zzgbVar2;
            }
        }
        return zzgbVar;
    }
}
