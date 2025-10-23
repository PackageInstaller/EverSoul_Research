package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class TypeCapture<T> {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TypeCapture() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final Type capture() {
        Type genericSuperclass = getClass().getGenericSuperclass();
        Preconditions.checkArgument(genericSuperclass instanceof ParameterizedType, "%s isn't parameterized", genericSuperclass);
        return ((ParameterizedType) genericSuperclass).getActualTypeArguments()[0];
    }
}
