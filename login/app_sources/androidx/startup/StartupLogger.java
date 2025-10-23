package androidx.startup;

import android.util.Log;

/* loaded from: classes.dex */
public final class StartupLogger {
    static final boolean DEBUG = false;
    private static final String TAG = "StartupLogger";

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private StartupLogger() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public static void m58i(String str) {
        Log.i(TAG, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public static void m59w(String str) {
        Log.w(TAG, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public static void m57e(String str, Throwable th) {
        Log.e(TAG, str, th);
    }
}
