package com.google.android.gms.internal.drive;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: classes2.dex */
final class zzmd {
    private static final zzmd zzuw = new zzmd();
    private final ConcurrentMap<Class<?>, zzmf<?>> zzuy = new ConcurrentHashMap();
    private final zzmg zzux = new zzlf();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzmd zzej() {
        return zzuw;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> zzmf<T> zzf(Class<T> cls) {
        zzkm.zza(cls, "messageType");
        zzmf<T> zzmfVar = (zzmf) this.zzuy.get(cls);
        if (zzmfVar != null) {
            return zzmfVar;
        }
        zzmf<T> zze = this.zzux.zze(cls);
        zzkm.zza(cls, "messageType");
        zzkm.zza(zze, "schema");
        zzmf<T> zzmfVar2 = (zzmf) this.zzuy.putIfAbsent(cls, zze);
        return zzmfVar2 != null ? zzmfVar2 : zze;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <T> zzmf<T> zzq(T t) {
        return zzf(t.getClass());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzmd() {
    }
}
