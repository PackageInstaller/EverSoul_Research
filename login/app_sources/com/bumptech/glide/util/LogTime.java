package com.bumptech.glide.util;

import android.os.SystemClock;

/* loaded from: classes.dex */
public final class LogTime {
    private static final double MILLIS_MULTIPLIER = 1.0d / Math.pow(10.0d, 6.0d);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private LogTime() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static long getLogTime() {
        return SystemClock.elapsedRealtimeNanos();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static double getElapsedMillis(long j) {
        return (getLogTime() - j) * MILLIS_MULTIPLIER;
    }
}
