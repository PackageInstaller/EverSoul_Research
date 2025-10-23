package com.google.android.datatransport.runtime.logging;

import android.os.Build;
import android.util.Log;

/* loaded from: classes.dex */
public final class Logging {
    private static final String LOG_PREFIX = "TRuntime.";
    private static final int MAX_LOG_TAG_SIZE_IN_SDK_N = 23;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private Logging() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String getTag(String str) {
        return Build.VERSION.SDK_INT < 26 ? concatTag(LOG_PREFIX, str) : LOG_PREFIX + str;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String concatTag(String str, String str2) {
        String str3 = str + str2;
        return str3.length() > 23 ? str3.substring(0, 23) : str3;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public static void m108d(String str, String str2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, str2);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public static void m109d(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public static void m110d(String str, String str2, Object obj, Object obj2) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, obj, obj2));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public static void m111d(String str, String str2, Object... objArr) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 3)) {
            Log.d(tag, String.format(str2, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public static void m113i(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 4)) {
            Log.i(tag, String.format(str2, obj));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public static void m112e(String str, String str2, Throwable th) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 6)) {
            Log.e(tag, str2, th);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public static void m114w(String str, String str2, Object obj) {
        String tag = getTag(str);
        if (Log.isLoggable(tag, 5)) {
            Log.w(tag, String.format(str2, obj));
        }
    }
}
