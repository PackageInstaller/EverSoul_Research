package org.apache.commons.lang3.reflect;

import com.liapp.y;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.ClassUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class ConstructorUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T invokeConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return (T) invokeConstructor(cls, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T invokeConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Constructor matchingAccessibleConstructor = getMatchingAccessibleConstructor(cls, ArrayUtils.nullToEmpty(clsArr));
        if (matchingAccessibleConstructor == null) {
            throw new NoSuchMethodException(y.֬ڱܱײٮ(-1159684111) + cls.getName());
        }
        if (matchingAccessibleConstructor.isVarArgs()) {
            nullToEmpty = MethodUtils.getVarArgs(nullToEmpty, matchingAccessibleConstructor.getParameterTypes());
        }
        return (T) matchingAccessibleConstructor.newInstance(nullToEmpty);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T invokeExactConstructor(Class<T> cls, Object... objArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        return (T) invokeExactConstructor(cls, nullToEmpty, ClassUtils.toClass(nullToEmpty));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T invokeExactConstructor(Class<T> cls, Object[] objArr, Class<?>[] clsArr) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Object[] nullToEmpty = ArrayUtils.nullToEmpty(objArr);
        Constructor accessibleConstructor = getAccessibleConstructor(cls, ArrayUtils.nullToEmpty(clsArr));
        if (accessibleConstructor == null) {
            throw new NoSuchMethodException(y.֬ڱܱײٮ(-1159684111) + cls.getName());
        }
        return (T) accessibleConstructor.newInstance(nullToEmpty);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Constructor<T> getAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        Validate.notNull(cls, y.ݮڮֲڭܩ(-628820628), new Object[0]);
        try {
            return getAccessibleConstructor(cls.getConstructor(clsArr));
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Constructor<T> getAccessibleConstructor(Constructor<T> constructor) {
        Validate.notNull(constructor, y.֬ڱܱײٮ(-1159684911), new Object[0]);
        if (MemberUtils.isAccessible(constructor) && isAccessible(constructor.getDeclaringClass())) {
            return constructor;
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> Constructor<T> getMatchingAccessibleConstructor(Class<T> cls, Class<?>... clsArr) {
        Constructor<T> accessibleConstructor;
        Validate.notNull(cls, y.ݮڮֲڭܩ(-628820628), new Object[0]);
        try {
            Constructor<T> constructor = cls.getConstructor(clsArr);
            MemberUtils.setAccessibleWorkaround(constructor);
            return constructor;
        } catch (NoSuchMethodException unused) {
            Constructor<T> constructor2 = null;
            for (Constructor<?> constructor3 : cls.getConstructors()) {
                if (MemberUtils.isMatchingConstructor(constructor3, clsArr) && (accessibleConstructor = getAccessibleConstructor(constructor3)) != null) {
                    MemberUtils.setAccessibleWorkaround(accessibleConstructor);
                    if (constructor2 == null || MemberUtils.compareConstructorFit(accessibleConstructor, constructor2, clsArr) < 0) {
                        constructor2 = accessibleConstructor;
                    }
                }
            }
            return constructor2;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isAccessible(Class<?> cls) {
        while (cls != null) {
            if (!Modifier.isPublic(cls.getModifiers())) {
                return false;
            }
            cls = cls.getEnclosingClass();
        }
        return true;
    }
}
