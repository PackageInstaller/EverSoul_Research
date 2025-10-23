package twitter4j.management;

import com.liapp.y;

/* loaded from: classes4.dex */
public class InvocationStatisticsCalculator implements InvocationStatistics {
    private long callCount;
    private long errorCount;
    private int index;
    private final String name;
    private long[] times;
    private long totalTime;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public InvocationStatisticsCalculator(String str, int i) {
        this.name = str;
        this.times = new long[i];
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    void increment(long j, boolean z) {
        this.callCount++;
        this.errorCount += z ? 0L : 1L;
        this.totalTime += j;
        long[] jArr = this.times;
        int i = this.index;
        jArr[i] = j;
        int i2 = i + 1;
        this.index = i2;
        if (i2 >= jArr.length) {
            this.index = 0;
        }
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public String getName() {
        return this.name;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public long getCallCount() {
        return this.callCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public long getErrorCount() {
        return this.errorCount;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public long getTotalTime() {
        return this.totalTime;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public synchronized long getAverageTime() {
        int min = Math.min(Math.abs((int) this.callCount), this.times.length);
        long j = 0;
        if (min == 0) {
            return 0L;
        }
        for (int i = 0; i < min; i++) {
            j += this.times[i];
        }
        return j / min;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public synchronized void reset() {
        this.callCount = 0L;
        this.errorCount = 0L;
        this.totalTime = 0L;
        this.times = new long[this.times.length];
        this.index = 0;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public String toString() {
        StringBuilder sb = new StringBuilder(y.֬ڱܱײٮ(-1158331479));
        sb.append(getCallCount()).append(y.ݮڮֲڭܩ(-628020604)).append(getErrorCount()).append(y.ݮڮֲڭܩ(-628020364)).append(getTotalTime()).append(y.ݬֲ֮ܲت(1513894935)).append(getAverageTime());
        return sb.toString();
    }
}
