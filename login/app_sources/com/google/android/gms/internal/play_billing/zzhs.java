package com.google.android.gms.internal.play_billing;

/* compiled from: com.android.billingclient:billing@@7.1.1 */
/* loaded from: classes2.dex */
public enum zzhs {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(zzgk.class, zzgk.class, zzgk.zzb),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class zzl;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zzhs(Class cls, Class cls2, Object obj) {
        this.zzl = cls2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final Class zza() {
        return this.zzl;
    }
}
