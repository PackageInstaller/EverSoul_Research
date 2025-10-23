package com.google.android.gms.internal.auth;

/* compiled from: com.google.android.gms:play-services-auth-base@@17.1.4 */
/* loaded from: classes2.dex */
final class zzfh implements zzfo {
    private final zzfo[] zza;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzfh(zzfo... zzfoVarArr) {
        this.zza = zzfoVarArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzfo
    public final zzfn zzb(Class<?> cls) {
        zzfo[] zzfoVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            zzfo zzfoVar = zzfoVarArr[i];
            if (zzfoVar.zzc(cls)) {
                return zzfoVar.zzb(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.auth.zzfo
    public final boolean zzc(Class<?> cls) {
        zzfo[] zzfoVarArr = this.zza;
        for (int i = 0; i < 2; i++) {
            if (zzfoVarArr[i].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
