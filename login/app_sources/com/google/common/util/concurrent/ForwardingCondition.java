package com.google.common.util.concurrent;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class ForwardingCondition implements Condition {
    abstract Condition delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ForwardingCondition() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Condition
    public void await() throws InterruptedException {
        delegate().await();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Condition
    public boolean await(long j, TimeUnit timeUnit) throws InterruptedException {
        return delegate().await(j, timeUnit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Condition
    public void awaitUninterruptibly() {
        delegate().awaitUninterruptibly();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Condition
    public long awaitNanos(long j) throws InterruptedException {
        return delegate().awaitNanos(j);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Condition
    public boolean awaitUntil(Date date) throws InterruptedException {
        return delegate().awaitUntil(date);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Condition
    public void signal() {
        delegate().signal();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Condition
    public void signalAll() {
        delegate().signalAll();
    }
}
