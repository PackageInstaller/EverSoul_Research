package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjf;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzjg implements zzks {
    private static final zzjg zza = new zzjg();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzjg zza() {
        return zza;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzks
    public final zzkp zza(Class<?> cls) {
        if (!zzjf.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (zzkp) zzjf.zza(cls.asSubclass(zzjf.class)).zza(zzjf.zze.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzjg() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzks
    public final boolean zzb(Class<?> cls) {
        return zzjf.class.isAssignableFrom(cls);
    }
}
