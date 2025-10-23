package org.apache.commons.lang3.reflect;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes2.dex */
abstract class MemberUtils {
    private static final int ACCESS_TEST = 7;
    private static final Class<?>[] ORDERED_PRIMITIVE_TYPES = {Byte.TYPE, Short.TYPE, Character.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE};

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isPackageAccess(int i) {
        return (i & 7) == 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    MemberUtils() {
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean setAccessibleWorkaround(AccessibleObject accessibleObject) {
        if (accessibleObject != 0 && !accessibleObject.isAccessible()) {
            Member member = (Member) accessibleObject;
            if (!accessibleObject.isAccessible() && Modifier.isPublic(member.getModifiers()) && isPackageAccess(member.getDeclaringClass().getModifiers())) {
                try {
                    accessibleObject.setAccessible(true);
                    return true;
                } catch (SecurityException unused) {
                }
            }
        }
        return false;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isAccessible(Member member) {
        return (member == null || !Modifier.isPublic(member.getModifiers()) || member.isSynthetic()) ? false : true;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int compareConstructorFit(Constructor<?> constructor, Constructor<?> constructor2, Class<?>[] clsArr) {
        return compareParameterTypes(Executable.m886of(constructor), Executable.m886of(constructor2), clsArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static int compareMethodFit(Method method, Method method2, Class<?>[] clsArr) {
        return compareParameterTypes(Executable.m887of(method), Executable.m887of(method2), clsArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int compareParameterTypes(Executable executable, Executable executable2, Class<?>[] clsArr) {
        float totalTransformationCost = getTotalTransformationCost(clsArr, executable);
        float totalTransformationCost2 = getTotalTransformationCost(clsArr, executable2);
        if (totalTransformationCost < totalTransformationCost2) {
            return -1;
        }
        return totalTransformationCost2 < totalTransformationCost ? 1 : 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static float getTotalTransformationCost(Class<?>[] clsArr, Executable executable) {
        float objectTransformationCost;
        Class<?>[] parameterTypes = executable.getParameterTypes();
        boolean isVarArgs = executable.isVarArgs();
        int length = parameterTypes.length;
        if (isVarArgs) {
            length--;
        }
        long j = length;
        if (clsArr.length < j) {
            return Float.MAX_VALUE;
        }
        boolean z = false;
        float f = 0.0f;
        for (int i = 0; i < j; i++) {
            f += getObjectTransformationCost(clsArr[i], parameterTypes[i]);
        }
        if (!isVarArgs) {
            return f;
        }
        boolean z2 = clsArr.length < parameterTypes.length;
        if (clsArr.length == parameterTypes.length && clsArr[clsArr.length - 1].isArray()) {
            z = true;
        }
        Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
        if (z2) {
            objectTransformationCost = getObjectTransformationCost(componentType, Object.class);
        } else if (z) {
            objectTransformationCost = getObjectTransformationCost(clsArr[clsArr.length - 1].getComponentType(), componentType);
        } else {
            for (int length2 = parameterTypes.length - 1; length2 < clsArr.length; length2++) {
                f += getObjectTransformationCost(clsArr[length2], componentType) + 0.001f;
            }
            return f;
        }
        return f + objectTransformationCost + 0.001f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static float getObjectTransformationCost(Class<?> cls, Class<?> cls2) {
        if (cls2.isPrimitive()) {
            return getPrimitivePromotionCost(cls, cls2);
        }
        float f = 0.0f;
        while (true) {
            if (cls != null && !cls2.equals(cls)) {
                if (cls2.isInterface() && ClassUtils.isAssignable(cls, cls2)) {
                    f += 0.25f;
                    break;
                }
                f += 1.0f;
                cls = cls.getSuperclass();
            } else {
                break;
            }
        }
        return cls == null ? f + 1.5f : f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static float getPrimitivePromotionCost(Class<?> cls, Class<?> cls2) {
        float f;
        if (cls.isPrimitive()) {
            f = 0.0f;
        } else {
            cls = ClassUtils.wrapperToPrimitive(cls);
            f = 0.1f;
        }
        int i = 0;
        while (cls != cls2) {
            Class<?>[] clsArr = ORDERED_PRIMITIVE_TYPES;
            if (i >= clsArr.length) {
                break;
            }
            if (cls == clsArr[i]) {
                f += 0.1f;
                if (i < clsArr.length - 1) {
                    cls = clsArr[i + 1];
                }
            }
            i++;
        }
        return f;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isMatchingMethod(Method method, Class<?>[] clsArr) {
        return isMatchingExecutable(Executable.m887of(method), clsArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static boolean isMatchingConstructor(Constructor<?> constructor, Class<?>[] clsArr) {
        return isMatchingExecutable(Executable.m886of(constructor), clsArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isMatchingExecutable(Executable executable, Class<?>[] clsArr) {
        Class<?>[] parameterTypes = executable.getParameterTypes();
        if (ClassUtils.isAssignable(clsArr, parameterTypes, true)) {
            return true;
        }
        if (!executable.isVarArgs()) {
            return false;
        }
        int i = 0;
        while (i < parameterTypes.length - 1 && i < clsArr.length) {
            if (!ClassUtils.isAssignable(clsArr[i], parameterTypes[i], true)) {
                return false;
            }
            i++;
        }
        Class<?> componentType = parameterTypes[parameterTypes.length - 1].getComponentType();
        while (i < clsArr.length) {
            if (!ClassUtils.isAssignable(clsArr[i], componentType, true)) {
                return false;
            }
            i++;
        }
        return true;
    }

    private static final class Executable {
        private final boolean isVarArgs;
        private final Class<?>[] parameterTypes;

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: of */
        public static Executable m887of(Method method) {
            return new Executable(method);
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        /* renamed from: of */
        public static Executable m886of(Constructor<?> constructor) {
            return new Executable(constructor);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Executable(Method method) {
            this.parameterTypes = method.getParameterTypes();
            this.isVarArgs = method.isVarArgs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Executable(Constructor<?> constructor) {
            this.parameterTypes = constructor.getParameterTypes();
            this.isVarArgs = constructor.isVarArgs();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public Class<?>[] getParameterTypes() {
            return this.parameterTypes;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public boolean isVarArgs() {
            return this.isVarArgs;
        }
    }
}
