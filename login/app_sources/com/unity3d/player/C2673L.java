package com.unity3d.player;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/* renamed from: com.unity3d.player.L */
/* loaded from: classes3.dex */
final class C2673L implements InvocationHandler {

    /* renamed from: a */
    private Runnable f1185a;

    /* renamed from: b */
    private UnityPlayer f1186b;

    /* renamed from: c */
    private long f1187c;

    /* renamed from: d */
    final /* synthetic */ long f1188d;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    C2673L(UnityPlayer unityPlayer, long j) {
        long j2;
        this.f1188d = j;
        j2 = ReflectionHelper.f1251b;
        this.f1185a = new RunnableC2679O(j2, j);
        this.f1186b = unityPlayer;
        this.f1187c = j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private static Object m735a(Object obj, Method method, Object[] objArr, C2677N c2677n) {
        long j;
        long j2;
        if (objArr == null) {
            try {
                try {
                    objArr = new Object[0];
                } catch (NoClassDefFoundError unused) {
                    AbstractC2768z.Log(6, String.format("Java interface default methods are only supported since Android Oreo", new Object[0]));
                    j2 = c2677n.f1199a;
                    ReflectionHelper.nativeProxyLogJNIInvokeException(j2);
                    c2677n.f1199a = 0L;
                    return null;
                }
            } finally {
                j = c2677n.f1199a;
                if (j != 0) {
                    ReflectionHelper.nativeProxyJNIFreeGCHandle(j);
                }
            }
        }
        Class<?> declaringClass = method.getDeclaringClass();
        Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
        declaredConstructor.setAccessible(true);
        return ((MethodHandles.Lookup) declaredConstructor.newInstance(declaringClass, 2)).in(declaringClass).unreflectSpecial(method, declaringClass).bindTo(obj).invokeWithArguments(objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected void finalize() {
        this.f1186b.queueGLThreadEvent(this.f1185a);
        super.finalize();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.reflect.InvocationHandler
    public final Object invoke(Object obj, Method method, Object[] objArr) {
        Object nativeProxyInvoke;
        boolean z;
        long j;
        if (!ReflectionHelper.beginProxyCall(this.f1187c)) {
            AbstractC2768z.Log(6, "Scripting proxy object was destroyed, because Unity player was unloaded.");
            return null;
        }
        try {
            nativeProxyInvoke = ReflectionHelper.nativeProxyInvoke(this.f1188d, method.getName(), objArr);
            if (!(nativeProxyInvoke instanceof C2677N)) {
                return nativeProxyInvoke;
            }
            C2677N c2677n = (C2677N) nativeProxyInvoke;
            z = c2677n.f1200b;
            if (z && (method.getModifiers() & 1024) == 0) {
                return m735a(obj, method, objArr, c2677n);
            }
            j = c2677n.f1199a;
            ReflectionHelper.nativeProxyLogJNIInvokeException(j);
            return null;
        } finally {
            ReflectionHelper.endProxyCall();
        }
    }
}
