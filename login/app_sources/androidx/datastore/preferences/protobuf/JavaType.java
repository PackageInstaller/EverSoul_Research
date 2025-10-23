package androidx.datastore.preferences.protobuf;

/* loaded from: classes.dex */
public enum JavaType {
    VOID(Void.class, Void.class, null),
    INT(Integer.TYPE, Integer.class, 0),
    LONG(Long.TYPE, Long.class, 0L),
    FLOAT(Float.TYPE, Float.class, Float.valueOf(0.0f)),
    DOUBLE(Double.TYPE, Double.class, Double.valueOf(0.0d)),
    BOOLEAN(Boolean.TYPE, Boolean.class, false),
    STRING(String.class, String.class, ""),
    BYTE_STRING(ByteString.class, ByteString.class, ByteString.EMPTY),
    ENUM(Integer.TYPE, Integer.class, null),
    MESSAGE(Object.class, Object.class, null);

    private final Class<?> boxedType;
    private final Object defaultDefault;
    private final Class<?> type;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    JavaType(Class cls, Class cls2, Object obj) {
        this.type = cls;
        this.boxedType = cls2;
        this.defaultDefault = obj;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Object getDefaultDefault() {
        return this.defaultDefault;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Class<?> getType() {
        return this.type;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Class<?> getBoxedType() {
        return this.boxedType;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isValidType(Class<?> cls) {
        return this.type.isAssignableFrom(cls);
    }
}
