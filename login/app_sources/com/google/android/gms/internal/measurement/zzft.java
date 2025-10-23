package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.1 */
/* loaded from: classes2.dex */
public final class zzft {
    private static zzfw zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized zzfw zza() {
        zzfw zzfwVar;
        synchronized (zzft.class) {
            if (zza == null) {
                zza(new zzfv());
            }
            zzfwVar = zza;
        }
        return zzfwVar;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static synchronized void zza(zzfw zzfwVar) {
        synchronized (zzft.class) {
            if (zza != null) {
                throw new IllegalStateException("init() already called");
            }
            zza = zzfwVar;
        }
    }
}
