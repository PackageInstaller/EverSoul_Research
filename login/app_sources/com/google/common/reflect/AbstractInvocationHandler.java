package com.google.common.reflect;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
public abstract class AbstractInvocationHandler implements InvocationHandler {
    private static final Object[] NO_ARGS = new Object[0];

    @CheckForNull
    protected abstract Object handleInvocation(Object obj, Method method, Object[] objArr) throws Throwable;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.InvocationHandler
    @CheckForNull
    public final Object invoke(Object obj, Method method, @CheckForNull Object[] objArr) throws Throwable {
        if (objArr == null) {
            objArr = NO_ARGS;
        }
        if (objArr.length == 0 && method.getName().equals("hashCode")) {
            return Integer.valueOf(hashCode());
        }
        if (objArr.length == 1 && method.getName().equals("equals") && method.getParameterTypes()[0] == Object.class) {
            Object obj2 = objArr[0];
            if (obj2 == null) {
                return false;
            }
            if (obj == obj2) {
                return true;
            }
            return Boolean.valueOf(isProxyOfSameInterfaces(obj2, obj.getClass()) && equals(Proxy.getInvocationHandler(obj2)));
        }
        if (objArr.length == 0 && method.getName().equals("toString")) {
            return toString();
        }
        return handleInvocation(obj, method, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean equals(@CheckForNull Object obj) {
        return super.equals(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int hashCode() {
        return super.hashCode();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return super.toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isProxyOfSameInterfaces(Object obj, Class<?> cls) {
        return cls.isInstance(obj) || (Proxy.isProxyClass(obj.getClass()) && Arrays.equals(obj.getClass().getInterfaces(), cls.getInterfaces()));
    }
}
