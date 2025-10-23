package com.singular.sdk.internal;

import android.content.Context;
import android.os.Build;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
class OAIDHelper {
    private static final String HUAWEI_ADVERTISING_ID_CLIENT = "com.huawei.hms.ads.identifier.AdvertisingIdClient";
    private static final String HUAWEI_BRAND_NAME = "huawei";
    private static final String IDENTIFIER_LISTENER = "com.bun.miitmdid.core.IIdentifierListener";
    private static final String JLIBRARY = "com.bun.miitmdid.core.JLibrary";
    private static final String MDID_SDK_HELPER = "com.bun.miitmdid.core.MdidSdkHelper";
    private static final String MSA_CORE_PACKAGE_NAME = "com.bun.miitmdid.core";
    private static final int[] MSA_INIT_ERROR_CODES = {1008610, 1008611, 1008612, 1008613, 1008614, 1008615};
    private static final String MSA_PACKAGE_NAME = "com.bun.miitmdid";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    OAIDHelper() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static String getOpenAdvertisingId(Context context) {
        if (isHuawei()) {
            return getHuaweiOAID(context);
        }
        return getMsaOAID(context);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isHuawei() {
        return Build.MANUFACTURER.equalsIgnoreCase(HUAWEI_BRAND_NAME) && getClassForName(HUAWEI_ADVERTISING_ID_CLIENT) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getHuaweiOAID(Context context) {
        try {
            Class classForName = getClassForName(HUAWEI_ADVERTISING_ID_CLIENT);
            if (((Boolean) classForName.getMethod("isAdvertisingIdAvailable", Context.class).invoke(null, context)).booleanValue()) {
                Object invoke = classForName.getMethod("getAdvertisingIdInfo", Context.class).invoke(null, context);
                return (String) invoke.getClass().getDeclaredMethod("getId", new Class[0]).invoke(invoke, new Object[0]);
            }
        } catch (Throwable unused) {
        }
        return null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getMsaOAID(Context context) {
        if (!isMsaOAIDSupported()) {
            return null;
        }
        try {
            final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
            initJLibrary(context);
            Class classForName = getClassForName(IDENTIFIER_LISTENER);
            if (classForName == null || isInitError(initMsaSDK(context, Proxy.newProxyInstance(classForName.getClassLoader(), new Class[]{classForName}, new InvocationHandler() { // from class: com.singular.sdk.internal.OAIDHelper.1
                /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
                @Override // java.lang.reflect.InvocationHandler
                public Object invoke(Object obj, Method method, Object[] objArr) {
                    if (objArr == null || objArr.length <= 1) {
                        linkedBlockingQueue.offer("");
                    }
                    linkedBlockingQueue.offer(OAIDHelper.getOAIDFromSupplier(objArr[1]));
                    return null;
                }
            }), classForName))) {
                return null;
            }
            String str = (String) linkedBlockingQueue.poll(1L, TimeUnit.SECONDS);
            if (Utils.isEmptyOrNull(str)) {
                return null;
            }
            return str;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isMsaOAIDSupported() {
        return getClassForName(MDID_SDK_HELPER) != null;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static Class getClassForName(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void initJLibrary(Context context) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        getClassForName(JLIBRARY).getMethod("InitEntry", Context.class).invoke(null, context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static int initMsaSDK(Context context, Object obj, Class cls) {
        try {
            return ((Integer) getClassForName(MDID_SDK_HELPER).getMethod("InitSdk", Context.class, Boolean.TYPE, cls).invoke(null, context, false, obj)).intValue();
        } catch (Throwable unused) {
            return MSA_INIT_ERROR_CODES[0];
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getOAIDFromSupplier(Object obj) {
        if (obj == null) {
            return "";
        }
        try {
            return (String) obj.getClass().getMethod("getOAID", new Class[0]).invoke(obj, new Object[0]);
        } catch (Throwable unused) {
            return "";
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static boolean isInitError(int i) {
        return Arrays.asList(MSA_INIT_ERROR_CODES).contains(Integer.valueOf(i));
    }
}
