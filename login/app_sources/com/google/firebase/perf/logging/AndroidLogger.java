package com.google.firebase.perf.logging;

import java.util.Locale;

/* loaded from: classes2.dex */
public class AndroidLogger {
    private static volatile AndroidLogger instance;
    private boolean isLogcatEnabled;
    private final LogWrapper logWrapper;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static AndroidLogger getInstance() {
        if (instance == null) {
            synchronized (AndroidLogger.class) {
                if (instance == null) {
                    instance = new AndroidLogger();
                }
            }
        }
        return instance;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public AndroidLogger(LogWrapper logWrapper) {
        this.isLogcatEnabled = false;
        this.logWrapper = logWrapper == null ? LogWrapper.getInstance() : logWrapper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private AndroidLogger() {
        this(null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void setLogcatEnabled(boolean z) {
        this.isLogcatEnabled = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isLogcatEnabled() {
        return this.isLogcatEnabled;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void debug(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m427d(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void debug(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m427d(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void verbose(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m430v(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void verbose(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m430v(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void info(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m429i(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void info(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m429i(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void warn(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m431w(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void warn(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m431w(String.format(Locale.ENGLISH, str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void error(String str) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m428e(str);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void error(String str, Object... objArr) {
        if (this.isLogcatEnabled) {
            this.logWrapper.m428e(String.format(Locale.ENGLISH, str, objArr));
        }
    }
}
