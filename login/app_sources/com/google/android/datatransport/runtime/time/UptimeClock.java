package com.google.android.datatransport.runtime.time;

import android.os.SystemClock;

/* loaded from: classes.dex */
public class UptimeClock implements Clock {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return SystemClock.elapsedRealtime();
    }
}
