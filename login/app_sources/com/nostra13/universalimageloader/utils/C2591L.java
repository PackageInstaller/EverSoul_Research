package com.nostra13.universalimageloader.utils;

import android.util.Log;
import com.nostra13.universalimageloader.core.ImageLoader;

/* renamed from: com.nostra13.universalimageloader.utils.L */
/* loaded from: classes3.dex */
public final class C2591L {
    private static final String LOG_FORMAT = "%1$s\n%2$s";
    private static volatile boolean writeDebugLogs = false;
    private static volatile boolean writeLogs = true;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private C2591L() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void enableLogging() {
        writeLogs(true);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Deprecated
    public static void disableLogging() {
        writeLogs(false);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeDebugLogs(boolean z) {
        writeDebugLogs = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void writeLogs(boolean z) {
        writeLogs = z;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public static void m719d(String str, Object... objArr) {
        if (writeDebugLogs) {
            log(3, null, str, objArr);
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: i */
    public static void m723i(String str, Object... objArr) {
        log(4, null, str, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: w */
    public static void m724w(String str, Object... objArr) {
        log(5, null, str, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public static void m721e(Throwable th) {
        log(6, th, null, new Object[0]);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public static void m720e(String str, Object... objArr) {
        log(6, null, str, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public static void m722e(Throwable th, String str, Object... objArr) {
        log(6, th, str, objArr);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static void log(int i, Throwable th, String str, Object... objArr) {
        if (writeLogs) {
            if (objArr.length > 0) {
                str = String.format(str, objArr);
            }
            if (th != null) {
                if (str == null) {
                    str = th.getMessage();
                }
                str = String.format(LOG_FORMAT, str, Log.getStackTraceString(th));
            }
            Log.println(i, ImageLoader.TAG, str);
        }
    }
}
