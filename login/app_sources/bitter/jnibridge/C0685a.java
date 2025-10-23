package bitter.jnibridge;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: bitter.jnibridge.a */
/* loaded from: classes.dex */
final class C0685a implements InvocationHandler {

    /* renamed from: a */
    private Object[] f141a = new Object[0];

    /* renamed from: b */
    private long f142b;

    /* renamed from: c */
    private Constructor f143c;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public C0685a(long j) {
        this.f142b = j;
        try {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            this.f143c = declaredConstructor;
            declaredConstructor.setAccessible(true);
        } catch (NoClassDefFoundError | NoSuchMethodException unused) {
            this.f143c = null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        synchronized (this.f141a) {
            long j = this.f142b;
            if (j == 0) {
                return null;
            }
            try {
                return JNIBridge.invoke(j, method.getDeclaringClass(), method, objArr);
            } catch (NoSuchMethodError e) {
                if (this.f143c == null) {
                    System.err.println("JNIBridge error: Java interface default methods are only supported since Android Oreo");
                    throw e;
                }
                if ((method.getModifiers() & 1024) != 0) {
                    throw e;
                }
                if (objArr == null) {
                    objArr = new Object[0];
                }
                Class<?> declaringClass = method.getDeclaringClass();
                return ((MethodHandles.Lookup) this.f143c.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
            }
        }
    }
}
