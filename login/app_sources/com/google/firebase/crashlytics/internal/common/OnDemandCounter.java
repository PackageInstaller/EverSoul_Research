package com.google.firebase.crashlytics.internal.common;

import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: classes2.dex */
public final class OnDemandCounter {
    private final AtomicInteger recordedOnDemandExceptions = new AtomicInteger();
    private final AtomicInteger droppedOnDemandExceptions = new AtomicInteger();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getRecordedOnDemandExceptions() {
        return this.recordedOnDemandExceptions.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void incrementRecordedOnDemandExceptions() {
        this.recordedOnDemandExceptions.getAndIncrement();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public int getDroppedOnDemandExceptions() {
        return this.droppedOnDemandExceptions.get();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void incrementDroppedOnDemandExceptions() {
        this.droppedOnDemandExceptions.getAndIncrement();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resetDroppedOnDemandExceptions() {
        this.droppedOnDemandExceptions.set(0);
    }
}
