package com.google.firebase.perf.logging;

import android.util.Log;

/* loaded from: classes2.dex */
class LogWrapper {
    private static final String LOG_TAG = "FirebasePerformance";
    private static LogWrapper instance;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static synchronized LogWrapper getInstance() {
        LogWrapper logWrapper;
        synchronized (LogWrapper.class) {
            if (instance == null) {
                instance = new LogWrapper();
            }
            logWrapper = instance;
        }
        return logWrapper;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    void m427d(String str) {
        Log.d(LOG_TAG, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: v */
    void m430v(String str) {
        Log.v(LOG_TAG, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    void m429i(String str) {
        Log.i(LOG_TAG, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    void m431w(String str) {
        Log.w(LOG_TAG, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    void m428e(String str) {
        Log.e(LOG_TAG, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LogWrapper() {
    }
}
