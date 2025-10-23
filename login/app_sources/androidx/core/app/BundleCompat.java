package androidx.core.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class BundleCompat {

    static class BeforeApi18Impl {
        private static final String TAG = "BundleCompatBaseImpl";
        private static Method sGetIBinderMethod;
        private static boolean sGetIBinderMethodFetched;
        private static Method sPutIBinderMethod;
        private static boolean sPutIBinderMethodFetched;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private BeforeApi18Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static IBinder getBinder(Bundle bundle, String str) {
            if (!sGetIBinderMethodFetched) {
                try {
                    Method method = Bundle.class.getMethod("getIBinder", String.class);
                    sGetIBinderMethod = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i(TAG, "Failed to retrieve getIBinder method", e);
                }
                sGetIBinderMethodFetched = true;
            }
            Method method2 = sGetIBinderMethod;
            if (method2 != null) {
                try {
                    return (IBinder) method2.invoke(bundle, str);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i(TAG, "Failed to invoke getIBinder via reflection", e2);
                    sGetIBinderMethod = null;
                }
            }
            return null;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
            if (!sPutIBinderMethodFetched) {
                try {
                    Method method = Bundle.class.getMethod("putIBinder", String.class, IBinder.class);
                    sPutIBinderMethod = method;
                    method.setAccessible(true);
                } catch (NoSuchMethodException e) {
                    Log.i(TAG, "Failed to retrieve putIBinder method", e);
                }
                sPutIBinderMethodFetched = true;
            }
            Method method2 = sPutIBinderMethod;
            if (method2 != null) {
                try {
                    method2.invoke(bundle, str, iBinder);
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e2) {
                    Log.i(TAG, "Failed to invoke putIBinder via reflection", e2);
                    sPutIBinderMethod = null;
                }
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private BundleCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static IBinder getBinder(Bundle bundle, String str) {
        return Api18Impl.getBinder(bundle, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void putBinder(Bundle bundle, String str, IBinder iBinder) {
        Api18Impl.putBinder(bundle, str, iBinder);
    }

    static class Api18Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api18Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static IBinder getBinder(Bundle bundle, String str) {
            return bundle.getBinder(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void putBinder(Bundle bundle, String str, IBinder iBinder) {
            bundle.putBinder(str, iBinder);
        }
    }
}
