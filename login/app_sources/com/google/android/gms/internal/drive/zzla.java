package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
abstract class zzla {
    private static final zzla zztm;
    private static final zzla zztn;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private zzla() {
    }

    abstract void zza(Object obj, long j);

    abstract <L> void zza(Object obj, Object obj2, long j);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzla zzdt() {
        return zztm;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static zzla zzdu() {
        return zztn;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zzlb zzlbVar = null;
        zztm = new zzlc();
        zztn = new zzld();
    }
}
