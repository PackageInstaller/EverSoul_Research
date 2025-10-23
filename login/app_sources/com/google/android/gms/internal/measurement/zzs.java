package com.google.android.gms.internal.measurement;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
public enum zzs {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);

    private final int zzg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzs zza(int i) {
        return i != 2 ? i != 3 ? i != 5 ? i != 6 ? INFO : ERROR : WARN : DEBUG : VERBOSE;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzs(int i) {
        this.zzg = i;
    }
}
