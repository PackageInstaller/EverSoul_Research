package com.google.firebase.perf.transport;

import com.google.firebase.perf.p010v1.ApplicationProcessState;
import com.google.firebase.perf.p010v1.PerfMetric;

/* loaded from: classes2.dex */
final class PendingPerfEvent {
    protected final ApplicationProcessState appState;
    protected final PerfMetric.Builder perfMetricBuilder;

    /* JADX WARN: Unreachable blocks removed: 1, instructions: 1 */
    public PendingPerfEvent(PerfMetric.Builder builder, ApplicationProcessState applicationProcessState) {
        this.perfMetricBuilder = builder;
        this.appState = applicationProcessState;
    }
}
