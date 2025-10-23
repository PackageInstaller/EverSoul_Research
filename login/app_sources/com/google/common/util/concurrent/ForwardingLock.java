package com.google.common.util.concurrent;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class ForwardingLock implements Lock {
    abstract Lock delegate();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    ForwardingLock() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Lock
    public void lock() {
        delegate().lock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Lock
    public void lockInterruptibly() throws InterruptedException {
        delegate().lockInterruptibly();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock() {
        return delegate().tryLock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Lock
    public boolean tryLock(long j, TimeUnit timeUnit) throws InterruptedException {
        return delegate().tryLock(j, timeUnit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Lock
    public void unlock() {
        delegate().unlock();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.locks.Lock
    public Condition newCondition() {
        return delegate().newCondition();
    }
}
