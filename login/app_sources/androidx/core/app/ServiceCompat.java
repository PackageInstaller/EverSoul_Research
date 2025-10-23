package androidx.core.app;

import android.app.Service;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes.dex */
public final class ServiceCompat {
    public static final int START_STICKY = 1;
    public static final int STOP_FOREGROUND_DETACH = 2;
    public static final int STOP_FOREGROUND_REMOVE = 1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface StopForegroundFlags {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ServiceCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void stopForeground(Service service, int i) {
        Api24Impl.stopForeground(service, i);
    }

    static class Api24Impl {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Api24Impl() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        static void stopForeground(Service service, int i) {
            service.stopForeground(i);
        }
    }
}
