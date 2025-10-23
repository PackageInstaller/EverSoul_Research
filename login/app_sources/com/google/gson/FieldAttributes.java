package com.google.gson;

import com.google.gson.internal.C$Gson$Preconditions;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collection;

/* loaded from: classes2.dex */
public final class FieldAttributes {
    private final Field field;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public FieldAttributes(Field field) {
        C$Gson$Preconditions.checkNotNull(field);
        this.field = field;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Class<?> getDeclaringClass() {
        return this.field.getDeclaringClass();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String getName() {
        return this.field.getName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Type getDeclaredType() {
        return this.field.getGenericType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Class<?> getDeclaredClass() {
        return this.field.getType();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public <T extends Annotation> T getAnnotation(Class<T> cls) {
        return (T) this.field.getAnnotation(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Collection<Annotation> getAnnotations() {
        return Arrays.asList(this.field.getAnnotations());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean hasModifier(int i) {
        return (i & this.field.getModifiers()) != 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    Object get(Object obj) throws IllegalAccessException {
        return this.field.get(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    boolean isSynthetic() {
        return this.field.isSynthetic();
    }
}
