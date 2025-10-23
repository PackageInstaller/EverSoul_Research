package bitter.jnibridge;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/* loaded from: classes.dex */
public class JNIBridge {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static void disableInterfaceProxy(Object obj) {
        Object[] objArr;
        if (obj != null) {
            C0685a c0685a = (C0685a) Proxy.getInvocationHandler(obj);
            objArr = c0685a.f141a;
            synchronized (objArr) {
                c0685a.f142b = 0L;
            }
        }
    }

    static native Object invoke(long j, Class cls, Method method, Object[] objArr);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object newInterfaceProxy(long j, Class[] clsArr) {
        return Proxy.newProxyInstance(JNIBridge.class.getClassLoader(), clsArr, new C0685a(j));
    }
}
