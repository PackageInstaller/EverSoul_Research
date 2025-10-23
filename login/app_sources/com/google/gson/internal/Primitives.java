package com.google.gson.internal;

import java.lang.reflect.Type;

/* loaded from: classes2.dex */
public final class Primitives {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Primitives() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isPrimitive(Type type) {
        return (type instanceof Class) && ((Class) type).isPrimitive();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isWrapperType(Type type) {
        return type == Integer.class || type == Float.class || type == Byte.class || type == Double.class || type == Long.class || type == Character.class || type == Boolean.class || type == Short.class || type == Void.class;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Class<T> wrap(Class<T> cls) {
        return cls == Integer.TYPE ? Integer.class : cls == Float.TYPE ? Float.class : cls == Byte.TYPE ? Byte.class : cls == Double.TYPE ? Double.class : cls == Long.TYPE ? Long.class : cls == Character.TYPE ? Character.class : cls == Boolean.TYPE ? Boolean.class : cls == Short.TYPE ? Short.class : cls == Void.TYPE ? Void.class : cls;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Class<T> unwrap(Class<T> cls) {
        return cls == Integer.class ? Integer.TYPE : cls == Float.class ? Float.TYPE : cls == Byte.class ? Byte.TYPE : cls == Double.class ? Double.TYPE : cls == Long.class ? Long.TYPE : cls == Character.class ? Character.TYPE : cls == Boolean.class ? Boolean.TYPE : cls == Short.class ? Short.TYPE : cls == Void.class ? Void.TYPE : cls;
    }
}
