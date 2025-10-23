package com.google.android.gms.measurement.internal;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.1 */
/* loaded from: classes2.dex */
enum zzak {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    FAILSAFE('9');

    private final char zzk;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static zzak zza(char c) {
        for (zzak zzakVar : values()) {
            if (zzakVar.zzk == c) {
                return zzakVar;
            }
        }
        return UNSET;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzak(char c) {
        this.zzk = c;
    }
}
