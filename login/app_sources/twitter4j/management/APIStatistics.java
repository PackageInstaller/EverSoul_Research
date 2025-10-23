package twitter4j.management;

import com.liapp.y;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes4.dex */
public class APIStatistics implements APIStatisticsMBean {
    private final InvocationStatisticsCalculator API_STATS_CALCULATOR;
    private final int HISTORY_SIZE;
    private final Map<String, InvocationStatisticsCalculator> METHOD_STATS_MAP = new HashMap(100);

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public APIStatistics(int i) {
        this.API_STATS_CALCULATOR = new InvocationStatisticsCalculator(y.ٲٴݴ״ٰ(1780493576), i);
        this.HISTORY_SIZE = i;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public synchronized void methodCalled(String str, long j, boolean z) {
        getMethodStatistics(str).increment(j, z);
        this.API_STATS_CALCULATOR.increment(j, z);
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    private synchronized InvocationStatisticsCalculator getMethodStatistics(String str) {
        InvocationStatisticsCalculator invocationStatisticsCalculator;
        invocationStatisticsCalculator = this.METHOD_STATS_MAP.get(str);
        if (invocationStatisticsCalculator == null) {
            invocationStatisticsCalculator = new InvocationStatisticsCalculator(str, this.HISTORY_SIZE);
            this.METHOD_STATS_MAP.put(str, invocationStatisticsCalculator);
        }
        return invocationStatisticsCalculator;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.APIStatisticsMBean
    public synchronized Iterable<? extends InvocationStatistics> getInvocationStatistics() {
        return this.METHOD_STATS_MAP.values();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public synchronized void reset() {
        this.API_STATS_CALCULATOR.reset();
        this.METHOD_STATS_MAP.clear();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public String getName() {
        return this.API_STATS_CALCULATOR.getName();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public long getCallCount() {
        return this.API_STATS_CALCULATOR.getCallCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public long getErrorCount() {
        return this.API_STATS_CALCULATOR.getErrorCount();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public long getTotalTime() {
        return this.API_STATS_CALCULATOR.getTotalTime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.InvocationStatistics
    public long getAverageTime() {
        return this.API_STATS_CALCULATOR.getAverageTime();
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.APIStatisticsMBean
    public synchronized Map<String, String> getMethodLevelSummariesAsString() {
        HashMap hashMap;
        hashMap = new HashMap();
        for (InvocationStatisticsCalculator invocationStatisticsCalculator : this.METHOD_STATS_MAP.values()) {
            hashMap.put(invocationStatisticsCalculator.getName(), invocationStatisticsCalculator.toString());
        }
        return hashMap;
    }

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    @Override // twitter4j.management.APIStatisticsMBean
    public synchronized String getMethodLevelSummary(String str) {
        return this.METHOD_STATS_MAP.get(str).toString();
    }
}
