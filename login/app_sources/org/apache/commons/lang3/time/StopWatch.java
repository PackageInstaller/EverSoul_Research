package org.apache.commons.lang3.time;

import com.liapp.y;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class StopWatch {
    private static final long NANO_2_MILLIS = 1000000;
    private State runningState = State.UNSTARTED;
    private SplitState splitState = SplitState.UNSPLIT;
    private long startTime;
    private long startTimeMillis;
    private long stopTime;

    private enum SplitState {
        SPLIT,
        UNSPLIT
    }

    private enum State {
        UNSTARTED { // from class: org.apache.commons.lang3.time.StopWatch.State.1
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStarted() {
                return false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStopped() {
                return true;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isSuspended() {
                return false;
            }
        },
        RUNNING { // from class: org.apache.commons.lang3.time.StopWatch.State.2
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStarted() {
                return true;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStopped() {
                return false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isSuspended() {
                return false;
            }
        },
        STOPPED { // from class: org.apache.commons.lang3.time.StopWatch.State.3
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStarted() {
                return false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStopped() {
                return true;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isSuspended() {
                return false;
            }
        },
        SUSPENDED { // from class: org.apache.commons.lang3.time.StopWatch.State.4
            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStarted() {
                return true;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isStopped() {
                return false;
            }

            /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
            @Override // org.apache.commons.lang3.time.StopWatch.State
            boolean isSuspended() {
                return true;
            }
        };

        abstract boolean isStarted();

        abstract boolean isStopped();

        abstract boolean isSuspended();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public static StopWatch createStarted() {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        return stopWatch;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void start() {
        if (this.runningState == State.STOPPED) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392620922));
        }
        if (this.runningState != State.UNSTARTED) {
            throw new IllegalStateException(y.ٲٴݴ״ٰ(1781836584));
        }
        this.startTime = System.nanoTime();
        this.startTimeMillis = System.currentTimeMillis();
        this.runningState = State.RUNNING;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void stop() {
        if (this.runningState != State.RUNNING && this.runningState != State.SUSPENDED) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392622338));
        }
        if (this.runningState == State.RUNNING) {
            this.stopTime = System.nanoTime();
        }
        this.runningState = State.STOPPED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void reset() {
        this.runningState = State.UNSTARTED;
        this.splitState = SplitState.UNSPLIT;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void split() {
        if (this.runningState != State.RUNNING) {
            throw new IllegalStateException(y.ٴسسݬߨ(1392622338));
        }
        this.stopTime = System.nanoTime();
        this.splitState = SplitState.SPLIT;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void unsplit() {
        if (this.splitState != SplitState.SPLIT) {
            throw new IllegalStateException(y.ݬֲ֮ܲت(1512610927));
        }
        this.splitState = SplitState.UNSPLIT;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void suspend() {
        if (this.runningState != State.RUNNING) {
            throw new IllegalStateException(y.دײܮڳܯ(2051585221));
        }
        this.stopTime = System.nanoTime();
        this.runningState = State.SUSPENDED;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public void resume() {
        if (this.runningState != State.SUSPENDED) {
            throw new IllegalStateException(y.ݬֲ֮ܲت(1512608143));
        }
        this.startTime += System.nanoTime() - this.stopTime;
        this.runningState = State.RUNNING;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getTime() {
        return getNanoTime() / NANO_2_MILLIS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getTime(TimeUnit timeUnit) {
        return timeUnit.convert(getNanoTime(), TimeUnit.NANOSECONDS);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getNanoTime() {
        long j;
        long j2;
        if (this.runningState == State.STOPPED || this.runningState == State.SUSPENDED) {
            j = this.stopTime;
            j2 = this.startTime;
        } else {
            if (this.runningState == State.UNSTARTED) {
                return 0L;
            }
            if (this.runningState == State.RUNNING) {
                j = System.nanoTime();
                j2 = this.startTime;
            } else {
                throw new RuntimeException(y.٬ݯح׭٩(575830614));
            }
        }
        return j - j2;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getSplitTime() {
        return getSplitNanoTime() / NANO_2_MILLIS;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getSplitNanoTime() {
        if (this.splitState != SplitState.SPLIT) {
            throw new IllegalStateException(y.֬ڱܱײٮ(-1159601487));
        }
        return this.stopTime - this.startTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public long getStartTime() {
        if (this.runningState == State.UNSTARTED) {
            throw new IllegalStateException(y.ۮڭڭܬި(862310435));
        }
        return this.startTimeMillis;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        return DurationFormatUtils.formatDurationHMS(getTime());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toSplitString() {
        return DurationFormatUtils.formatDurationHMS(getSplitTime());
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isStarted() {
        return this.runningState.isStarted();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isSuspended() {
        return this.runningState.isSuspended();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public boolean isStopped() {
        return this.runningState.isStopped();
    }
}
