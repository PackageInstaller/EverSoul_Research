package com.google.android.datatransport.runtime.time;

/* loaded from: classes.dex */
public class WallTimeClock implements Clock {
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return System.currentTimeMillis();
    }
}
