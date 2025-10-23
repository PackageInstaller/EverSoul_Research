package com.singular.sdk.internal;

import android.util.Log;
import java.io.PrintWriter;

/* loaded from: classes3.dex */
public class SingularLog {
    static boolean ENABLE_LOGGING = false;
    static int LOG_LEVEL = 6;
    private final String TAG;
    private PrintWriter printWriter;
    private final String tag;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private SingularLog(String str) {
        this.TAG = "Singular";
        this.tag = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static SingularLog getLogger(String str) {
        return new SingularLog(str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static SingularLog getLogger(String str, String str2) {
        final boolean z = !"PROD".equals(str2);
        return new SingularLog(str) { // from class: com.singular.sdk.internal.SingularLog.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // com.singular.sdk.internal.SingularLog
            protected boolean shouldLog(int i) {
                return super.shouldLog(i) && z;
            }
        };
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected boolean shouldLog(int i) {
        return ENABLE_LOGGING && LOG_LEVEL <= i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    String text(String str) {
        return String.format("%s [%s] - %s", this.tag, getThreadInfo(), str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isDebugEnabled() {
        return shouldLog(3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int debug(String str) {
        if (shouldLog(3)) {
            return Log.d("Singular", text(str));
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int debug(String str, Object... objArr) {
        if (shouldLog(3)) {
            return Log.d("Singular", text(String.format(str, objArr)));
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int info(String str) {
        if (shouldLog(4)) {
            return Log.i("Singular", text(str));
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int info(String str, Object... objArr) {
        if (shouldLog(4)) {
            return Log.i("Singular", text(String.format(str, objArr)));
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int error(String str) {
        if (shouldLog(6)) {
            return Log.e("Singular", text(str));
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int error(String str, Throwable th) {
        if (shouldLog(6)) {
            return Log.e("Singular", text(str), th);
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int error(String str, Object... objArr) {
        if (shouldLog(6)) {
            return Log.e("Singular", text(String.format(str, objArr)));
        }
        return 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static String getThreadInfo() {
        return String.format("%s", Thread.currentThread().getName());
    }
}
