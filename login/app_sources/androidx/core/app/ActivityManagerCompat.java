package androidx.core.app;

import android.app.ActivityManager;

/* loaded from: classes.dex */
public final class ActivityManagerCompat {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private ActivityManagerCompat() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static boolean isLowRamDevice(ActivityManager activityManager) {
        return activityManager.isLowRamDevice();
    }
}
