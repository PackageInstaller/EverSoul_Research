package com.google.common.util.concurrent;

import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.CheckForNull;

@ElementTypesAreNonnullByDefault
/* loaded from: classes2.dex */
final class TimeoutFuture<V> extends FluentFuture.TrustedFuture<V> {

    @CheckForNull
    private ListenableFuture<V> delegateRef;

    @CheckForNull
    private ScheduledFuture<?> timer;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    static <V> ListenableFuture<V> create(ListenableFuture<V> listenableFuture, long j, TimeUnit timeUnit, ScheduledExecutorService scheduledExecutorService) {
        TimeoutFuture timeoutFuture = new TimeoutFuture(listenableFuture);
        Fire fire = new Fire(timeoutFuture);
        timeoutFuture.timer = scheduledExecutorService.schedule(fire, j, timeUnit);
        listenableFuture.addListener(fire, MoreExecutors.directExecutor());
        return timeoutFuture;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private TimeoutFuture(ListenableFuture<V> listenableFuture) {
        this.delegateRef = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
    }

    private static final class Fire<V> implements Runnable {

        @CheckForNull
        TimeoutFuture<V> timeoutFutureRef;

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        Fire(TimeoutFuture<V> timeoutFuture) {
            this.timeoutFutureRef = timeoutFuture;
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Runnable
        public void run() {
            ListenableFuture<? extends V> listenableFuture;
            TimeoutFuture<V> timeoutFuture = this.timeoutFutureRef;
            if (timeoutFuture == null || (listenableFuture = ((TimeoutFuture) timeoutFuture).delegateRef) == null) {
                return;
            }
            this.timeoutFutureRef = null;
            if (!listenableFuture.isDone()) {
                try {
                    ScheduledFuture scheduledFuture = ((TimeoutFuture) timeoutFuture).timer;
                    ((TimeoutFuture) timeoutFuture).timer = null;
                    String str = "Timed out";
                    if (scheduledFuture != null) {
                        try {
                            long abs = Math.abs(scheduledFuture.getDelay(TimeUnit.MILLISECONDS));
                            if (abs > 10) {
                                str = new StringBuilder("Timed out".length() + 66).append("Timed out (timeout delayed by ").append(abs).append(" ms after scheduled time)").toString();
                            }
                        } catch (Throwable th) {
                            timeoutFuture.setException(new TimeoutFutureException(str));
                            throw th;
                        }
                    }
                    String valueOf = String.valueOf(str);
                    String valueOf2 = String.valueOf(listenableFuture);
                    timeoutFuture.setException(new TimeoutFutureException(new StringBuilder(String.valueOf(valueOf).length() + 2 + String.valueOf(valueOf2).length()).append(valueOf).append(": ").append(valueOf2).toString()));
                    return;
                } finally {
                    listenableFuture.cancel(true);
                }
            }
            timeoutFuture.setFuture(listenableFuture);
        }
    }

    private static final class TimeoutFutureException extends TimeoutException {
        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        private TimeoutFutureException(String str) {
            super(str);
        }

        /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
        @Override // java.lang.Throwable
        public synchronized Throwable fillInStackTrace() {
            setStackTrace(new StackTraceElement[0]);
            return this;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.AbstractFuture
    @CheckForNull
    protected String pendingToString() {
        ListenableFuture<V> listenableFuture = this.delegateRef;
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (listenableFuture == null) {
            return null;
        }
        String valueOf = String.valueOf(listenableFuture);
        String sb = new StringBuilder(String.valueOf(valueOf).length() + 14).append("inputFuture=[").append(valueOf).append("]").toString();
        if (scheduledFuture == null) {
            return sb;
        }
        long delay = scheduledFuture.getDelay(TimeUnit.MILLISECONDS);
        if (delay <= 0) {
            return sb;
        }
        String valueOf2 = String.valueOf(sb);
        return new StringBuilder(String.valueOf(valueOf2).length() + 43).append(valueOf2).append(", remaining delay=[").append(delay).append(" ms]").toString();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // com.google.common.util.concurrent.AbstractFuture
    protected void afterDone() {
        maybePropagateCancellationTo(this.delegateRef);
        ScheduledFuture<?> scheduledFuture = this.timer;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.delegateRef = null;
        this.timer = null;
    }
}
