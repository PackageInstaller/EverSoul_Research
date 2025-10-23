package twitter4j.management;

/* loaded from: classes4.dex */
public interface InvocationStatistics {
    long getAverageTime();

    long getCallCount();

    long getErrorCount();

    String getName();

    long getTotalTime();

    void reset();
}
