package org.apache.commons.lang3.concurrent;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes2.dex */
public class ThresholdCircuitBreaker extends AbstractCircuitBreaker<Long> {
    private static final long INITIAL_COUNT = 0;
    private final long threshold;
    private final AtomicLong used = new AtomicLong(0);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public ThresholdCircuitBreaker(long j) {
        this.threshold = j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getThreshold() {
        return this.threshold;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean checkState() {
        return isOpen();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public void close() {
        super.close();
        this.used.set(0L);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // org.apache.commons.lang3.concurrent.AbstractCircuitBreaker, org.apache.commons.lang3.concurrent.CircuitBreaker
    public boolean incrementAndCheckState(Long l) {
        if (this.threshold == 0) {
            open();
        }
        if (this.used.addAndGet(l.longValue()) > this.threshold) {
            open();
        }
        return checkState();
    }
}
