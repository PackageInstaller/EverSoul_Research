package com.google.android.datatransport.runtime.time;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public class TestClock implements Clock {
    private final AtomicLong timestamp;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TestClock(long j) {
        this.timestamp = new AtomicLong(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.android.datatransport.runtime.time.Clock
    public long getTime() {
        return this.timestamp.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void tick() {
        advance(1L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void advance(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("cannot advance time backwards.");
        }
        this.timestamp.addAndGet(j);
    }
}
