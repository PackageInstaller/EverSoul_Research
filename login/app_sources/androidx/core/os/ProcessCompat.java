package androidx.core.os;

import android.os.Process;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class ProcessCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ProcessCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isApplicationUid(int i) {
        return Api24Impl.isApplicationUid(i);
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isApplicationUid(int i) {
            return Process.isApplicationUid(i);
        }
    }

    static class Api17Impl {
        private static Method sMethodUserHandleIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = new Object();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api17Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isApplicationUid(int i) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserHandleIsAppMethod = UserHandle.class.getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = sMethodUserHandleIsAppMethod;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i));
                    if (bool == null) {
                        throw new NullPointerException();
                    }
                    return bool.booleanValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }

    static class Api16Impl {
        private static Method sMethodUserIdIsAppMethod;
        private static boolean sResolved;
        private static final Object sResolvedLock = new Object();

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api16Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isApplicationUid(int i) {
            try {
                synchronized (sResolvedLock) {
                    if (!sResolved) {
                        sResolved = true;
                        sMethodUserIdIsAppMethod = Class.forName("android.os.UserId").getDeclaredMethod("isApp", Integer.TYPE);
                    }
                }
                Method method = sMethodUserIdIsAppMethod;
                if (method != null) {
                    Boolean bool = (Boolean) method.invoke(null, Integer.valueOf(i));
                    if (bool == null) {
                        throw new NullPointerException();
                    }
                    return bool.booleanValue();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return true;
        }
    }
}
