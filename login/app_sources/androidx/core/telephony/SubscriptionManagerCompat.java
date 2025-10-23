package androidx.core.telephony;

import android.os.Build;
import android.telephony.SubscriptionManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public class SubscriptionManagerCompat {
    private static Method sGetSlotIndexMethod;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static int getSlotIndex(int i) {
        if (i == -1) {
            return -1;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return Api29Impl.getSlotIndex(i);
        }
        try {
            if (sGetSlotIndexMethod == null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotIndex", Integer.TYPE);
                } else {
                    sGetSlotIndexMethod = SubscriptionManager.class.getDeclaredMethod("getSlotId", Integer.TYPE);
                }
                sGetSlotIndexMethod.setAccessible(true);
            }
            Integer num = (Integer) sGetSlotIndexMethod.invoke(null, Integer.valueOf(i));
            if (num != null) {
                return num.intValue();
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
        }
        return -1;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SubscriptionManagerCompat() {
    }

    private static class Api29Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api29Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static int getSlotIndex(int i) {
            return SubscriptionManager.getSlotIndex(i);
        }
    }
}
