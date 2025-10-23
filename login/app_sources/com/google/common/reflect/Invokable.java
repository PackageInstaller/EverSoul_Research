package com.google.common.reflect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import java.lang.annotation.Annotation;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class Invokable<T, R> implements AnnotatedElement, Member {
    private final AccessibleObject accessibleObject;
    private final Member member;

    abstract Type[] getGenericExceptionTypes();

    abstract Type[] getGenericParameterTypes();

    abstract Type getGenericReturnType();

    abstract Annotation[][] getParameterAnnotations();

    public abstract TypeVariable<?>[] getTypeParameters();

    @CheckForNull
    abstract Object invokeInternal(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException;

    public abstract boolean isOverridable();

    public abstract boolean isVarArgs();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    <M extends AccessibleObject & Member> Invokable(M m) {
        Preconditions.checkNotNull(m);
        this.accessibleObject = m;
        this.member = m;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Invokable<?, Object> from(Method method) {
        return new MethodInvokable(method);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Invokable<T, T> from(Constructor<T> constructor) {
        return new ConstructorInvokable(constructor);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.AnnotatedElement
    public final boolean isAnnotationPresent(Class<? extends Annotation> cls) {
        return this.accessibleObject.isAnnotationPresent(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.AnnotatedElement
    @CheckForNull
    public final <A extends Annotation> A getAnnotation(Class<A> cls) {
        return (A) this.accessibleObject.getAnnotation(cls);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getAnnotations() {
        return this.accessibleObject.getAnnotations();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.AnnotatedElement
    public final Annotation[] getDeclaredAnnotations() {
        return this.accessibleObject.getDeclaredAnnotations();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final void setAccessible(boolean z) {
        this.accessibleObject.setAccessible(z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean trySetAccessible() {
        try {
            this.accessibleObject.setAccessible(true);
            return true;
        } catch (RuntimeException unused) {
            return false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAccessible() {
        return this.accessibleObject.isAccessible();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.Member
    public final String getName() {
        return this.member.getName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.Member
    public final int getModifiers() {
        return this.member.getModifiers();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.Member
    public final boolean isSynthetic() {
        return this.member.isSynthetic();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPublic() {
        return Modifier.isPublic(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isProtected() {
        return Modifier.isProtected(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPackagePrivate() {
        return (isPrivate() || isPublic() || isProtected()) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isPrivate() {
        return Modifier.isPrivate(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isStatic() {
        return Modifier.isStatic(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isFinal() {
        return Modifier.isFinal(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isAbstract() {
        return Modifier.isAbstract(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isNative() {
        return Modifier.isNative(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final boolean isSynchronized() {
        return Modifier.isSynchronized(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean isVolatile() {
        return Modifier.isVolatile(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final boolean isTransient() {
        return Modifier.isTransient(getModifiers());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(@CheckForNull Object obj) {
        if (!(obj instanceof Invokable)) {
            return false;
        }
        Invokable invokable = (Invokable) obj;
        return getOwnerType().equals(invokable.getOwnerType()) && this.member.equals(invokable.member);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return this.member.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return this.member.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @CheckForNull
    public final R invoke(@CheckForNull T t, Object... objArr) throws InvocationTargetException, IllegalAccessException {
        return (R) invokeInternal(t, (Object[]) Preconditions.checkNotNull(objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final TypeToken<? extends R> getReturnType() {
        return (TypeToken<? extends R>) TypeToken.m369of(getGenericReturnType());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImmutableList<Parameter> getParameters() {
        Type[] genericParameterTypes = getGenericParameterTypes();
        Annotation[][] parameterAnnotations = getParameterAnnotations();
        ImmutableList.Builder builder = ImmutableList.builder();
        for (int i = 0; i < genericParameterTypes.length; i++) {
            builder.add((ImmutableList.Builder) new Parameter(this, i, TypeToken.m369of(genericParameterTypes[i]), parameterAnnotations[i]));
        }
        return builder.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final ImmutableList<TypeToken<? extends Throwable>> getExceptionTypes() {
        ImmutableList.Builder builder = ImmutableList.builder();
        for (Type type : getGenericExceptionTypes()) {
            builder.add((ImmutableList.Builder) TypeToken.m369of(type));
        }
        return builder.build();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <R1 extends R> Invokable<T, R1> returning(Class<R1> cls) {
        return returning(TypeToken.m368of((Class) cls));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final <R1 extends R> Invokable<T, R1> returning(TypeToken<R1> typeToken) {
        if (typeToken.isSupertypeOf(getReturnType())) {
            return this;
        }
        String valueOf = String.valueOf(getReturnType());
        String valueOf2 = String.valueOf(typeToken);
        throw new IllegalArgumentException(new StringBuilder(String.valueOf(valueOf).length() + 35 + String.valueOf(valueOf2).length()).append("Invokable is known to return ").append(valueOf).append(", not ").append(valueOf2).toString());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.Member
    public final Class<? super T> getDeclaringClass() {
        return (Class<? super T>) this.member.getDeclaringClass();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TypeToken<T> getOwnerType() {
        return TypeToken.m368of((Class) getDeclaringClass());
    }

    static class MethodInvokable<T> extends Invokable<T, Object> {
        final Method method;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MethodInvokable(Method method) {
            super(method);
            this.method = method;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        @CheckForNull
        final Object invokeInternal(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            return this.method.invoke(obj, objArr);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        Type getGenericReturnType() {
            return this.method.getGenericReturnType();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        Type[] getGenericParameterTypes() {
            return this.method.getGenericParameterTypes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        Type[] getGenericExceptionTypes() {
            return this.method.getGenericExceptionTypes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        final Annotation[][] getParameterAnnotations() {
            return this.method.getParameterAnnotations();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        public final TypeVariable<?>[] getTypeParameters() {
            return this.method.getTypeParameters();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return (isFinal() || isPrivate() || isStatic() || Modifier.isFinal(getDeclaringClass().getModifiers())) ? false : true;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.method.isVarArgs();
        }
    }

    static class ConstructorInvokable<T> extends Invokable<T, T> {
        final Constructor<?> constructor;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        public final boolean isOverridable() {
            return false;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        ConstructorInvokable(Constructor<?> constructor) {
            super(constructor);
            this.constructor = constructor;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        final Object invokeInternal(@CheckForNull Object obj, Object[] objArr) throws InvocationTargetException, IllegalAccessException {
            try {
                return this.constructor.newInstance(objArr);
            } catch (InstantiationException e) {
                String valueOf = String.valueOf(this.constructor);
                throw new RuntimeException(new StringBuilder(String.valueOf(valueOf).length() + 8).append(valueOf).append(" failed.").toString(), e);
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        Type getGenericReturnType() {
            Class<? super T> declaringClass = getDeclaringClass();
            TypeVariable<Class<? super T>>[] typeParameters = declaringClass.getTypeParameters();
            return typeParameters.length > 0 ? Types.newParameterizedType(declaringClass, typeParameters) : declaringClass;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        Type[] getGenericParameterTypes() {
            Type[] genericParameterTypes = this.constructor.getGenericParameterTypes();
            if (genericParameterTypes.length <= 0 || !mayNeedHiddenThis()) {
                return genericParameterTypes;
            }
            Class<?>[] parameterTypes = this.constructor.getParameterTypes();
            return (genericParameterTypes.length == parameterTypes.length && parameterTypes[0] == getDeclaringClass().getEnclosingClass()) ? (Type[]) Arrays.copyOfRange(genericParameterTypes, 1, genericParameterTypes.length) : genericParameterTypes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        Type[] getGenericExceptionTypes() {
            return this.constructor.getGenericExceptionTypes();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        final Annotation[][] getParameterAnnotations() {
            return this.constructor.getParameterAnnotations();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        public final TypeVariable<?>[] getTypeParameters() {
            TypeVariable<Class<? super T>>[] typeParameters = getDeclaringClass().getTypeParameters();
            TypeVariable<Constructor<?>>[] typeParameters2 = this.constructor.getTypeParameters();
            TypeVariable<?>[] typeVariableArr = new TypeVariable[typeParameters.length + typeParameters2.length];
            System.arraycopy(typeParameters, 0, typeVariableArr, 0, typeParameters.length);
            System.arraycopy(typeParameters2, 0, typeVariableArr, typeParameters.length, typeParameters2.length);
            return typeVariableArr;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // com.google.common.reflect.Invokable
        public final boolean isVarArgs() {
            return this.constructor.isVarArgs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private boolean mayNeedHiddenThis() {
            Class<?> declaringClass = this.constructor.getDeclaringClass();
            if (declaringClass.getEnclosingConstructor() != null) {
                return true;
            }
            if (declaringClass.getEnclosingMethod() != null) {
                return !Modifier.isStatic(r1.getModifiers());
            }
            return (declaringClass.getEnclosingClass() == null || Modifier.isStatic(declaringClass.getModifiers())) ? false : true;
        }
    }
}
