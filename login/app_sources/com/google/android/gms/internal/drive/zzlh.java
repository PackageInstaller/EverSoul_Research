package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
final class zzlh implements zzlp {
    private zzlp[] zztt;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzlh(zzlp... zzlpVarArr) {
        this.zztt = zzlpVarArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzlp
    public final boolean zzb(Class<?> cls) {
        for (zzlp zzlpVar : this.zztt) {
            if (zzlpVar.zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.gms.internal.drive.zzlp
    public final zzlo zzc(Class<?> cls) {
        for (zzlp zzlpVar : this.zztt) {
            if (zzlpVar.zzb(cls)) {
                return zzlpVar.zzc(cls);
            }
        }
        String valueOf = String.valueOf(cls.getName());
        throw new UnsupportedOperationException(valueOf.length() != 0 ? "No factory is available for message type: ".concat(valueOf) : new String("No factory is available for message type: "));
    }
}
