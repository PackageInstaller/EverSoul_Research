package com.google.firebase;

import android.os.SystemClock;

/* loaded from: classes2.dex */
public abstract class StartupTime {
    public abstract long getElapsedRealtime();

    public abstract long getEpochMillis();

    public abstract long getUptimeMillis();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StartupTime create(long j, long j2, long j3) {
        return new AutoValue_StartupTime(j, j2, j3);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StartupTime now() {
        return create(System.currentTimeMillis(), SystemClock.elapsedRealtime(), SystemClock.uptimeMillis());
    }
}
