package com.google.android.gms.internal.drive;

/* loaded from: classes2.dex */
public enum zznr {
    INT(0),
    LONG(0L),
    FLOAT(Float.valueOf(0.0f)),
    DOUBLE(Double.valueOf(0.0d)),
    BOOLEAN(false),
    STRING(""),
    BYTE_STRING(zzjc.zznq),
    ENUM(null),
    MESSAGE(null);

    private final Object zztd;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zznr(Object obj) {
        this.zztd = obj;
    }
}
