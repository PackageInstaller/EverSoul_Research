package org.apache.commons.lang3.concurrent;

import com.liapp.y;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class TimedSemaphore {
    public static final int NO_LIMIT = 0;
    private static final int THREAD_POOL_SIZE = 1;
    private int acquireCount;
    private final ScheduledExecutorService executorService;
    private int lastCallsPerPeriod;
    private int limit;
    private final boolean ownExecutor;
    private final long period;
    private long periodCount;
    private boolean shutdown;
    private ScheduledFuture<?> task;
    private long totalAcquireCount;
    private final TimeUnit unit;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TimedSemaphore(long j, TimeUnit timeUnit, int i) {
        this(null, j, timeUnit, i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TimedSemaphore(ScheduledExecutorService scheduledExecutorService, long j, TimeUnit timeUnit, int i) {
        Validate.inclusiveBetween(1L, Long.MAX_VALUE, j, y.٬ݯح׭٩(575873486));
        this.period = j;
        this.unit = timeUnit;
        if (scheduledExecutorService != null) {
            this.executorService = scheduledExecutorService;
            this.ownExecutor = false;
        } else {
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
            scheduledThreadPoolExecutor.setContinueExistingPeriodicTasksAfterShutdownPolicy(false);
            scheduledThreadPoolExecutor.setExecuteExistingDelayedTasksAfterShutdownPolicy(false);
            this.executorService = scheduledThreadPoolExecutor;
            this.ownExecutor = true;
        }
        setLimit(i);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized int getLimit() {
        return this.limit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public final synchronized void setLimit(int i) {
        this.limit = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void shutdown() {
        if (!this.shutdown) {
            if (this.ownExecutor) {
                getExecutorService().shutdownNow();
            }
            ScheduledFuture<?> scheduledFuture = this.task;
            if (scheduledFuture != null) {
                scheduledFuture.cancel(false);
            }
            this.shutdown = true;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean isShutdown() {
        return this.shutdown;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void acquire() throws InterruptedException {
        boolean acquirePermit;
        prepareAcquire();
        do {
            acquirePermit = acquirePermit();
            if (!acquirePermit) {
                wait();
            }
        } while (!acquirePermit);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized boolean tryAcquire() {
        prepareAcquire();
        return acquirePermit();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int getLastAcquiresPerPeriod() {
        return this.lastCallsPerPeriod;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int getAcquireCount() {
        return this.acquireCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized int getAvailablePermits() {
        return getLimit() - getAcquireCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized double getAverageCallsPerPeriod() {
        long j;
        j = this.periodCount;
        return j == 0 ? 0.0d : this.totalAcquireCount / j;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getPeriod() {
        return this.period;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public TimeUnit getUnit() {
        return this.unit;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ScheduledExecutorService getExecutorService() {
        return this.executorService;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    protected ScheduledFuture<?> startTimer() {
        return getExecutorService().scheduleAtFixedRate(new Runnable() { // from class: org.apache.commons.lang3.concurrent.TimedSemaphore.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // java.lang.Runnable
            public void run() {
                TimedSemaphore.this.endOfPeriod();
            }
        }, getPeriod(), getPeriod(), getUnit());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    synchronized void endOfPeriod() {
        int i = this.acquireCount;
        this.lastCallsPerPeriod = i;
        this.totalAcquireCount += i;
        this.periodCount++;
        this.acquireCount = 0;
        notifyAll();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private void prepareAcquire() {
        if (isShutdown()) {
            throw new IllegalStateException(y.ٲٴݴ״ٰ(1781921840));
        }
        if (this.task == null) {
            this.task = startTimer();
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private boolean acquirePermit() {
        if (getLimit() > 0 && this.acquireCount >= getLimit()) {
            return false;
        }
        this.acquireCount++;
        return true;
    }
}
