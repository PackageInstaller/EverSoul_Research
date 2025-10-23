package androidx.core.os;

import android.os.Message;

/* loaded from: classes.dex */
public final class MessageCompat {
    private static boolean sTryIsAsynchronous = true;
    private static boolean sTrySetAsynchronous = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setAsynchronous(Message message, boolean z) {
        Api22Impl.setAsynchronous(message, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isAsynchronous(Message message) {
        return Api22Impl.isAsynchronous(message);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private MessageCompat() {
    }

    static class Api22Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api22Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static boolean isAsynchronous(Message message) {
            return message.isAsynchronous();
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void setAsynchronous(Message message, boolean z) {
            message.setAsynchronous(z);
        }
    }
}
