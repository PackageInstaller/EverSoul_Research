package com.unity3d.player;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.singular.sdk.internal.Constants;
import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.commons.lang3.ClassUtils;

/* loaded from: classes3.dex */
final class ReflectionHelper {
    protected static boolean LOG;
    protected static final boolean LOGV = false;

    /* renamed from: a */
    private static C2675M[] f1250a = new C2675M[4096];

    /* renamed from: b */
    private static long f1251b;

    /* renamed from: c */
    private static long f1252c;

    /* renamed from: d */
    private static boolean f1253d;

    /* JADX WARN: Code restructure failed: missing block: B:56:0x0075, code lost:
    
        if (r12.asSubclass(r11) != null) goto L46;
     */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static float m742a(java.lang.Class r11, java.lang.Class[] r12, java.lang.Class[] r13) {
        /*
            int r0 = r13.length
            r1 = 1036831949(0x3dcccccd, float:0.1)
            if (r0 != 0) goto L7
            return r1
        L7:
            r0 = 0
            if (r12 != 0) goto Lc
            r2 = r0
            goto Ld
        Lc:
            int r2 = r12.length
        Ld:
            int r2 = r2 + 1
            int r3 = r13.length
            r4 = 0
            if (r2 == r3) goto L14
            return r4
        L14:
            r2 = 1056964608(0x3f000000, float:0.5)
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r12 == 0) goto L4f
            int r5 = r12.length
            r6 = r0
            r7 = r3
        L1d:
            if (r0 >= r5) goto L50
            r8 = r12[r0]
            int r9 = r6 + 1
            r6 = r13[r6]
            boolean r10 = r8.equals(r6)
            if (r10 == 0) goto L2d
            r6 = r3
            goto L4a
        L2d:
            boolean r10 = r8.isPrimitive()
            if (r10 != 0) goto L49
            boolean r10 = r6.isPrimitive()
            if (r10 != 0) goto L49
            java.lang.Class r10 = r8.asSubclass(r6)     // Catch: java.lang.ClassCastException -> L41
            if (r10 == 0) goto L41
            r6 = r2
            goto L4a
        L41:
            java.lang.Class r6 = r6.asSubclass(r8)     // Catch: java.lang.ClassCastException -> L49
            if (r6 == 0) goto L49
            r6 = r1
            goto L4a
        L49:
            r6 = r4
        L4a:
            float r7 = r7 * r6
            int r0 = r0 + 1
            r6 = r9
            goto L1d
        L4f:
            r7 = r3
        L50:
            int r12 = r13.length
            int r12 = r12 + (-1)
            r12 = r13[r12]
            boolean r13 = r11.equals(r12)
            if (r13 == 0) goto L5d
            r1 = r3
            goto L79
        L5d:
            boolean r13 = r11.isPrimitive()
            if (r13 != 0) goto L78
            boolean r13 = r12.isPrimitive()
            if (r13 != 0) goto L78
            java.lang.Class r13 = r11.asSubclass(r12)     // Catch: java.lang.ClassCastException -> L71
            if (r13 == 0) goto L71
            r1 = r2
            goto L79
        L71:
            java.lang.Class r11 = r12.asSubclass(r11)     // Catch: java.lang.ClassCastException -> L78
            if (r11 == 0) goto L78
            goto L79
        L78:
            r1 = r4
        L79:
            float r7 = r7 * r1
            return r7
            fill-array 0x007c: FILL_ARRAY_DATA , data: ?
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unity3d.player.ReflectionHelper.m742a(java.lang.Class, java.lang.Class[], java.lang.Class[]):float");
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private static Class m743a(String str, int[] iArr) {
        while (iArr[0] < str.length()) {
            int i = iArr[0];
            iArr[0] = i + 1;
            char charAt = str.charAt(i);
            if (charAt != '(' && charAt != ')') {
                if (charAt == 'L') {
                    int indexOf = str.indexOf(59, iArr[0]);
                    if (indexOf == -1) {
                        return null;
                    }
                    String substring = str.substring(iArr[0], indexOf);
                    iArr[0] = indexOf + 1;
                    try {
                        return Class.forName(substring.replace('/', ClassUtils.PACKAGE_SEPARATOR_CHAR));
                    } catch (ClassNotFoundException unused) {
                        return null;
                    }
                }
                if (charAt == 'Z') {
                    return Boolean.TYPE;
                }
                if (charAt == 'I') {
                    return Integer.TYPE;
                }
                if (charAt == 'F') {
                    return Float.TYPE;
                }
                if (charAt == 'V') {
                    return Void.TYPE;
                }
                if (charAt == 'B') {
                    return Byte.TYPE;
                }
                if (charAt == 'C') {
                    return Character.TYPE;
                }
                if (charAt == 'S') {
                    return Short.TYPE;
                }
                if (charAt == 'J') {
                    return Long.TYPE;
                }
                if (charAt == 'D') {
                    return Double.TYPE;
                }
                if (charAt == '[') {
                    return Array.newInstance((Class<?>) m743a(str, iArr), 0).getClass();
                }
                AbstractC2768z.Log(5, "! parseType; " + charAt + " is not known!");
                return null;
            }
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private static synchronized boolean m744a(C2675M c2675m) {
        int i;
        synchronized (ReflectionHelper.class) {
            C2675M[] c2675mArr = f1250a;
            i = c2675m.f1196d;
            C2675M c2675m2 = c2675mArr[i & 4095];
            if (!c2675m.equals(c2675m2)) {
                return false;
            }
            c2675m.f1197e = c2675m2.f1197e;
            return true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: a */
    private static Class[] m745a(String str) {
        Class m743a;
        int i = 0;
        int[] iArr = {0};
        ArrayList arrayList = new ArrayList();
        while (iArr[0] < str.length() && (m743a = m743a(str, iArr)) != null) {
            arrayList.add(m743a);
        }
        Class[] clsArr = new Class[arrayList.size()];
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            clsArr[i] = (Class) it.next();
            i++;
        }
        return clsArr;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static synchronized boolean beginProxyCall(long j) {
        synchronized (ReflectionHelper.class) {
            if (j != f1251b) {
                return false;
            }
            f1252c++;
            return true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Object createInvocationError(long j, boolean z) {
        return new C2677N(j, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static synchronized void endProxyCall() {
        synchronized (ReflectionHelper.class) {
            long j = f1252c - 1;
            f1252c = j;
            if (0 == j && f1253d) {
                ReflectionHelper.class.notifyAll();
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static synchronized void endUnityLaunch() {
        synchronized (ReflectionHelper.class) {
            try {
                f1251b++;
                f1253d = true;
                while (f1252c > 0) {
                    ReflectionHelper.class.wait();
                }
            } catch (InterruptedException unused) {
                AbstractC2768z.Log(6, "Interrupted while waiting for all proxies to exit.");
            }
            f1253d = false;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Constructor getConstructorID(Class cls, String str) {
        int i;
        Constructor<?> constructor;
        C2675M c2675m = new C2675M(cls, "", str);
        if (m744a(c2675m)) {
            constructor = (Constructor) c2675m.f1197e;
        } else {
            Class[] m745a = m745a(str);
            Constructor<?>[] constructors = cls.getConstructors();
            int length = constructors.length;
            Constructor<?> constructor2 = null;
            float f = 0.0f;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                Constructor<?> constructor3 = constructors[i2];
                float m742a = m742a(Void.TYPE, constructor3.getParameterTypes(), m745a);
                if (m742a > f) {
                    if (m742a == 1.0f) {
                        constructor2 = constructor3;
                        break;
                    }
                    constructor2 = constructor3;
                    f = m742a;
                }
                i2++;
            }
            synchronized (ReflectionHelper.class) {
                c2675m.f1197e = constructor2;
                C2675M[] c2675mArr = f1250a;
                i = c2675m.f1196d;
                c2675mArr[i & 4095] = c2675m;
            }
            constructor = constructor2;
        }
        if (constructor != null) {
            return constructor;
        }
        throw new NoSuchMethodError("<init>" + str + " in class " + cls.getName());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Field getFieldID(Class cls, String str, String str2, boolean z) {
        int i;
        Field field;
        Class cls2 = cls;
        C2675M c2675m = new C2675M(cls2, str, str2);
        if (m744a(c2675m)) {
            field = (Field) c2675m.f1197e;
        } else {
            Class[] m745a = m745a(str2);
            float f = 0.0f;
            Field field2 = null;
            while (cls2 != null) {
                Field[] declaredFields = cls2.getDeclaredFields();
                int length = declaredFields.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Field field3 = declaredFields[i2];
                    if (z == Modifier.isStatic(field3.getModifiers()) && field3.getName().compareTo(str) == 0) {
                        float m742a = m742a(field3.getType(), null, m745a);
                        if (m742a > f) {
                            field2 = field3;
                            if (m742a == 1.0f) {
                                f = m742a;
                                break;
                            }
                            f = m742a;
                        } else {
                            continue;
                        }
                    }
                    i2++;
                }
                if (f == 1.0f || cls2.isPrimitive() || cls2.isInterface() || cls2.equals(Object.class) || cls2.equals(Void.TYPE)) {
                    break;
                }
                cls2 = cls2.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                c2675m.f1197e = field2;
                C2675M[] c2675mArr = f1250a;
                i = c2675m.f1196d;
                c2675mArr[i & 4095] = c2675m;
            }
            field = field2;
        }
        if (field != null) {
            return field;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls2.getName();
        throw new NoSuchFieldError(String.format("no %s field with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static String getFieldSignature(Field field) {
        Class<?> type = field.getType();
        if (!type.isPrimitive()) {
            return type.isArray() ? type.getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') : "L" + type.getName().replace(ClassUtils.PACKAGE_SEPARATOR_CHAR, '/') + ";";
        }
        String name = type.getName();
        return TypedValues.Custom.S_BOOLEAN.equals(name) ? "Z" : "byte".equals(name) ? "B" : "char".equals(name) ? "C" : "double".equals(name) ? "D" : TypedValues.Custom.S_FLOAT.equals(name) ? "F" : "int".equals(name) ? "I" : Constants.LONG.equals(name) ? "J" : "short".equals(name) ? "S" : name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Method getMethodID(Class cls, String str, String str2, boolean z) {
        int i;
        Method method;
        C2675M c2675m = new C2675M(cls, str, str2);
        if (m744a(c2675m)) {
            method = (Method) c2675m.f1197e;
        } else {
            Class[] m745a = m745a(str2);
            Method method2 = null;
            float f = 0.0f;
            while (cls != null) {
                Method[] declaredMethods = cls.getDeclaredMethods();
                int length = declaredMethods.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    Method method3 = declaredMethods[i2];
                    if (z == Modifier.isStatic(method3.getModifiers()) && method3.getName().compareTo(str) == 0) {
                        float m742a = m742a(method3.getReturnType(), method3.getParameterTypes(), m745a);
                        if (m742a <= f) {
                            continue;
                        } else {
                            if (m742a == 1.0f) {
                                method2 = method3;
                                f = m742a;
                                break;
                            }
                            method2 = method3;
                            f = m742a;
                        }
                    }
                    i2++;
                }
                if (f == 1.0f || cls.isPrimitive() || cls.isInterface() || cls.equals(Object.class) || cls.equals(Void.TYPE)) {
                    break;
                }
                cls = cls.getSuperclass();
            }
            synchronized (ReflectionHelper.class) {
                c2675m.f1197e = method2;
                C2675M[] c2675mArr = f1250a;
                i = c2675m.f1196d;
                c2675mArr[i & 4095] = c2675m;
            }
            method = method2;
        }
        if (method != null) {
            return method;
        }
        Object[] objArr = new Object[4];
        objArr[0] = z ? "static" : "non-static";
        objArr[1] = str;
        objArr[2] = str2;
        objArr[3] = cls.getName();
        throw new NoSuchMethodError(String.format("no %s method with name='%s' signature='%s' in class L%s;", objArr));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyFinalize(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native Object nativeProxyInvoke(long j, String str, Object[] objArr);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyJNIFreeGCHandle(long j);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void nativeProxyLogJNIInvokeException(long j);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j, Class cls) {
        return newProxyInstance(unityPlayer, j, new Class[]{cls});
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected static Object newProxyInstance(UnityPlayer unityPlayer, long j, Class[] clsArr) {
        return Proxy.newProxyInstance(ReflectionHelper.class.getClassLoader(), clsArr, new C2673L(unityPlayer, j));
    }
}
