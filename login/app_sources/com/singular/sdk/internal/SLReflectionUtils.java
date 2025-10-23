package com.singular.sdk.internal;

import android.content.res.Configuration;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Locale;

/* loaded from: classes3.dex */
public class SLReflectionUtils {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String[] getSupportedAbis() {
        try {
            return (String[]) readField("android.os.Build", "SUPPORTED_ABIS");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getCpuAbi() {
        try {
            return (String) readField("android.os.Build", "CPU_ABI");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Locale getLocaleFromLocaleList(Configuration configuration) {
        try {
            Object invokeInstanceMethod = invokeInstanceMethod(configuration, "getLocales", null, new Object[0]);
            if (invokeInstanceMethod == null) {
                return null;
            }
            return (Locale) invokeInstanceMethod(invokeInstanceMethod, "get", new Class[]{Integer.TYPE}, 0);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Locale getLocaleFromField(Configuration configuration) {
        try {
            return (Locale) readField("android.content.res.Configuration", "locale", configuration);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object invokeInstanceMethod(Object obj, String str, Class[] clsArr, Object... objArr) throws Exception {
        return invokeMethod(obj.getClass(), str, obj, clsArr, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object invokeStaticMethod(String str, String str2, Class[] clsArr, Object... objArr) throws Exception {
        return invokeMethod(Class.forName(str), str2, null, clsArr, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object invokeMethod(Class cls, String str, Object obj, Class[] clsArr, Object... objArr) throws Exception {
        Method method = cls.getMethod(str, clsArr);
        if (method == null) {
            return null;
        }
        return method.invoke(obj, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Object createInstance(String str, Class[] clsArr, Object... objArr) {
        try {
            return Class.forName(str).getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object readField(String str, String str2) throws Exception {
        return readField(str, str2, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Object readField(String str, String str2, Object obj) throws Exception {
        Field field;
        Class forName = forName(str);
        if (forName == null || (field = forName.getField(str2)) == null) {
            return null;
        }
        return field.get(obj);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static Class forName(String str) {
        try {
            return Class.forName(str);
        } catch (Throwable unused) {
            return null;
        }
    }
}
