package com.google.common.reflect;

import com.google.common.base.Preconditions;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public final class Reflection {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageName(Class<?> cls) {
        return getPackageName(cls.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getPackageName(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf < 0 ? "" : str.substring(0, lastIndexOf);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void initialize(Class<?>... clsArr) {
        for (Class<?> cls : clsArr) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
            } catch (ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static <T> T newProxy(Class<T> cls, InvocationHandler invocationHandler) {
        Preconditions.checkNotNull(invocationHandler);
        Preconditions.checkArgument(cls.isInterface(), "%s is not an interface", cls);
        return cls.cast(Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, invocationHandler));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Reflection() {
    }
}
