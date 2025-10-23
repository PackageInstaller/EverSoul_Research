package androidx.core.os;

import android.content.Context;
import android.os.UserManager;

/* loaded from: classes.dex */
public class UserManagerCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private UserManagerCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isUserUnlocked(Context context) {
        return Api24Impl.isUserUnlocked(context);
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isUserUnlocked(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }
}
