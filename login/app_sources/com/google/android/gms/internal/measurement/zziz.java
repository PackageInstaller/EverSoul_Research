package com.google.android.gms.internal.measurement;

import java.lang.reflect.Type;

/* compiled from: com.google.android.gms:play-services-measurement-base@@21.5.1 */
/* loaded from: classes2.dex */
public enum zziz {
    DOUBLE(0, zzjb.SCALAR, zzjs.DOUBLE),
    FLOAT(1, zzjb.SCALAR, zzjs.FLOAT),
    INT64(2, zzjb.SCALAR, zzjs.LONG),
    UINT64(3, zzjb.SCALAR, zzjs.LONG),
    INT32(4, zzjb.SCALAR, zzjs.INT),
    FIXED64(5, zzjb.SCALAR, zzjs.LONG),
    FIXED32(6, zzjb.SCALAR, zzjs.INT),
    BOOL(7, zzjb.SCALAR, zzjs.BOOLEAN),
    STRING(8, zzjb.SCALAR, zzjs.STRING),
    MESSAGE(9, zzjb.SCALAR, zzjs.MESSAGE),
    BYTES(10, zzjb.SCALAR, zzjs.BYTE_STRING),
    UINT32(11, zzjb.SCALAR, zzjs.INT),
    ENUM(12, zzjb.SCALAR, zzjs.ENUM),
    SFIXED32(13, zzjb.SCALAR, zzjs.INT),
    SFIXED64(14, zzjb.SCALAR, zzjs.LONG),
    SINT32(15, zzjb.SCALAR, zzjs.INT),
    SINT64(16, zzjb.SCALAR, zzjs.LONG),
    GROUP(17, zzjb.SCALAR, zzjs.MESSAGE),
    DOUBLE_LIST(18, zzjb.VECTOR, zzjs.DOUBLE),
    FLOAT_LIST(19, zzjb.VECTOR, zzjs.FLOAT),
    INT64_LIST(20, zzjb.VECTOR, zzjs.LONG),
    UINT64_LIST(21, zzjb.VECTOR, zzjs.LONG),
    INT32_LIST(22, zzjb.VECTOR, zzjs.INT),
    FIXED64_LIST(23, zzjb.VECTOR, zzjs.LONG),
    FIXED32_LIST(24, zzjb.VECTOR, zzjs.INT),
    BOOL_LIST(25, zzjb.VECTOR, zzjs.BOOLEAN),
    STRING_LIST(26, zzjb.VECTOR, zzjs.STRING),
    MESSAGE_LIST(27, zzjb.VECTOR, zzjs.MESSAGE),
    BYTES_LIST(28, zzjb.VECTOR, zzjs.BYTE_STRING),
    UINT32_LIST(29, zzjb.VECTOR, zzjs.INT),
    ENUM_LIST(30, zzjb.VECTOR, zzjs.ENUM),
    SFIXED32_LIST(31, zzjb.VECTOR, zzjs.INT),
    SFIXED64_LIST(32, zzjb.VECTOR, zzjs.LONG),
    SINT32_LIST(33, zzjb.VECTOR, zzjs.INT),
    SINT64_LIST(34, zzjb.VECTOR, zzjs.LONG),
    DOUBLE_LIST_PACKED(35, zzjb.PACKED_VECTOR, zzjs.DOUBLE),
    FLOAT_LIST_PACKED(36, zzjb.PACKED_VECTOR, zzjs.FLOAT),
    INT64_LIST_PACKED(37, zzjb.PACKED_VECTOR, zzjs.LONG),
    UINT64_LIST_PACKED(38, zzjb.PACKED_VECTOR, zzjs.LONG),
    INT32_LIST_PACKED(39, zzjb.PACKED_VECTOR, zzjs.INT),
    FIXED64_LIST_PACKED(40, zzjb.PACKED_VECTOR, zzjs.LONG),
    FIXED32_LIST_PACKED(41, zzjb.PACKED_VECTOR, zzjs.INT),
    BOOL_LIST_PACKED(42, zzjb.PACKED_VECTOR, zzjs.BOOLEAN),
    UINT32_LIST_PACKED(43, zzjb.PACKED_VECTOR, zzjs.INT),
    ENUM_LIST_PACKED(44, zzjb.PACKED_VECTOR, zzjs.ENUM),
    SFIXED32_LIST_PACKED(45, zzjb.PACKED_VECTOR, zzjs.INT),
    SFIXED64_LIST_PACKED(46, zzjb.PACKED_VECTOR, zzjs.LONG),
    SINT32_LIST_PACKED(47, zzjb.PACKED_VECTOR, zzjs.INT),
    SINT64_LIST_PACKED(48, zzjb.PACKED_VECTOR, zzjs.LONG),
    GROUP_LIST(49, zzjb.VECTOR, zzjs.MESSAGE),
    MAP(50, zzjb.MAP, zzjs.VOID);

    private static final zziz[] zzaz;
    private static final Type[] zzba = new Type[0];
    private final zzjs zzbc;
    private final int zzbd;
    private final zzjb zzbe;
    private final Class<?> zzbf;
    private final boolean zzbg;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final int zza() {
        return this.zzbd;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        zziz[] values = values();
        zzaz = new zziz[values.length];
        for (zziz zzizVar : values) {
            zzaz[zzizVar.zzbd] = zzizVar;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    zziz(int i, zzjb zzjbVar, zzjs zzjsVar) {
        int i2;
        this.zzbd = i;
        this.zzbe = zzjbVar;
        this.zzbc = zzjsVar;
        int ordinal = zzjbVar.ordinal();
        if (ordinal == 1) {
            this.zzbf = zzjsVar.zza();
        } else if (ordinal == 3) {
            this.zzbf = zzjsVar.zza();
        } else {
            this.zzbf = null;
        }
        this.zzbg = (zzjbVar != zzjb.SCALAR || (i2 = zzjc.zza[zzjsVar.ordinal()]) == 1 || i2 == 2 || i2 == 3) ? false : true;
    }
}
