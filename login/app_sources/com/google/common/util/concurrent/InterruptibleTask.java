package com.google.common.util.concurrent;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.AbstractOwnableSynchronizer;
import java.util.concurrent.locks.LockSupport;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
abstract class InterruptibleTask<T> extends AtomicReference<Runnable> implements Runnable {
    private static final Runnable DONE;
    private static final int MAX_BUSY_WAIT_SPINS = 1000;
    private static final Runnable PARKED;

    abstract void afterRanInterruptiblyFailure(Throwable th);

    abstract void afterRanInterruptiblySuccess(@ParametricNullness T t);

    abstract boolean isDone();

    @ParametricNullness
    abstract T runInterruptibly() throws Exception;

    abstract String toPendingString();

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    InterruptibleTask() {
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static {
        DONE = new DoNothingRunnable();
        PARKED = new DoNothingRunnable();
    }

    private static final class DoNothingRunnable implements Runnable {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private DoNothingRunnable() {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.lang.Runnable
    public final void run() {
        Thread currentThread = Thread.currentThread();
        Object obj = null;
        if (compareAndSet(null, currentThread)) {
            boolean z = !isDone();
            if (z) {
                try {
                    obj = runInterruptibly();
                } catch (Throwable th) {
                    if (!compareAndSet(currentThread, DONE)) {
                        waitForInterrupt(currentThread);
                    }
                    if (z) {
                        afterRanInterruptiblyFailure(th);
                        return;
                    }
                    return;
                }
            }
            if (!compareAndSet(currentThread, DONE)) {
                waitForInterrupt(currentThread);
            }
            if (z) {
                afterRanInterruptiblySuccess(NullnessCasts.uncheckedCastNullableTToT(obj));
            }
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void waitForInterrupt(Thread thread) {
        Runnable runnable = get();
        Blocker blocker = null;
        boolean z = false;
        int i = 0;
        while (true) {
            boolean z2 = runnable instanceof Blocker;
            if (!z2 && runnable != PARKED) {
                break;
            }
            if (z2) {
                blocker = (Blocker) runnable;
            }
            i++;
            if (i > 1000) {
                Runnable runnable2 = PARKED;
                if (runnable == runnable2 || compareAndSet(runnable, runnable2)) {
                    z = Thread.interrupted() || z;
                    LockSupport.park(blocker);
                }
            } else {
                Thread.yield();
            }
            runnable = get();
        }
        if (z) {
            thread.interrupt();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    final void interruptTask() {
        Runnable runnable = get();
        if (runnable instanceof Thread) {
            Blocker blocker = new Blocker();
            blocker.setOwner(Thread.currentThread());
            if (compareAndSet(runnable, blocker)) {
                try {
                    ((Thread) runnable).interrupt();
                } finally {
                    if (getAndSet(DONE) == PARKED) {
                        LockSupport.unpark((Thread) runnable);
                    }
                }
            }
        }
    }

    static final class Blocker extends AbstractOwnableSynchronizer implements Runnable {
        private final InterruptibleTask<?> task;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private Blocker(InterruptibleTask<?> interruptibleTask) {
            this.task = interruptibleTask;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public void setOwner(Thread thread) {
            super.setExclusiveOwnerThread(thread);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        public String toString() {
            return this.task.toString();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // java.util.concurrent.atomic.AtomicReference
    public final String toString() {
        String str;
        Runnable runnable = get();
        if (runnable == DONE) {
            str = "running=[DONE]";
        } else if (runnable instanceof Blocker) {
            str = "running=[INTERRUPTED]";
        } else if (runnable instanceof Thread) {
            String name = ((Thread) runnable).getName();
            str = new StringBuilder(String.valueOf(name).length() + 21).append("running=[RUNNING ON ").append(name).append("]").toString();
        } else {
            str = "running=[NOT STARTED YET]";
        }
        String pendingString = toPendingString();
        return new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(pendingString).length()).append(str).append(", ").append(pendingString).toString();
    }
}
