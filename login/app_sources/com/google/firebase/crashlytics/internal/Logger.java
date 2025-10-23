package com.google.firebase.crashlytics.internal;

import android.util.Log;

/* loaded from: classes2.dex */
public class Logger {
    private int logLevel = 4;
    private final String tag;
    public static final String TAG = "FirebaseCrashlytics";
    static final Logger DEFAULT_LOGGER = new Logger(TAG);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public Logger(String str) {
        this.tag = str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static Logger getLogger() {
        return DEFAULT_LOGGER;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean canLog(int i) {
        return this.logLevel <= i || Log.isLoggable(this.tag, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public void m391d(String str, Throwable th) {
        if (canLog(3)) {
            Log.d(this.tag, str, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: v */
    public void m397v(String str, Throwable th) {
        if (canLog(2)) {
            Log.v(this.tag, str, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public void m395i(String str, Throwable th) {
        if (canLog(4)) {
            Log.i(this.tag, str, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public void m399w(String str, Throwable th) {
        if (canLog(5)) {
            Log.w(this.tag, str, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public void m393e(String str, Throwable th) {
        if (canLog(6)) {
            Log.e(this.tag, str, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public void m390d(String str) {
        m391d(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: v */
    public void m396v(String str) {
        m397v(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public void m394i(String str) {
        m395i(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public void m398w(String str) {
        m399w(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public void m392e(String str) {
        m393e(str, null);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(int i, String str) {
        log(i, str, false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void log(int i, String str, boolean z) {
        if (z || canLog(i)) {
            Log.println(i, this.tag, str);
        }
    }
}
