package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import com.liapp.y;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes.dex */
public class VolleyLog {
    public static boolean DEBUG = Log.isLoggable(y.دײܮڳܯ(2051827213), 2);
    public static String TAG = "Volley";

    static class MarkerLog {
        public static final boolean ENABLED = VolleyLog.DEBUG;
        private static final long MIN_DURATION_FOR_LOGGING_MS = 0;
        private final List<Marker> mMarkers = new ArrayList();
        private boolean mFinished = false;

        private static class Marker {
            public final String name;
            public final long thread;
            public final long time;

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            public Marker(String str, long j, long j2) {
                this.name = str;
                this.thread = j;
                this.time = j2;
            }
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        MarkerLog() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private long getTotalDuration() {
            if (this.mMarkers.size() == 0) {
                return 0L;
            }
            return this.mMarkers.get(r2.size() - 1).time - this.mMarkers.get(0).time;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized void add(String str, long j) {
            if (this.mFinished) {
                throw new IllegalStateException("Marker added to finished log");
            }
            this.mMarkers.add(new Marker(str, j, SystemClock.elapsedRealtime()));
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        protected void finalize() {
            if (this.mFinished) {
                return;
            }
            finish(y.٬ݯح׭٩(576105910));
            VolleyLog.m63e(y.ݮڮֲڭܩ(-629055900), new Object[0]);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public synchronized void finish(String str) {
            this.mFinished = true;
            long totalDuration = getTotalDuration();
            if (totalDuration <= 0) {
                return;
            }
            long j = this.mMarkers.get(0).time;
            VolleyLog.m62d("(%-4d ms) %s", Long.valueOf(totalDuration), str);
            for (Marker marker : this.mMarkers) {
                long j2 = marker.time;
                VolleyLog.m62d("(+%-4d) [%2d] %s", Long.valueOf(j2 - j), Long.valueOf(marker.thread), marker.name);
                j = j2;
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private static String buildMessage(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i = 2;
        while (true) {
            if (i >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            }
            if (!stackTrace[i].getClass().equals(VolleyLog.class)) {
                String className = stackTrace[i].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = substring.substring(substring.lastIndexOf(36) + 1) + y.ݮڮֲڭܩ(-629059348) + stackTrace[i].getMethodName();
                break;
            }
            i++;
        }
        return String.format(Locale.US, "[%d] %s: %s", Long.valueOf(Thread.currentThread().getId()), str2, str);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: d */
    public static void m62d(String str, Object... objArr) {
        Log.d(TAG, buildMessage(str, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public static void m63e(String str, Object... objArr) {
        Log.e(TAG, buildMessage(str, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: e */
    public static void m64e(Throwable th, String str, Object... objArr) {
        Log.e(TAG, buildMessage(str, objArr), th);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void setTag(String str) {
        m62d(y.ݬֲ֮ܲت(1512853327), str);
        TAG = str;
        DEBUG = Log.isLoggable(str, 2);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    /* renamed from: v */
    public static void m65v(String str, Object... objArr) {
        if (DEBUG) {
            Log.v(TAG, buildMessage(str, objArr));
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void wtf(String str, Object... objArr) {
        Log.wtf(TAG, buildMessage(str, objArr));
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static void wtf(Throwable th, String str, Object... objArr) {
        Log.wtf(TAG, buildMessage(str, objArr), th);
    }
}
