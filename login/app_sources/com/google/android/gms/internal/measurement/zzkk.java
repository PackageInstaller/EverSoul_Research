package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
final class zzkk implements zzks {
    private zzks[] zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzks
    public final zzkp zza(Class<?> cls) {
        for (zzks zzksVar : this.zza) {
            if (zzksVar.zzb(cls)) {
                return zzksVar.zza(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: " + cls.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzkk(zzks... zzksVarArr) {
        this.zza = zzksVarArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.measurement.zzks
    public final boolean zzb(Class<?> cls) {
        for (zzks zzksVar : this.zza) {
            if (zzksVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }
}
