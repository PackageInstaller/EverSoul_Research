package com.google.common.reflect;

import com.google.common.collect.Sets;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.lang.reflect.WildcardType;
import java.util.Set;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class TypeVisitor {
    private final Set<Type> visited = Sets.newHashSet();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void visitClass(Class<?> cls) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void visitGenericArrayType(GenericArrayType genericArrayType) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void visitParameterizedType(ParameterizedType parameterizedType) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void visitTypeVariable(TypeVariable<?> typeVariable) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void visitWildcardType(WildcardType wildcardType) {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    TypeVisitor() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void visit(Type... typeArr) {
        for (Type type : typeArr) {
            if (type != null && this.visited.add(type)) {
                try {
                    if (type instanceof TypeVariable) {
                        visitTypeVariable((TypeVariable) type);
                    } else if (type instanceof WildcardType) {
                        visitWildcardType((WildcardType) type);
                    } else if (type instanceof ParameterizedType) {
                        visitParameterizedType((ParameterizedType) type);
                    } else if (type instanceof Class) {
                        visitClass((Class) type);
                    } else if (type instanceof GenericArrayType) {
                        visitGenericArrayType((GenericArrayType) type);
                    } else {
                        String valueOf = String.valueOf(type);
                        throw new AssertionError(new StringBuilder(String.valueOf(valueOf).length() + 14).append("Unknown type: ").append(valueOf).toString());
                    }
                } catch (Throwable th) {
                    this.visited.remove(type);
                    throw th;
                }
            }
        }
    }
}
